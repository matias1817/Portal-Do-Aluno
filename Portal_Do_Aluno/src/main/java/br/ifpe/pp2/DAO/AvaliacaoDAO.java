package br.ifpe.pp2.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.pp2.entities.Alunos;
import br.ifpe.pp2.entities.Avaliacao;
import br.ifpe.pp2.entities.Materias;
import br.ifpe.pp2.entities.Periodo;

public interface AvaliacaoDAO extends JpaRepository<Avaliacao, Integer> {
	public Avaliacao findByalunosAndMateriasAndPeriodo(Alunos aluno, Materias materias, Periodo periodo);
	
	@Query(value = "SELECT av FROM Avaliacao av, Alunos al, Materias ma, Periodo pe WHERE av.alunos.id = al.id and av.materias.id = ma.id and av.periodo.id = pe.id and  av.alunos.nome like :nomeCliente and av.materias.id = :materia and av.periodo.id = :periodo")
    List<Avaliacao> filtrarAvaliacao(String nomeCliente,Integer materia, Integer periodo);
	
	@Query(value = "SELECT av FROM Avaliacao av, Materias ma, Periodo pe WHERE av.materias.id = ma.id and av.periodo.id = pe.id and  av.materias.id = :materia and av.periodo.id = :periodo")
	List<Avaliacao> filtrarAvaliacaoMateriaPeriodo(Integer materia, Integer periodo);
	
	@Query(value = "SELECT av FROM Avaliacao av, Alunos al, Materias ma WHERE av.alunos.id = al.id and av.materias.id = ma.id and  av.alunos.nome like :nomeCliente and av.materias.id = :materia")
	List<Avaliacao> filtrarAvaliacaoNomeMateria(String nomeCliente,Integer materia);
	
	@Query(value = "SELECT av FROM Avaliacao av, Alunos al, Periodo pe WHERE av.alunos.id = al.id and av.periodo.id = pe.id and  av.alunos.nome like :nomeCliente and av.periodo.id = :periodo")
	List<Avaliacao> filtrarAvaliacaoNomePeriodo(String nomeCliente, Integer periodo);
	
	@Query(value = "SELECT av FROM Avaliacao av,Periodo pe WHERE av.periodo.id = pe.id and av.periodo.id = :periodo")
	List<Avaliacao> filtrarAvaliacaoPeriodo(Integer periodo);
	
	@Query(value = "SELECT av FROM Avaliacao av, Alunos al WHERE av.alunos.id = al.id and av.alunos.nome like :nomeCliente")
	List<Avaliacao> filtrarAvaliacaoNome(String nomeCliente);
	
	@Query(value = "SELECT av FROM Avaliacao av, Materias ma WHERE av.materias.id = ma.id and av.materias.id = :materia")
	List<Avaliacao> filtrarAvaliacaoMateria(Integer materia);
}
