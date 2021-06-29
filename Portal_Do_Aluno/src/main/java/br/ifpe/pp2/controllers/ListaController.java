package br.ifpe.pp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.ifpe.pp2.DAO.AlunoDAO;
import br.ifpe.pp2.DAO.CursoDAO;
import br.ifpe.pp2.DAO.FrequenciaDAO;
import br.ifpe.pp2.DAO.MateriasDAO;

@Controller
public class ListaController {
	
	@Autowired
	private AlunoDAO alunoDAO;
	
	@Autowired
	private CursoDAO cursoDAO;
	
	@Autowired
	private MateriasDAO materiasDAO;
	
	@Autowired
	private FrequenciaDAO frequenciaDAO;
	
	@GetMapping("/listaAluno")
	public String exibirLista(Model model) {
		model.addAttribute("lista", this.alunoDAO.findAll()); 
		return "Lista";
	}
	
	@GetMapping("/listaCurso")
	public String exibirListaC(Model model) {
		model.addAttribute("lista", this.cursoDAO.findAll());
		return "listaC";
	}
	@GetMapping("/listaMateria")
	public String exibirListaM(Model model) {
		model.addAttribute("lista", this.materiasDAO.findAll());
		return "listaM";
	}
	@GetMapping("/listaFrequencia")
	public String exibirListaF(Model model) {
		model.addAttribute("lista", this.frequenciaDAO.findAll());
		return "listaF";
	}
}
