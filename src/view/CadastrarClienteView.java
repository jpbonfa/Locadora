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

import controller.CidadeController;
import controller.ClienteController;
import controller.EstadoController;
import model.Cidade;
import model.Cliente;
import model.Data;
import model.Endereco;
import model.Estado;
import util.Mensagem;
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
	private JLabel lbBairro;
	private JLabel lbCep;
	private JComboBox cbLougradouro;
	private JComboBox cbCidade;
	private JComboBox cbEstado;
	private JTextField tfNome;
	private JTextField tfEndereco;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JTextField tfBairro;
	private JTextField tfCep;
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
	private JButton btNovo;
	private JButton btSair;
	public String lougradouros[] = { "- Selecione um lougradouro - ", "Rua", "Avenida", "Alameda" };
	public String cidade[] = {};
	public String estado[] = {};
	private MaskFormatter fmtCpf;
	private MaskFormatter fmtRg;
	private MaskFormatter fmtDataNascimento;
	private MaskFormatter fmtTelefone;
	private MaskFormatter fmtCelular;
	private MaskFormatter fmtCep;
	private ButtonGroup grupoRadioSexo;
	private int dataNascimento[];

	public void iniciaGui() throws ParseException {

		// Criação das instancias de formato(DEVE SER A PRIMEIRA INSTANCIA)
		fmtCpf = new MaskFormatter("###.###.###-##");
		fmtRg = new MaskFormatter("##.###.###-#");
		fmtDataNascimento = new MaskFormatter("##/##/####");
		fmtTelefone = new MaskFormatter("(##)####-####");
		fmtCelular = new MaskFormatter("(##)#####-####");
		fmtCep = new MaskFormatter("#####-###");

		// Cria o objeto dos grupos de botões
		grupoRadioSexo = new ButtonGroup();

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
		lbBairro = new JLabel();
		lbCep = new JLabel();
		tfNome = new JTextField();
		tfEndereco = new JTextField();
		tfTelefone = new JFormattedTextField(fmtTelefone);
		tfCelular = new JFormattedTextField(fmtCelular);
		tfEmail = new JTextField();
		tfEndereco = new JTextField();
		tfNumero = new JTextField();
		tfComplemento = new JTextField();
		tfBairro = new JTextField();
		tfCep = new JFormattedTextField(fmtCep);
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();
		btSalvar = new JButton();
		btCancelar = new JButton();
		btNovo = new JButton();
		btSair = new JButton();
		tfCpf = new JFormattedTextField(fmtCpf);
		tfRg = new JFormattedTextField(fmtRg);
		tfData = new JFormattedTextField(fmtDataNascimento);
		cbLougradouro = new JComboBox(lougradouros);
		cbCidade = new JComboBox(cidade);
		cbEstado = new JComboBox(estado);

		// Adicionando os botões ao grupo
		grupoRadioSexo.add(rbMasculino);
		grupoRadioSexo.add(rbFeminino);

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
		lbBairro.setText("Bairro:");
		lbCep.setText("CEP:");

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
		lbCidade.setBounds(400, 145, 90, 25);
		cbCidade.setBounds(460, 145, 110, 25);
		lbEstado.setBounds(20, 190, 90, 25);
		cbEstado.setBounds(80, 190, 110, 25);
		lbBairro.setBounds(180, 145, 90, 25);
		tfBairro.setBounds(248, 145, 140, 25);
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
		lbSexo.setBounds(350, 190, 70, 25);
		rbMasculino.setBounds(390, 190, 90, 25);
		rbFeminino.setBounds(480, 190, 80, 25);

		// configurações dos componentes de cep
		lbCep.setBounds(200, 190, 70, 25);
		tfCep.setBounds(248, 190, 90, 25);

		// configurações das coordenadas dos componentes de Telefone
		lbTelefone.setBounds(20, 240, 120, 25);
		tfTelefone.setBounds(80, 240, 120, 25);

		// configurações das coordenadas dos componentes de Celular
		lbCelular.setBounds(210, 240, 120, 25);
		tfCelular.setBounds(250, 240, 150, 25);

		// configurações das coordenadas dos componentes de email
		lbEmail.setBounds(20, 280, 120, 25);
		tfEmail.setBounds(80, 280, 450, 25);

		// Configuracões dos Botões
		btSalvar.setText("Salvar");
		btCancelar.setText("Cancelar");
		btNovo.setText("Novo");
		btSair.setText("Sair");
		btSalvar.setBounds(150, 320, 130, 25);
		btNovo.setBounds(150, 320, 130, 25);
		btCancelar.setBounds(290, 320, 130, 25);
		btSair.setBounds(290, 320, 130, 25);

		btCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});

		btNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});

		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(false);
			}
		});

		carregarCidade();
		carregarEstado();
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
		painelDaJanela.add(btNovo);
		painelDaJanela.add(btSair);
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
		painelDaJanela.add(lbBairro);
		painelDaJanela.add(tfBairro);
		painelDaJanela.add(lbCep);
		painelDaJanela.add(tfCep);

		// Configurações da janela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("CADASTRO DE CLIENTES");
		janela.setSize(600, 400);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		bloqueioInicial();
	}

	public void salvar() {

		if (validarDados()) {

			Cliente cliente = new Cliente();
			Endereco endereco = new Endereco();
			Data data = new Data();

			cliente.setNome(tfNome.getText());
			endereco.setLougradouro(cbLougradouro.getSelectedItem() + "");
			endereco.setEndereco(tfEndereco.getText());
			endereco.setNumero(Integer.parseInt(tfNumero.getText()));
			endereco.setComplemento(tfComplemento.getText());
			endereco.setBairro(tfBairro.getText());
			endereco.setCidade(cbCidade.getSelectedItem() + "");
			endereco.setEstado(cbEstado.getSelectedItem() + "");
			endereco.setCep(tfCep.getText());
			cliente.setEndereco(endereco);
			cliente.setCpf(tfCpf.getText());
			cliente.setRg(tfRg.getText());
			dataNascimento = Util.quebraData(tfData.getText());
			data.setDia(dataNascimento[0]);
			data.setMes(dataNascimento[1]);
			data.setAno(dataNascimento[2]);
			cliente.setDataDeNascimento(data);
			cliente.setIdade(Util.calculaIdade(dataNascimento[2]));
			if (rbMasculino.isSelected()) {
				cliente.setSexo('M');
			} else {
				cliente.setSexo('F');
			}

			cliente.setCelular(tfCelular.getText());
			cliente.setTelefone(tfTelefone.getText());
			cliente.setEmail(tfEmail.getText());

			ClienteController controller = new ClienteController();
			controller.inserir(cliente);

			limparCampos();
			bloqueioInicial();
		}

	}

	public boolean validarDados() {

		if (Valida.verificaCpfVazio(tfCpf.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.informeCpf, Mensagem.erro, 0);
			return false;
		}
		if (Valida.verificaRgVazio(tfRg.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.informeRg, Mensagem.erro, 0);
			return false;
		}
		if (Valida.verificaDataVazio(tfData.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.informeData, Mensagem.erro, 0);
			return false;
		}
		if (tfNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Mensagem.informeNome, Mensagem.erro, 0);
			return false;
		}
		if (cbLougradouro.getSelectedIndex() == 0) {

			JOptionPane.showMessageDialog(null, Mensagem.informeLog, Mensagem.erro, 0);
			return false;

		}
		if (tfEndereco.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Mensagem.informeEndereco, Mensagem.erro, 0);
			return false;
		}
		if (tfNumero.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Mensagem.informeNumero, Mensagem.erro, 0);
			return false;
		}
		if (tfComplemento.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Mensagem.informeComplet, Mensagem.erro, 0);
			return false;
		}
		if (tfBairro.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Mensagem.informeBairro, Mensagem.erro, 0);
			return false;
		}

		if (cbCidade.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, Mensagem.informeCidade, Mensagem.erro, 0);
			return false;
		}
		if (cbEstado.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, Mensagem.informeEstado, Mensagem.erro, 0);
			return false;
		}
		if (Valida.verificaCepVazio(tfCep.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.informeCep, Mensagem.erro, 0);
			return false;
		}
		if (!rbMasculino.isSelected()) {// inicio do if
			if (!rbFeminino.isSelected()) {// inicio do if
				JOptionPane.showMessageDialog(null, Mensagem.informeSexo, Mensagem.erro, 0);

				return false;
			} // fim do if
		}
		if (Valida.verificaTelefoneVazio(tfTelefone.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.informeTelefone, Mensagem.erro, 0);
			return false;
		}
		if (Valida.verificaCelularVazio(tfCelular.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.informeCelular, Mensagem.erro, 0);
			return false;
		}
		if (tfEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Mensagem.informeEmail, Mensagem.erro, 0);
			return false;
		}
		return true;

	}

	public void carregarCidade() {

		cbCidade.addItem("- Selecione uma cidade -");
		for (Cidade cidade : new CidadeController().buscarTodos()) {
			cbCidade.addItem(cidade.getNome());
		}
	}

	public void carregarEstado() {

		cbEstado.addItem("- Selecione um estado -");
		for (Estado estado : new EstadoController().buscarTodos()) {
			cbEstado.addItem(estado.getUf());
		}
	}

	public void novo() {

		btNovo.setVisible(false);
		btSair.setVisible(false);
		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		tfCpf.setEditable(true);
		tfRg.setEditable(true);
		tfData.setEditable(true);
		tfNome.setEditable(true);
		tfCep.setEditable(true);
		tfBairro.setEditable(true);
		cbLougradouro.setEnabled(true);
		tfEndereco.setEditable(true);
		tfNumero.setEditable(true);
		tfComplemento.setEditable(true);
		cbCidade.setEnabled(true);
		cbEstado.setEnabled(true);
		rbFeminino.setEnabled(true);
		rbMasculino.setEnabled(true);
		tfTelefone.setEditable(true);
		tfCelular.setEditable(true);
		tfEmail.setEditable(true);

	}

	public void cancelar() {
		limparCampos();
		bloqueioInicial();
	}

	public void bloqueioInicial() {
		btNovo.setVisible(true);
		btSair.setVisible(true);
		btSalvar.setVisible(false);
		btCancelar.setVisible(false);
		tfCpf.setEditable(false);
		tfRg.setEditable(false);
		tfData.setEditable(false);
		tfNome.setEditable(false);
		tfCep.setEditable(false);
		tfBairro.setEditable(false);
		cbLougradouro.setEnabled(false);
		tfEndereco.setEditable(false);
		tfNumero.setEditable(false);
		tfComplemento.setEditable(false);
		cbCidade.setEnabled(false);
		cbEstado.setEnabled(false);
		rbMasculino.setEnabled(false);
		rbFeminino.setEnabled(false);
		tfTelefone.setEditable(false);
		tfCelular.setEditable(false);
		tfEmail.setEditable(false);

	}

	public void limparCampos() {
		tfNome.setText(null);
		tfCpf.setText(null);
		tfRg.setText(null);
		tfRg.setText(null);
		tfData.setText(null);
		tfEndereco.setText(null);
		tfNumero.setText(null);
		tfComplemento.setText(null);
		tfCep.setText(null);
		tfBairro.setText(null);
		grupoRadioSexo.clearSelection();
		tfTelefone.setText(null);
		tfCelular.setText(null);
		tfEmail.setText(null);
		cbLougradouro.setSelectedIndex(0);
		cbCidade.setSelectedIndex(0);
		cbEstado.setSelectedIndex(0);

	}

}
