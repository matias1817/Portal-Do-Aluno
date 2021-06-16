package br.ifpe.pp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.ifpe.pp2.DAO.AlunoDAO;

@Controller
public class ListaController {
	
	@Autowired
	private AlunoDAO alunoDAO;
	
	@GetMapping("/listaAluno")
	public String exibirLista(Model model) {
		model.addAttribute("lista", this.alunoDAO.findAll()); 
		return "Lista";
	}

}
