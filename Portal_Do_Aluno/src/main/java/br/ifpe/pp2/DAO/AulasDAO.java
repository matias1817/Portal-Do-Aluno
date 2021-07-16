package br.ifpe.pp2.DAO;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.entities.Aulas;
import br.ifpe.pp2.entities.Materias;

public interface AulasDAO extends JpaRepository<Aulas, Integer> {
	public Aulas findBymaterialAndDataAndMaterias(String material, LocalDate data, Materias materias);
}
