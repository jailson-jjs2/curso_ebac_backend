/**
 * 
 */
package br.com.jau;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.jau.dao.ClienteDaoMock;
import br.com.jau.dao.IClienteDAO;
import br.com.jau.domain.Cliente;
import br.com.jau.exceptions.DAOException;
import br.com.jau.exceptions.TipoChaveNaoEncontradaException;
import br.com.jau.services.ClienteService;
import br.com.jau.services.IClienteService;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Jailson");
		cliente.setEmail("jjs2@hotmail.com");
		cliente.setCidade("João Pessoa");
		cliente.setEnd("End");
		cliente.setEstado("PB");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Jailson Joventino");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Jailson Joventino", cliente.getNome());
	}
}
