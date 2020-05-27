package br.ufc.quixada.entity;

import java.util.Date;

import javax.xml.crypto.Data;

public class Cadastro {

	private int id_dvd;
	private long cpf_func;
	private long cpf_cliente;
	private int id_aluguel;
	private String data_aluguel;
	private String data_devolucao;
	private String data_entregue;
	private float multa;
	
	public Cadastro(int id_dvd,long cpf_func,long cpf_cliente,int id_aluguel,String data_aluguel, String data_devolucao,String data_entregue, float multa){
		this.id_dvd = id_aluguel;
		this.cpf_func = cpf_cliente;
		this.cpf_cliente = cpf_cliente;
		this.id_aluguel= id_aluguel;
		this.data_aluguel =  data_aluguel;
		this.data_devolucao = data_devolucao;
		this.data_entregue =  data_entregue;
		this.multa = multa;
	}

	public Cadastro() {
		super();
	}
	public int getId_dvd() {
		return id_dvd;
	}
	public long getCpf_func(){
		return cpf_func;
	}
	public long getCpf_cliente(){
		return cpf_cliente;
	}
	public int getId_aluguel(){
		return id_aluguel;
	}
	public String getData_aluguel(){
		return  data_aluguel;
	}
	public String getData_devolucao(){
		return  data_devolucao;
	}
	public String getData_entregue(){
		return  data_entregue;
	}
	public float getMulta(){
		return multa;
	}
	
	
	
	public void setId_dvd(int id_dvd) {
		this.id_dvd = id_dvd;
	}
	public void setCpf_func(long cpf_func){
		this.cpf_func = cpf_func;	
	}
	
	public void setCpf_cliente(long cpf_cliente){
		this.cpf_cliente = cpf_cliente;	
	}
	public void setId_aluguel(int id_aluguel){
		this.id_aluguel = id_aluguel;
	}
	public void setData_aluguel(String data_aluguel){
		this.data_aluguel=  data_aluguel;	
	}
	public void setData_devolucao(String data_devolucao){
		this.data_devolucao =  data_devolucao;	
	}
	public void setData_entregue(String data_entregue){
		this.data_entregue = data_entregue;	
	}
	public void setMulta(float multa){
		this.multa = multa;	
	}
	
	
	
	public String toString() {
		return " [id_dvd=" + id_dvd + ",  cpf_func=" + cpf_func+",cpf_cliente="+ cpf_cliente +",id_aluguel="+data_aluguel+",data_devolucao="+data_devolucao+",data_entregue="+data_entregue+",multa="+multa+"]";
	}
}
