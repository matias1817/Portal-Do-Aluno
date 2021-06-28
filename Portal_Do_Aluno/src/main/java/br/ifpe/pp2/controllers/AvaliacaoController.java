
package br.ifpe.pp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.pp2.DAO.AlunoDAO;
import br.ifpe.pp2.DAO.AvaliacaoDAO;
import br.ifpe.pp2.entities.Alunos;
import br.ifpe.pp2.entities.Avaliacao;

@Controller
public class AvaliacaoController {
	@Autowired
	private AvaliacaoDAO avaliacaoDAO;
	@Autowired
	private AlunoDAO alunoDAO;
	
	
	@PostMapping("/salvarAvaliacao")
	public String salvarAvaliacao(Integer id, Avaliacao avaliacao) {
		Alunos alunos = this.alunoDAO.getById(id);

		avaliacao.setAlunos(alunos);
		this.avaliacaoDAO.save(avaliacao);

		return "";
	}
}
