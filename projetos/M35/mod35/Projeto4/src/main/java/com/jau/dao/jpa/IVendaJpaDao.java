package com.jau.dao.jpa;


import com.jau.dao.generic.jpa.IGenericJpaDao;
import com.jau.domain.jpa.VendaJpa;
import com.jau.exceptions.DAOException;
import com.jau.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDao extends IGenericJpaDao<VendaJpa, Long> {
    void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;
    void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;
    VendaJpa consultarComCollection(Long id);
}
