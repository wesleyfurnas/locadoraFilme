package br.ufc.quixada.dao;

import java.util.List;
import br.ufc.quixada.entity.Filme;
/**
 * @author Anderson Uchoa
 */

public interface FilmeDAO {
	
	public void save( Filme filme);

	public void delete(int id_dvd);

	/*public Cliente find(int id);

	public List<Cliente> find();

	public Cliente findByCpf(String cpf);

	public List<Cliente> findByNome(String str);
*/
}

