
package br.ifpe.pp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.pp2.DAO.AlunoDAO;
import br.ifpe.pp2.DAO.AvaliacaoDAO;
import br.ifpe.pp2.DAO.MateriasDAO;
import br.ifpe.pp2.DAO.PeriodoDAO;
import br.ifpe.pp2.entities.Avaliacao;

@Controller
public class AvaliacaoController {
	@Autowired
	private AvaliacaoDAO avaliacaoDAO;
	@Autowired
	private AlunoDAO alunoDAO; 
	
	@Autowired
	private PeriodoDAO periodoDAO;
	
	@Autowired 
	private MateriasDAO materiasDAO;
		
	
	@GetMapping("/professor/cadNotas")
	public String exibirCad(Integer id, Model model) {
	if (id != null) {
		
	Avaliacao avaliacao = this.avaliacaoDAO.getById(id);
	model.addAttribute("Avaliacao", avaliacao);
	} else {
	model.addAttribute("Avaliacao", new Avaliacao());
	}
	model.addAttribute("alunos", this.alunoDAO.findAll());
	model.addAttribute("periodo", this.periodoDAO.findAll());
	model.addAttribute("materias", this.materiasDAO.findAll());
	
	return "cadA";
	}
	 
	@PostMapping("/salvarAvaliacao")
	public String salvarAvaliacao(Avaliacao avaliacao,  RedirectAttributes ra) {
		this.avaliacaoDAO.save(avaliacao);
		ra.addFlashAttribute("menssagem", "avaliação salva com sucesso");
		return "redirect:/listaAvaliacao";
	}
	
	@GetMapping("/excluirAvaliacao")
	public String excluirAvaliacao(Integer id,  RedirectAttributes ra) {
	this.avaliacaoDAO.deleteById(id);
	ra.addFlashAttribute("menssagem", "avaliação deletada com sucesso");
	return "redirect:/listaAvaliacao";
	}
}
