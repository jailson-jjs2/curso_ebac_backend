package com.jau.dao;

import com.jau.dao.generic.IGenericDAO;
import com.jau.domain.Venda;
import com.jau.exceptions.DAOException;
import com.jau.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
