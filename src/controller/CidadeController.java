package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import dao.CidadeDAO;
import model.Cidade;
import util.ConnectionFactory;

public class CidadeController {

	private Connection conexao = ConnectionFactory.getConnection();

	public List<Cidade> buscarTodos() {
		List<Cidade> listaCidades = new ArrayList<Cidade>();
		CidadeDAO dao = new CidadeDAO(conexao);
		try {
			listaCidades = dao.buscarTodos();
			conexao.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao listar as Cidades");
			e.printStackTrace();
		}
		return listaCidades;
	}
}
