package br.ifpe.pp2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.entities.Alunos;
import br.ifpe.pp2.entities.Avaliacao;
import br.ifpe.pp2.entities.Materias;
import br.ifpe.pp2.entities.Periodo;

public interface AvaliacaoDAO extends JpaRepository<Avaliacao, Integer> {
	public Avaliacao findByalunosAndMateriasAndPeriodo(Alunos aluno, Materias materias, Periodo periodo);
}
