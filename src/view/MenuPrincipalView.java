package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class MenuPrincipalView {

	// declaraçao de variaveis
	private JFrame janela;
	private JMenuBar barraMenu;
	private JMenu menuCadastro;
	private JMenu menuConsulta;
	private JMenu menuSair;
	private JMenuItem itemMenuCliente;
	private JMenuItem itemMenuVendedor;
	private JMenuItem itemMenuFilme;
	private JMenuItem itemMenuLocacao;
	private JMenuItem itemMenuConsultaCliente;
	private JMenuItem itemMenuConsultaVendedor;
	private JMenuItem itemMenuConsultaFilme;
	private JMenuItem itemMenuConsultaLocacao;
	private JMenuItem itemMenuSair;
	private JMenuItem itemMenu10;
	private JMenuItem itemMenu11;

	public void iniciaGui() {

		// Criação das instancias
		janela = new JFrame();
		barraMenu = new JMenuBar();
		menuCadastro = new JMenu();
		menuConsulta = new JMenu();
		itemMenuCliente = new JMenuItem();
		itemMenuVendedor = new JMenuItem();
		itemMenuFilme = new JMenuItem();
		itemMenuLocacao = new JMenuItem();
		itemMenuConsultaCliente = new JMenuItem();
		itemMenuConsultaVendedor = new JMenuItem();
		itemMenuConsultaFilme = new JMenuItem();
		itemMenuConsultaLocacao = new JMenuItem();
		itemMenuSair = new JMenuItem();
		menuSair = new JMenu();

		menuCadastro.setText("Cadastro");
		menuConsulta.setText("Consulta");
		menuSair.setText("Sair");

		// Adicionando os rotulos aos intens de menu
		itemMenuCliente.setText("Cliente");
		itemMenuVendedor.setText("Vendedor");
		itemMenuFilme.setText("Filme");
		itemMenuLocacao.setText("Locação");
		itemMenuConsultaCliente.setText("Cliente");
		itemMenuConsultaVendedor.setText("Vendedor");
		itemMenuConsultaFilme.setText("Filme");
		itemMenuSair.setText("Sair");

		// Adicionando os menus a barra de menu
		barraMenu.add(menuCadastro);
		barraMenu.add(menuConsulta);
		barraMenu.add(menuSair);

		// Adicionando os itens de menu no menuCadastro
		menuCadastro.add(itemMenuCliente);
		menuCadastro.add(itemMenuVendedor);
		menuCadastro.add(itemMenuFilme);
		menuCadastro.add(itemMenuLocacao);

		// adicionando os itens de menu no menuConsulta
		menuConsulta.add(itemMenuConsultaCliente);
		menuConsulta.add(itemMenuConsultaVendedor);
		menuConsulta.add(itemMenuConsultaFilme);

		// adicionando os itens de menu no menuSair
		menuSair.add(itemMenuSair);

		// Configurando as ações dos itens de menu
		itemMenuCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new CadastrarClienteView().iniciaGui();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		itemMenuVendedor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CadastrarVendedorView().iniciaGui();
			}
		});
		itemMenuFilme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CadastrarFilmeView().iniciaGui();
			}
		});
		itemMenuLocacao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CadastrarLocacaoView().iniciaGui();
			}
		});

		itemMenuConsultaVendedor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ConsultarVendedorView().iniciaGui();
			}
		});
		itemMenuConsultaFilme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ConsultaFilmeView().iniciaGui();
			}
		});

		itemMenuSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		// Configuraçoes da janela
		janela.setJMenuBar(barraMenu);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setTitle("Exemplo de menu");
		janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

}
