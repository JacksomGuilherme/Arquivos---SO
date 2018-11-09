package Controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController {

	@Override
	public void leDir(String dir) throws IOException {

		File diretorio = new File(dir);
		if (diretorio.exists() && diretorio.isDirectory()) {

			File[] lista = diretorio.listFiles();
			for (File file : lista) {

				if (file.isDirectory()) {
					System.out.println("[" + file.getName() + "]");
				}

			}
			for (File file : lista) {
				if (file.isFile()) {
					System.out.println(file.getName());
				}
			}
		}

	}

	@Override
	public void escreveArq(String dir, String arq) throws IOException {

		File diretorio = new File(dir);

		if (diretorio.exists() && diretorio.isDirectory()) {

			File arquivo = new File(dir, arq);
			boolean existe = false;

			if (arquivo.exists()) {
				existe = true;
			}
			StringBuffer buffer = new StringBuffer();
			String linha = JOptionPane.showInputDialog("Digite algo");
			while (!linha.equals("fim")) {
				buffer.append(linha);
				buffer.append("\r\n");
				linha = JOptionPane.showInputDialog("Digite algo");
			}
			FileWriter writer = new FileWriter(arquivo, existe);
			PrintWriter printer = new PrintWriter(writer);

			printer.write(buffer.toString());
			printer.flush();
			printer.close();
			writer.close();

		}

	}

	@Override
	public void LeArq(String dir, String arq) throws IOException {

		File diretorio = new File(dir);

		if (diretorio.exists() && diretorio.isDirectory()) {

			File arquivo = new File(dir, arq);

			if (arquivo.exists() && arquivo.isFile()) {

				FileInputStream fluxo = new FileInputStream(arquivo);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}

				buffer.close();
				leitor.close();
				fluxo.close();

			} else {
				throw new IOException("ARQUIVO INVALIDO BABACA");
			}

		}

	}

	@Override
	public void abreApp(String dir, String arq) throws IOException {

		File diretorio = new File(dir);
		if (diretorio.exists() && diretorio.isDirectory()) {
			File arquivo = new File(dir, arq);
			if (arquivo.exists() && arquivo.isFile()) {
				Desktop dskp = Desktop.getDesktop();
				dskp.open(arquivo);
			}
		}

	}

}
