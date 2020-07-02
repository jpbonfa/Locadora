package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

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
import model.Endereco;
import model.Estado;

public class AlterarClienteView {

	// declaração das variaveis
	private JFrame janela;
	private JPanel painelDaJanela;
	// labels
	private JLabel lbNome;
	private JLabel lblougradouro;
	private JLabel lbEndereco;
	private JLabel lbNumero;
	private JLabel lbComplemento;
	private JLabel lbBairro;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JLabel lbCep;
	private JLabel lbCpf;
	private JLabel lbRg;
	private JLabel lbDataNascimento;
	private JLabel lbSexo;
	private JLabel lbTelefone;
	private JLabel lbCelular;
	private JLabel lbEmail;
	// ComboBox
	private JComboBox cbClientes;
	private JComboBox cbLougradouro;
	private JComboBox cbCidade;
	private JComboBox cbEstado;
	// vetores
	public String lougradouros[] = { "- Selecione um lougradouro - ", "Rua", "Avenida", "Alameda" };
	public String cidade[] = {};
	public String estado[] = {};
	// Textfiled
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
	// radioButoon
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private ButtonGroup grupoRadioSexo;
	// Jbutton
	private JButton btAlterar;
	private JButton btCancelar;
	private JButton btOk;
	// maskformatter
	private MaskFormatter fmtCpf;
	private MaskFormatter fmtRg;
	private MaskFormatter fmtDataNascimento;
	private MaskFormatter fmtTelefone;
	private MaskFormatter fmtCelular;
	private MaskFormatter fmtCep;
	// arraylist
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	// objeto cliente
	private Cliente cliente = new Cliente();

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
		// labels
		lbNome = new JLabel();
		lbEndereco = new JLabel();
		lbCpf = new JLabel();
		lbRg = new JLabel();
		lbDataNascimento = new JLabel();
		lbSexo = new JLabel();
		lbEmail = new JLabel();
		lbTelefone = new JLabel();
		lbCelular = new JLabel();
		lblougradouro = new JLabel();
		lbNumero = new JLabel();
		lbComplemento = new JLabel();
		lbCidade = new JLabel();
		lbEstado = new JLabel();
		lbBairro = new JLabel();
		lbCep = new JLabel();
		// textfields
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
		tfCpf = new JFormattedTextField(fmtCpf);
		tfRg = new JFormattedTextField(fmtRg);
		tfData = new JFormattedTextField(fmtDataNascimento);
		// radioButton
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();
		// JButton
		btAlterar = new JButton();
		btCancelar = new JButton();
		btOk = new JButton();
		// comboBox
		cbClientes = new JComboBox();
		cbLougradouro = new JComboBox(lougradouros);
		cbCidade = new JComboBox();
		cbEstado = new JComboBox();

		// Adicionando os botões ao grupo
		grupoRadioSexo.add(rbMasculino);
		grupoRadioSexo.add(rbFeminino);

		// configurações dos componentes da comboBox de seleção
		cbClientes.setBounds(25, 30, 450, 25);

		// configurações dos componentes de nome
		lbNome.setText("Nome:");
		lbNome.setBounds(25, 60, 80, 25);
		tfNome.setBounds(70, 60, 300, 25);

		// configurações dos componentes de data de nascimento
		lbDataNascimento.setText("Nascimento:");
		lbDataNascimento.setBounds(375, 60, 80, 25);
		tfData.setBounds(450, 60, 110, 25);

		// configurações dos componentes de lougradouro
		lblougradouro.setText("Log:");
		lblougradouro.setBounds(25, 90, 80, 25);
		cbLougradouro.setBounds(70, 90, 80, 25);

		// configurações dos componentes de endereço
		lbEndereco.setText("Endereço:");
		lbEndereco.setBounds(160, 90, 80, 25);
		tfEndereco.setBounds(225, 90, 200, 25);

		// configurações dos componentes de numero
		lbNumero.setText("Nº:");
		lbNumero.setBounds(430, 90, 80, 25);
		tfNumero.setBounds(450, 90, 110, 25);

