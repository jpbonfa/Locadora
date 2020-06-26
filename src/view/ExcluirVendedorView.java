package view;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.FilmeController;
import controller.VendedorController;
import model.Filme;
import model.Vendedor;

public class ExcluirVendedorView {

	// Declara�ao das variaveis
	private JFrame janela;
	private JPanel painelDaJanela;
	private JComboBox cbVendedor;
	private JButton btOk;
	private JButton btExcluir;
	private JButton btCancelar;
	private JLabel lbNome;
	private TextField tfNome;
	private ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();

	public void iniciaGui() {

		// cria��o das instancias
		janela = new JFrame();
		painelDaJanela = (JPanel) janela.getContentPane();
		cbVendedor = new JComboBox();
		btOk = new JButton();
		btExcluir = new JButton();
		btCancelar = new JButton();
		lbNome = new JLabel();
		tfNome = new TextField();

		// Configura��es das Labels
		lbNome.setText("Nome:");
		lbNome.setBounds(20, 110, 50, 30);
		tfNome.setBounds(80, 110, 300, 30);

		// Configura��es dos bot�es
		btOk.setText("OK");
		btExcluir.setText("Excluir");
		btCancelar.setText("Cancelar");
		btOk.setBounds(450, 30, 80, 30);
		btExcluir.setBounds(150, 180, 130, 30);
		btCancelar.setBounds(290, 180, 130, 30);
		btCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(false);
				cbVendedor.setSelectedItem(-1);
			}
		});
		btOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ok();
			}
		});

		btExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});

		// Configura��es dos comboBox
		cbVendedor.setBounds(80, 30, 350, 30);

		carregarCombo();
		bloqueioInicial();

		// Configura��es do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(lbNome);
		painelDaJanela.add(tfNome);
		painelDaJanela.add(btOk);
		painelDaJanela.add(cbVendedor);
		painelDaJanela.add(btCancelar);
		painelDaJanela.add(btExcluir);

		// Configura��es da janela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("EXCLUIR VENDEDOR");
		janela.setSize(600, 270);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public void carregarCombo() {
		cbVendedor.addItem("- Selecione um vendedor -");
		for (Vendedor vendedor : new VendedorController().buscarTodos()) {
			cbVendedor.addItem(vendedor.getNome());
			listaVendedores.add(vendedor);
		}
	}

	public void bloqueioInicial() {
		tfNome.setEditable(false);
		btExcluir.setEnabled(false);
	}

	public void ok() {
		if (cbVendedor.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um vendedor para excluir.");
		} else {
			carregarVendedor();
		}
	}

	public void carregarVendedor() {
		btExcluir.setEnabled(true);
		tfNome.setText(cbVendedor.getSelectedItem() + "");
	}

	public void excluir() {
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir esse filme?");
		if (opcao == 0) {
			// procedimentos de exclus�o

			new VendedorController().excluir(listaVendedores.get(cbVendedor.getSelectedIndex() - 1));

			limparTela();
		}

	}

	public void limparTela() {
		cbVendedor.removeAllItems();
		tfNome.setText(null);
		bloqueioInicial();
		carregarCombo();
	}

}
