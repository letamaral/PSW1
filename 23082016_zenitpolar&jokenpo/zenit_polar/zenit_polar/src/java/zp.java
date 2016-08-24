
import java.util.HashMap;
import java.util.Map;

public class zp {
   public static String converter(String texto) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("z", "p");
        map.put("e", "o");
        map.put("n", "l");
        map.put("i", "a");
        map.put("t", "r");
        map.put("p", "z");
        map.put("o", "e");
        map.put("l", "n");
        map.put("a", "i");
        map.put("r", "t");
        
        String letras[] = texto.split("");
        String textoConvertido = "";
        
        for (String letra : letras) {
            String code = map.get(letra);
            if (code != null)
                textoConvertido = textoConvertido + code;
            else
                textoConvertido = textoConvertido + letra;
        }
        return textoConvertido;
    } 
}

