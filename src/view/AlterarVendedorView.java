package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.CidadeController;
import controller.ClienteController;
import controller.EstadoController;
import controller.VendedorController;
import model.Cidade;
import model.Cliente;
import model.Estado;
import model.Vendedor;

public class AlterarVendedorView {
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
	private JComboBox cbVendedor;
	private String estado[] = {};
	private String cidade[] = {};
	private String vendedor[] = {};
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JButton btAltera;
	private JButton btCancelar;
	private JButton btOk;
	private ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();
	// objeto vendedor
	private Vendedor vendedores = new Vendedor();

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
		tfIdade = new JTextField();
		tfSalario = new JTextField();
		cbCidade = new JComboBox(cidade);
		cbEstado = new JComboBox(estado);
		cbVendedor = new JComboBox(vendedor);
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();
		btAltera = new JButton();
		btCancelar = new JButton();
		btOk = new JButton();

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

		// configurações dos componentes da comboBox de seleção
		cbVendedor.setBounds(25, 20, 450, 25);

		// configurações das coordenadas dos componentes do nome
		lbNome.setBounds(20, 50, 50, 20);
		tfNome.setBounds(140, 50, 420, 27);

		// configurações das coordenadas dos componentes da Area de venda
		lbArea.setBounds(20, 80, 90, 20);
		tfArea.setBounds(140, 80, 420, 27);

		// configurações das coordenadas dos componentes do Cidade
		lbCidade.setBounds(20, 110, 50, 20);
		cbCidade.setBounds(140, 110, 420, 27);

		// configurações das coordenadas dos componentes do Estado
		lbEstado.setBounds(20, 140, 50, 20);
		cbEstado.setBounds(140, 140, 320, 27);

		// configurações das coordenadas dos componentes de Sexo
		lbSexo.setBounds(20, 170, 50, 20);
		rbMasculino.setText("Masculino");
		rbMasculino.setBounds(140, 170, 120, 27);
		rbFeminino.setText("Feminino");
		rbFeminino.setBounds(250, 170, 120, 27);

		// configurações das coordenadas dos componentes da Idade
		lbIdade.setBounds(20, 200, 50, 20);
		tfIdade.setBounds(140, 200, 420, 27);

		// configurações das coordenadas dos componentes do Estado
		lbSalario.setBounds(20, 230, 50, 20);
		tfSalario.setBounds(140, 230, 420, 27);

		// Configuracões dos Botões

		btOk.setText("OK");
		btOk.setBounds(480, 20, 80, 25);
		btOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbVendedor.getSelectedIndex() > 0) {
					ok();
					desbloqueioAlterar();
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um vendedor valido");
				}

			}
		});
		btAltera.setText("Alterar");
		btAltera.setBounds(150, 280, 130, 35);
		btAltera.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alterar();
				limparCampos();
				bloqueioInicial();
			}
		});
		btCancelar.setText("Cancelar");
		btCancelar.setBounds(290, 280, 130, 35);
		btCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(false);
			}
		});
		carregarCidade();
		carregarEstado();
		carregarVendedor();
		bloqueioInicial();
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
		painelDaJanela.add(btOk);
		painelDaJanela.add(btCancelar);
		painelDaJanela.add(btAltera);
		painelDaJanela.add(cbVendedor);

		// Configurações da janela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("AlTERAR  VENDEDORES");
		janela.setSize(600, 370);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

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

	public void carregarVendedor() {

		cbVendedor.addItem("- Selecione um vendedor -");
		for (Vendedor vendedor : new VendedorController().buscarTodos()) {
			cbVendedor.addItem(vendedor.getNome());
			listaVendedores.add(vendedor);
		}

	}

	public void bloqueioInicial() {

		tfNome.setEditable(false);
		tfArea.setEditable(false);
		cbCidade.setEnabled(false);
		cbEstado.setEnabled(false);
		rbFeminino.setEnabled(false);
		rbMasculino.setEnabled(false);
		tfIdade.setEditable(false);
		tfSalario.setEditable(false);

	}

	public void desbloqueioAlterar() {
		tfArea.setEditable(true);
		cbCidade.setEnabled(true);
		cbEstado.setEnabled(true);
		tfSalario.setEditable(true);

	}

	public void limparCampos() {
		tfNome.setText(null);
		tfArea.setText(null);
		cbCidade.setSelectedIndex(0);
		cbEstado.setSelectedIndex(0);
		grupoRadioSexo.clearSelection();
		tfIdade.setText(null);
		tfSalario.setText(null);
		cbVendedor.setSelectedIndex(0);

	}

	public void ok() {
		vendedores = listaVendedores.get(cbVendedor.getSelectedIndex() - 1);
		tfNome.setText(vendedores.getNome());
		tfArea.setText(vendedores.getAreaVenda());
		cbCidade.setSelectedItem(vendedores.getCidade());
		cbEstado.setSelectedItem(vendedores.getEstado());
		if (vendedores.getSexo() == 'M') {
			rbMasculino.setSelected(true);
		} else {
			rbFeminino.setSelected(true);
		}
		tfIdade.setText(vendedores.getIdade() + "");
		tfSalario.setText(vendedores.getSalario() + "");
	}

	public void alterar() {
		vendedores.setAreaVenda(tfArea.getText());
		vendedores.setCidade(cbCidade.getSelectedItem() + "");
		vendedores.setEstado(cbEstado.getSelectedItem() + "");
		vendedores.setSalario(Integer.parseInt(tfSalario.getText()));
		new VendedorController().alterar(vendedores);

	}
}
