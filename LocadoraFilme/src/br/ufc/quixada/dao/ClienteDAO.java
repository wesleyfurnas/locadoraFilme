package br.ufc.quixada.dao;

import java.util.List;
import br.ufc.quixada.entity.Cliente;

/**
 * @author Anderson Uchoa
 */

public interface ClienteDAO {

	public void save(Cliente cliente);
	public List<Cliente> find();
	public void delete( long cpf);

	public Cliente find(long cpf);

	

	/*public Cliente findByCpf(String cpf);

	public List<Cliente> findByNome(String str);
*/
}
