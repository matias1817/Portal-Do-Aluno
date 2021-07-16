package br.ifpe.pp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.pp2.DAO.AulasDAO;
import br.ifpe.pp2.DAO.MateriasDAO;
import br.ifpe.pp2.DAO.ProfessorDAO;
import br.ifpe.pp2.entities.Aulas;

@Controller
public class AulasContrroller {
	@Autowired
	private AulasDAO aulasDAO;
	
	@Autowired
	private ProfessorDAO professorDAO;
	
	@Autowired 
	private MateriasDAO materiasDAO;
		
	
	@GetMapping("/professor/cadAulas")
	public String exibirCad(Integer id, Model model) {
	
	if (id != null) {
		
	Aulas aulas = this.aulasDAO.getById(id);
	model.addAttribute("aulas", aulas);
	} else {
	model.addAttribute("aulas", new Aulas());
	}
	model.addAttribute("alunos", this.aulasDAO.findAll());
	model.addAttribute("professores", this.professorDAO.findAll());
	model.addAttribute("materias", this.materiasDAO.findAll());
	
	return "cadAulas";
	}
	 
	@PostMapping("/professor/salvarAulas")
	public String salvarAvaliacao(Aulas aulas,  RedirectAttributes ra) {
		 if(aulasDAO.findBymaterialAndDataAndMaterias(aulas.getMaterial(), aulas.getData(), aulas.getMaterias()) != null && aulas.getId() == null) {
			 ra.addFlashAttribute("menssagemE", "Conteudo de aula já postado");
				return "redirect:/professor/cadAulas";
		 } else {
		this.aulasDAO.save(aulas);
		ra.addFlashAttribute("menssagemS", "conteudo da aula salvo com sucesso");
		return "redirect:/listaAulas";
		}
	}
	
	@GetMapping("/professor/excluirAulas")
	public String excluirAvaliacao(Integer id,  RedirectAttributes ra) {
	this.aulasDAO.deleteById(id);
	ra.addFlashAttribute("menssagemS", "conteudo da aula deletada com sucesso");
	return "redirect:/listaAulas";
	}
	@GetMapping("/aluno/materiais")
	public String materias(Model model) {
		model.addAttribute("lista", this.aulasDAO.findAll());
		return "materias";
}
	
}