package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPrincipalView {

	// declaraçao de variaveis
	private JFrame janela;
	private JMenuBar barraMenu;
	private JMenu menuCadastro;
	private JMenu menuConsulta;
	private JMenu menuExcluir;
	private JMenu menuAlterar;
	private JMenu menuSair;
	private JMenuItem itemMenuCadastrarCliente;
	private JMenuItem itemMenuCadastrarVendedor;
	private JMenuItem itemMenuCadastrarFilme;
	private JMenuItem itemMenuCadastrarLocacao;
	private JMenuItem itemMenuConsultaCliente;
	private JMenuItem itemMenuConsultaVendedor;
	private JMenuItem itemMenuConsultaFilme;
	private JMenuItem itemMenuSair;
	private JMenuItem itemMenuExcluirCliente;
	private JMenuItem itemMenuExcluirFilme;
	private JMenuItem itemMenuExcluirVendedor;
	private JMenuItem itemMenuAlterarCliente;
	private JMenuItem itemMenuAlterarFilme;
	private JMenuItem itemMenuAlterarVendedor;

	public void iniciaGui() {

		// Criação das instancias
		janela = new JFrame();
		barraMenu = new JMenuBar();
		menuCadastro = new JMenu();
		menuConsulta = new JMenu();
		menuExcluir = new JMenu();
		menuAlterar = new JMenu();
		itemMenuCadastrarCliente = new JMenuItem();
		itemMenuCadastrarVendedor = new JMenuItem();
		itemMenuCadastrarFilme = new JMenuItem();
		itemMenuCadastrarLocacao = new JMenuItem();
		itemMenuConsultaCliente = new JMenuItem();
		itemMenuConsultaVendedor = new JMenuItem();
		itemMenuConsultaFilme = new JMenuItem();
		itemMenuAlterarCliente = new JMenuItem();
		itemMenuAlterarFilme = new JMenuItem();
		itemMenuAlterarVendedor = new JMenuItem();
		itemMenuExcluirCliente = new JMenuItem();
		itemMenuExcluirFilme = new JMenuItem();
		itemMenuExcluirVendedor = new JMenuItem();

		itemMenuSair = new JMenuItem();
		menuSair = new JMenu();

		menuCadastro.setText("Cadastro");
		menuConsulta.setText("Consulta");
		menuAlterar.setText("Alterar");
		menuExcluir.setText("Excluir");
		menuSair.setText("Sair");

		// Adicionando os rotulos aos intens de menu
		itemMenuCadastrarCliente.setText("Cliente");
		itemMenuCadastrarVendedor.setText("Vendedor");
		itemMenuCadastrarFilme.setText("Filme");
		itemMenuCadastrarLocacao.setText("Locação");
		itemMenuConsultaCliente.setText("Cliente");
		itemMenuConsultaVendedor.setText("Vendedor");
		itemMenuConsultaFilme.setText("Filme");
		itemMenuAlterarCliente.setText("Cliente");
		itemMenuAlterarVendedor.setText("Vendedor");
		itemMenuAlterarFilme.setText("Filme");
		itemMenuExcluirCliente.setText("Cliente");
		itemMenuExcluirVendedor.setText("Vendedor");
		itemMenuExcluirFilme.setText("Filme");
		itemMenuSair.setText("Sair");

		// Adicionando os menus a barra de menu
		barraMenu.add(menuCadastro);
		barraMenu.add(menuConsulta);
		barraMenu.add(menuAlterar);
		barraMenu.add(menuExcluir);
		barraMenu.add(menuSair);

		// Adicionando os itens de menu no menuCadastro
		menuCadastro.add(itemMenuCadastrarCliente);
		menuCadastro.add(itemMenuCadastrarVendedor);
		menuCadastro.add(itemMenuCadastrarFilme);
		menuCadastro.add(itemMenuCadastrarLocacao);

		// adicionando os itens de menu no menuConsulta
		menuConsulta.add(itemMenuConsultaCliente);
		menuConsulta.add(itemMenuConsultaVendedor);
		menuConsulta.add(itemMenuConsultaFilme);

		// adicionando os itens de menu no menuAlterar
		menuAlterar.add(itemMenuAlterarCliente);
		menuAlterar.add(itemMenuAlterarVendedor);
		menuAlterar.add(itemMenuAlterarFilme);

		// adicionando os itens de menu no menuExcluir
		menuExcluir.add(itemMenuExcluirCliente);
		menuExcluir.add(itemMenuExcluirVendedor);
		menuExcluir.add(itemMenuExcluirFilme);

		// adicionando os itens de menu no menuSair
		menuSair.add(itemMenuSair);

		// Configurando as ações dos itens de menu
		itemMenuCadastrarCliente.addActionListener(new ActionListener() {

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
		itemMenuCadastrarVendedor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CadastrarVendedorView().iniciaGui();
			}
		});
		itemMenuCadastrarFilme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CadastrarFilmeView().iniciaGui();
			}
		});
		itemMenuCadastrarLocacao.addActionListener(new ActionListener() {

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
		itemMenuConsultaCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ConsultaClienteView().iniciaGui();
			}
		});

		itemMenuSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		itemMenuExcluirCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				new ExcluirClienteView().iniciaGui();
			}
		});
		itemMenuExcluirCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				new ExcluirClienteView().iniciaGui();
			}
		});
		itemMenuExcluirFilme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				new ExcluirFilmeView().iniciaGui();
			}
		});
		itemMenuExcluirVendedor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				new ExcluirVendedorView().iniciaGui();
			}
		});
		itemMenuAlterarVendedor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				new AlterarVendedorView().iniciaGui();
			}
		});
		itemMenuAlterarFilme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				new AlterarFilmeView().iniciaGui();
			}
		});
		itemMenuAlterarCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					new AlterarClienteView().iniciaGui();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		// Configuraçoes da janela
		janela.setJMenuBar(barraMenu);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setTitle("EXEMPLO DE MENU");
		janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

}
