package br.ifpe.pp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.pp2.DAO.ProfessorDAO;
import br.ifpe.pp2.entities.Professores;

@Controller
public class ProfessorController {
	
	@Autowired
	private ProfessorDAO professorDAO;
	
	@GetMapping("/P")
	public String exibirLogin(Model model) {
		return "loginP";
	}
	
	@GetMapping("/homeP")
	public String exibirHomeP(Model model){
		return "HomeP";
	}
	@GetMapping("/loginProfessor")
	public String logarAluno(String email, String senha, Model model) {
		if(professorDAO.findByemailAndSenha(email, senha) != null){
			return "redirect:/homeP";
		} else {
			return "redirect:/P";
	}	
	}
	
	@GetMapping("/cadP")
	public String exibirCadP(Integer id, Model model) {
	if (id != null) {
	Professores professores = this.professorDAO.getById(id);
	model.addAttribute("Professor", professores);
	} else {
	model.addAttribute("Professor", new Professores());
	}

	model.addAttribute("lista", this.professorDAO.findAll());
	
	return "cadP";
	}
	  
	@PostMapping("/salvarProfessores")
	public String salvarProfessor(Professores professores) {
		this.professorDAO.save(professores);
		return "redirect:/P";
	}
	 
	@GetMapping("/excluirProfessor")
	public String excluirProfessor(Integer id) {
	this.professorDAO.deleteById(id);
	return "redirect:/listaP";
	}
	@GetMapping("/listaP")
	public String exibirLista(Model model) {
		model.addAttribute("lista", this.professorDAO.findAll()); 
		return "listaP";
	}
	
}
