package br.ifpe.pp2.entities;

public class Instituição {
	private Integer id;
	private String numero;
	private String endereco;
	private String site;
	
	public Instituição(Integer id, String numero, String site, String endereco) {
		super();
		this.id = id;
		this.numero = numero;
		this.site = site;
		this.endereco = endereco;
	}
	public Instituição() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
