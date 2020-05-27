package br.ufc.quixada.entity;

public class Filme {

	private int id_dvd;
	private String titulo;
	private String sub_titulo;
	private int ano_lancamento;
	private int status;
	private String sinopse;
	private int  valor_aluguel;
	private String produtora;
	private String titulo_original;
	
	public Filme(int status,int id_dvd , String titulo , String subtitulo, int ano_lancamento,String sinopse, int valor_aluguel,String produtora, String titulo_original) {
		this.id_dvd = id_dvd;
		this.titulo = titulo;
		this.sub_titulo = subtitulo;
		this.sinopse = sinopse;
		this.produtora = produtora;
		this.titulo_original = titulo_original;
		this.valor_aluguel = valor_aluguel;
		this.ano_lancamento = ano_lancamento;	
		this.status = status;
	}

	public Filme() {
		super();
	}
	public int getid_dvd() {
		return id_dvd;
	}
	public void setid_dvd(int  id_dvd) {
		this.id_dvd = id_dvd;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getTitulo(){
		return titulo;
	}
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	public String getSub_titulo(){
		return sub_titulo;
	}
	public void setSub_titulo(String sub_titulo){
		this.sub_titulo = sub_titulo;
	}
	public String getSinopse(){
		return sinopse;
	}
	public void setSinopse(String sinopse){
		this.sinopse = sinopse;
	}
	public String getProdutora(){
		return produtora;
	}
	public void setProdutora(String produtora){
		this.produtora = produtora;
	}
	public String getTitulo_original(){
		return titulo_original;
	}
	public void setTitulo_original(String titulo_original){
		this.titulo_original = titulo_original;
	}
	public int getValor_aluguel(){
		return valor_aluguel;
	}
	public void setValor_aluguel(int valor_aluguel){
		this.valor_aluguel = valor_aluguel;
	}
	public int getAno_lancamento(){
		return ano_lancamento;
	}
	public void setAno_lancamento (int ano_lancamento){
		this.ano_lancamento = ano_lancamento;
	}
	public String toString() {
		return " [id_dvd=" + id_dvd + ",  titulo=" + titulo+ ", sub_titulo=" + sinopse + ", sinopse=" + sinopse + ",produtora="+ produtora+",ano_lancamento="+ ano_lancamento +",valor_aluguel="+ valor_aluguel+",titulo_original="+ titulo_original+",status="+ status+"]";
	}
}



























