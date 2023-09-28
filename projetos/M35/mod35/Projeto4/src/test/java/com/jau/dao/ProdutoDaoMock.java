package com.jau.dao;

import java.util.Collection;

import com.jau.dao.IProdutoDAO;
import com.jau.domain.Produto;
import com.jau.exceptions.DAOException;
import com.jau.exceptions.MaisDeUmRegistroException;
import com.jau.exceptions.TableException;
import com.jau.exceptions.TipoChaveNaoEncontradaException;


public class ProdutoDaoMock implements IProdutoDAO {


	@Override
	public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {
		return null;
	}

	@Override
	public void excluir(String valor) throws DAOException {

	}

	@Override
	public void alterar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {

	}

	@Override
	public Produto consultar(String valor) throws MaisDeUmRegistroException, TableException, DAOException {
		Produto produto = new Produto();
		produto.setCodigo(valor);
		return produto;
	}

	@Override
	public Collection<Produto> buscarTodos() throws DAOException {
		return null;
	}
}
