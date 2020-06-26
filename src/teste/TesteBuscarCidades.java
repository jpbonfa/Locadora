package teste;

import controller.CidadeController;
import model.Cidade;

public class TesteBuscarCidades {

	public static void main(String[] args) {
		for (Cidade cidade : new CidadeController().buscarTodos()) {
			System.out.println("Nome da cidade: " + cidade.getNome());

		}
	}

}
