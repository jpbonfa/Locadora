package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Filme;
import model.Vendedor;

public class VendedorDAO {

	private Connection bd;

	public VendedorDAO(Connection bd) {
		this.bd = bd;
	}

	public void inserir(Vendedor vendedor) throws SQLException {
		String sql = "INSERT INTO vendedor (nome,area_venda,cidade,estado,sexo,idade,salario) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, vendedor.getNome());
		comando.setString(2, vendedor.getAreaVenda());
		comando.setString(3, vendedor.getCidade());
		comando.setString(4, vendedor.getEstado());
		comando.setString(5, vendedor.getSexo() + "");
		comando.setInt(6, vendedor.getIdade());
		comando.setDouble(7, vendedor.getSalario());
		comando.execute();
	}

	public List<Vendedor> buscarTodos() throws SQLException {
		String sql = "SELECT * FROM vendedor ORDER BY nome";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery();
		List<Vendedor> listaVendedores = new ArrayList<Vendedor>();

		while (cursor.next()) {
			Vendedor vendedor = new Vendedor();
			vendedor.setCodigo(cursor.getInt("codigo"));
			vendedor.setNome(cursor.getString("nome"));
			vendedor.setAreaVenda(cursor.getString("area_venda"));
			vendedor.setCidade(cursor.getString("cidade"));
			vendedor.setEstado(cursor.getString("estado"));
			vendedor.setSexo(cursor.getString("sexo").charAt(0));
			vendedor.setIdade(cursor.getInt("idade"));
			vendedor.setSalario(cursor.getDouble("salario"));
			listaVendedores.add(vendedor);
		}

		return listaVendedores;
	}

	public void excluir(Vendedor vendedor) throws SQLException {
		String sql = "DELETE FROM vendedor WHERE codigo = ?";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setInt(1, vendedor.getCodigo());
		comando.execute();
	}

	public void alterar(Vendedor vendedor) throws SQLException {
		String sql = "UPDATE vendedor SET area_venda=?, cidade = ?, estado=?, salario=? WHERE codigo=?;";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, vendedor.getAreaVenda());
		comando.setString(2, vendedor.getCidade());
		comando.setString(3, vendedor.getEstado());
		comando.setDouble(4, vendedor.getSalario());
		comando.setInt(5, vendedor.getCodigo());
		comando.execute();
	}
}
