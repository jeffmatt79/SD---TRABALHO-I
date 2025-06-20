package modelos;

import java.io.Serializable;

public class Funcionario implements Serializable {  
    private static final long serialVersionUID = 1L;

    private String nome;
    private String cpf;
    private double salario;

    public Funcionario(String nome, String cpf, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public double getSalario() { return salario; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setSalario(double salario) { this.salario = salario; }
    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                '}';
    }
}

