package exVendas.DAO;

import exVendas.DAO.generics.GenericDAO;
import exVendas.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {
	
	public ClienteDAO() {
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
