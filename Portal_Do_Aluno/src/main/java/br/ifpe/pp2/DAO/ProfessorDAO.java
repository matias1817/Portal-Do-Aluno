package br.ifpe.pp2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import br.ifpe.pp2.entities.Professores;

public interface ProfessorDAO extends JpaRepository<Professores, Integer> {
	public Professores findByemailAndSenha(String email, String senha); 
	public Professores findBycpf(String cpf);
}
