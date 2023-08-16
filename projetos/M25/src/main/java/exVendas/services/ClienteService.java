package exVendas.services;


import exVendas.DAO.IClienteDAO;
import exVendas.DAO.generics.GenericDAO;
import exVendas.domain.Cliente;

public class ClienteService extends GenericDAO<Cliente> implements IClienteService {
	
	public ClienteService(IClienteDAO clienteDAO) {
		super();
	}

	@Override
	public Class<Cliente> getTipoClass() {
		// TODO Auto-generated method stub
		return Cliente.class;
	}

	@Override
	public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
		// TODO Auto-generated method stub
		
	}

}
