package br.ufc.quixada.dao.impl;

import java.io.ObjectOutputStream.PutField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.ufc.quixada.ConnectionFactory;
import br.ufc.quixada.DAOException;
import br.ufc.quixada.dao.ClienteDAO;
import br.ufc.quixada.entity.Cliente;


/**
 * @author Anderson Uchoa
 */

public class ClienteJDBCDAO implements ClienteDAO{
	public ClienteJDBCDAO() {
		
	}
	public void save(Cliente cliente) {
		Connection con = null;
		//if (cliente.getCpf() == 0) {
			String sql = "insert into cliente ( cpf, cep,nome , cidade, complemento, numero , logradouro , bairro , estado) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				con = ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setLong(1,cliente.getCpf());
				ps.setLong(2, Long.parseLong(cliente.getCep()));
				ps.setString(3, cliente.getNome());
				ps.setString(4,cliente.getCidade());
				ps.setString(5, cliente.getComplemento());
				ps.setLong(6, cliente.getNumero());
				ps.setString(7, cliente.getLogradouro());
				ps.setString(8, cliente.getBairro());
				ps.setString(9, cliente.getEstado());
				
				ps.executeUpdate();
                ps.close();
				
			}
			catch (SQLException e) {
				throw new DAOException("Operação não realizada com sucesso.", e);
			} finally {
				if (con != null) {
					try {
						con.close();
					}
					catch (SQLException e) {
						throw new DAOException("Não foi possível fechar a conexão.",e);
					}
				}
			}
		}
 
	//}
		/* else {
			String sql = "UPDATE cliente SET  cpf = ? ,nome = ?, fone = ?, renda = ? "+ "WHERE id =  ? ";
			try {
				con = ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, cliente.getCpf());
				ps.setString(2, cliente.getNome());
				ps.setString(3, cliente.getFone());
				ps.setDouble(4, cliente.getRenda());
				ps.setInt(5, cliente.getId());
				ps.executeUpdate();
                ps.close();
				
				
			}
			catch (SQLException e) {
				throw new DAOException("Operação não realizada com sucesso.", e);
			} finally {
				if (con != null) {
					try {
						con.close();
					}

					catch (SQLException e) {
						throw new DAOException("Não foi possível fechar a conexão.",e);
					}
				}
			}
		}
	}*/
	
	public void delete(long cpf){
		String sql = "DELETE FROM cliente WHERE cpf = ?";
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, cpf);
			ps.executeUpdate();
			ps.close();	
			
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				}

				catch (SQLException e) {
					throw new DAOException("Não foi possível fechar a conexão.",e);
				}
			}
		}
	}
	

	
	public Cliente find( long cpf){
		String sql = "select * from cliente" + " WHERE id = ?" ;
		Cliente cliente = null;
		Connection con = null;

		try {
			con = ConnectionFactory.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, cpf);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setCpf(rs.getLong("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setNumero(rs.getLong("numero"));
				cliente.setEstado(rs.getString("estado"));  
			}
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				}

				catch (SQLException e) {
					throw new DAOException("Não foi possível fechar a conexão.",e);
					}

			}
		}
		return cliente;
	}

	@Override
	public List<Cliente> find() {
		String sql = "SELECT * FROM cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente = new Cliente();
				cliente.setCpf(rs.getLong("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setNumero(rs.getLong("numero"));
				cliente.setEstado(rs.getString("estado")); 
				clientes.add(cliente);
			}
			ps.execute();
			ps.close();
		
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				}

				catch (SQLException e) {
					throw new DAOException("Não foi possível fechar a conexão.",e);
				}

			}
		}
		return clientes;
	}
	
	public Cliente findByCpf(Long cpf){
		String sql = "select * from cliente" + " WHERE cpf = ?";
		Cliente cliente = null;
		Connection con = null;

		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, cpf);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setCpf(rs.getLong("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setNumero(rs.getLong("numero"));
				cliente.setEstado(rs.getString("estado")); 
			}
			ps.execute();
			ps.close();
		
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			if (con != null) {
				try {
					con.close();
			}

				catch (SQLException e) {
					throw new DAOException("Não foi possível fechar a conexão.",e);
				}

			}
		}
		return cliente;
	}
	/*
	@Override
	public Cliente findByCpf(String cpf){
		String sql = "select * from cliente" + " WHERE cpf = ?";
		Cliente cliente = null;
		Connection con = null;

		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cpf);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setFone(rs.getString("fone"));
				cliente.setRenda(rs.getDouble("renda"));

			}
			ps.execute();
			ps.close();
		
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			if (con != null) {
				try {
					con.close();
			}

				catch (SQLException e) {
					throw new DAOException("Não foi possível fechar a conexão.",e);
				}

			}
		}
		return cliente;
	}

	@Override
	public List<Cliente> findByNome(String str){

		String sql = "SELECT * FROM cliente WHERE nome LIKE '%" + str +"%'";
		List<Cliente> clientes = new ArrayList<Cliente>();
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setFone(rs.getString("fone"));
				cliente.setRenda(rs.getDouble("renda"));
				clientes.add(cliente);
			}
			ps.execute();
			ps.close();
		     
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				}

				catch (SQLException e) {
					throw new DAOException("Não foi possível fechar a conexão.",e);
				}

			}
		}
		return clientes;
	
	}*/
}