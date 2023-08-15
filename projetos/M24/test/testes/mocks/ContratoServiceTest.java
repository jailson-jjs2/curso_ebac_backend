package testes.mocks;

import org.junit.Assert;
import org.junit.Test;

import testes.mocks.dao.ContratoDao;
import testes.mocks.dao.ContratoDaoMock;
import testes.mocks.dao.IContratoServide;
import testes.mocks.dao.IContratoDao;
import testes.mocks.service.ContratoService;



public class ContratoServiceTest {
	
	@Test
	public void salvarTest() {
		IContratoDao dao = new ContratoDaoMock();
		IContratoServide service = new ContratoService(dao);
		String retorno = service.salvar();
		Assert.assertEquals("Sucesso", retorno);
		
	}
	
	@Test
	public void buscarTest() {
		IContratoDao dao = new ContratoDaoMock();
		IContratoServide service = new ContratoService(dao);
		String retorno = service.buscar();
		Assert.assertEquals("Sucesso", retorno);
		
	}
	
	@Test
	public void atualizarTest() {
		IContratoDao dao = new ContratoDaoMock();
		IContratoServide service = new ContratoService(dao);
		String retorno = service.atualizar();
		Assert.assertEquals("Sucesso", retorno);
		
	}
	
	@Test
	public void excluirTest() {
		IContratoDao dao = new ContratoDaoMock();
		IContratoServide service = new ContratoService(dao);
		String retorno = service.excluir();
		Assert.assertEquals("Sucesso", retorno);
		
	}
	
	
	// Metodos buscar, excluir e atualizar
	
	@Test(expected = UnsupportedOperationException.class)
	public void esperadoErroSalvarTest() {
		IContratoDao dao = new ContratoDao();
		IContratoServide service = new ContratoService(dao);
		String retorno = service.salvar();
		Assert.assertEquals("Sucesso", retorno);
		
	}

}
