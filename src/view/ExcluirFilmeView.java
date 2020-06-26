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
import model.Filme;

public class ExcluirFilmeView {

	// Declaraçao das variaveis
	private JFrame janela;
	private JPanel painelDaJanela;
	private JComboBox cbFilmes;
	private JButton btOk;
	private JButton btExcluir;
	private JButton btCancelar;
	private JLabel lbNome;
	private TextField tfNome;
	private ArrayList<Filme> listaFilmes = new ArrayList<Filme>();

	public void iniciaGui() {

		// criação das instancias
		janela = new JFrame();
		painelDaJanela = (JPanel) janela.getContentPane();
		cbFilmes = new JComboBox();
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
		cbFilmes.setBounds(80, 30, 350, 30);

		carregarCombo();
		bloqueioInicial();

		// Configurações do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(lbNome);
		painelDaJanela.add(tfNome);
		painelDaJanela.add(btOk);
		painelDaJanela.add(cbFilmes);
		painelDaJanela.add(btCancelar);
		painelDaJanela.add(btExcluir);

		// Configurações da janela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("EXCLUIR FILME");
		janela.setSize(600, 270);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public void carregarCombo() {
		cbFilmes.addItem("- Selecione um filme -");
		for (Filme filme : new FilmeController().buscarTodos()) {
			cbFilmes.addItem(filme.getNome());
			listaFilmes.add(filme);
		}
	}

	public void bloqueioInicial() {
		tfNome.setEditable(false);
		btExcluir.setEnabled(false);
	}

	public void ok() {
		if (cbFilmes.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um filme para excluir.");
		} else {
			carregarFilme();
		}
	}

	public void carregarFilme() {
		btExcluir.setEnabled(true);
		tfNome.setText(cbFilmes.getSelectedItem() + "");
	}

	public void excluir() {
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir esse filme?");
		if (opcao == 0) {
			// procedimentos de exclusão

			new FilmeController().excluir(listaFilmes.get(cbFilmes.getSelectedIndex() - 1));

			limparTela();
		}

	}

	public void limparTela() {
		cbFilmes.removeAllItems();
		tfNome.setText(null);
		bloqueioInicial();
		carregarCombo();
	}

}
