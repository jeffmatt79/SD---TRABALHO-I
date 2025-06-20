package modelos;

import java.io.*;

public class FuncionarioBinarioInputStream extends InputStream {
    private DataInputStream dataIn;

    public FuncionarioBinarioInputStream(InputStream in) {
        this.dataIn = new DataInputStream(in);
    }

    public Funcionario lerFuncionario() throws IOException {
        String nome = dataIn.readUTF();
        String cpf = dataIn.readUTF();
        double salario = dataIn.readDouble();
        return new Funcionario(nome, cpf, salario);
    }

    @Override
    public int read() throws IOException {
        return dataIn.read();
    }

    @Override
    public void close() throws IOException {
        dataIn.close();
    }
}
