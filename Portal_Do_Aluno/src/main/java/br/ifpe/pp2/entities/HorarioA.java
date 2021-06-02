package br.ifpe.pp2.entities;

public class HorarioA {
	private Integer id;
	private String horario;
	private Materias materias;
	private Alunos alunos;
	private Periodo periodo;
	
	public HorarioA(Integer id, String horario, Materias materias, Alunos alunos, Periodo periodo) {
		super();
		this.id = id;
		this.horario = horario;
		this.materias = materias;
		this.alunos = alunos;
		this.periodo = periodo;
	}

	public HorarioA() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Materias getMaterias() {
		return materias;
	}

	public void setMaterias(Materias materias) {
		this.materias = materias;
	}

	public Alunos getAlunos() {
		return alunos;
	}

	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	
	
}
