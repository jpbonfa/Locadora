package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import dao.ClienteDAO;
import dao.FilmeDAO;
import model.Cliente;
import model.Filme;
import util.ConnectionFactory;
import util.Mensagem;

public class FilmeController {

	private Connection conexao = ConnectionFactory.getConnection();

	public void inserir(Filme filme) {

		FilmeDAO dao = new FilmeDAO(conexao);
		try {
			dao.inserir(filme);
			JOptionPane.showMessageDialog(null, Mensagem.filmeGravado, Mensagem.sucesso, 1);
			conexao.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao inserir o filme");
			e.printStackTrace();
		}
	}

	public List<Filme> buscarTodos() {
		List<Filme> listaFilmes = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO(conexao);
		try {
			listaFilmes = dao.buscarTodos();
			conexao.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao listar os filmes");
			e.printStackTrace();
		}
		return listaFilmes;
	}

	public void excluir(Filme filme) {
		FilmeDAO dao = new FilmeDAO(conexao);
		try {
			dao.excluir(filme);
			JOptionPane.showMessageDialog(null, "Filme excluido com sucesso");
			conexao.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao excluir o filme");
			e.printStackTrace();
		}
	}

	public void alterar(Filme filme) {
		FilmeDAO dao = new FilmeDAO(conexao);
		try {
			dao.alterar(filme);
			JOptionPane.showMessageDialog(null, "Filme alterado com sucesso");
			conexao.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao alterar o filme");
			e.printStackTrace();
		}
	}

}
