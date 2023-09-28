package com.jau.dao.jpa;

import com.jau.dao.generic.jpa.GenericJpaDao;
import com.jau.domain.jpa.VendaJpa;
import com.jau.exceptions.DAOException;
import com.jau.exceptions.TipoChaveNaoEncontradaException;

public class VendaExclusaoJpaDao extends GenericJpaDao<VendaJpa, Long> implements IVendaJpaDao {

    public VendaExclusaoJpaDao() {
        super(VendaJpa.class);
    }

    @Override
    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("Operação não permitida.");
    }

    @Override
    public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("Operação não permitida.");
    }

    @Override
    public VendaJpa consultarComCollection(Long id) {
        throw new UnsupportedOperationException("Operação não permitida.");
    }
}
