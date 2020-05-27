package br.ufc.quixada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.ufc.quixada.ConnectionFactory;
import br.ufc.quixada.DAOException;
import br.ufc.quixada.dao.ClienteDAO;
import br.ufc.quixada.dao.FilmeDAO;
import br.ufc.quixada.entity.Cliente;
import br.ufc.quixada.entity.Filme;



public class FilmeJDBCDAO implements FilmeDAO{
	
	public FilmeJDBCDAO() {
		
	}
	public void save (Filme filme) {
		Connection con = null;
		//if (cliente.getCpf() == 0) {
			String sql = "insert into DVDFILME ( titulo ,sub_titulo , ano_lancamento, sinopse , valor_aluguel , produtora , titulo_original,status) values ( ?, ?, ?, ?, ?, ?, ?, 02)";
			try {
				con = ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, filme.getTitulo());
				ps.setString(2, filme.getSub_titulo());
				ps.setInt(3,filme.getAno_lancamento());
				ps.setString(4, filme.getSinopse());
				ps.setLong(5,filme.getValor_aluguel());
				ps.setString(6, filme.getProdutora());
				ps.setString(7,filme.getTitulo_original());
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
	
	public void delete(int id_dvd){
		String sql = "DELETE FROM DVDFILME WHERE id_dvd = ?";
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id_dvd);
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
	public List<Filme> find() {
		String sql = "SELECT * FROM DVDFILME";
		List<Filme> filmes = new ArrayList<Filme>();
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Filme filme = new Filme();
				filme = new Filme();
				filme.setTitulo(rs.getString("titulo"));
				filme.setSub_titulo(rs.getString("sub_titulo"));
				filme.setAno_lancamento(rs.getInt("ano_lancamento"));
				filme.setSinopse(rs.getString("sinopse"));
				filme.setProdutora(rs.getString("produtora"));
				filme.setTitulo_original(rs.getString("titulo_original"));
				filme.setValor_aluguel(rs.getInt("valor_aluguel")); 
				filme.setStatus(rs.getInt("status"));
				filmes.add(filme);
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
		return filmes;
	}
 }
