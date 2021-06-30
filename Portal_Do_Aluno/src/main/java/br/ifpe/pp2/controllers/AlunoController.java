package br.ifpe.pp2.controllers;

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
	@GetMapping("/")
	public String exibirLogin(Model model) {
		return "login";
	}
	
	@GetMapping("/home")
	public String exibirHome(Model model){
		return "Home";
	}
	@GetMapping("/loginAluno")
	public String logarAluno(String email, String senha, Model model, RedirectAttributes ra) {
		if(alunoDAO.findByemailAndSenha(email, senha) != null){
			ra.addFlashAttribute("menssagem", "usuário logado com sucesso");
			return "redirect:/home";
	} else {
		ra.addFlashAttribute("menssagem", "usuário ou senha inválidos");
			return "redirect:/";
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
	 
	@GetMapping("/excluirAluno")
	public String excluirCliente(Integer id, RedirectAttributes ra) {
	this.alunoDAO.deleteById(id);
	ra.addFlashAttribute("menssagem", "usuário excluido com sucesso");
	return "redirect:/listaAluno";
	}
	
	
	
	
}
