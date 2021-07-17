package br.ifpe.pp2.DAO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.pp2.entities.Aulas;
import br.ifpe.pp2.entities.Materias;

public interface AulasDAO extends JpaRepository<Aulas, Integer> {
	public Aulas findBymaterialAndDataAndMaterias(String material, LocalDate data, Materias materias);
	
	@Query(value = "SELECT au FROM Aulas au, Materias ma WHERE au.materias.id = ma.id and au.data = data and  au.materias.id = :materia and au.data = :data")
	List<Aulas> filtrarAulasMaterias(Integer materia, LocalDate data);
	
	
	@Query(value = "SELECT au FROM Aulas au WHERE au.data = data and au.data = :data")
	List<Aulas> filtrarAulasData(LocalDate data);
	 
	@Query(value = "SELECT au FROM Aulas au, Materias ma WHERE au.materias.id = ma.id and au.materias.id = :materia")
	List<Aulas> filtrarAulasMateria(Integer materia);
}
