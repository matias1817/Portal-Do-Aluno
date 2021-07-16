package br.ifpe.pp2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.entities.Alunos;
import br.ifpe.pp2.entities.Frequencia;
import br.ifpe.pp2.entities.Materias;
import br.ifpe.pp2.entities.Periodo;

public interface FrequenciaDAO extends JpaRepository<Frequencia, Integer>{
	public Frequencia findByalunosAndMateriasAndPeriodo(Alunos alunos, Materias materias, Periodo periodo);
}
