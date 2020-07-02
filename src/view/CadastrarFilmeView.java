package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.FilmeController;
import controller.VendedorController;
import model.Filme;
import util.Mensagem;

/**
 * Classe responsavel por armazenar os componentes da tela de cadastro da
 * secretaria
 * 
 * @author JPJBonfa
 * @since 08/06/2020
 */
public class CadastrarFilmeView {

	private JFrame janela;
	private JPanel painelDaJanela;
	private JLabel lbNome;
	private JLabel lbValor;
	private JLabel lbDisponivel;
	private JLabel lbPromocao;
	private JLabel lbValorDaPromocao;
	private JLabel lbGenero;
	private JTextField tfNome;
	private JTextField tfValor;
	private JTextField tfValorPromocao;
	private JRadioButton rbDisponivelSim;
	private JRadioButton rbDisponivelNao;
	private JRadioButton rbPromocaoSim;
	private JRadioButton rbPromocaoNao;
	private JCheckBox cbAcao;
	private JCheckBox cbFiccao;
	private JCheckBox cbTerror;
	private JCheckBox cbComedia;
	private JCheckBox cbOutro;
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	private ButtonGroup grupoRadioDisponivel;
	private ButtonGroup grupoRadioPromocao;

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
		btSalvar = new JButton();
		btCancelar = new JButton();
		btNovo = new JButton();
		btSair = new JButton();

		// Cria o objeto dos grupos de botões
		grupoRadioDisponivel = new ButtonGroup();
		grupoRadioPromocao = new ButtonGroup();

		// Adicionando os botões ao grupo
		grupoRadioDisponivel.add(rbDisponivelSim);
		grupoRadioDisponivel.add(rbDisponivelNao);
		grupoRadioPromocao.add(rbPromocaoSim);
		grupoRadioPromocao.add(rbPromocaoNao);

		// Configurações dos textos das Labels
		lbNome.setText("Nome:");
		lbValor.setText("Valor:");
		lbDisponivel.setText("Disponivel:");
		lbPromocao.setText("Promoção:");
		lbValorDaPromocao.setText("Valor da promoção:");
		lbGenero.setText("Gênero");

		// configurações das coordenadas dos componentes do Nome
		lbNome.setBounds(20, 40, 50, 20);
		tfNome.setBounds(140, 40, 420, 27);

		// configurações das coordenadas dos componentes do Valor
		lbValor.setBounds(20, 80, 50, 20);
		tfValor.setBounds(140, 80, 420, 27);

		// configurações dos componentes do Disponibilidade
		rbDisponivelNao.setText("Não");
		rbDisponivelSim.setText("Sim");
		lbDisponivel.setBounds(20, 120, 70, 20);
		rbDisponivelSim.setBounds(150, 120, 50, 20);
		rbDisponivelNao.setBounds(250, 120, 50, 20);

		// configurações dos componentes da PromoçÃO
		rbPromocaoSim.setText("Sim");
		rbPromocaoNao.setText("Não");
		lbPromocao.setBounds(20, 150, 70, 20);
		rbPromocaoSim.setBounds(150, 150, 50, 20);
		rbPromocaoNao.setBounds(250, 150, 50, 20);

		// Configurações das coordenadas dos componentes de valor da promoçao
		lbValorDaPromocao.setBounds(20, 180, 110, 20);
		tfValorPromocao.setBounds(140, 180, 420, 27);

		// Configuraçoes dos componentes de genero
		lbGenero.setBounds(20, 220, 50, 20);
		cbAcao.setText("Ação");
		cbAcao.setBounds(150, 220, 50, 20);
		cbFiccao.setText("Ficção");
		cbFiccao.setBounds(213, 220, 70, 20);
		cbTerror.setText("Terror");
		cbTerror.setBounds(282, 220, 70, 20);
		cbComedia.setText("Comedia");
		cbComedia.setBounds(343, 220, 100, 20);
		cbOutro.setText("Outro");
		cbOutro.setBounds(420, 220, 70, 20);

		// Configuracões dos Botões
		btSalvar.setText("Salvar");
		btCancelar.setText("Cancelar");
		btNovo.setText("Novo");
		btSair.setText("Sair");
		btSalvar.setBounds(150, 280, 130, 25);
		btNovo.setBounds(150, 280, 130, 25);
		btCancelar.setBounds(290, 280, 130, 25);
		btSair.setBounds(290, 280, 130, 25);

		// Configurações das ações dos botões
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

