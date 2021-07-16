package br.ifpe.pp2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.entities.Materias;

public interface MateriasDAO extends JpaRepository< Materias , Integer>{
	public Materias findBynome(String nome);
	public Materias findByhorario(String horario);
}
