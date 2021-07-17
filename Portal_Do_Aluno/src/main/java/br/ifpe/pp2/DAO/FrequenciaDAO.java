package br.ifpe.pp2.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.pp2.entities.Alunos;
import br.ifpe.pp2.entities.Frequencia;
import br.ifpe.pp2.entities.Materias;
import br.ifpe.pp2.entities.Periodo;

public interface FrequenciaDAO extends JpaRepository<Frequencia, Integer>{
	public Frequencia findByalunosAndMateriasAndPeriodo(Alunos alunos, Materias materias, Periodo periodo);
	
	@Query(value = "SELECT fr FROM Frequencia fr, Alunos al, Materias ma, Periodo pe WHERE fr.alunos.id = al.id and fr.materias.id = ma.id and fr.periodo.id = pe.id and  fr.alunos.nome like :nomeCliente and fr.materias.id = :materia and fr.periodo.id = :periodo")
    List<Frequencia> filtrarFrequencia(String nomeCliente,Integer materia, Integer periodo);
	
	@Query(value = "SELECT fr FROM Frequencia fr, Materias ma, Periodo pe WHERE fr.materias.id = ma.id and fr.periodo.id = pe.id and  fr.materias.id = :materia and fr.periodo.id = :periodo")
	List<Frequencia> filtrarFrequenciaMateriaPeriodo(Integer materia, Integer periodo);
	
	@Query(value = "SELECT fr FROM Frequencia fr, Alunos al, Materias ma WHERE fr.alunos.id = al.id and fr.materias.id = ma.id and  fr.alunos.nome like :nomeCliente and fr.materias.id = :materia")
	List<Frequencia> filtrarFrequenciaNomeMateria(String nomeCliente,Integer materia);
	
	@Query(value = "SELECT fr FROM Frequencia fr, Alunos al, Periodo pe WHERE fr.alunos.id = al.id and fr.periodo.id = pe.id and  fr.alunos.nome like :nomeCliente and fr.periodo.id = :periodo")
	List<Frequencia> filtrarFrequenciaNomePeriodo(String nomeCliente, Integer periodo);
	
	@Query(value = "SELECT fr FROM Frequencia fr,Periodo pe WHERE fr.periodo.id = pe.id and fr.periodo.id = :periodo")
	List<Frequencia> filtrarFrequenciaPeriodo(Integer periodo);
	
	@Query(value = "SELECT fr FROM Frequencia fr, Alunos al WHERE fr.alunos.id = al.id and fr.alunos.nome like :nomeCliente")
	List<Frequencia> filtrarFrequenciaNome(String nomeCliente);
	
	@Query(value = "SELECT fr FROM Frequencia fr, Materias ma WHERE fr.materias.id = ma.id and fr.materias.id = :materia")
	List<Frequencia> filtrarFrequenciaMateria(Integer materia);
}
