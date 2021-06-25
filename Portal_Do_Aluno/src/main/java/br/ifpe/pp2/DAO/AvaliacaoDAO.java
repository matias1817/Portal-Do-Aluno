package br.ifpe.pp2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.entities.Avaliacao;

public interface AvaliacaoDAO extends JpaRepository<Avaliacao, Integer> {
	
}
