package modelos;

import java.io.*;

public class FuncionarioBinarioOutputStream extends OutputStream {
    private DataOutputStream dataOut;

    public FuncionarioBinarioOutputStream(OutputStream out) {
        this.dataOut = new DataOutputStream(out);
    }

    public void enviarFuncionario(Funcionario f) throws IOException {
        dataOut.writeUTF(f.getNome());
        dataOut.writeUTF(f.getCpf());
        dataOut.writeDouble(f.getSalario());
    }

    @Override
    public void write(int b) throws IOException {
        dataOut.write(b);
    }

    @Override
    public void close() throws IOException {
        dataOut.close();
    }
}
