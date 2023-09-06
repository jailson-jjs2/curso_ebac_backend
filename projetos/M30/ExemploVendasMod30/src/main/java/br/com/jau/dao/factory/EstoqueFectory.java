package br.com.jau.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.jau.domain.Estoque;

public class EstoqueFectory {
	
	public static Estoque convert(ResultSet rs) throws SQLException {
		Estoque estoque = new Estoque();
		estoque.setId(rs.getLong("ID_PRODUTO"));
		estoque.setCodigo(rs.getString("CODIGO"));
		estoque.setQuantidade(rs.getLong("QUANTIDADE"));
		return estoque;
	}

}
