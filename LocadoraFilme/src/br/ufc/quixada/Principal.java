

package br.ufc.quixada;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.crypto.Data;
import br.ufc.quixada.dao.impl.CadastroJDBCDAO;
import br.ufc.quixada.dao.impl.ClienteJDBCDAO;
import br.ufc.quixada.dao.impl.ConsultaJDBCDAO;
import br.ufc.quixada.dao.impl.FilmeJDBCDAO;
import br.ufc.quixada.entity.Cadastro;
import br.ufc.quixada.entity.Cliente;
import br.ufc.quixada.entity.Consulta;
import br.ufc.quixada.entity.Filme;
import java.util.Date;
public class Principal {
	//cliente
	private static String nome;
	private static String cpf;
	private static String estado;
	private static String complemento;
	private static String cep;
	private static String bairro;
	private static String cidade;
	private static String logradouro;
	private static String numero;
	
	//filme
	private static String id_dvd;
	private static String  titulo;
	private static String sub_titulo;
	private static String  ano_lancamento;
	private static String  sinopse;
	private static String   valor_aluguel;
	private static String  produtora;
	private static String  titulo_original;
	private static String status;
	
	//cadastro
	private static float multa;
	private static String cpf_func;
	private static int id_aluguel;
	
	
	public static void main(String[] args)  {
		ClienteJDBCDAO clienteDAO = new ClienteJDBCDAO();
		Cliente cliente = new Cliente();
		
		ConsultaJDBCDAO consultaDAO = new ConsultaJDBCDAO();
		Consulta consulta = new Consulta();
		
		FilmeJDBCDAO filmeDAO = new FilmeJDBCDAO();
		Filme filme = new Filme();
		
		CadastroJDBCDAO cadastroDAO = new CadastroJDBCDAO();
		Cadastro cadastro = new Cadastro();
		int opcao;
			opcao = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(""
									+ "Escolha uma das opções abaixo:\n"
									+ "1:Cadastrar cliente\n"
									+ "2:Cadastrar filme \n"
									+ "3:Remover um cliente \n"
									+ "4:Remover um filme \n"
									+ "5:Listar clientes \n"
									+ "6:Listar filmes \n"
									+ "7:Ver filmes alugados por cada cliente \n"
									+ "8:Alugar filme \n"
									+ "9:Sair da aplicação\n"));

			switch (opcao) {
			case 1:
			    nome = JOptionPane.showInputDialog("Digite o nome do cliente");
				cpf = JOptionPane.showInputDialog("Digite o cpf do cliente");
				estado = JOptionPane.showInputDialog("Digite o estado em que vive o cliente");
				bairro = JOptionPane.showInputDialog("Digite o bairro do cliente");
				logradouro = JOptionPane.showInputDialog("Digite o logradouro do cliente");
				cep = JOptionPane.showInputDialog("Digite o cep do cliente");
				complemento = JOptionPane.showInputDialog("Digite o complemento do endereço do cliente");
				numero = JOptionPane.showInputDialog("Digite o telefone do cliente");
				cidade = JOptionPane.showInputDialog("Digite a cidade do cliente");
				
				cliente.setNome(nome);
				cliente.setCpf(Long.parseLong(cpf));
				cliente.setEstado(estado);
				cliente.setNumero(Long.parseLong(numero));
				cliente.setBairro(bairro);
				cliente.setLogradouro(logradouro);
				cliente.setCep((cep));
				cliente.setComplemento(complemento);
				cliente.setCidade(cidade);
				
				clienteDAO.save(cliente);
				break;
				
			case 2:
                titulo = JOptionPane.showInputDialog("Digite o titulo do filme");
				sub_titulo = JOptionPane.showInputDialog("Digite o sub_titulo do filme");
				titulo_original = JOptionPane.showInputDialog("Digite o titulo original do filme");
				valor_aluguel = JOptionPane.showInputDialog("Digite o valor do aluguel do filme");
				ano_lancamento = JOptionPane.showInputDialog("Digite o ano de lancamento do filme");
				sinopse = JOptionPane.showInputDialog("Digite a sinopse do filme");
				produtora = JOptionPane.showInputDialog("Digite o nome da produtora do filme");
				status = "pago";

				filme.setTitulo(titulo);
				filme.setStatus(Integer.parseInt(status));
				filme.setSub_titulo(sub_titulo);
				filme.setAno_lancamento(Integer.parseInt(ano_lancamento));
				filme.setSinopse(sinopse);
				filme.setTitulo_original(titulo_original);
				filme.setProdutora(produtora);
				filme.setValor_aluguel(Integer.parseInt(valor_aluguel));
				
				filmeDAO.save(filme);
				break;

			case 3:
				cpf = JOptionPane.showInputDialog("Digite o cpf do cliente");
				clienteDAO.delete(Long.parseLong(cpf));
				break;
					
			case 4:
				id_dvd = JOptionPane.showInputDialog("Digite o id do filme a ser excluído");
				filmeDAO.delete(Integer.parseInt(id_dvd));
				break;
			
			case 5:
				List<Cliente> clientes6 = clienteDAO.find();
				String unir = "";
				if (clientes6.size() > 0) {
					for (Cliente cliente6 : clientes6) {
						unir += cliente6 + "\n";
					}
					JOptionPane.showMessageDialog(null, unir);
				} else {
					JOptionPane.showMessageDialog(null,	"Sem resultado.\nVerifique sua consulta!");
				}
				clienteDAO.find();
				break;
				
			case 6:
				List<Filme> Filmes6 = filmeDAO.find();
				String uniao = "";
				if (Filmes6.size() > 0) {
					for (Filme filme2 : Filmes6) {
						uniao += Filmes6 + "\n";
					}
					JOptionPane.showMessageDialog(null, uniao);
				} else {
					JOptionPane.showMessageDialog(null,	"Sem resultado.\nVerifique sua consulta!");
				}
				clienteDAO.find();

				break;
			case 7:
				List<Consulta> viciados = consultaDAO.Busca();
				String listaViciados = "";
				if (viciados.size() > 0) {
					for (Consulta consultinha :viciados) {
						listaViciados += viciados + "\n";
					}
					JOptionPane.showMessageDialog(null, listaViciados);
				} else {
					JOptionPane.showMessageDialog(null,	"Sem resultado.\nVerifique sua consulta!");
				}
				consultaDAO.Busca();

				break;
				
			case 8 : 		
				    id_dvd = JOptionPane.showInputDialog("Digite o id do dvd alugado");
					cpf = JOptionPane.showInputDialog("Digite o cpf do cliente");
					cpf_func = JOptionPane.showInputDialog("Digite o cpf do vendedor");
					id_aluguel = 1; //JOptionPane.showInputDialog("Digite o bairro do cliente");
					Data data_aluguel = (Data) new Date(System.currentTimeMillis());
					Date data_devolucao = (Date) new Date(System.currentTimeMillis());  
					Date data_entregue = null;
					multa =  (Float) null;
					
					cadastro.setCpf_cliente(Long.parseLong(cpf));
					cadastro.setCpf_func(Long.parseLong(cpf_func));
					cadastro.setId_aluguel(id_aluguel);
					cadastro.setMulta(multa);
					cadastro.setId_dvd(Integer.parseInt(id_dvd));
					//cadastro.setData_aluguel(data_aluguel);
					//cadastro.setData_devolucao(data_devolucao);
					
					cadastroDAO.aluga(cadastro);
					
			
				break;

			default:
				JOptionPane.showMessageDialog(null,	"Fim do Programa");
			}

	}

}
