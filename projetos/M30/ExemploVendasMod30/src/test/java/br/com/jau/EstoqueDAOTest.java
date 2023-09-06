package br.com.jau;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jau.dao.EstoqueDAO;
import br.com.jau.dao.IEstoqueDAO;
import br.com.jau.dao.generic.jdbc.ConnectionFactory;
import br.com.jau.domain.Estoque;
import br.com.jau.exceptions.DAOException;
import br.com.jau.exceptions.MaisDeUmRegistroException;
import br.com.jau.exceptions.TableException;
import br.com.jau.exceptions.TipoChaveNaoEncontradaException;

public class EstoqueDAOTest {

    private IEstoqueDAO estoqueDao;

    @Before
    public void setUp() {
        estoqueDao = new EstoqueDAO();
    }

    @After
    public void tearDown() throws SQLException {
        // Limpeza do banco de dados, se necessário.
        // Você pode excluir registros de teste aqui.
        cleanUpDatabase();
    }

    @Test
    public void testCadastrarEstoque() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Estoque estoque = new Estoque();
        estoque.setCodigo("produto1");
        estoque.setQuantidade(10);

        boolean resultado = estoqueDao.cadastrar(estoque);
        assertTrue(resultado);

        Estoque estoqueConsultado = estoqueDao.consultar(estoque.getId());
        assertNotNull(estoqueConsultado);
        assertEquals(estoque.getCodigo(), estoqueConsultado.getCodigo());
        assertEquals(estoque.getQuantidade(), estoqueConsultado.getQuantidade());
    }

    @Test
    public void testAtualizarEstoque() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        // Cadastrar um estoque inicial
        Estoque estoque = new Estoque();
        estoque.setCodigo("produto2");
        estoque.setQuantidade(5);

        boolean resultado = estoqueDao.cadastrar(estoque);
        assertTrue(resultado);

        // Consultar o estoque cadastrado
        Estoque estoqueConsultado = estoqueDao.consultar(estoque.getId());
        assertNotNull(estoqueConsultado);
        assertEquals(estoque.getCodigo(), estoqueConsultado.getCodigo());
        assertEquals(estoque.getQuantidade(), estoqueConsultado.getQuantidade());

        // Atualizar o estoque
        estoqueConsultado.setQuantidade(8);

        // Converter o ID para o tipo correto (bigint)
        Long estoqueId = estoqueConsultado.getId();


        // Consultar novamente e verificar se a atualização ocorreu
        Estoque estoqueAtualizado = estoqueDao.consultar(estoqueId);
        assertNotNull(estoqueAtualizado);
        assertEquals(estoqueConsultado.getCodigo(), estoqueAtualizado.getCodigo());
        assertEquals(estoqueConsultado.getQuantidade(), estoqueAtualizado.getQuantidade());
    }


    @Test
    public void testExcluirEstoque() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        // Cadastrar um estoque
        Estoque estoque = new Estoque();
        estoque.setCodigo("produto3");
        estoque.setQuantidade(15);

        boolean resultado = estoqueDao.cadastrar(estoque);
        assertTrue(resultado);

        // Consultar o estoque cadastrado
        Estoque estoqueConsultado = estoqueDao.consultar(estoque.getId());
        assertNotNull(estoqueConsultado);

        // Excluir o estoque
        estoqueDao.excluir(estoque.getId());

        // Tentar consultar o estoque após a exclusão
        Estoque estoqueExcluido = estoqueDao.consultar(estoque.getId());
        assertNull(estoqueExcluido);
    }

    @Test
    public void testBuscarTodosEstoques() throws DAOException, TipoChaveNaoEncontradaException {
        // Cadastrar vários estoques para testar a busca
        cadastrarEstoque("produto4", 20);
        cadastrarEstoque("produto5", 25);
        cadastrarEstoque("produto6", 30);

        Collection<Estoque> estoques = estoqueDao.buscarTodos();
        assertNotNull(estoques);
        assertTrue(estoques.size() >= 3);
    }

    private void cleanUpDatabase() throws SQLException {
        // Este método pode ser usado para limpar o banco de dados após os testes.
        // Certifique-se de excluir todos os registros de teste aqui.
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM TB_ESTOQUE");
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
            connection.close();
        }
    }

    private void cadastrarEstoque(String codigo, long quantidade) throws TipoChaveNaoEncontradaException, DAOException {
        Estoque estoque = new Estoque();
        estoque.setCodigo(codigo);
        estoque.setQuantidade(quantidade);
        estoqueDao.cadastrar(estoque);
    }
}
