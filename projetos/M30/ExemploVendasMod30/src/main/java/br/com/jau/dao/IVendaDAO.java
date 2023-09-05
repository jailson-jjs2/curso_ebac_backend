/**
 * 
 */
package br.com.jau.dao;

import br.com.jau.dao.generic.IGenericDAO;
import br.com.jau.domain.Venda;
import br.com.jau.exceptions.DAOException;
import br.com.jau.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
