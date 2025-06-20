package modelos;

import java.io.*;

public class FuncionarioOutputStream extends OutputStream {
    private Funcionario[] funcionarios;
    private int quantidade;
    private OutputStream destino;

    public FuncionarioOutputStream(Funcionario[] funcionarios, int quantidade, OutputStream destino) {
        this.funcionarios = funcionarios;
        this.quantidade = quantidade;
        this.destino = destino;
    }

    @Override
    public void write(int b) throws IOException {
        destino.write(b);
    }

    public void enviarDados() throws IOException {
        for (int i = 0; i < quantidade; i++) {
            Funcionario f = funcionarios[i];
            String dados = String.format("Nome: %s | CPF: %s | Salário: %.2f\n",
                    f.getNome(), f.getCpf(), f.getSalario());

            byte[] bytes = dados.getBytes();
            destino.write(("Tamanho: " + bytes.length + " bytes\n").getBytes());
            destino.write(bytes);
        }
        destino.flush();
    }

    @Override
    public void close() throws IOException {
        destino.close();
    }
}
