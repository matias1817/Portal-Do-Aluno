package br.ifpe.pp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.pp2.DAO.AlunoDAO;
import br.ifpe.pp2.DAO.CursoDAO;
import br.ifpe.pp2.entities.Alunos;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoDAO alunoDAO;
	
	@Autowired
	private CursoDAO cursoDAO;
	
	@GetMapping("/")
	public String exibirLogin(Model model) {
		return "login";
	}
	
	@GetMapping("/home")
	public String exibirHome(Model model){
		return "Home";
	}
	@GetMapping("/loginAluno")
	public String logarAluno(String email, String senha, Model model) {
		if(alunoDAO.findByemailAndSenha(email, senha) != null){
			return "redirect:/home";
	} else {
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
	public String salvarAluno(Alunos alunos) {
		this.alunoDAO.save(alunos);
		return "redirect:/";
	}
	 
	@GetMapping("/excluirAluno")
	public String excluirCliente(Integer id) {
	this.alunoDAO.deleteById(id);
	return "redirect:/home";
	}
	
	
	
	
}
