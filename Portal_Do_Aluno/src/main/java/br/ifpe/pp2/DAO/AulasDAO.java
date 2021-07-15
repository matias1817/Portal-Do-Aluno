package br.ifpe.pp2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.entities.Aulas;

public interface AulasDAO extends JpaRepository<Aulas, Integer> {
	public Aulas findBymaterial(String material);
}
