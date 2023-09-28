package com.jau.services;

import com.jau.dao.generic.IGenericDAO;
import com.jau.domain.Produto;
import com.jau.exceptions.DAOException;
import com.jau.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
	public ProdutoService(IGenericDAO<Produto, String> genericJpaDao) {
		super(genericJpaDao);
	}

	@Override
	public void excluir(String valor) throws DAOException {

	}
}
