package br.ifpe.pp2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifpe.pp2.entities.Curso;

public interface CursoDAO extends JpaRepository< Curso , Integer>{
	public Curso findBynome(String nome); 
}