		// configurações dos componentes de complemento
		lbComplemento.setText("Compl:");
		lbComplemento.setBounds(25, 120, 80, 25);
		tfComplemento.setBounds(70, 120, 80, 25);

		// configurações dos componentes de Cidade
		lbCidade.setText("Cidade:");
		lbCidade.setBounds(160, 120, 80, 25);
		cbCidade.setBounds(225, 120, 170, 25);

		// configurações dos componentes de Estado
		lbEstado.setText("Estado:");
		lbEstado.setBounds(400, 120, 80, 25);
		cbEstado.setBounds(450, 120, 110, 25);

		// configurações dos componentes de bairro
		lbBairro.setText("Bairro:");
		lbBairro.setBounds(25, 150, 80, 25);
		tfBairro.setBounds(70, 150, 80, 25);

		// configurações dos componentes de cep
		lbCep.setText("CEP:");
		lbCep.setBounds(160, 150, 80, 25);
		tfCep.setBounds(225, 150, 170, 25);

		// configurações dos componentes de CPF
		lbCpf.setText("CPF:");
		lbCpf.setBounds(400, 150, 80, 25);
		tfCpf.setBounds(450, 150, 110, 25);

		// configurações dos componentes de rg
		lbRg.setText("RG:");
		lbRg.setBounds(25, 180, 80, 25);
		tfRg.setBounds(70, 180, 80, 25);

		// configurações dos componentes de sexo
		rbMasculino.setText("Masculino");
		rbFeminino.setText("Feminino");
		lbSexo.setBounds(160, 180, 80, 25);
		rbMasculino.setBounds(220, 180, 90, 25);
		rbFeminino.setBounds(320, 180, 80, 25);

		// configurações dos componentes de telefone
		lbTelefone.setText("Tel:");
		lbTelefone.setBounds(400, 180, 80, 25);
		tfTelefone.setBounds(450, 180, 110, 25);

		// configurações dos componentes de celular
		lbCelular.setText("Cel:");
		lbCelular.setBounds(25, 210, 80, 25);
		tfCelular.setBounds(70, 210, 95, 25);

		// configurações dos componentes de email
		lbEmail.setText("Email:");
		lbEmail.setBounds(25, 240, 80, 25);
		tfEmail.setBounds(70, 240, 450, 25);

