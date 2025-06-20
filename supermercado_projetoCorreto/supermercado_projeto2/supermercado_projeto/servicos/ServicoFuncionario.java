package servicos;

import modelos.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class ServicoFuncionario {
    private List<Funcionario> listaFuncionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario f) {
        listaFuncionarios.add(f);
    }

    public List<Funcionario> listarFuncionarios() {
        return listaFuncionarios;
    }

    public Funcionario buscarPorCpf(String cpf) {
        for (Funcionario f : listaFuncionarios) {
            if (f.getCpf().equals(cpf)) {
                return f;
            }
        }
        return null;
    }
}