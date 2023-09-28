package com.jau.dao.jpa;


import com.jau.dao.generic.jpa.GenericJpaDao;
import com.jau.domain.jpa.ProdutoJpa;

public class ProdutoJpaDao extends GenericJpaDao<ProdutoJpa, Long> implements IProdutoJpaDao {
    public ProdutoJpaDao() {
        super(ProdutoJpa.class);
    }
}
