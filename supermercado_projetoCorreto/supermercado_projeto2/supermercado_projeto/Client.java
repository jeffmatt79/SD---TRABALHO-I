import java.io.*;
import java.net.*;
import modelos.Funcionario;
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 12345);

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
         oos.writeObject("PROCESSAR");
        // Criar array de funcionarios para enviar
        Funcionario[] funcionarios = {
            new Funcionario("Ana", "123.456.789-00", 3000.0),
            new Funcionario("Pedro", "987.654.321-00", 2500.0)
        };

        // requisição 
        oos.writeObject(funcionarios);
        oos.flush();

        // respota 
        String reply = (String) ois.readObject();
        System.out.println("Cliente recebeu do servidor: " + reply);

        ois.close();
        oos.close();
        socket.close();
    }
}

