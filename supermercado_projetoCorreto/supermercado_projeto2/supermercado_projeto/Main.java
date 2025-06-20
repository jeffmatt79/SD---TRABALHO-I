import modelos.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("\n=== MENU SERIALIZAÇÃO DE FUNCIONÁRIOS ===");
            System.out.println("1. Ler funcionário de arquivo (formato texto)");
            System.out.println("2. Ler funcionário do teclado (formato texto)");
            System.out.println("3. Escrever funcionário em binário");
            System.out.println("4. Ler funcionários em binário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    lerDeArquivoTexto();
                    break;
                case 2:
                    lerDoTecladoTexto();
                    break;
                case 3:
                    escreverBinario();
                    break;
                case 4:
                    lerBinario();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    static void lerDeArquivoTexto() throws IOException {
        System.out.println("\n=== Lendo de arquivo 'caixas.txt' ===");
        try (FileInputStream fileIn = new FileInputStream("caixas.txt");
             FuncionarioInputStream leitor = new FuncionarioInputStream(fileIn)) {
            leitor.lerDados();
        }
    }

    static void lerDoTecladoTexto() throws IOException {
        System.out.println("\n=== Digite manualmente os dados ===");
        System.out.println("Exemplo: Tamanho: 40 bytes\\nNome: Ana | CPF: 123 | Salário: 2000.00");
        FuncionarioInputStream leitor = new FuncionarioInputStream(System.in);
        leitor.lerDados();
    }

    static void escreverBinario() throws IOException {
        Funcionario f = criarFuncionarioViaTeclado();
        try (FuncionarioBinarioOutputStream binOut = new FuncionarioBinarioOutputStream(
                new FileOutputStream("func.dat", true))) {  // append = true
            binOut.enviarFuncionario(f);
            System.out.println("Funcionário salvo em 'func.dat'");
        }
    }

    static void lerBinario() throws IOException {
        try (FuncionarioBinarioInputStream binIn = new FuncionarioBinarioInputStream(
                new FileInputStream("func.dat"))) {
            System.out.println("=== Funcionários lidos do binário ===");
            while (true) {
                Funcionario f = binIn.lerFuncionario();
                System.out.println(f);
            }
        } catch (EOFException e) {
            System.out.println("Fim do arquivo alcançado.");
        }
    }

    static Funcionario criarFuncionarioViaTeclado() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Salário: ");
        double salario = Double.parseDouble(sc.nextLine());

        return new Funcionario(nome, cpf, salario);
    }
}
