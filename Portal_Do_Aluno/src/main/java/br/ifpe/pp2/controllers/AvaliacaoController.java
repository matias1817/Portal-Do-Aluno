
package br.ifpe.pp2.controllers;

import javax.servlet.http.HttpSession;

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
import br.ifpe.pp2.entities.Materias;
import br.ifpe.pp2.entities.Periodo;

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

	@GetMapping("/professor/cadAvaliacao")
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

	@PostMapping("/professor/salvarAvaliacao")
	public String salvarAvaliacao(Avaliacao avaliacao, RedirectAttributes ra) {
		if (avaliacaoDAO.findByalunosAndMateriasAndPeriodo(avaliacao.getAlunos(), avaliacao.getMaterias(),
				avaliacao.getPeriodo()) != null && avaliacao.getId() == null) {
			ra.addFlashAttribute("menssagemE", "nota desse aluno neste periodo já lançada");
			return "redirect:/professor/cadAvaliacao";
		} else {
			this.avaliacaoDAO.save(avaliacao);
			ra.addFlashAttribute("menssagemS", "avaliação salva com sucesso");
			return "redirect:/listaAvaliacao";
		}
	}
	@PostMapping("/professor/filtrarAvaliacao")
	public String filtar(String nome, Integer materia, Integer periodo, RedirectAttributes ra, Model model) {
		if(materia == null && periodo == null) {
			model.addAttribute("lista",this.avaliacaoDAO.filtrarAvaliacaoNome(nome));
			model.addAttribute("periodo", this.periodoDAO.findAll());
			model.addAttribute("materias", this.materiasDAO.findAll());
			return "filtroNota";
			
		}else{
			if(nome.isEmpty() && periodo == null) {
				model.addAttribute("lista",this.avaliacaoDAO.filtrarAvaliacaoMateria(materia));
				model.addAttribute("periodo", this.periodoDAO.findAll());
				model.addAttribute("materias", this.materiasDAO.findAll());
				return "filtroNota";
			} else {
			model.addAttribute("lista",this.avaliacaoDAO.filtrarAvaliacao(nome, materia, periodo));
			model.addAttribute("periodo", this.periodoDAO.findAll());
			model.addAttribute("materias", this.materiasDAO.findAll());
			return "filtroNota";
			}
		}
			
	}
	
	@GetMapping("/listaAvaliacao")
	public String exibirListaA(Model model) {

		model.addAttribute("periodo", this.periodoDAO.findAll());
		model.addAttribute("materias", this.materiasDAO.findAll());
		model.addAttribute("lista", this.avaliacaoDAO.findAll());

		return "filtroNota";
	}

	@GetMapping("/professor/excluirAvaliacao")
	public String excluirAvaliacao(Integer id, RedirectAttributes ra) {
		this.avaliacaoDAO.deleteById(id);
		ra.addFlashAttribute("menssagemS", "avaliação deletada com sucesso");
		return "redirect:/listaAvaliacao";
	}

	@GetMapping("/aluno/minhasNotas")
	public String boletim(Model model, HttpSession session) {
		model.addAttribute("lista", this.avaliacaoDAO.findAll());
		return "boletim";
	}
}
