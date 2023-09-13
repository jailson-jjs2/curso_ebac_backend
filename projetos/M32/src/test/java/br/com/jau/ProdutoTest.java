package br.com.jau;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.jau.dao.IProdutoDao;
import br.com.jau.dao.ProdutoDao;
import br.com.jau.domain.Produto;

public class ProdutoTest {
    private IProdutoDao produtoDao;

    public ProdutoTest() {
        produtoDao = new ProdutoDao();
    }

    @Test
    public void cadastrar() {
        Produto produto = new Produto();
        produto.setCodigo("Notebook");
        produto.setNome("Daten");
        produto.setValor(2000.0);
        produto = produtoDao.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getId());
    }
}