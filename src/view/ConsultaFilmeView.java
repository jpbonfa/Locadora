package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultaFilmeView {

	private JFrame janela;
	private JPanel painelDaJanela;
	private JButton btSair;
	private JTable tbTabela;
	private JScrollPane scroll;
	private String colunas[] = { "Codigo", "Nome", "Valor", "Disponivel", "Promo��o", "Valor Promocional" };
	private String dados[][] = { { "01", "MIB", "15,00", "SIM", "5,00", "10,00" }, {} };

	public void iniciaGui() {

		// declara�ao das variaveis
		janela = new JFrame();
		painelDaJanela = (JPanel) janela.getContentPane();
		btSair = new JButton();

		// Configura��es da tabela,
		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
		tbTabela = new JTable(modelo);
		tbTabela.setEnabled(true);
		tbTabela.setBounds(20, 120, 400, 50);
		// configura��es do scroll
		scroll = new JScrollPane(tbTabela);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(01, 01, 590, 300);

		// configuracoes do bot�o
		btSair.setText("Sair");
		btSair.setBounds(230, 310, 120, 30);
		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				janela.setVisible(false);
			}
		});

		// Configura��es do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(scroll);
		painelDaJanela.add(btSair);

		// Configura��es da janela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("Consulta DE FILME");
		janela.setSize(600, 380);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

}