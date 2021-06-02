package br.ifpe.pp2.entities;

public class HorarioP {
	private Integer id;
	private String horario;
	private Professores professores;
	private Materias materias;
	private Periodo periodo;
	
	public HorarioP(Integer id, String horario, Professores professores, Materias materias, Periodo periodo) {
		super();
		this.id = id;
		this.horario = horario;
		this.professores = professores;
		this.materias = materias;
		this.periodo = periodo;
	}

	public HorarioP() {
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

	public Professores getProfessores() {
		return professores;
	}

	public void setProfessores(Professores professores) {
		this.professores = professores;
	}

	public Materias getMaterias() {
		return materias;
	}

	public void setMaterias(Materias materias) {
		this.materias = materias;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	
	
}
