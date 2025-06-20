package modelos;

public class Caixa extends Funcionario {
    private int numeroCaixa;

    public Caixa(String nome, String cpf, double salario, int numeroCaixa) {
        super(nome, cpf, salario);
        this.numeroCaixa = numeroCaixa;
    }

    public int getNumeroCaixa() { return numeroCaixa; }
    public void setNumeroCaixa(int numeroCaixa) { this.numeroCaixa = numeroCaixa; }
}