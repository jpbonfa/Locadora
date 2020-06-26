package teste;

import controller.ClienteController;
import controller.EstadoController;
import model.Cliente;
import model.Endereco;
import model.Estado;

public class TesteBuscarCliente {

	public static void main(String[] args) {

		for (Cliente cliente : new ClienteController().buscarTodos()) {
			System.out.println("Nome da cidade: " + cliente.getNome());
			if (cliente.getSexo() == 'M') {
				System.out.println("Sexo do cliente: Masculino");
			} else {
				System.out.println("Sexo do cliente: Feminino");
			}
			System.out.println("Idade do cliente: " + cliente.getIdade());
			System.out.println("Cidade do cliente: " + cliente.getEndereco().getCidade());
			System.out.println("Celular do cliente: " + cliente.getCelular());
			System.out.println("");
		
		}

	}

}
