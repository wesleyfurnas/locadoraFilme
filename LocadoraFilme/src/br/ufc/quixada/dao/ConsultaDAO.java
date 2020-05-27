package br.ufc.quixada.dao;

import java.util.List;
import br.ufc.quixada.entity.Cliente;
import br.ufc.quixada.entity.Consulta;

public interface ConsultaDAO {

	
	public List<Consulta> Busca();
	/*public Cliente findByCpf(String cpf);

	public List<Cliente> findByNome(String str);
*/
}