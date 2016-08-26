import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class jokenpo extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>JOKENPO</title>");            
            out.println("</head>");
            out.println("<body align=\"center\">");
            out.println("<h2>JOGO JOKENPO</h2>");
            
            String escolha = request.getParameter("choice");
            
            String[] choice = {"pedra", "papel", "tesoura"};
            int sorteio = new Random().nextInt(3);
            String escolhapc = choice[sorteio];
            
            out.println("<b>Sua escolha: </b>" + escolha + "</br></br>");
            out.println("<b>Escolha do computador: </b>" + escolhapc + "</br></br>");
            
            boolean userwin = false;
            out.println("<b>Resultado: </b>");
            
            if (escolha.equals("papel")){
                if(escolhapc.equals("papel")){
                    userwin = true;
                    out.println("Empate!"); 
                }}
            if (escolha.equals("pedra")){
                if (escolhapc.equals("pedra")){
                    userwin = true;
                    out.println("Empate!"); 
                }}
            if (escolha.equals("tesoura")){
                if (escolhapc.equals("tesoura")){
                    userwin = true;
                    out.println("Empate!"); 
                }}
            if (escolha.equals("papel")){
                if (escolhapc.equals("pedra")){
                    userwin = true;
                    out.println("Você perdeu!<br>Pedra perde para Papel."); 
                }}
            if (escolha.equals("papel")){
                if (escolhapc.equals("tesoura")){
                    userwin = true;
                    out.println("Você ganhou!<br>Tesoura perde para Pedra."); 
                }}
            if (escolha.equals("pedra")){
                if (escolhapc.equals("papel")){
                    userwin = true;
                    out.println("Você ganhou!<br>Pedra perde para Papel."); 
                }}
            if (escolha.equals("pedra")){
                if (escolhapc.equals("tesoura")){
                    userwin = true;
                    out.println("Você perdeu!<br>Papel perde para Tesoura."); 
                }}
            if (escolha.equals("tesoura")){
                if (escolhapc.equals("papel")){
                    userwin = true;
                    out.println("Você perdeu!<br>Tesoura perde para Pedra."); 
                }}
            if (escolha.equals("tesoura")){
                if (escolhapc.equals("pedra")){
                    userwin = true;
                    out.println("Você ganhou!<br>Papel perde para Tesoura."); 
                } else { 
                    out.println("Escolha entre Pedra, Papel ou Tesoura");
                }
            }
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
