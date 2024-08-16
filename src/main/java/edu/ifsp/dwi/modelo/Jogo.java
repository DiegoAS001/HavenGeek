package edu.ifsp.dwi.modelo;

public class Jogo extends Entity {

	private String nome;
	private String tipo_midia;
	private Double preco;
	private String categoria;
	private String plataforma;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipoMidia() {
		return tipo_midia;
	}
	
	public void setTipoMidia(String midia) {
		this.tipo_midia = midia;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	
}
