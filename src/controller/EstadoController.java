package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import dao.EstadoDAO;
import model.Estado;
import util.ConnectionFactory;

public class EstadoController {
	private Connection conexao = ConnectionFactory.getConnection();

	public List<Estado> buscarTodos() {
		List<Estado> listaCidades = new ArrayList<Estado>();
		EstadoDAO dao = new EstadoDAO(conexao);
		try {
			listaCidades = dao.buscarTodos();
			conexao.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao listar os estado");
			e.printStackTrace();
		}
		return listaCidades;
	}
}