		// configurações do botão alterar
		btAlterar.setText("Alterar");
		btAlterar.setBounds(180, 300, 90, 25);
		btAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alterar();
				limparCampos();
				bloqueioInicial();
			}
		});

		// configurações do botão cancelar
		btCancelar.setText("Cancelar");
		btCancelar.setBounds(280, 300, 90, 25);
		btCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(false);
			}
		});

		// configurações do botão OK
		btOk.setText("OK");
		btOk.setBounds(480, 30, 80, 25);
		btOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbClientes.getSelectedIndex() > 0) {
					ok();
					desbloqueioAlterar();
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente valido");
				}

			}
		});

		carregarCidade();
		carregarEstado();
		carregarCliente();
		bloqueioInicial();
		// Configurações do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(cbClientes);
		painelDaJanela.add(btOk);
		painelDaJanela.add(lbNome);
		painelDaJanela.add(tfNome);
		painelDaJanela.add(lbDataNascimento);
		painelDaJanela.add(tfData);
		painelDaJanela.add(lblougradouro);
		painelDaJanela.add(cbLougradouro);
		painelDaJanela.add(lbEndereco);
		painelDaJanela.add(tfEndereco);
		painelDaJanela.add(lbNumero);
		painelDaJanela.add(tfNumero);
		painelDaJanela.add(lbComplemento);
		painelDaJanela.add(tfComplemento);
		painelDaJanela.add(lbCidade);
		painelDaJanela.add(cbCidade);
		painelDaJanela.add(lbEstado);
		painelDaJanela.add(cbEstado);
		painelDaJanela.add(lbBairro);
		painelDaJanela.add(tfBairro);
		painelDaJanela.add(lbCep);
		painelDaJanela.add(tfCep);
		painelDaJanela.add(lbCpf);
		painelDaJanela.add(tfCpf);
		painelDaJanela.add(tfRg);
		painelDaJanela.add(lbRg);
		painelDaJanela.add(lbSexo);
		painelDaJanela.add(rbMasculino);
		painelDaJanela.add(rbFeminino);
		painelDaJanela.add(lbTelefone);
		painelDaJanela.add(tfTelefone);
		painelDaJanela.add(lbCelular);
		painelDaJanela.add(tfCelular);
		painelDaJanela.add(tfEmail);
		painelDaJanela.add(lbEmail);
		painelDaJanela.add(btAlterar);
		painelDaJanela.add(btCancelar);

		// Configurações da janela
		// janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("ALTERAR CLIENTES");
		janela.setSize(600, 400);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public void carregarCliente() {
		cbClientes.addItem("- Selecione um cliente -");
		for (Cliente cliente : new ClienteController().buscarTodos()) {
			cbClientes.addItem(cliente.getNome());
			listaClientes.add(cliente);
		}
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

	public void bloqueioInicial() {
		tfNome.setEditable(false);
		tfData.setEditable(false);
		cbLougradouro.setEnabled(false);
		tfEndereco.setEditable(false);
		tfNumero.setEditable(false);
		tfComplemento.setEditable(false);
		cbCidade.setEnabled(false);
		cbEstado.setEnabled(false);
		tfBairro.setEditable(false);
		tfCep.setEditable(false);
		rbMasculino.setEnabled(false);
		rbFeminino.setEnabled(false);
		tfRg.setEditable(false);
		tfCpf.setEditable(false);
		tfCelular.setEditable(false);
		tfTelefone.setEditable(false);
		tfEmail.setEditable(false);

	}

	public void ok() {
		cliente = listaClientes.get(cbClientes.getSelectedIndex() - 1);
		tfNome.setText(cliente.getNome());
		tfData.setText(cliente.getDataDeNascimento() + "");
		cbLougradouro.setSelectedItem(cliente.getEndereco().getLougradouro());
		tfEndereco.setText(cliente.getEndereco().getEndereco());
		tfNumero.setText(cliente.getEndereco().getNumero() + "");
		tfComplemento.setText(cliente.getEndereco().getComplemento());
		cbCidade.setSelectedItem(cliente.getEndereco().getCidade());
		cbEstado.setSelectedItem(cliente.getEndereco().getEstado());
		tfBairro.setText(cliente.getEndereco().getBairro());
		tfCep.setText(cliente.getEndereco().getCep());
		tfCpf.setText(cliente.getCpf());
		tfRg.setText(cliente.getRg());
		if (cliente.getSexo() == 'M') {
			rbMasculino.setSelected(true);
		} else {
			rbFeminino.setSelected(true);
		}
		tfTelefone.setText(cliente.getTelefone());
		tfCelular.setText(cliente.getCelular());
		tfEmail.setText(cliente.getEmail());

	}

	public void desbloqueioAlterar() {
		cbLougradouro.setEnabled(true);
		tfEndereco.setEditable(true);
		tfNumero.setEditable(true);
		tfComplemento.setEditable(true);
		cbCidade.setEnabled(true);
		cbEstado.setEnabled(true);
		tfBairro.setEditable(true);
		tfCep.setEditable(true);
		tfCelular.setEditable(true);
		tfTelefone.setEditable(true);
		tfEmail.setEditable(true);
	}

	public void alterar() {
		Endereco endereco = new Endereco();
		endereco.setLougradouro(cbLougradouro.getSelectedItem() + "");
		endereco.setEndereco(tfEndereco.getText());
		endereco.setNumero(Integer.parseInt(tfNumero.getText()));
		endereco.setComplemento(tfComplemento.getText());
		endereco.setCidade(cbCidade.getSelectedItem() + "");
		endereco.setEstado(cbEstado.getSelectedItem() + "");
		endereco.setBairro(tfBairro.getText());
		endereco.setCep(tfCep.getText());
		cliente.setEndereco(endereco);
		cliente.setTelefone(tfTelefone.getText());
		cliente.setCelular(tfCelular.getText());
		cliente.setEmail(tfEmail.getText());
		new ClienteController().alterar(cliente);

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
		cbClientes.setSelectedIndex(0);

	}
}
