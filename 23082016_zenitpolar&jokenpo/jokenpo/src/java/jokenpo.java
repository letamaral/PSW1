import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class jokenpo extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String escolha = request.getParameter("escolha");
            String escolhapc = "pedra";
            //String escolhapc = (String)random.random(escolhapc);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>JOKENPO</title>");            
            out.println("</head>");
            out.println("<body align=\"center\">");
            out.println("<h2>JOGO JOKENPO</h2>");
            out.println("<b>Sua escolha: </b>" + escolha + "</br></br>");
            out.println("<b>Escolha do computador: </b>" + escolhapc + "</br></br>");
            out.println("<b>Resultado: </b>");
                if (escolha.trim().equals("papel") && escolhapc.trim().equals("papel")){ 
                out.println("Empate!"); 
                } else if (escolha.trim().equals("pedra") && escolhapc.trim().equals("pedra")){ 
                    out.println("Empate!"); 
                } else if (escolha.trim().equals("tesoura") && escolhapc.trim().equals("tesoura")){ 
                    out.println("Empate!"); 
                } else if (escolha.trim().equals("papel") && escolhapc.trim().equals("pedra")){ 
                    out.println("Você perdeu!<br>Pedra perde para Papel."); 
                } else if (escolha.trim().equals("papel") && escolhapc.trim().equals("tesoura")){ 
                    out.println("Você ganhou!<br>Tesoura perde para Pedra."); 
                } else if (escolha.trim().equals("pedra") && escolhapc.trim().equals("papel")){ 
                    out.println("Você ganhou!<br>Pedra perde para Papel."); 
                } else if (escolha.trim().equals("pedra") && escolhapc.trim().equals("tesoura")){ 
                    out.println("Você perdeu!<br>Papel perde para Tesoura."); 
                } else if (escolha.trim().equals("tesoura") && escolhapc.trim().equals("papel")){ 
                    out.println("Você perdeu!<br>Tesoura perde para Pedra."); 
                } else if (escolha.trim().equals("tesoura") && escolhapc.trim().equals("pedra")){ 
                    out.println("Você ganhou!<br>Papel perde para Tesoura."); 
                } else { 
                    out.println("Escolha entre Pedra, Papel ou Tesoura"); 
                }
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}