		// Configurações do painel da janela
		painelDaJanela.setLayout(null);
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
		painelDaJanela.add(btSalvar);
		painelDaJanela.add(btCancelar);
		painelDaJanela.add(btNovo);
		painelDaJanela.add(btSair);

		// Configurações da janela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("CADASTRO DE FILME");
		janela.setSize(600, 370);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		bloqueioInicial();
	}

	public void salvar() {
		Filme filme = new Filme();

		if (validarDados()) {
			filme.setNome(tfNome.getText());
			filme.setValor(Double.parseDouble(tfValor.getText()));
			filme.setValorDaPromocao(Double.parseDouble(tfValorPromocao.getText()));

			if (rbDisponivelSim.isSelected()) {
				filme.setDisponivel(true);
			}

			if (rbDisponivelNao.isSelected()) {
				filme.setDisponivel(false);
			}
			if (rbPromocaoSim.isSelected()) {
				filme.setDisponivel(true);
			}
			if (rbPromocaoNao.isSelected()) {
				filme.setDisponivel(false);
			}

			if (cbAcao.isSelected()) {
				filme.setGenero(cbAcao.getText());

			}
			if (cbFiccao.isSelected()) {
				filme.setGenero(cbFiccao.getText());

			}
			if (cbTerror.isSelected()) {
				filme.setGenero(cbTerror.getText());

			}
			if (cbComedia.isSelected()) {
				filme.setGenero(cbComedia.getText());

			}
			if (cbOutro.isSelected()) {
				filme.setGenero(cbOutro.getText());

			}

			new FilmeController().inserir(filme);

			limparCampos();
			bloqueioInicial();
		}

	}

	public boolean validarDados() {
		int cont = 0;

		if (tfNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Mensagem.informeNome, Mensagem.erro, 0);
			return false;
		}
		if (tfValor.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Mensagem.informeValor, Mensagem.erro, 0);
			return false;
		}

		if (!rbDisponivelSim.isSelected()) {// inicio do if
			if (!rbDisponivelNao.isSelected()) {// inicio do if
				JOptionPane.showMessageDialog(null, Mensagem.informeDisponibilidade, Mensagem.erro, 0);
				return false;
			} // fim do if

		}
		if (!rbPromocaoSim.isSelected()) {// inicio do if
			if (!rbPromocaoNao.isSelected()) {// inicio do if
				JOptionPane.showMessageDialog(null, Mensagem.informePromocao, Mensagem.erro, 0);

				return false;
			} // fim do if
		}

		if (tfValorPromocao.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Mensagem.informeValorPromocao, Mensagem.erro, 0);
			return false;
		}
		if (cbAcao.isSelected()) {
			cont = 1;
		}
		if (cbComedia.isSelected()) {
			cont = 1;
		}
		if (cbFiccao.isSelected()) {
			cont = 1;
		}
		if (cbTerror.isSelected()) {
			cont = 1;
		}
		if (cbOutro.isSelected()) {
			cont = 1;
		}
		if (cont == 0) {
			JOptionPane.showMessageDialog(null, Mensagem.selecioneGenero, Mensagem.erro, 0);
			return false;
		}
		return true;
	}

	public void novo() {
		btNovo.setVisible(false);
		btSair.setVisible(false);
		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		tfNome.setEditable(true);
		tfValor.setEditable(true);
		rbDisponivelNao.setEnabled(true);
		rbDisponivelSim.setEnabled(true);
		rbPromocaoNao.setEnabled(true);
		rbPromocaoSim.setEnabled(true);
		tfValor.setEditable(true);
		cbAcao.setEnabled(true);
		cbComedia.setEnabled(true);
		cbFiccao.setEnabled(true);
		cbTerror.setEnabled(true);
		cbOutro.setEnabled(true);
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
		tfNome.setEditable(false);
		tfValor.setEditable(false);
		rbDisponivelNao.setEnabled(false);
		rbDisponivelSim.setEnabled(false);
		rbPromocaoNao.setEnabled(false);
		rbPromocaoSim.setEnabled(false);
		cbAcao.setEnabled(false);
		cbComedia.setEnabled(false);
		cbFiccao.setEnabled(false);
		cbTerror.setEnabled(false);
		cbOutro.setEnabled(false);

	}

	public void limparCampos() {
		tfNome.setText(null);
		tfValor.setText(null);
		grupoRadioDisponivel.clearSelection();
		grupoRadioPromocao.clearSelection();
		tfValorPromocao.setText(null);
		cbAcao.setSelected(false);
		cbComedia.setSelected(false);
		cbFiccao.setSelected(false);
		cbTerror.setSelected(false);
		cbOutro.setSelected(false);

	}
}
