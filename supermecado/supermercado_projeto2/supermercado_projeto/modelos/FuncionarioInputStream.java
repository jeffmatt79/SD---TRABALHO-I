package modelos;

import java.io.*;

public class FuncionarioInputStream extends InputStream {
    private InputStream origem;
    private BufferedReader reader;

    public FuncionarioInputStream(InputStream origem) {
        this.origem = origem;
        this.reader = new BufferedReader(new InputStreamReader(origem));
    }

    @Override
    public int read() throws IOException {
        return origem.read(); 
    }

    public void lerDados() throws IOException {
        String linha;
        while ((linha = reader.readLine()) != null) {
            if (linha.startsWith("Tamanho:")) {
                System.out.println(linha); 
                String dados = reader.readLine(); 
                System.out.println("Dado lido: " + dados);
            }
        }
    }

    @Override
    public void close() throws IOException {
        origem.close();
    }
}

