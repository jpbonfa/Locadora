package teste;

import controller.ClienteController;
import model.Cliente;
import model.Data;
import model.Endereco;

public class TesteInserirCliente {

	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		Data data = new Data();

		cliente.setNome("Joao");
		endereco.setLougradouro("rua");
		endereco.setEndereco("Teodoro Quartim Barbosa");
		endereco.setNumero(248);
		endereco.setComplemento("ap153");
		endereco.setBairro("vila lageando");
		endereco.setCidade("São Paulo");
		endereco.setEstado("São Paulo");
		endereco.setCep("05351-015");
		cliente.setEndereco(endereco);
		cliente.setCpf("532.614.510-33");
		cliente.setRg("39.100.107-3");
		data.setDia(05);
		data.setMes(8);
		data.setAno(1993);
		cliente.setDataDeNascimento(data);
		cliente.setIdade(27);
		cliente.setSexo('M');
		cliente.setCelular("(11)98711-0380");
		cliente.setTelefone("(11)39266066");
		cliente.setEmail("jooaopedro@email.com");

		ClienteController controller = new ClienteController();
		controller.inserir(cliente);
	}

}
