package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.Cliente;
import model.Data;
import util.Util;
import util.Valida;

public class CadastrarClienteView {
	private JFrame janela;
	private JPanel painelDaJanela;
	private JLabel lbNome;
	private JLabel lbEndereco;
	private JLabel lbCpf;
	private JLabel lbRg;
	private JLabel lbDataNascimento;
	private JLabel lbSexo;
	private JLabel lbTelefone;
	private JLabel lbCelular;
	private JLabel lbEmail;
	private JLabel lblougradoro;
	private JLabel lbNumero;
	private JLabel lbComplemento;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JComboBox cbLougradouro;
	private JComboBox cbCidade;
	private JComboBox cbEstado;
	private JTextField tfNome;
	private JTextField tfEndereco;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JFormattedTextField tfCpf;
	private JFormattedTextField tfRg;
	private JFormattedTextField tfData;
	private JFormattedTextField tfTelefone;
	private JFormattedTextField tfCelular;
	private JTextField tfEmail;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JButton btSalvar;
	private JButton btCancelar;
	public String lougradouros[] = { "- Selecione um lougradouro - ", "rua", "avenida", "alameda" };
	public String cidade[] = { "- Selecione uma cidade - ", "São Paulo", "Rio de janeiro" };
	public String estado[] = { "- Selecione um estado - ", "São Paulo", "Rio de janeiro" };
	private MaskFormatter fmtCpf;
	private MaskFormatter fmtRg;
	private MaskFormatter fmtDataNascimento;
	private MaskFormatter fmtTelefone;
	private MaskFormatter fmtCelular;
	private ButtonGroup grupoRadioSexo;

