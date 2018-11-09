package Controller;

import java.io.IOException;

public interface IArquivosController {

	public void leDir(String dir) throws IOException;

	public void escreveArq(String dir, String arq) throws IOException;

	public void LeArq(String dir, String arq) throws IOException;

	public void abreApp(String dir, String arq) throws IOException;

}
