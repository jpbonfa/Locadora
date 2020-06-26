import util.Util;
import view.MenuPrincipalView;

public class Main {

	public static void main(String[] args) {
		Util.mudarAparencia();
		new MenuPrincipalView().iniciaGui();
	}

}
