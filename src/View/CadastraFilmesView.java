package View;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import util.Util;

/**
 * Classe responsavel por armazenar os componentes da tela de cadastro da
 * secretaria
 * 
 * @author JPJBonfa
 * @since 08/06/2020
 */
public class CadastraFilmesView {
	private JFrame janela;
	private JPanel painelDaJanela;
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbValor;
	private JLabel lbDisponivel;
	private JLabel lbPromocao;
	private JLabel lbValorDaPromocao;
	private JLabel lbGenero;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfValor;
	private JTextField tfPromocao;
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

	public void iniciaGui() {

		// Criar Instancias
		janela = new JFrame();
		painelDaJanela = (JPanel) janela.getContentPane();
		lbCodigo = new JLabel();
		lbNome = new JLabel();
		lbValor = new JLabel();
		lbDisponivel = new JLabel();
		lbPromocao = new JLabel();
		lbValorDaPromocao = new JLabel();
		lbGenero = new JLabel();
		tfCodigo = new JTextField();
		tfNome = new JTextField();
		tfValor = new JTextField();
		tfPromocao = new JTextField();
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

		 // Configurações dos textos das Labels
		lbCodigo.setText("Codigo:");
		lbNome.setText("Nome:");
		lbValor.setText("Valor:");
		lbDisponivel.setText("Disponivel:");
		lbPromocao.setText("Promoção:");
		lbValorDaPromocao.setText("Valor da promoção:");
		lbGenero.setText("Gênero");

		// configurações das coordenadas dos componentes do codigo
		lbCodigo.setBounds(20, 20, 50, 20);
		tfCodigo.setBounds(140, 20, 420, 27);

		// configurações das coordenadas dos componentes do Nome
		lbNome.setBounds(20, 50, 50, 20);
		tfNome.setBounds(140, 50, 420, 27);

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
		
		//Configurações das coordenadas dos componentes de valor da promoçao
		lbValorDaPromocao.setBounds(20,180,110,20);
		tfPromocao.setBounds(140,180,420,27);
		
		//Configuraçoes dos componentes de genero
			lbGenero.setBounds(20,210,50,20);
			cbAcao.setText("Ação");
			cbAcao.setBounds(150,210,50,20);
			cbFiccao.setText("Ficção");
			cbFiccao.setBounds(213,210,70,20);
			cbTerror.setText("Terror");
			cbTerror.setBounds(282,210,70,20);
			cbComedia.setText("Comedia");
			cbComedia.setBounds(343,210,100,20);
			cbOutro.setText("Outro");
			cbOutro.setBounds(420,210,70,20);
		// Configuracões dos Botões
		btSalvar.setText("Salvar");
		btCancelar.setText("Cancelar");
		btSalvar.setBounds(150,280,130,35);
		btCancelar.setBounds(290,280,130,35);

		// Configurações do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(lbCodigo);
		painelDaJanela.add(tfCodigo);
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
		painelDaJanela.add(tfPromocao);
		painelDaJanela.add(lbGenero);
		painelDaJanela.add(cbAcao);
		painelDaJanela.add(cbFiccao);
		painelDaJanela.add(cbAcao);
		painelDaJanela.add(cbTerror);
		painelDaJanela.add(cbComedia);
		painelDaJanela.add(cbOutro);
		painelDaJanela.add(btSalvar);
		painelDaJanela.add(btCancelar);

		// Configurações da janela
		// janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setTitle("CADASTRO DE FILME");
		janela.setSize(600, 370);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public static void main(String[] args) {
		new Util().mudarAparencia();
		new CadastraFilmesView().iniciaGui();

	}

}
