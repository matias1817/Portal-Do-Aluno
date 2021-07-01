package br.ifpe.pp2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.pp2.DAO.AlunoDAO;
import br.ifpe.pp2.DAO.CursoDAO;
import br.ifpe.pp2.entities.Alunos;


@Controller
public class AlunoController {
	
	@Autowired
	private AlunoDAO alunoDAO;
	
	@Autowired
	private CursoDAO cursoDAO;
	

	@GetMapping("/PortalDoAluno")
	public String exibir(Model model) {
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
		Alunos alunoLogado = this.alunoDAO.findByemailAndSenha(email, senha);
		if(alunoLogado == null){
			ra.addFlashAttribute("menssagem", "usuário ou senha inválidos");
			return "redirect:/login";
	} else {
			session.setAttribute("alunoLogado", alunoLogado);
			ra.addFlashAttribute("menssagem", "usuário logado com sucesso");
			return "redirect:/aluno/home";
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
		
		this.alunoDAO.save(alunos);
		ra.addFlashAttribute("menssagem", "usuário salvo com sucesso");
		return "redirect:/";
	}
	 
	@GetMapping("/aluno/excluirAluno")
	public String excluirCliente(Integer id, RedirectAttributes ra) {
	this.alunoDAO.deleteById(id);
	ra.addFlashAttribute("menssagem", "usuário excluido com sucesso");
	return "redirect:/listaAluno";
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
	
	
	
}
