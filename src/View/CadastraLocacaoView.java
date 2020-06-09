package View;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import util.Util;

public class CadastraLocacaoView {
	private JFrame janela;
	private JPanel painelDaJanela;
	private JLabel lbNomeVendedor;
	private JLabel lbNomeFilme;
	private JLabel lbFormaDePagamento;
	private JLabel lbTotal;
	private JLabel lbPago;
	private JLabel lbTroco;
	private JComboBox cbVendedor;
	private JComboBox cbFilme;
	private JRadioButton rbDinheiro;
	private JRadioButton rbCheque;
	private JRadioButton rbDebito;
	private JRadioButton rbCredito;
	private JTextField tfTotal;
	private JTextField tfPago;
	private JTextField tfTroco;
	private JButton btIncluir;
	private JButton btSalvar;
	private JButton btCancelar;
	private JTable tbTabela;
	private JScrollPane scroll;
	private String vendedor[] = { " - selecione um Vendedor - " };
	private String filme[] = { " - selecione um Filme - " };
	private String colunas[] = { "Codigo", "Nome", "Valor", "Disponivel",
			"Promoção", "Valor Promocional" };
	private String dados[][] = { {"01","MIB","15,00","SIM","5,00","10,00"},{ }};

	public void iniciaGui() {

		// Criar Instancias
		janela = new JFrame();
		painelDaJanela = (JPanel) janela.getContentPane();
		lbNomeVendedor = new JLabel();
		lbNomeFilme = new JLabel();
		lbFormaDePagamento = new JLabel();
		lbTotal = new JLabel();
		lbPago = new JLabel();
		lbTroco = new JLabel();
		tfTotal = new JTextField();
		tfPago = new JTextField();
		tfTroco = new JTextField();
		rbDinheiro = new JRadioButton();
		rbCheque = new JRadioButton();
		rbDebito = new JRadioButton();
		rbCredito = new JRadioButton();
		btSalvar = new JButton();
		btCancelar = new JButton();
		btIncluir = new JButton();
		tbTabela = new JTable();
		cbVendedor = new JComboBox(vendedor);
		cbFilme = new JComboBox(filme);

		// Configurações dos textos das Labels
		lbNomeVendedor.setText("Nome do Vendedor:");
		lbNomeFilme.setText("Nome do Filme:");
		lbFormaDePagamento.setText("Forma de Pagamento:");
		lbTotal.setText("Valor Total:");
		lbPago.setText("Valor Pago:");
		lbTroco.setText("Troco:");

		// configuraçoes das coordenadas dos componetes do nome do vendedor
		lbNomeVendedor.setBounds(20, 30, 120, 30);
		cbVendedor.setBounds(160, 30, 410, 30);

		// configuraçoes das coordenadas dos componetes do nome do Filme
		lbNomeFilme.setBounds(20, 70, 120, 30);
		cbFilme.setBounds(160, 70, 300, 30);

		// configuraçoes dos componetes dos Botões
		btIncluir.setText("INCLUIR");
		btIncluir.setBounds(470, 70, 100, 30);

		// configuraçoes das coordenadas dos componetes da forma de pagamento
		lbFormaDePagamento.setBounds(20, 200, 150, 30);
		rbDinheiro.setText("Dinheiro");
		rbCheque.setText("Cheque");
		rbDebito.setText("Debito");
		rbCredito.setText("Credito");
		rbDinheiro.setBounds(160, 205, 70, 20);
		rbCheque.setBounds(160, 225, 70, 20);
		rbDebito.setBounds(160, 245, 70, 20);
		rbCredito.setBounds(160, 265, 70, 20);

		// configuraçoes das coordenadas dos componetes de pagamento
		lbTotal.setBounds(360, 205, 70, 20);
		tfTotal.setBounds(430, 205, 100, 25);
		lbPago.setBounds(360, 235, 70, 20);
		tfPago.setBounds(430, 235, 100, 25);
		lbTroco.setBounds(360, 265, 70, 20);
		tfTroco.setBounds(430, 265, 100, 25);

		// Configuracões dos Botões
		btSalvar.setText("Salvar");
		btCancelar.setText("Cancelar");
		btSalvar.setBounds(150, 300, 130, 25);
		btCancelar.setBounds(290, 300, 130, 25);
		btIncluir.setText("INCLUIR");
		btIncluir.setBounds(470, 70, 100, 25);

		// Configurações da tabela,
		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
		tbTabela = new JTable(modelo);
		tbTabela.setEnabled(true);
		tbTabela.setBounds(20, 120, 400, 50);
		// configurações do scroll
		scroll = new JScrollPane(tbTabela);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(01, 100, 590, 100);

		// Configurações do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(lbNomeVendedor);
		painelDaJanela.add(cbVendedor);
		painelDaJanela.add(lbNomeFilme);
		painelDaJanela.add(cbFilme);
		painelDaJanela.add(btIncluir);
		painelDaJanela.add(lbFormaDePagamento);
		painelDaJanela.add(rbDinheiro);
		painelDaJanela.add(rbCheque);
		painelDaJanela.add(rbDebito);
		painelDaJanela.add(rbCredito);
		painelDaJanela.add(lbTotal);
		painelDaJanela.add(tfTotal);
		painelDaJanela.add(lbPago);
		painelDaJanela.add(tfPago);
		painelDaJanela.add(lbTroco);
		painelDaJanela.add(tfTroco);
		painelDaJanela.add(btSalvar);
		painelDaJanela.add(btCancelar);
		painelDaJanela.add(scroll);

		// Configurações da janela
		// janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("LOCAÇÃO DE FILME");
		janela.setSize(600, 370);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public static void main(String[] args) {
		new Util().mudarAparencia();
		new CadastraLocacaoView().iniciaGui();
	}
}
