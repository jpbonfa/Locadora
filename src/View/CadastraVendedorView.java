package View;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import util.Util;

public class CadastraVendedorView {

	private JFrame janela;
	private JPanel painelDaJanela;
	private JLabel lbNome;
	private JLabel lbArea;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JLabel lbSexo;
	private JLabel lbIdade;
	private JLabel lbSalario;
	private JTextField tfNome;
	private JTextField tfArea;
	private JTextField tfCidade;
	private JTextField tfIdade;
	private JTextField tfSalario;
	private JComboBox cbEstado;
	private String estado[] = { "São Paulo", "Rio de Janeiro" };
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JButton btSalvar;
	private JButton btCancelar;

	public void iniciaGui() {

		// Criar Instancias
		janela = new JFrame();
		painelDaJanela = (JPanel) janela.getContentPane();
		lbNome = new JLabel();
		lbArea = new JLabel();
		lbCidade = new JLabel();
		lbEstado = new JLabel();
		lbSexo = new JLabel();
		lbIdade = new JLabel();
		lbSalario = new JLabel();
		tfNome = new JTextField();
		tfNome = new JTextField();
		tfArea = new JTextField();
		tfCidade = new JTextField();
		tfIdade = new JTextField();
		tfSalario = new JTextField();
		cbEstado = new JComboBox(estado);
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();
		btSalvar = new JButton();
		btCancelar = new JButton();

		// Configurações dos textos das Labels
		lbNome.setText("Nome:");
		lbArea.setText("Area de Venda:");
		lbCidade.setText("Cidade:");
		lbEstado.setText("Estado:");
		lbSexo.setText("Sexo");
		lbIdade.setText("Idade:");
		lbSalario.setText("Salario:");

		// configurações das coordenadas dos componentes do nome
		lbNome.setBounds(20, 20, 50, 20);
		tfNome.setBounds(140, 20, 420, 27);

		// configurações das coordenadas dos componentes da Area de venda
		lbArea.setBounds(20, 50, 90, 20);
		tfArea.setBounds(140, 50, 420, 27);

		// configurações das coordenadas dos componentes do Cidade
		lbCidade.setBounds(20, 80, 50, 20);
		tfCidade.setBounds(140, 80, 420, 27);

		// configurações das coordenadas dos componentes do Estado
		lbEstado.setBounds(20, 110, 50, 20);
		cbEstado.setBounds(140, 110, 320, 27);

		// configurações das coordenadas dos componentes de Sexo
		lbSexo.setBounds(20, 140, 50, 20);
		rbMasculino.setText("Masculino");
		rbMasculino.setBounds(140, 140, 120, 27);
		rbFeminino.setText("Feminino");
		rbFeminino.setBounds(230, 140, 120, 27);

		// configurações das coordenadas dos componentes da Idade
		lbIdade.setBounds(20, 170, 50, 20);
		tfIdade.setBounds(140, 170, 420, 27);

		// configurações das coordenadas dos componentes do Estado
		lbSalario.setBounds(20, 200, 50, 20);
		tfSalario.setBounds(140, 200, 420, 27);

		// Configuracões dos Botões
		btSalvar.setText("Salvar");
		btCancelar.setText("Cancelar");
		btSalvar.setBounds(150, 280, 130, 35);
		btCancelar.setBounds(290, 280, 130, 35);

		// Configurações do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(lbNome);
		painelDaJanela.add(tfNome);
		painelDaJanela.add(lbArea);
		painelDaJanela.add(tfArea);
		painelDaJanela.add(lbCidade);
		painelDaJanela.add(tfCidade);
		painelDaJanela.add(lbEstado);
		painelDaJanela.add(cbEstado);
		painelDaJanela.add(lbSexo);
		painelDaJanela.add(rbMasculino);
		painelDaJanela.add(rbFeminino);
		painelDaJanela.add(tfIdade);
		painelDaJanela.add(lbIdade);
		painelDaJanela.add(lbSalario);
		painelDaJanela.add(tfSalario);
		painelDaJanela.add(btSalvar);
		painelDaJanela.add(btCancelar);

		// Configurações da janela
		// janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("CADASTRO DE VENDEDOR");
		janela.setSize(600, 370);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public static void main(String[] args) {
		new Util().mudarAparencia();
		new CadastraVendedorView().iniciaGui();
	}
}
