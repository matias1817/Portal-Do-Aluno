package br.ifpe.pp2.entities;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;

@Entity
public class Professores {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String senha;
	private String nome;
	private String cpf;
	private String rg;
	private String telefone;
	private String endereco;
	
	@OneToMany// ( orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Aulas> aulas;//@Fetch(FetchMode.SUBSELECT)
	
	
	@OneToMany//( orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Materias> materias;//@Fetch(FetchMode.SUBSELECT)


	public Professores(Integer id, String email, String senha, String nome, String cpf, String rg, String telefone,
			String endereco, List<Aulas> aulas, List<Materias> materias) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.endereco = endereco;
		this.aulas = aulas;
		this.materias = materias;
	}
	
	public Professores() {
		super();
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public List<Aulas> getAulas() {
		return aulas;
	}


	public void setAulas(List<Aulas> aulas) {
		this.aulas = aulas;
	}


	public List<Materias> getMaterias() {
		return materias;
	}


	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
	}
	
	
	
}
