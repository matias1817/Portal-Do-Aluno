package br.ifpe.pp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.pp2.DAO.AlunoDAO;
import br.ifpe.pp2.DAO.FrequenciaDAO;
import br.ifpe.pp2.DAO.MateriasDAO;
import br.ifpe.pp2.DAO.PeriodoDAO;
import br.ifpe.pp2.entities.Frequencia;

@Controller 
public class FrequenciaController {
	@Autowired
	private AlunoDAO alunoDAO;
	
	@Autowired
	private FrequenciaDAO frequenciaDAO;
	
	@Autowired
	private PeriodoDAO periodoDAO;
	
	@Autowired 
	private MateriasDAO materiasDAO;
		
	
	@GetMapping("/cadFrequencia")
	public String exibirCad(Integer id, Model model) {
	if (id != null) {
	Frequencia frequencia = this.frequenciaDAO.getById(id);
	model.addAttribute("Frequencia", frequencia);
	} else {
	model.addAttribute("Frequencia", new Frequencia());
	}
	model.addAttribute("alunos", this.alunoDAO.findAll());
	model.addAttribute("periodo", this.periodoDAO.findAll());
	model.addAttribute("materias", this.materiasDAO.findAll());
	
	return "cadF";
	}
	  
	@PostMapping("/salvarFrequencia")
	public String salvarFrequencia(Frequencia frequencia,  RedirectAttributes ra) {
		
		this.frequenciaDAO.save(frequencia);
		ra.addFlashAttribute("menssagem", "Frequência salva com sucesso");
		return "redirect:/listaFrequencia";
	}
	 
	@GetMapping("/excluirFrequencia")
	public String excluirFrequencia(Integer id, RedirectAttributes ra) {
	this.frequenciaDAO.deleteById(id);
	ra.addFlashAttribute("menssagem", "Frequência deletada com sucesso");
	return "redirect:/listaFrequencia";
	}
	
	
}
