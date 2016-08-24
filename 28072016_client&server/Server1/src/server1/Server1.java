package server1;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class Server1 {
    public static void main(String[] args) {

        //scanner sc = new scanner (system.in) //Ler do teclado
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); //Ler do teclado com buffer (cache)
        //BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //Socket (Entrada por uma porta/conexão)

        try{
            System.out.println("Aguardando conexão" + " na porta 5555");
            ServerSocket server = new ServerSocket(5555); // Prepara o servidor para receber conexoes na porta 1234
            Socket socket = server.accept(); //Interrompe a execução esperando um cliente
            System.out.println("CONEXÃO OK");
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //Prepara as classes para leitura dos dados 
            
            //String lido = inputReader.readLine(); //Le a informação enviada
            String lido = "";
            do{
                lido = inputReader.readLine();
                if(lido.indexOf("GET") == 0){
                    String comando = lido.substring(lido.indexOf("GET") + "GET".length());
                    comando = comando.substring(0,comando.indexOf("HTTP"));
                    comando = comando.trim();
                    System.out.println("Comando: " + comando);
                }
                System.out.println("Li: " + lido);
            } while(!lido.equals(""));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); //Prepara as classes para envio dos dados 
            if(comando.equals("/batata.html")){
                out.writeBytes("<h1>BATATA </h1>");
            }
            /*String resposta = "papel";
            if(lido.trim().equals("tesoura")){
                resposta = "pedra";
            }
            else if(lido.trim().equals("papel")){
                resposta = "tesoura";
            }*/
            //System.out.println("Escolhido: " + resposta);
            //DataOutputStream out = new DataOutputStream(socket.getOutputStream()); //Prepara as classes para envio dos dados 
            out.writeBytes("<h1>Olá mundo!</h1>" + '\n'); //envia a mensagem (msg deve ser String)
            //System.out.println("Enviado: " + resposta);
            out.close();
            /*switch(lido)
            {
                case 1:
                    System.out.println("Lido: " + "1");
                    break;
                case 2:
                    System.out.println("Lido: " + "2");
                    break;
                case 3:
                    System.out.println("Lido: " + "3");
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }*/

        }
        catch(Exception e){
            System.out.println("ERRO NA CONEXÃO");
        }
    }
}