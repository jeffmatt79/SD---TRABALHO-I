package servicos;

import modelos.Funcionario;
import modelos.Supermercado;

public class ServicoSupermercado {
    private Supermercado supermercado;

    public ServicoSupermercado(Supermercado supermercado) {
        this.supermercado = supermercado;
    }

    public void adicionarFuncionario(Funcionario f) {
        supermercado.getFuncionarios().add(f);
    }

    public void exibirInformacoes() {
        System.out.println("Supermercado: " + supermercado.getNome());
        System.out.println("Endereço: " + supermercado.getEndereco());
        System.out.println("Funcionários:");
        for (Funcionario f : supermercado.getFuncionarios()) {
            System.out.println("- " + f.getClass().getSimpleName() + ": " + f.getNome());
        }
    }
}