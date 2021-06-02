package br.ifpe.pp2.entities;

import java.util.List;

public class Alunos {
	private Integer id;
	private String nome; 
	private String senha;
	private String matricula;
	private String sexo;
	private String email;
	private Curso curso;
	private List<Frequencia> frequencia;
	private List<Avaliacao> avaliacao;
	private List<HorarioA> horarioA;
	
	
	public Alunos(Integer id, String nome, String senha, String matricula, String sexo, String email, Curso curso,
			List<Frequencia> frequencia, List<Avaliacao> avaliacao, List<HorarioA> horarioA) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.matricula = matricula;
		this.sexo = sexo;
		this.email = email;
		this.curso = curso;
		this.frequencia = frequencia;
		this.avaliacao = avaliacao;
		this.horarioA = horarioA;
	}

	public Alunos() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Frequencia> getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(List<Frequencia> frequencia) {
		this.frequencia = frequencia;
	}

	public List<Avaliacao> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(List<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<HorarioA> getHorarioA() {
		return horarioA;
	}

	public void setHorarioA(List<HorarioA> horarioA) {
		this.horarioA = horarioA;
	}
	
	
}