	public void iniciaGui() throws ParseException {

		// Criação das instancias de formato(DEVE SER A PRIMEIRA INSTANCIA)
		fmtCpf = new MaskFormatter("###.###.###-##");
		fmtRg = new MaskFormatter("##.###.###-#");
		fmtDataNascimento = new MaskFormatter("##/##/####");
		fmtTelefone = new MaskFormatter("(##)####-####");
		fmtCelular = new MaskFormatter("(##)#####-####");

		// Cria o objeto dos grupos de botões
		grupoRadioSexo = new ButtonGroup();

		// Adicionando os botões ao grupo
		grupoRadioSexo.add(rbMasculino);
		grupoRadioSexo.add(rbFeminino);

		// inicialização das instancias
		janela = new JFrame();
		painelDaJanela = (JPanel) janela.getContentPane();
		lbNome = new JLabel();
		lbEndereco = new JLabel();
		lbCpf = new JLabel();
		lbRg = new JLabel();
		lbDataNascimento = new JLabel();
		lbSexo = new JLabel();
		lbEmail = new JLabel();
		lbTelefone = new JLabel();
		lbCelular = new JLabel();
		lblougradoro = new JLabel();
		lbNumero = new JLabel();
		lbComplemento = new JLabel();
		lbCidade = new JLabel();
		lbEstado = new JLabel();
		tfNome = new JTextField();
		tfEndereco = new JTextField();
		tfTelefone = new JFormattedTextField(fmtTelefone);
		tfCelular = new JFormattedTextField(fmtCelular);
		tfEmail = new JTextField();
		tfEndereco = new JTextField();
		tfNumero = new JTextField();
		tfComplemento = new JTextField();
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();
		btSalvar = new JButton();
		btCancelar = new JButton();
		tfCpf = new JFormattedTextField(fmtCpf);
		tfRg = new JFormattedTextField(fmtRg);
		tfData = new JFormattedTextField(fmtDataNascimento);
		cbLougradouro = new JComboBox(lougradouros);
		cbCidade = new JComboBox(cidade);
		cbEstado = new JComboBox(estado);

		// configuraçao de texto das labels
		lbNome.setText("Nome:");
		lbEndereco.setText("Endereço:");
		lbCpf.setText("CPF:");
		lbRg.setText("RG:");
		lbDataNascimento.setText("nascimento:");
		lbSexo.setText("Sexo:");
		lbTelefone.setText("Telefone:");
		lbCelular.setText("Celular:");
		lbEmail.setText("Email:");
		lblougradoro.setText("Log:");
		lbNumero.setText("Nº:");
		lbComplemento.setText("Compl:");
		lbCidade.setText("Cidade:");
		lbEstado.setText("Estado:");

		// configurações das coordenadas dos componentes de nome
		lbNome.setBounds(20, 60, 70, 25);
		tfNome.setBounds(80, 60, 400, 25);

		// configurações das coordenadas dos componentes de Endereço
		lblougradoro.setBounds(20, 105, 90, 25);
		cbLougradouro.setBounds(80, 105, 90, 25);

		lbEndereco.setBounds(180, 105, 70, 25);
		tfEndereco.setBounds(248, 105, 230, 25);

		lbComplemento.setBounds(20, 145, 90, 25);
		tfComplemento.setBounds(80, 145, 70, 25);
		lbCidade.setBounds(180, 145, 90, 25);
		cbCidade.setBounds(250, 145, 110, 25);
		lbEstado.setBounds(400, 145, 90, 25);
		cbEstado.setBounds(448, 145, 110, 25);
		lbNumero.setBounds(492, 105, 80, 25);
		tfNumero.setBounds(520, 105, 50, 25);

		// configurações das coordenadas dos componentes de CPF

		lbCpf.setBounds(20, 25, 70, 25);
		tfCpf.setBounds(80, 25, 100, 25);

		// configurações das coordenadas dos componentes de rg
		lbRg.setBounds(200, 25, 30, 25);
		tfRg.setBounds(248, 25, 100, 25);

		// configurações das coordenadas dos componentes de data
		lbDataNascimento.setBounds(360, 25, 120, 25);
		tfData.setBounds(440, 25, 100, 25);

		// configurações dos componentes de sexo
		rbMasculino.setText("Masculino");
		rbFeminino.setText("Feminino");
		lbSexo.setBounds(20, 177, 70, 25);
		rbMasculino.setBounds(100, 177, 90, 25);
		rbFeminino.setBounds(185, 177, 80, 25);

		// configurações das coordenadas dos componentes de Telefone
		lbTelefone.setBounds(20, 220, 120, 25);
		tfTelefone.setBounds(80, 220, 120, 25);

		// configurações das coordenadas dos componentes de Celular
		lbCelular.setBounds(210, 220, 120, 25);
		tfCelular.setBounds(250, 220, 150, 25);

		// configurações das coordenadas dos componentes de email
		lbEmail.setBounds(20, 265, 120, 25);
		tfEmail.setBounds(80, 265, 450, 25);

		// Configuracões dos Botões
		btSalvar.setText("Salvar");
		btCancelar.setText("Cancelar");
		btSalvar.setBounds(150, 300, 130, 25);
		btCancelar.setBounds(290, 300, 130, 25);
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
		painelDaJanela.add(lbEndereco);
		painelDaJanela.add(tfEndereco);
		painelDaJanela.add(lbCpf);
		painelDaJanela.add(tfCpf);
		painelDaJanela.add(lbRg);
		painelDaJanela.add(tfRg);
		painelDaJanela.add(lbDataNascimento);
		painelDaJanela.add(tfData);
		painelDaJanela.add(lbSexo);
		painelDaJanela.add(rbMasculino);
		painelDaJanela.add(rbFeminino);
		painelDaJanela.add(lbTelefone);
		painelDaJanela.add(tfTelefone);
		painelDaJanela.add(lbCelular);
		painelDaJanela.add(tfCelular);
		painelDaJanela.add(lbEmail);
		painelDaJanela.add(tfEmail);
		painelDaJanela.add(btSalvar);
		painelDaJanela.add(btCancelar);
		painelDaJanela.add(cbLougradouro);
		painelDaJanela.add(lblougradoro);
		painelDaJanela.add(lbNumero);
		painelDaJanela.add(tfNumero);
		painelDaJanela.add(lbCidade);
		painelDaJanela.add(cbCidade);
		painelDaJanela.add(lbEstado);
		painelDaJanela.add(cbEstado);
		painelDaJanela.add(lbComplemento);
		painelDaJanela.add(tfComplemento);

		// Configurações da janela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("Cadastro de clientes");
		janela.setSize(600, 370);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public void salvar() {

		if (validarDados()) {
			JOptionPane.showMessageDialog(null, "Cliente gravado com sucesso");
		}

	}

	public boolean validarDados() {

		if (Valida.verificaCpfVazio(tfCpf.getText())) {
			JOptionPane.showMessageDialog(null, "Inforome um CPF valido, campo obrigatorio", "Erro", 0);
			return false;
		}
		if (Valida.verificaRgVazio(tfRg.getText())) {
			JOptionPane.showMessageDialog(null, "Inforome um RG valido, campo obrigatorio", "Erro", 0);
			return false;
		}
		if (Valida.verificaDataVazio(tfData.getText())) {
			JOptionPane.showMessageDialog(null, "Inforome uma data valida, campo obrigatorio", "Erro", 0);
			return false;
		}
		if (tfNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Inforome um nome valido, campo obrigatorio", "Erro", 0);
			return false;
		}
		if (cbLougradouro.getSelectedIndex() == 0) {

			JOptionPane.showMessageDialog(null, "Inforome um lougradouro valido, campo obrigatorio", "Erro", 0);
			return false;

		}
		if (tfEndereco.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Inforome um endereço valido, campo obrigatorio", "Erro", 0);
			return false;
		}
		if (tfNumero.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Inforome um numero valido, campo obrigatorio", "Erro", 0);
			return false;
		}
		if (tfComplemento.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Inforome um complemento valido, campo obrigatorio", "Erro", 0);
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
			} // fim do if

		}
		if (tfTelefone.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Inforome um telefone valido, campo obrigatorio", "Erro", 0);
			return false;
		}
		if (tfCelular.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Inforome um celular valido, campo obrigatorio", "Erro", 0);
			return false;
		}
		if (tfEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Inforome um email valido, campo obrigatorio", "Erro", 0);
			return false;
		}

		return true;
	}
}
