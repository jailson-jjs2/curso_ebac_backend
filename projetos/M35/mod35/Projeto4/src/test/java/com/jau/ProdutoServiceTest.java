package com.jau;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jau.dao.IProdutoDAO;
import com.jau.dao.ProdutoDaoMock;
import com.jau.domain.Produto;
import com.jau.exceptions.DAOException;
import com.jau.exceptions.MaisDeUmRegistroException;
import com.jau.exceptions.TableException;
import com.jau.exceptions.TipoChaveNaoEncontradaException;
import com.jau.services.IProdutoService;
import com.jau.services.ProdutoService;

public class ProdutoServiceTest {

	private IProdutoService produtoService;
	
	private Produto produto;
	
	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("P1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
	}
	
	@Test
	public void pesquisar() throws DAOException, MaisDeUmRegistroException, TableException {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = produtoService.cadastrar(produto);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluir() throws DAOException {
		produtoService.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarProduto() throws TipoChaveNaoEncontradaException, DAOException {
		produto.setNome("Daten");
		produtoService.alterar(produto);
		
		Assert.assertEquals("Daten", produto.getNome());
	}
}
