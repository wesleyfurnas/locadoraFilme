package br.ufc.quixada.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufc.quixada.ConnectionFactory;
import br.ufc.quixada.DAOException;
import br.ufc.quixada.dao.CadastroDAO;
import br.ufc.quixada.dao.ClienteDAO;
import br.ufc.quixada.entity.Cadastro;
import br.ufc.quixada.entity.Cliente;

public class CadastroJDBCDAO implements CadastroDAO{
	public CadastroJDBCDAO() {
		
	}
	public void aluga(Cadastro cadastro) {
		Connection con = null;
		//if (cliente.getCpf() == 0) {
			String sql = "insert into aluguel (id_dvd, cpf_func,cpf_cliente,id_aluguel,data_aluguel,data_devolucao,data_entregue,multa) values ( ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				con = ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setInt(1,cadastro.getId_dvd());
				ps.setLong(2,(cadastro.getCpf_func()));
				ps.setLong(3, cadastro.getCpf_cliente());
				ps.setInt(4,cadastro.getId_aluguel());
				//ps.setDate(5,(Date) cadastro.getData_aluguel());
				//ps.setDate(6,(Date) cadastro.getData_devolucao());
				//ps.setDate(7,(Date) cadastro.getData_entregue());
				ps.setFloat(8,cadastro.getMulta());
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
}
 