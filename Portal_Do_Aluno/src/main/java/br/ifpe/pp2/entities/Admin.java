package br.ifpe.pp2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String email;
	private String senha;
	public Admin(String email, String senha, Integer id) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
	}
	public Admin() {
		super();
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
