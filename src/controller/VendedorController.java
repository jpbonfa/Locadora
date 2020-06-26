package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import dao.FilmeDAO;
import dao.VendedorDAO;
import model.Filme;
import model.Vendedor;
import util.ConnectionFactory;
import util.Mensagem;

public class VendedorController {

	private Connection conexao = ConnectionFactory.getConnection();

	public void inserir(Vendedor vendedor) {

		VendedorDAO dao = new VendedorDAO(conexao);
		try {
			dao.inserir(vendedor);
			JOptionPane.showMessageDialog(null, Mensagem.VendedorGravado, Mensagem.sucesso, 1);
			conexao.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao inserir o vendedor");
			e.printStackTrace();
		};
	}

	public List<Vendedor> buscarTodos() {
		List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
		VendedorDAO dao = new VendedorDAO(conexao);
		try {
			listaVendedores = dao.buscarTodos();
			conexao.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao listar os vendedor");
			e.printStackTrace();
		}
		return listaVendedores;
	}
	public void excluir(Vendedor vendedor) {
		VendedorDAO dao = new VendedorDAO(conexao);
		try {
			dao.excluir(vendedor);
			JOptionPane.showMessageDialog(null, "Vendedor excluido com sucesso");
			conexao.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao excluir o vendedor");
			e.printStackTrace();
		}
	}

}
