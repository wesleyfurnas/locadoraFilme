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
import br.ufc.quixada.dao.ConsultaDAO;
import br.ufc.quixada.entity.Cliente;
import br.ufc.quixada.entity.Consulta;


/**
 * @author Anderson Uchoa
 */

public class ConsultaJDBCDAO implements ConsultaDAO{
	public ConsultaJDBCDAO() {
		
	}
	
	public List<Consulta> Busca() {
		String sql = "SELECT C.nome, D.titulo from cliente C, dvdFilme D, aluguel A where (A.cpf_cliente=C.cpf) and A.id_dvd = D.id_dvd";
		List<Consulta> consultas = new ArrayList<Consulta>();
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Consulta consulta = new Consulta();
				consulta = new Consulta();
				consulta.setNome_comprador(rs.getString("nome"));
				consulta.setTitulo_filme(rs.getString("titulo"));
				consultas.add(consulta);
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
		return consultas;
	}
}