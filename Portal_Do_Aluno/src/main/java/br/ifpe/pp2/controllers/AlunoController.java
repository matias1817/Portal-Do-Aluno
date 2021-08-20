package br.ifpe.pp2.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

import br.ifpe.pp2.DAO.AdminDAO;
import br.ifpe.pp2.DAO.AlunoDAO;
import br.ifpe.pp2.DAO.AvaliacaoDAO;
import br.ifpe.pp2.DAO.CursoDAO;
import br.ifpe.pp2.DAO.FrequenciaDAO;
import br.ifpe.pp2.DAO.PeriodoDAO;
import br.ifpe.pp2.entities.Admin;
import br.ifpe.pp2.entities.Alunos;
import br.ifpe.pp2.entities.Avaliacao;
import br.ifpe.pp2.entities.Frequencia;
import br.ifpe.pp2.entities.Periodo;

@Controller
public class AlunoController {

	@Autowired
	private AlunoDAO alunoDAO;

	@Autowired
	private CursoDAO cursoDAO;
	@Autowired
	private PeriodoDAO periodoDAO;
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private AvaliacaoDAO avaliacaoDAO;

	@Autowired
	private FrequenciaDAO frequenciaDAO;

	Periodo periodo1 = new Periodo("Primeiro Periodo");
	Periodo periodo2 = new Periodo("Segundo Periodo");
	Periodo periodo3 = new Periodo("Terceiro Periodo");
	Admin admin = new Admin("admin@gmail.com", "admin");

	@GetMapping("/PortalDoAluno")
	public String exibir(Model model) {
		if (periodoDAO.findAll().isEmpty()) {
			periodoDAO.save(periodo1);
			periodoDAO.save(periodo2);
			periodoDAO.save(periodo3);
		}
		if (adminDAO.findAll().isEmpty()) {
			adminDAO.save(admin);
		}
		
		

		return "Portal";
	}

	@GetMapping("/login")
	public String exibirLogin(Model model) {
		return "login";
	}

	@GetMapping("/aluno/home")
	public String exibirHome(Model model) {
		return "Home";
	}

	@GetMapping("/loginAluno")
	public String logarAluno(String email, String senha, Model model, RedirectAttributes ra, HttpSession session) {

		Admin adminLogado = this.adminDAO.findByemailAndSenha(email, senha);
		if (adminLogado != null) {
			session.setAttribute("adminLogado", adminLogado);
			ra.addFlashAttribute("menssagemS", "admin logado com sucesso");
			return "redirect:/admin/home";
		} else {
			Alunos alunoLogado = this.alunoDAO.findByemailAndSenha(email, senha);
			if (alunoLogado != null) {
				session.setAttribute("alunoLogado", alunoLogado);
				ra.addFlashAttribute("menssagemS", "usuário logado com sucesso");
				return "redirect:/aluno/home";
			} else {

				ra.addFlashAttribute("menssagemE", "usuário ou senha inválidos");
				return "redirect:/login";
			}
		}
	}

	@GetMapping("/cad")
	public String exibirCad(Integer id, Model model) {
		if (id != null) {
			Alunos alunos = this.alunoDAO.getById(id);
			model.addAttribute("Aluno", alunos);
		} else {
			model.addAttribute("Aluno", new Alunos());
		}

		model.addAttribute("lista", this.alunoDAO.findAll());

		model.addAttribute("curso", this.cursoDAO.findAll());
		return "cad";
	}

	@PostMapping("/salvarAluno")
	public String salvarAluno(Alunos alunos, RedirectAttributes ra, HttpSession session) {
		if (alunoDAO.findBycpf(alunos.getCpf()) != null && alunos.getId() == null) {
			ra.addFlashAttribute("menssagemE", "Aluno existente");
			return "redirect:/cad";

		} else {
			this.alunoDAO.save(alunos);
			ra.addFlashAttribute("menssagemS", "usuário salvo com sucesso");
			Alunos alunoLogado = (Alunos) session.getAttribute("alunoLogado");
			if (alunoLogado != null ) {
				ra.addFlashAttribute("menssagemS", "usuário editado com sucesso");
				return "redirect:/aluno/home";
			} else {
			return "redirect:/PortalDoAluno";
			}
		}
	}

