package br.ifpe.pp2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.entities.Admin;

public interface AdminDAO extends JpaRepository<Admin, Integer>{
	public Admin findByemailAndSenha(String email, String senha); 
}