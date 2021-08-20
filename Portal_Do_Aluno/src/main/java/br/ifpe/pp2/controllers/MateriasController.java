package br.ifpe.pp2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.pp2.DAO.CursoDAO;
import br.ifpe.pp2.DAO.MateriasDAO;
import br.ifpe.pp2.DAO.PeriodoDAO;
import br.ifpe.pp2.DAO.ProfessorDAO;
import br.ifpe.pp2.entities.Materias;

@Controller
public class MateriasController {
	@Autowired
	private MateriasDAO materiasDAO;
	@Autowired
	private ProfessorDAO professorDAO;
	@Autowired
	private CursoDAO cursoDAO;
	@Autowired
	private PeriodoDAO periodoDAO;
	
	@GetMapping("/admin/cadMateria")
	public String exibirCad(Integer id, Model model) {
	if (id != null) {
	Materias materias = this.materiasDAO.getById(id);
	model.addAttribute("Materias", materias);
	} else {
	model.addAttribute("Materias", new Materias());
	}
	model.addAttribute("curso", this.cursoDAO.findAll());
	model.addAttribute("professores", this.professorDAO.findAll());
	model.addAttribute("periodo", this.periodoDAO.findAll());
	return "cadM";
	} 
	   
	@PostMapping("/admin/salvarMateria")
	public String salvarMateria(Materias materias,  RedirectAttributes ra) {
		if( (materiasDAO.findBynome(materias.getNome()) != null ) && materias.getId() == null) {
			ra.addFlashAttribute("menssagemE", "materia já existente");
			return "redirect:/admin/cadMateria";
		} else {
		this.materiasDAO.save(materias);
		ra.addFlashAttribute("menssagemS", "materia salva com sucesso");
		return "redirect:/admin/listaMateria";
	}
		
	}
	 
	@GetMapping("/admin/excluirMaterias")
	public String excluirCurso(Integer id, RedirectAttributes ra) {
	this.materiasDAO.deleteById(id); 
	ra.addFlashAttribute("menssagemS", "materia excluida com sucesso");
	return "redirect:/admin/listaMateria";
	}
	@GetMapping("/aluno/meusHorarios")
	public String boletim(Model model, HttpSession session) {
		model.addAttribute("lista", this.materiasDAO.findAll());
		return "horario";
		}
	@GetMapping("/aluno/contatosProfessores")
	public String contatos(Model model, HttpSession session) {
		model.addAttribute("lista", this.materiasDAO.findAll());
		return "contatosProfessores";
	}
	
}
