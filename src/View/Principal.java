package View;

import java.io.IOException;

import Controller.ArquivosController;
import Controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {

		IArquivosController ac = new ArquivosController();
		//
		// String dir = "C:\\Users\\Laboratorios\\Desktop";
		// String arq = "";
		//
		// try {
		// ac.leDir(dir);
		// ac.escreveArq(dir, arq);
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		String dir = "C:\\TEMP";
		String arq = "newFile.txt";

		try {
			// ac.escreveArq(dir, arq);
			// ac.LeArq(dir, arq);
			ac.abreApp(dir, arq);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

}
