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
			ra.addFlashAttribute("menssagemS", "admin logado com sucesso");
			return "redirect:/admin/home";
		} else {
		
		Professores professorLogado = this.professorDAO.findByemailAndSenha(email, senha);
		if(professorLogado != null){
			ra.addFlashAttribute("menssagemS", "usuário logado com sucesso");
			session.setAttribute("professorLogado", professorLogado);
			return "redirect:/professor/home";
		} else {
			ra.addFlashAttribute("menssagemE", "usuário ou senha inválidos");
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
	@GetMapping("/admin/cadP")
	public String exibirCadPAdmin(Integer id, Model model) {
		if (id != null) {
			Professores professores = this.professorDAO.getById(id);
			model.addAttribute("Professor", professores);
		} else {
			model.addAttribute("Professor", new Professores());
		}
		
		model.addAttribute("lista", this.professorDAO.findAll());
		
		return "cadPAdmin";
	}
	  
	@PostMapping("/salvarProfessores")
	public String editarProfessor(Professores professores, RedirectAttributes ra) {
		if(professorDAO.findBycpf(professores.getCpf()) != null && professores.getId() == null) {
			ra.addFlashAttribute("menssagemE", "Professor existente");
			return "redirect:/cadP";
			
			
		} else {
		this.professorDAO.save(professores);
		ra.addFlashAttribute("menssagemS", "usuário editado com sucesso");
		return "redirect:/professor/home";
		}
	}
	@GetMapping("/admin/salvarProfessores")
	public String salvarProfessor(Professores professores, RedirectAttributes ra) {
		if(professorDAO.findBycpf(professores.getCpf()) != null && professores.getId() == null) {
			ra.addFlashAttribute("menssagemE", "Professor existente");
			return "redirect:/admin/cadP";
		} else {
		this.professorDAO.save(professores);
		ra.addFlashAttribute("menssagemS", "usuário salvo com sucesso");
		return "redirect:/admin/listaProfessor";
		}	
		}
	 
	@GetMapping("/excluirProfessor")
	public String excluirProfessor(Integer id, RedirectAttributes ra) {
	this.professorDAO.deleteById(id);
	ra.addFlashAttribute("menssagemS", "usuário excluido com sucesso");
	return "redirect:/listaProfessor";
	}
	@GetMapping("/admin/excluirProfessor")
	public String excluirProfessorA(Integer id, RedirectAttributes ra) {
		this.professorDAO.deleteById(id);
		ra.addFlashAttribute("menssagemS", "usuário excluido com sucesso");
		return "redirect:/admin/listaProfessor";
	}
	@GetMapping("/listaProfessor")
	public String exibirLista(Model model) {
		model.addAttribute("lista", this.professorDAO.findAll()); 
		return "listaP";
	}
	@GetMapping("/admin/listaProfessor")
	public String exibirListaA(Model model) {
		model.addAttribute("lista", this.professorDAO.findAll()); 
		return "listaPAdmin";
	}
	
}
