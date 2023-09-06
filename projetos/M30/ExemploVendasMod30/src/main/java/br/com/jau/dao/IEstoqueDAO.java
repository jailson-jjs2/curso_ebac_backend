package br.com.jau.dao;

import java.sql.SQLException;

import br.com.jau.dao.generic.IGenericDAO;
import br.com.jau.domain.Estoque;
import br.com.jau.exceptions.DAOException;
import br.com.jau.exceptions.MaisDeUmRegistroException;
import br.com.jau.exceptions.TableException;
import br.com.jau.exceptions.TipoChaveNaoEncontradaException;

public interface IEstoqueDAO extends IGenericDAO<Estoque, Long> {
	
    void entradaEstoque(Estoque estoque) throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException, SQLException;
    
    void saidaEstoque(Estoque estoque) throws TipoChaveNaoEncontradaException, DAOException, SQLException, MaisDeUmRegistroException, TableException;

	void atualizar(Estoque estoqueConsultado) throws TipoChaveNaoEncontradaException, DAOException, SQLException;
}
