package br.ifpe.pp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.pp2.DAO.CursoDAO;
import br.ifpe.pp2.entities.Curso; 

@Controller 
public class CursoController {

	@Autowired
	private CursoDAO cursoDAO;
	
	@GetMapping("/admin/cadCurso")
	public String exibirCad(Integer id, Model model) {
	if (id != null) {
	Curso curso = this.cursoDAO.getById(id);
	model.addAttribute("Curso", curso);
	} else {
	model.addAttribute("Curso", new Curso());
	}
	return "cadC";
	}
	  
	@PostMapping("/admin/salvarCurso")
	public String salvarCurso(Curso curso, RedirectAttributes ra) {
		this.cursoDAO.save(curso);
		ra.addFlashAttribute("menssagemS", "curso salvo com sucesso");
		return "redirect:/listaCurso";
	}
	 
	@GetMapping("/admin/excluirCurso")
	public String excluirCurso(Integer id,RedirectAttributes ra ) {
	this.cursoDAO.deleteById(id); 
	ra.addFlashAttribute("menssagemS", "curso deletado com sucesso");
	return "redirect:/listaCurso";
	}
}
