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
		
	
	@GetMapping("/professor/cadFrequencia")
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
	  
	@PostMapping("/professor/salvarFrequencia")
	public String salvarFrequencia(Frequencia frequencia,  RedirectAttributes ra) {
		if (frequenciaDAO.findByalunosAndMateriasAndPeriodo(frequencia.getAlunos(), frequencia.getMaterias(), frequencia.getPeriodo()) != null && frequencia.getId() == null) {
			ra.addFlashAttribute("menssagemE", "faltas desse aluno nessa materia e nesse periodo já lançados, clique a baixo caso queira editar");
			return "redirect:/professor/cadFrequencia";
		} else {
		this.frequenciaDAO.save(frequencia);
		ra.addFlashAttribute("menssagemS", "Frequência salva com sucesso");
		return "redirect:/listaFrequencia";
	}
	}
	  
	@GetMapping("/professor/excluirFrequencia")
	public String excluirFrequencia(Integer id, RedirectAttributes ra) {
	this.frequenciaDAO.deleteById(id);
	ra.addFlashAttribute("menssagemS", "Frequência deletada com sucesso");
	return "redirect:/listaFrequencia";
	}
	@GetMapping("/aluno/minhaFrequencia")
	public String boletim(Model model) {
		model.addAttribute("lista", this.frequenciaDAO.findAll());
		model.addAttribute("periodo", this.periodoDAO.findAll());
		model.addAttribute("materias", this.materiasDAO.findAll());
		return "frequencia";
	}
	@GetMapping("/listaFrequencia")
	public String exibirListaF(Model model) {
		
		model.addAttribute("lista", this.frequenciaDAO.findAll());
		model.addAttribute("periodo", this.periodoDAO.findAll());
		model.addAttribute("materias", this.materiasDAO.findAll());

		return "listaF";
	}

	@PostMapping("/professor/filtrarFrequencia")
	public String filtar(String nome, Integer materia, Integer periodo, RedirectAttributes ra, Model model) {
		if (materia == null && periodo == null) {
			model.addAttribute("lista", this.frequenciaDAO.filtrarFrequenciaNome(nome));
			model.addAttribute("periodo", this.periodoDAO.findAll());
			model.addAttribute("materias", this.materiasDAO.findAll());
			return "listaF";

		} else {
			if (nome.isEmpty() && periodo == null) {
				model.addAttribute("lista", this.frequenciaDAO.filtrarFrequenciaMateria(materia));
				model.addAttribute("periodo", this.periodoDAO.findAll());
				model.addAttribute("materias", this.materiasDAO.findAll());
				return "listaF";
			} else {
				if (nome.isEmpty() && materia == null) {
					model.addAttribute("lista", this.frequenciaDAO.filtrarFrequenciaPeriodo(periodo));
					model.addAttribute("periodo", this.periodoDAO.findAll());
					model.addAttribute("materias", this.materiasDAO.findAll());
					return "listaF";
				} else {
					if (materia == null) {
						model.addAttribute("lista", this.frequenciaDAO.filtrarFrequenciaNomePeriodo(nome, periodo));
						model.addAttribute("periodo", this.periodoDAO.findAll());
						model.addAttribute("materias", this.materiasDAO.findAll());
						return "listaF";
					} else {
						if (periodo == null) {
							model.addAttribute("lista", this.frequenciaDAO.filtrarFrequenciaNomeMateria(nome, materia));
							model.addAttribute("periodo", this.periodoDAO.findAll());
							model.addAttribute("materias", this.materiasDAO.findAll());
							return "listaF";
						} else {
							if (nome.isEmpty()) {
								model.addAttribute("lista",
										this.frequenciaDAO.filtrarFrequenciaMateriaPeriodo(materia, periodo));
								model.addAttribute("periodo", this.periodoDAO.findAll());
								model.addAttribute("materias", this.materiasDAO.findAll());
								return "listaF";
							} else {
								model.addAttribute("lista",
										this.frequenciaDAO.filtrarFrequencia(nome, materia, periodo));
								model.addAttribute("periodo", this.periodoDAO.findAll());
								model.addAttribute("materias", this.materiasDAO.findAll());
								return "listaF";
							}
						}
					}
				}
			}
		}

	}
	
	@PostMapping("/aluno/filtrarFrequencia")
	public String filtarAluno(Integer materia, Integer periodo, RedirectAttributes ra, Model model) {
		if (periodo == null) {
			model.addAttribute("lista", this.frequenciaDAO.filtrarFrequenciaMateria(materia));
			model.addAttribute("periodo", this.periodoDAO.findAll());
			model.addAttribute("materias", this.materiasDAO.findAll());
			return "frequencia";
		} else {
			if (materia == null) {
				model.addAttribute("lista", this.frequenciaDAO.filtrarFrequenciaPeriodo(periodo));
				model.addAttribute("periodo", this.periodoDAO.findAll());
				model.addAttribute("materias", this.materiasDAO.findAll());
				return "frequencia";
			} else {
				model.addAttribute("lista", this.frequenciaDAO.filtrarFrequenciaMateriaPeriodo(materia, periodo));
				model.addAttribute("periodo", this.periodoDAO.findAll());
				model.addAttribute("materias", this.materiasDAO.findAll());
				return "frequencia";
			}
		}
	}
	
}
