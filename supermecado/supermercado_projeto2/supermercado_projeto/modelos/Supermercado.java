package modelos;

import java.util.List;

public class Supermercado {
    private String nome;
    private String endereco;
    private List<Funcionario> funcionarios;

    public Supermercado(String nome, String endereco, List<Funcionario> funcionarios) {
        this.nome = nome;
        this.endereco = endereco;
        this.funcionarios = funcionarios;
    }

    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public List<Funcionario> getFuncionarios() { return funcionarios; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setFuncionarios(List<Funcionario> funcionarios) { this.funcionarios = funcionarios; }
}