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

import controller.ClienteController;
import model.Cliente;

public class ExcluirClienteView {

	// Declaraçao das variaveis
	private JFrame janela;
	private JPanel painelDaJanela;
	private JComboBox cbClientes;
	private JButton btOk;
	private JButton btExcluir;
	private JButton btCancelar;
	private JLabel lbNome;
	private TextField tfNome;
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	public void iniciaGui() {

		// criação das instancias
		janela = new JFrame();
		painelDaJanela = (JPanel) janela.getContentPane();
		cbClientes = new JComboBox();
		btOk = new JButton();
		btExcluir = new JButton();
		btCancelar = new JButton();
		lbNome = new JLabel();
		tfNome = new TextField();

		// Configurações das Labels
		lbNome.setText("Nome:");
		lbNome.setBounds(20, 110, 50, 30);
		tfNome.setBounds(80, 110, 300, 30);

		// Configurações dos botões
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

		// Configurações dos comboBox
		cbClientes.setBounds(80, 30, 350, 30);

		carregarCombo();
		bloqueioInicial();

		// Configurações do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(lbNome);
		painelDaJanela.add(tfNome);
		painelDaJanela.add(btOk);
		painelDaJanela.add(cbClientes);
		painelDaJanela.add(btCancelar);
		painelDaJanela.add(btExcluir);

		// Configurações da janela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("EXCLUIR CLIENTE");
		janela.setSize(600, 270);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public void carregarCombo() {
		cbClientes.addItem("- Selecione um cliente -");
		for (Cliente cliente : new ClienteController().buscarTodos()) {
			cbClientes.addItem(cliente.getNome());
			listaClientes.add(cliente);
		}
	}

	public void bloqueioInicial() {
		tfNome.setEditable(false);
		btExcluir.setEnabled(false);
	}

	public void ok() {
		if (cbClientes.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir.");
		} else {
			carregarCliente();
		}
	}

	public void carregarCliente() {
		btExcluir.setEnabled(true);
		tfNome.setText(cbClientes.getSelectedItem() + "");
	}

	public void excluir() {
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir esse cliente?");
		if (opcao == 0) {
			// procedimentos de exclusão

			new ClienteController().excluir(listaClientes.get(cbClientes.getSelectedIndex() - 1));

			limparTela();
		}

	}

	public void limparTela() {
		cbClientes.removeAllItems();
		tfNome.setText(null);
		bloqueioInicial();
		carregarCombo();
	}

}
