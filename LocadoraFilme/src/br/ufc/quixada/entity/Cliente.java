package br.ufc.quixada.entity;

/**
 * @author Anderson Uchoa
 */

public class Cliente {

	private long  cpf;
	private String nome;
	private String estado;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String logradouro;
	private long numero;
	
	public Cliente(long cpf, String nome, String estado,String complemento, String cep, String bairro, String cidade, String logradouro, long numero ) {
		this.cpf = cpf;
		this.cep = cep;
		this.nome = nome;
		this.cidade = cidade;
		this.complemento = complemento;
		this.numero = numero;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.estado = estado;	
	}

	public Cliente() {
		super();
	}
	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public String getCep(){
		return cep;
	}
	public void setCep(String cep){
		this.cep = cep;	
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCidade(String cidade){
		this.cidade = cidade;
	}
	public String getCidade(){
		return cidade;
	}
	
	public void setComplemento(String complemento){
		this.complemento = complemento;
	}
	public String getComplemento(){
		return complemento;
	}
	
	public String getLogradouro( ) {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public long getNumero(){
		return numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String  getEstado( ){
		return estado;
	}
	public void setEstado(String estado){
		this.estado = estado;
	}

	
	public String toString() {
		return " [cpf=" + cpf + ",  nome=" + nome+ ", estado=" + estado + ", logradouro=" + logradouro + ",complemento="+ complemento+",cep="+ cep +",bairro="+ bairro+",cidade="+ cidade+",numero="+numero+ "]";
	}
}
