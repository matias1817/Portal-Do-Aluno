package br.ifpe.pp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.pp2.DAO.InstituiçãoDAO;
import br.ifpe.pp2.entities.Frequencia;
import br.ifpe.pp2.entities.Instituição;

@Controller
public class InstituiçãoController {
	
	@Autowired
	InstituiçãoDAO instituiçãoDAO;
	
	@GetMapping("/admin/cadInstituição")
	public String exibirCad(Integer id, Model model) {
	if (id != null) {
	Instituição instituição = this.instituiçãoDAO.getById(id);
	model.addAttribute("instituicao", instituição);
	} else {
	model.addAttribute("instituicao", new Instituição());
	}
	return "cadI";
	}
	  
	@GetMapping("/admin/salvarInstituição")
	public String salvarInstituição(Instituição instituição,  RedirectAttributes ra) {
		 
		this.instituiçãoDAO.save(instituição);
		ra.addFlashAttribute("menssagemS", "Contatos da instituição salvos com sucesso");
		return "redirect:/listaInstituicao";
	} 
	
	@GetMapping("/admin/excluirInstituicao")
	public String excluirFrequencia(Integer id, RedirectAttributes ra) {
	this.instituiçãoDAO.deleteById(id);
	ra.addFlashAttribute("menssagemS", "Contatos da instituição deletada com sucesso");
	return "redirect:/listaInstituicao";
	}
}
