package br.ifpe.pp2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.pp2.DAO.AdminDAO;
import br.ifpe.pp2.DAO.AlunoDAO;
import br.ifpe.pp2.DAO.CursoDAO;
import br.ifpe.pp2.DAO.PeriodoDAO;
import br.ifpe.pp2.entities.Admin;
import br.ifpe.pp2.entities.Alunos;
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
	
	Periodo periodo1 = new Periodo("Primeiro Periodo");
	Periodo periodo2 = new Periodo("Segundo Periodo");
	Periodo periodo3 = new Periodo("Terceiro Periodo");
	Admin admin = new Admin("admin@gmail.com", "admin");
	@GetMapping("/PortalDoAluno")
	public String exibir(Model model) {
		if(periodoDAO.findAll().isEmpty()) {
			periodoDAO.save(periodo1);
			periodoDAO.save(periodo2);
			periodoDAO.save(periodo3);
		}
		if(adminDAO.findAll().isEmpty()) {
			adminDAO.save(admin);
		} 
		return "Portal";
	}
	@GetMapping("/login")
	public String exibirLogin(Model model) {
		return "login";
	}
	
	@GetMapping("/aluno/home")
	public String exibirHome(Model model){
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
		if(alunoLogado != null){
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
	public String salvarAluno(Alunos alunos, RedirectAttributes ra) {
		if(alunoDAO.findBycpf(alunos.getCpf()) != null && alunos.getId() == null) {
			ra.addFlashAttribute("menssagemE", "Aluno existente");
			return "redirect:/cad";
	
		} else {
		this.alunoDAO.save(alunos);
		ra.addFlashAttribute("menssagemS", "usuário salvo com sucesso");
		return "redirect:/loginAluno";
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
	
	
}
