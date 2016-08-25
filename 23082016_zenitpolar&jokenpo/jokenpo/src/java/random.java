
import static java.lang.System.out;

public class random {
    public static String random (String escolhapc){
        String escolhapc = Random();
            if (escolhapc.trim().equals("pedra")){
                escolhapc = "Pedra";
            } else if (escolhapc.trim().equals("papel")){
                escolhapc = "Papel";
            } else if (escolhapc.trim().equals("tesoura")){
                escolhapc = "Tesoura";
            } else {
                out.println("Escolha entre PEDRA, PAPEL e TESOURA.");
            }
    }
}