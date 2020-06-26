package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.FilmeController;
import controller.VendedorController;
import model.Filme;
import model.Vendedor;

public class ConsultarVendedorView {

	private JFrame janela;
	private JPanel painelDaJanela;
	private JButton btSair;
	private JTable tbTabela;
	private JScrollPane scroll;
	private String colunas[] = { "Nome", "Area de venda", "Cidade", "Estado", "Idade", "Salario" };
	private String dados[][] = { {} };

	public void iniciaGui() {

		// declaraçao das variaveis
		janela = new JFrame();
		painelDaJanela = (JPanel) janela.getContentPane();
		btSair = new JButton();

		// Configurações da tabela,
		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
		tbTabela = new JTable(modelo);
		tbTabela.setEnabled(true);
		tbTabela.setBounds(20, 120, 400, 50);
		// configurações do scroll
		scroll = new JScrollPane(tbTabela);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(01, 01, 590, 300);

		// configuracoes do botão
		btSair.setText("Sair");
		btSair.setBounds(230, 310, 120, 30);
		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				janela.setVisible(false);
			}
		});

		carregarVendedores();

		// Configurações do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(scroll);
		painelDaJanela.add(btSair);

		// Configurações da janela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("CONSULTA DE VENDEDOR");
		janela.setSize(600, 380);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public void carregarVendedores() {
		// Obtendo o modelo da tabela ja criada
		DefaultTableModel modelo = (DefaultTableModel) tbTabela.getModel();
		modelo.removeRow(0);
		for (Vendedor vendedor : new VendedorController().buscarTodos()) {
			// Adicioando a linha com os dados
			modelo.addRow(new String[] { vendedor.getCodigo() + "", vendedor.getNome(), vendedor.getAreaVenda(),
					vendedor.getCidade(), vendedor.getEstado(), vendedor.getSexo() + "", vendedor.getIdade() + "",
					vendedor.getSalario() + "" });

		}
	}

}
