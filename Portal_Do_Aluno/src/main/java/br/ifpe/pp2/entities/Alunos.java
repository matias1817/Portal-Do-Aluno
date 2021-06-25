package br.ifpe.pp2.entities;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;

@Entity
public class Alunos {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String nome; 
	private String senha;
	private String matricula;
	private String sexo;
	private String email;
	@ManyToOne 
	private Curso curso;
	
	@OneToMany//( orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Frequencia> frequencia;//@Fetch(FetchMode.SUBSELECT)
	
	
	@OneToMany//( orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacao;//@Fetch(FetchMode.SUBSELECT)
	
	
	
	public Alunos(Integer id, String nome, String senha, String matricula, String sexo, String email, Curso curso,
			List<Frequencia> frequencia, List<Avaliacao> avaliacao) {
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

}
