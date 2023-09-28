package com.jau.dao.jpa;


import com.jau.dao.generic.jpa.GenericJpaDao;
import com.jau.domain.jpa.ClienteJpa;



public class ClienteJpaDao extends GenericJpaDao<ClienteJpa, Long> implements IClienteJpaDao {
    public ClienteJpaDao() {
        super(ClienteJpa.class);
    }

}
