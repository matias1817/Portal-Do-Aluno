package br.ifpe.pp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.pp2.DAO.CursoDAO;
import br.ifpe.pp2.entities.Curso; 

@Controller 
public class CursoController {

	@Autowired
	private CursoDAO cursoDAO;
	
	@GetMapping("/cadCurso")
	public String exibirCad(Integer id, Model model) {
	if (id != null) {
	Curso curso = this.cursoDAO.getById(id);
	model.addAttribute("Curso", curso);
	} else {
	model.addAttribute("Curso", new Curso());
	}
	return "cadC";
	}
	  
	@PostMapping("/salvarCurso")
	public String salvarCurso(Curso curso) {
		this.cursoDAO.save(curso);
		return "redirect:/listaCurso";
	}
	 
	@GetMapping("/excluirCurso")
	public String excluirCurso(Integer id) {
	this.cursoDAO.deleteById(id); 
	return "redirect:/listaCurso";
	}
}
