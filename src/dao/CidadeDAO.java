package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Cidade;
import model.Cliente;
import model.Filme;

public class CidadeDAO {

	private Connection bd;

	public CidadeDAO(Connection bd) {
		this.bd = bd;
	}

	public List<Cidade> buscarTodos() throws SQLException {
		String sql = "SELECT * FROM cidade ORDER BY nome";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery();
		List<Cidade> listaCidades = new ArrayList<Cidade>();

		while (cursor.next()) {
			Cidade cidade = new Cidade();
			cidade.setNome(cursor.getString("nome"));
			listaCidades.add(cidade);
		}

		return listaCidades;
	}

	

}
