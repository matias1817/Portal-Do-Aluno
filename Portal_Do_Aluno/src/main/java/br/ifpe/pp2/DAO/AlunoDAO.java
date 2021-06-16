package br.ifpe.pp2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.entities.Alunos;

public interface AlunoDAO extends JpaRepository<Alunos, Integer>{
	public Alunos findByemailAndSenha(String email, String senha); 
}