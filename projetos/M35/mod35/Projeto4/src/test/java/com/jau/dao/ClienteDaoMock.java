package com.jau.dao;

import java.util.Collection;

import com.jau.dao.IClienteDAO;
import com.jau.domain.Cliente;
import com.jau.exceptions.DAOException;
import com.jau.exceptions.MaisDeUmRegistroException;
import com.jau.exceptions.TableException;
import com.jau.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDaoMock implements IClienteDAO {


	@Override
	public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
		return true;
	}

	@Override
	public void excluir(Long valor) throws DAOException {

	}

	@Override
	public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {

	}

	@Override
	public Cliente consultar(Long valor) throws MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(valor);
		return cliente;
	}

	@Override
	public Collection<Cliente> buscarTodos() throws DAOException {
		return null;
	}
}
