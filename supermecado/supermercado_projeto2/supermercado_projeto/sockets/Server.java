package sockets;
import modelos.Funcionario;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Servidor aguardando conexão...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Cliente conectado.");

        ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());

        // requisição
        String comando = (String) ois.readObject();
        System.out.println("Comando recebido: " + comando);

        if ("PROCESSAR".equalsIgnoreCase(comando)) {
            
            Funcionario[] funcionarios = (Funcionario[]) ois.readObject();
            System.out.println("Servidor recebeu " + funcionarios.length + " funcionários.");

          
            for (Funcionario f : funcionarios) {
                double novoSalario = f.getSalario() * 1.1;
                System.out.println("Aumentando salário de " + f.getNome() + " para " + novoSalario);
            }

            // Envia reply 
            String reply = "Processamento concluído para " + funcionarios.length + " funcionários.";
            oos.writeObject(reply);
        } else {
        
            String reply = "Comando inválido. Nenhum processamento realizado.";
            oos.writeObject(reply);
        }

        oos.flush();
        ois.close();
        oos.close();
        clientSocket.close();
        serverSocket.close();
    }
}

