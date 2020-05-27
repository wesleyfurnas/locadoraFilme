package br.ufc.quixada.entity;

/**
 * @author Anderson Uchoa
 */

public class Consulta {

	private String nome_comprador;
	private String titulo_filme;
	
	public Consulta( String nome_comprador, String titulo_filme){
		this.nome_comprador = nome_comprador;
		this.titulo_filme = titulo_filme;	
	}

	public Consulta() {
		super();
	}
	
	public String getNome_comprador() {
		return nome_comprador;
	}
	public void setNome_comprador(String nome_comprador) {
		this.nome_comprador = nome_comprador;
	}
	
	public String getTitulo_filme(){
		return titulo_filme;
	}
	public void setTitulo_filme(String titulo_filme){
		this.titulo_filme = titulo_filme;	
	}
		
	public String toString() {
		return " [titulo_filme=" + titulo_filme+ ",  nome_comprador=" + nome_comprador+  "]";
	}
}

