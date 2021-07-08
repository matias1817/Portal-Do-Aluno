package br.ifpe.pp2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.pp2.DAO.AdminDAO;
import br.ifpe.pp2.DAO.ProfessorDAO;
import br.ifpe.pp2.entities.Admin;
import br.ifpe.pp2.entities.Professores;

@Controller
public class ProfessorController {
	
	@Autowired
	private ProfessorDAO professorDAO;
	
	@Autowired
	private AdminDAO adminDAO;
	
	@GetMapping("/loginProf")
	public String exibirLogin(Model model) {
		return "loginP";
	}
	
	@GetMapping("/professor/home")
	public String exibirHomeP(Model model){
		
		return "HomeP";
	}
	@GetMapping("/loginProfessor")
	public String logarAluno(String email, String senha, Model model, RedirectAttributes ra, HttpSession session) {
		Admin adminLogado = this.adminDAO.findByemailAndSenha(email, senha);
		if (adminLogado != null) {
			session.setAttribute("adminLogado", adminLogado);
			ra.addFlashAttribute("menssagem", "admin logado com sucesso");
			return "redirect:/admin/home";
		} else {
		
		Professores professorLogado = this.professorDAO.findByemailAndSenha(email, senha);
		if(professorLogado != null){
			ra.addFlashAttribute("menssagem", "usuário logado com sucesso");
			session.setAttribute("professorLogado", professorLogado);
			return "redirect:/professor/home";
		} else {
			ra.addFlashAttribute("menssagem", "usuário ou senha inválidos");
			return "redirect:/loginProf";
	}	}
	}
	
	@GetMapping("/cadP")
	public String exibirCadP(Integer id, Model model) {
	if (id != null) {
	Professores professores = this.professorDAO.getById(id);
	model.addAttribute("Professor", professores);
	} else {
	model.addAttribute("Professor", new Professores());
	}

	model.addAttribute("lista", this.professorDAO.findAll());
	
	return "cadP";
	}
	  
	@PostMapping("/salvarProfessores")
	public String salvarProfessor(Professores professores, RedirectAttributes ra) {
		this.professorDAO.save(professores);
		ra.addFlashAttribute("menssagem", "usuário salvo com sucesso");
		return "redirect:/P";
	}
	 
	@GetMapping("/professor/excluirProfessor")
	public String excluirProfessor(Integer id, RedirectAttributes ra) {
	this.professorDAO.deleteById(id);
	ra.addFlashAttribute("menssagem", "usuário excluido com sucesso");
	return "redirect:/listaP";
	}
	@GetMapping("/listaProfessor")
	public String exibirLista(Model model) {
		model.addAttribute("lista", this.professorDAO.findAll()); 
		return "listaP";
	}
	
}
