package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.FilmeController;
import model.Filme;

public class AlterarFilmeView {

	// declaração das variaveis
	private JFrame janela;
	private JPanel painelDaJanela;
	// labels
	private JLabel lbNome;
	private JLabel lbValor;
	private JLabel lbDisponivel;
	private JLabel lbPromocao;
	private JLabel lbValorDaPromocao;
	private JLabel lbGenero;
	// tetxtfields
	private JTextField tfNome;
	private JTextField tfValor;
	private JTextField tfValorPromocao;
	// RadioButton
	private JRadioButton rbDisponivelSim;
	private JRadioButton rbDisponivelNao;
	private JRadioButton rbPromocaoSim;
	private JRadioButton rbPromocaoNao;
	// CheckBox
	private JCheckBox cbAcao;
	private JCheckBox cbFiccao;
	private JCheckBox cbTerror;
	private JCheckBox cbComedia;
	private JCheckBox cbOutro;
	// comboBox
	private JComboBox cbFilmes;
	// JButtton
	private JButton btAlterar;
	private JButton btCancelar;
	private JButton btOk;
	// ButtonGroup
	private ButtonGroup grupoRadioDisponivel;
	private ButtonGroup grupoRadioPromocao;
	// arraylist
	private ArrayList<Filme> listaFilmes = new ArrayList<Filme>();

	public void iniciaGui() {
		// Criar Instancias
		janela = new JFrame();
		painelDaJanela = (JPanel) janela.getContentPane();
		lbNome = new JLabel();
		lbValor = new JLabel();
		lbDisponivel = new JLabel();
		lbPromocao = new JLabel();
		lbValorDaPromocao = new JLabel();
		lbGenero = new JLabel();
		tfNome = new JTextField();
		tfValor = new JTextField();
		tfValorPromocao = new JTextField();
		rbDisponivelSim = new JRadioButton();
		rbDisponivelNao = new JRadioButton();
		rbPromocaoSim = new JRadioButton();
		rbPromocaoNao = new JRadioButton();
		cbAcao = new JCheckBox();
		cbFiccao = new JCheckBox();
		cbTerror = new JCheckBox();
		cbComedia = new JCheckBox();
		cbOutro = new JCheckBox();
		cbFilmes = new JComboBox();
		btOk = new JButton();
		btCancelar = new JButton();
		btAlterar = new JButton();

		// Cria o objeto dos grupos de botões
		grupoRadioDisponivel = new ButtonGroup();
		grupoRadioPromocao = new ButtonGroup();

		// Adicionando os botões ao grupo
		grupoRadioDisponivel.add(rbDisponivelSim);
		grupoRadioDisponivel.add(rbDisponivelNao);
		grupoRadioPromocao.add(rbPromocaoSim);
		grupoRadioPromocao.add(rbPromocaoNao);

		// configurações dos componentes da comboBox de seleção
		cbFilmes.setBounds(25, 30, 450, 25);
		// configurações do botão OK
		btOk.setText("OK");
		btOk.setBounds(480, 30, 80, 25);
		// configurações dos componentes de nome
		lbNome.setText("Nome:");
		lbNome.setBounds(25, 60, 80, 25);
		tfNome.setBounds(70, 60, 300, 25);
		// configurações dos componentes do Valor
		lbValor.setText("Valor: ");
		lbValor.setBounds(375, 60, 80, 25);
		tfValor.setBounds(420, 60, 140, 25);
		// configurações dos componentes de disponibilidade
		lbDisponivel.setText("Disp: ");
		rbDisponivelSim.setText("Disponivel");
		rbDisponivelNao.setText("Indisponivel");
		lbDisponivel.setBounds(25, 90, 80, 25);
		rbDisponivelSim.setBounds(100, 90, 90, 25);
		rbDisponivelNao.setBounds(190, 90, 100, 25);

		// configurações dos componentes da Promoção
		lbPromocao.setText("Promoção: ");
		rbPromocaoSim.setText("Sim");
		rbPromocaoNao.setText("Não");
		lbPromocao.setBounds(320, 90, 80, 25);
		rbPromocaoSim.setBounds(400, 90, 50, 25);
		rbPromocaoNao.setBounds(480, 90, 50, 25);

		// Configurações das coordenadas dos componentes de valor da promoçao
		lbValorDaPromocao.setText("Valor promo: ");
		lbValorDaPromocao.setBounds(20, 120, 110, 20);
		tfValorPromocao.setBounds(100, 120, 420, 25);

		// Configuraçoes dos componentes de genero
		lbGenero.setText("Genero: ");
		lbGenero.setBounds(20, 150, 50, 20);
		cbAcao.setText("Ação");
		cbAcao.setBounds(100, 150, 90, 20);
		cbFiccao.setText("Ficção");
		cbFiccao.setBounds(200, 150, 90, 20);
		cbTerror.setText("Terror");
		cbTerror.setBounds(300, 150, 90, 20);
		cbComedia.setText("Comedia");
		cbComedia.setBounds(400, 150, 100, 20);
		cbOutro.setText("Outro");
		cbOutro.setBounds(500, 150, 90, 20);

		// configurações do botão alterar
		btAlterar.setText("Alterar");
		btAlterar.setBounds(180, 220, 90, 25);

		// configurações do botão cancelar
		btCancelar.setText("Cancelar");
		btCancelar.setBounds(280, 220, 90, 25);
		btCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(false);
			}
		});
		carregarFilme();
		// Configurações do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(cbFilmes);
		painelDaJanela.add(lbNome);
		painelDaJanela.add(tfNome);
		painelDaJanela.add(lbValor);
		painelDaJanela.add(tfValor);
		painelDaJanela.add(lbDisponivel);
		painelDaJanela.add(rbDisponivelSim);
		painelDaJanela.add(rbDisponivelNao);
		painelDaJanela.add(lbPromocao);
		painelDaJanela.add(rbPromocaoSim);
		painelDaJanela.add(rbPromocaoNao);
		painelDaJanela.add(lbValorDaPromocao);
		painelDaJanela.add(tfValorPromocao);
		painelDaJanela.add(lbGenero);
		painelDaJanela.add(cbAcao);
		painelDaJanela.add(cbFiccao);
		painelDaJanela.add(cbAcao);
		painelDaJanela.add(cbTerror);
		painelDaJanela.add(cbComedia);
		painelDaJanela.add(cbOutro);
		painelDaJanela.add(btOk);
		painelDaJanela.add(btCancelar);
		painelDaJanela.add(btAlterar);

		// Configurações da janela
		// janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("ALTERAR DE FILMES");
		janela.setSize(600, 300);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

	public void carregarFilme() {

		cbFilmes.addItem("- Selecione um filme -");
		for (Filme filme : new FilmeController().buscarTodos()) {
			cbFilmes.addItem(filme.getNome());
			listaFilmes.add(filme);
		}
	}
}
