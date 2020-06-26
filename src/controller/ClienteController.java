package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import dao.ClienteDAO;
import model.Cliente;
import util.ConnectionFactory;
import util.Mensagem;

public class ClienteController {

	private Connection conexao = ConnectionFactory.getConnection();

	public void inserir(Cliente cliente) {

		ClienteDAO dao = new ClienteDAO(conexao);
		try {
			dao.inserir(cliente);
			JOptionPane.showMessageDialog(null, Mensagem.clienteGravado, Mensagem.sucesso, 1);
			conexao.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao inserir o cliente");
			e.printStackTrace();
		}
	}

	public List<Cliente> buscarTodos() {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		ClienteDAO dao = new ClienteDAO(conexao);
		try {
			listaClientes = dao.buscarTodos();
			conexao.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao listar os clientes");
			e.printStackTrace();
		}
		return listaClientes;
	}

	public void excluir(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO(conexao);
		try {
			dao.excluir(cliente);
			JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");
			conexao.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao excluir o cliente");
			e.printStackTrace();
		}
	}

}
