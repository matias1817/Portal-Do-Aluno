package br.ifpe.pp2.entities;

public class Instituição {
	private Integer id;
	private String numero;
	private String site;
	
	public Instituição(Integer id, String numero, String site) {
		super();
		this.id = id;
		this.numero = numero;
		this.site = site;
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
	
	
}
