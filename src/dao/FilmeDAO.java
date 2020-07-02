package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Cliente;
import model.Filme;

public class FilmeDAO {

	private Connection bd;

	public FilmeDAO(Connection bd) {
		this.bd = bd;
	}

	public void inserir(Filme filme) throws SQLException {
		String sql = "INSERT INTO filme (nome,valor,disponivel,promocao,valor_promocao,genero) VALUES (?,?,?,?,?,?)";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, filme.getNome());
		comando.setDouble(2, filme.getValor());
		comando.setBoolean(3, filme.isDisponivel());
		comando.setBoolean(4, filme.isPromocao());
		comando.setDouble(5, filme.getValorDaPromocao());
		comando.setString(6, filme.getGenero());
		comando.execute();
	}

	public List<Filme> buscarTodos() throws SQLException {
		String sql = "SELECT * FROM filme ORDER BY nome";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery();
		List<Filme> listaFilmes = new ArrayList<Filme>();

		while (cursor.next()) {
			Filme filme = new Filme();
			filme.setCodigo(cursor.getInt("codigo"));
			filme.setNome(cursor.getString("nome"));
			filme.setValor(cursor.getDouble("valor"));
			filme.setDisponivel(cursor.getBoolean("disponivel"));
			filme.setPromocao(cursor.getBoolean("promocao"));
			filme.setValorDaPromocao(cursor.getDouble("valor_promocao"));
			filme.setGenero(cursor.getString("genero"));
			listaFilmes.add(filme);
		}

		return listaFilmes;
	}

	public void excluir(Filme filme) throws SQLException {
		String sql = "DELETE FROM filme WHERE codigo = ?";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setInt(1, filme.getCodigo());
		comando.execute();
	}

	public void alterar(Filme filme) throws SQLException {
		String sql = "UPDATE filme SET valor=?, disponivel = ?, promocao=?, valor_promocao=? WHERE codigo=?;";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setDouble(1, filme.getValor());
		comando.setBoolean(2, filme.isDisponivel());
		comando.setBoolean(3, filme.isPromocao());
		comando.setDouble(4, filme.getValorDaPromocao());
		comando.setInt(5, filme.getCodigo());
		comando.execute();
	}
}
