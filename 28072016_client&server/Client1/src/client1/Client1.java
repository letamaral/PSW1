package client1;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class Client1 {
    public static void main(String[] args) {
        try{
            
	    System.out.println("Escolha pedra, papel ou tesoura");
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); //Prepara para ler do teclado
            String sentence = inFromUser.readLine(); //Le do teclado
            System.out.println("Conectando" + " na porta 5555");
            Socket clientSocket = new Socket("localhost", 5555); // Conecta-se ao servidor remoto na porta indicada
            System.out.println("CONEXÃO OK");
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream()); //Prepara as classes para envio dos dados 
            out.writeBytes(sentence + '\n'); //envia a mensagem (msg deve ser String)
            //out.close(); //Para outro servidor
	    BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //Prepara as classes para leitura dos dados
            String lido = inputReader.readLine(); //Le a informação enviada
            System.out.println("O Servidor jogou: " + lido);
        }
        catch(Exception e){
            System.out.println("ERRO NA CONEXÃO");
        }
    }
    
}