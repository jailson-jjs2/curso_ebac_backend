package com.jau.services.generic.jpa;

import com.jau.dao.Persistente;
import com.jau.exceptions.DAOException;
import com.jau.exceptions.MaisDeUmRegistroException;
import com.jau.exceptions.TableException;
import com.jau.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericJpaService<T extends Persistente, E extends Serializable> {
    T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    void excluir(T entity) throws DAOException;
    T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    T consultar(E valor) throws MaisDeUmRegistroException, DAOException, TableException;
    Collection<T> buscarTodos() throws DAOException;
}