	@GetMapping("/aluno/excluirAluno")
	public String excluirCliente(Integer id, RedirectAttributes ra) {
		this.alunoDAO.deleteById(id);
		ra.addFlashAttribute("menssagemS", "usuário excluido com sucesso");
		return "redirect:/aluno/listaAluno";
	}

	@GetMapping("/sair")
	public String sair(HttpSession session) {
		session.invalidate();
		return "redirect:/PortalDoAluno";
	}

	@GetMapping("/acessoNegado")
	public String negado() {
		return "Acesso";
	}

	@GetMapping("/admin/home")
	public String homeAdmin() {
		return "homeA";
	}

	@GetMapping("/aluno/historico")
	public String gerador(HttpSession session, RedirectAttributes ra) {
		Alunos alunoLogado = (Alunos) session.getAttribute("alunoLogado");
	    double somaNota = 0;
	    double somaNota1 = 0;
	    double somaNota2 = 0;
	    double somaNota3 = 0;
	  
		List<Avaliacao> avaliacao = avaliacaoDAO.filtrarAvaliacaoNomeExato(alunoLogado.getNome());
		List<Avaliacao> avaliacaoPrimeiro = avaliacaoDAO.filtrarAvaliacaoNomeExatoPeriodo(alunoLogado.getNome(),1);
		List<Avaliacao> avaliacaoSegundo = avaliacaoDAO.filtrarAvaliacaoNomeExatoPeriodo(alunoLogado.getNome(),2);
		List<Avaliacao> avaliacaoTerceiro = avaliacaoDAO.filtrarAvaliacaoNomeExatoPeriodo(alunoLogado.getNome(),3);
		
		for (Avaliacao avaliacao2 : avaliacao) {
			double nota = avaliacao2.getNota();
			somaNota = nota + somaNota;
		}
		for (Avaliacao avaliacao2 : avaliacaoPrimeiro) {
			double nota = avaliacao2.getNota();
			somaNota1 = nota + somaNota1;
		}
		for (Avaliacao avaliacao2 : avaliacaoSegundo) {
			double nota = avaliacao2.getNota();
			somaNota2 = nota + somaNota2;
		}
		for (Avaliacao avaliacao2 : avaliacaoTerceiro) {
			double nota = avaliacao2.getNota();
			somaNota3 = nota + somaNota3;
		}
		
		double mediaGeral = somaNota/avaliacao.size();
		
		double media1 = somaNota1/avaliacaoPrimeiro.size();
		double media2 = somaNota2/avaliacaoSegundo.size();
		double media3 = somaNota3/avaliacaoTerceiro.size();
		
		List<Frequencia> frequencia = frequenciaDAO.findAll();
		
		generatePdfFromHtml(alunoLogado, avaliacao, frequencia, mediaGeral, media1, media2,media3);
		ra.addFlashAttribute("menssagemS", "Pdf baixado com sucesso");
		return "redirect:/aluno/home";
	}

	public void generatePdfFromHtml(Alunos alunoLogado, List<Avaliacao> avaliacao, List<Frequencia> frequencia, double mediaGeral,
			double media1, double media2, double media3) {
		String Fil = System.getProperty("user.home");
		String outputFolder = Fil + File.separator + "Downloads" + File.separator + "MeuHistorico.pdf";
		OutputStream outputStream;
		try {
			String html = parseThymeleafTemplate(alunoLogado, avaliacao, frequencia, mediaGeral, media1, media2, media3);
			outputStream = new FileOutputStream(outputFolder);
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(html);
			renderer.layout();
			renderer.createPDF(outputStream);

			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 

	

	private String parseThymeleafTemplate(Alunos alunoLogado,  List<Avaliacao> avaliacao, List<Frequencia> frequencia, double mediaGeral
			,double media1,double media2,double media3) {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setPrefix("/templates/");
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		String periodo1 = "Primeiro Periodo";
		String periodo2 = "Segundo Periodo";
		String periodo3 = "Terceiro Periodo";
		Context context = new Context();
		context.setVariable("lista", alunoLogado);
		context.setVariable("lista1", avaliacao);
		context.setVariable("lista2", frequencia);
		context.setVariable("Primeiro", periodo1);
		context.setVariable("Segundo", periodo2);
		context.setVariable("Terceiro", periodo3);
		context.setVariable("Media", mediaGeral);
		context.setVariable("Media1", media1);
		context.setVariable("Media2", media2);
		context.setVariable("Media3", media3);

		return templateEngine.process("gerador.html", context);
	}

}
