package teste;

import controller.CidadeController;
import controller.EstadoController;
import model.Cidade;
import model.Estado;

public class TesteBuscarEstado {

	public static void main(String[] args) {
		for (Estado estado : new EstadoController().buscarTodos()) {
			System.out.println("Nome da cidade: " + estado.getNome());
			System.out.println("UF do estado: " + estado.getUf());

		}
	}

}
