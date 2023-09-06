package br.com.jau.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.jau.dao.generic.GenericDAO;
import br.com.jau.domain.Estoque;
import br.com.jau.domain.Produto;
import br.com.jau.exceptions.DAOException;
import br.com.jau.exceptions.MaisDeUmRegistroException;
import br.com.jau.exceptions.TableException;
import br.com.jau.exceptions.TipoChaveNaoEncontradaException;

public class EstoqueDAO extends GenericDAO<Estoque, Long> implements IEstoqueDAO {

    @Override
    public Class<Estoque> getTipoClasse() {
        return Estoque.class;
    }

    @Override
    public void atualiarDados(Estoque entity, Estoque entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setQuantidade(entity.getQuantidade());
    }

    @Override
    protected String getQueryInsercao() {
        return "INSERT INTO TB_ESTOQUE (ID, CODIGO, QUANTIDADE) VALUES (nextval('sq_estoque'), ?, ?)";
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_ESTOQUE WHERE ID = ?";
    }

    @Override
    protected String getQueryAtualizacao() {
        return "UPDATE TB_ESTOQUE SET CODIGO = ?, QUANTIDADE = ? WHERE ID = ?";
    }


    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
        stmInsert.setString(1, entity.getCodigo());
        stmInsert.setLong(2, entity.getQuantidade());
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmDelete, Long id) throws SQLException {
        stmDelete.setLong(1, id);
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {
        stmUpdate.setString(1, entity.getCodigo());
        stmUpdate.setLong(2, entity.getQuantidade());
        stmUpdate.setLong(3, entity.getId());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long id) throws SQLException {
        stmSelect.setLong(1, id);
    }

    @Override
    public Collection<Estoque> buscarTodos() throws DAOException {
        List<Estoque> estoques = new ArrayList<>();
        String sql = "SELECT ID, CODIGO, QUANTIDADE FROM TB_ESTOQUE";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Estoque estoque = new Estoque();
                estoque.setId(resultSet.getLong("ID"));
                estoque.setCodigo(resultSet.getString("CODIGO"));
                estoque.setQuantidade(resultSet.getLong("QUANTIDADE"));
                estoques.add(estoque);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro ao buscar estoques", e);
        }
        return estoques;
    }

    @Override
    public void entradaEstoque(Estoque estoque) throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException, SQLException {
        Estoque estoqueConsultado = consultar(estoque.getId());

		if (estoqueConsultado != null) {
		    int novoEstoque = (int) (estoqueConsultado.getQuantidade() + estoque.getQuantidade());
		    estoqueConsultado.setQuantidade(novoEstoque);
		    alterar(estoqueConsultado);
		} else {
		    throw new TipoChaveNaoEncontradaException("Estoque não encontrado.");
		}
    }

    @Override
    public void saidaEstoque(Estoque estoque) throws TipoChaveNaoEncontradaException, DAOException, SQLException, MaisDeUmRegistroException, TableException {
        Estoque estoqueConsultado = consultar(estoque.getId());

		if (estoqueConsultado != null) {
		    int novoEstoque = (int) (estoqueConsultado.getQuantidade() - estoque.getQuantidade());
		    if (novoEstoque >= 0) {
		        estoqueConsultado.setQuantidade(novoEstoque);
		        alterar(estoqueConsultado);
		    } else {
		        throw new DAOException("Estoque insuficiente.", null);
		    }
		} else {
		    throw new TipoChaveNaoEncontradaException("Estoque não encontrado.");
		}
    }

	@Override
	public Estoque consultar(Long valor) throws MaisDeUmRegistroException, TableException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Estoque estoqueConsultado)
			throws TipoChaveNaoEncontradaException, DAOException, SQLException {
		// TODO Auto-generated method stub
		
	}
 
}