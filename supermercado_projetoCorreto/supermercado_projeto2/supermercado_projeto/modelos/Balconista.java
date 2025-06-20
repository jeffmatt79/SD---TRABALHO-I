package modelos;

public class Balconista extends Funcionario {
    private String setor;

    public Balconista(String nome, String cpf, double salario, String setor) {
        super(nome, cpf, salario);
        this.setor = setor;
    }

    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }
}