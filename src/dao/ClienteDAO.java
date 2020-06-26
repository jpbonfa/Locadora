package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Cliente;
import model.Data;
import model.Endereco;

public class ClienteDAO {

	private Connection bd;

	public ClienteDAO(Connection bd) {
		this.bd = bd;
	}

	public void inserir(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO cliente (nome,lougradouro,endereco,numero,complemento,bairro,cidade,estado,cep,cpf,rg,data_nascimento, idade, sexo, telefone, celular, email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);

		comando.setString(1, cliente.getNome());

		comando.setString(2, cliente.getEndereco().getLougradouro());
		comando.setString(3, cliente.getEndereco().getEndereco());
		comando.setInt(4, cliente.getEndereco().getNumero());
		comando.setString(5, cliente.getEndereco().getComplemento());
		comando.setString(6, cliente.getEndereco().getBairro());
		comando.setString(7, cliente.getEndereco().getCidade());
		comando.setString(8, cliente.getEndereco().getEstado());
		comando.setString(9, cliente.getEndereco().getCep());
		comando.setString(10, cliente.getCpf());
		comando.setString(11, cliente.getRg());
		comando.setString(12, cliente.getDataDeNascimento() + "");
		comando.setInt(13, cliente.getIdade());
		comando.setString(14, cliente.getSexo() + "");
		comando.setString(15, cliente.getTelefone());
		comando.setString(16, cliente.getCelular());
		comando.setString(17, cliente.getEmail());
		comando.execute();
	}

	public List<Cliente> buscarTodos() throws SQLException {
		String sql = "SELECT * FROM cliente ORDER BY nome";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery();
		List<Cliente> listaClientes = new ArrayList<Cliente>();

		while (cursor.next()) {

			Cliente cliente = new Cliente();
			Endereco endereco = new Endereco();
			cliente.setCodigo(cursor.getInt("codigo"));
			cliente.setNome(cursor.getString("nome"));
			endereco.setLougradouro(cursor.getString("lougradouro"));
			endereco.setEndereco(cursor.getString("endereco"));
			endereco.setNumero(cursor.getInt("numero"));
			endereco.setComplemento(cursor.getString("complemento"));
			endereco.setBairro(cursor.getString("bairro"));
			endereco.setCidade(cursor.getString("cidade"));
			endereco.setEstado(cursor.getString("estado"));
			endereco.setCep(cursor.getString("cep"));
			cliente.setEndereco(endereco);
			cliente.setCpf(cursor.getString("cpf"));
			cliente.setRg(cursor.getString("rg"));
			Data data = new Data(cursor.getString("data_nascimento"));
			cliente.setDataDeNascimento(data);
			cliente.setIdade(cursor.getInt("idade"));
			cliente.setSexo(cursor.getString("sexo").charAt(0));
			cliente.setCelular(cursor.getString("celular"));
			cliente.setTelefone(cursor.getString("telefone"));
			cliente.setEmail(cursor.getString("email"));
			listaClientes.add(cliente);
		}

		return listaClientes;
	}

	public void excluir(Cliente cliente) throws SQLException {
		String sql = "DELETE FROM cliente WHERE codigo = ?";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setInt(1, cliente.getCodigo());
		comando.execute();
	}

}
