/**
 * 
 */
package br.com.jau.services;

import br.com.jau.domain.Cliente;
import br.com.jau.exceptions.DAOException;
import br.com.jau.exceptions.TipoChaveNaoEncontradaException;
import br.com.jau.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
