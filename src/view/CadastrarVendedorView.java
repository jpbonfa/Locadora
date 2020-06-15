package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import util.Valida;

public class CadastrarVendedorView {

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
	private JTextField tfIdade;
	private JTextField tfSalario;
	private JComboBox cbEstado;
	private JComboBox cbCidade;
	private String estado[] = { "- Selecione um estado - ", "São Paulo", "Rio de Janeiro" };
	private String cidade[] = { "- Selecione uma cidade - ", "São Paulo", "Rio de Janeiro" };
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JButton btSalvar;
	private JButton btCancelar;
	private ButtonGroup grupoRadioSexo;

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
		cbCidade = new JComboBox(cidade);
		tfIdade = new JTextField();
		tfSalario = new JTextField();
		cbEstado = new JComboBox(estado);
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();
		btSalvar = new JButton();
		btCancelar = new JButton();

		// Cria o objeto dos grupos de botões
		grupoRadioSexo = new ButtonGroup();
		// Adicionando os botões ao grupo
		grupoRadioSexo.add(rbMasculino);
		grupoRadioSexo.add(rbFeminino);

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
		cbCidade.setBounds(140, 80, 420, 27);

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
		btCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(false);
			}
		});
		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});

		// Configurações do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(lbNome);
		painelDaJanela.add(tfNome);
		painelDaJanela.add(lbArea);
		painelDaJanela.add(tfArea);
		painelDaJanela.add(lbCidade);
		painelDaJanela.add(cbCidade);
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
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("CADASTRO DE VENDEDOR");
		janela.setSize(600, 370);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public void salvar() {

		if (validarDados()) {
			JOptionPane.showMessageDialog(null, "Vendedor gravado com sucesso");
		}

	}

	public boolean validarDados() {

		if (tfNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Inforome um nome valido, campo obrigatorio", "Erro", 0);
			return false;
		}
		if (tfArea.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Inforome uma area valida, campo obrigatorio", "Erro", 0);
			return false;
		}
		if (cbCidade.getSelectedIndex() == 0) {

			JOptionPane.showMessageDialog(null, "Inforome uma cidade valida, campo obrigatorio", "Erro", 0);
			return false;
		}
		if (cbEstado.getSelectedIndex() == 0) {

			JOptionPane.showMessageDialog(null, "Inforome um Estado valido, campo obrigatorio", "Erro", 0);
			return false;
		}
		if (!rbMasculino.isSelected()) {// inicio do if
			if (!rbFeminino.isSelected()) {// inicio do if
				JOptionPane.showMessageDialog(null, "Inforome um sexo valido, campo obrigatorio", "Erro", 0);
				return false;
			}
		} // fim do if

		if (Valida.verificaIntZero(tfIdade.getText())) {

			JOptionPane.showMessageDialog(null, "Informe uma idade valida, campo obrigatorio", "Erro", 0);
			return false;
		}
		if (Valida.verificaDoubleZero(tfSalario.getText())) {

			JOptionPane.showMessageDialog(null, "Informe um salario valido, campo obrigatorio", "Erro", 0);
			return false;
		}

		return true;
	}

}
