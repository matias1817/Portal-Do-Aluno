package br.ifpe.pp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.ifpe.pp2.DAO.AlunoDAO;
import br.ifpe.pp2.DAO.AulasDAO;
import br.ifpe.pp2.DAO.AvaliacaoDAO;
import br.ifpe.pp2.DAO.CursoDAO;
import br.ifpe.pp2.DAO.FrequenciaDAO;
import br.ifpe.pp2.DAO.InstituiçãoDAO;
import br.ifpe.pp2.DAO.MateriasDAO;
import br.ifpe.pp2.DAO.PeriodoDAO;

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

	@Autowired
	private AvaliacaoDAO avaliacaoDAO;

	@Autowired
	InstituiçãoDAO instituiçãoDAO;

	@Autowired
	AulasDAO aulasDAO;

	@Autowired
	PeriodoDAO periodoDAO;

	@GetMapping("/aluno/listaAluno")
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
		return "listaMP";
	}

	@GetMapping("/admin/listaMateria")
	public String exibirListaMA(Model model) {
		model.addAttribute("lista", this.materiasDAO.findAll());
		return "listaM";
	}

	@GetMapping("/listaFrequencia")
	public String exibirListaF(Model model) {
		model.addAttribute("lista", this.frequenciaDAO.findAll());
		return "listaF";
	}

	

	@GetMapping("/listaInstituicao")
	public String exibirListaI(Model model) {
		model.addAttribute("lista", this.instituiçãoDAO.findAll());
		return "listaI";
	}

	@GetMapping("/listaAulas")
	public String exibirListaAulas(Model model) {
		model.addAttribute("lista", this.aulasDAO.findAll());
		return "listaAulas";
	}
}
