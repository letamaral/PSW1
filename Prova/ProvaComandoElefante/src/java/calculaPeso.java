import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class calculaPeso extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Prova 1 - PSW1</title>");            
            out.println("</head>");
            out.println("<body align=\"center\">");
            out.println("<h1>Peso Elefante</h1>\n" + "<p><b>Qual é o peso de um elefante adulto? </b></p>");
            
            int valor = Integer.parseInt(request.getParameter("valor"));
            if (valor != 4500){
                int resultado = (valor - 4500);
                out.println("Seu palpite foi: " + valor + "<br>A diferença entre seu palpite e a resposta é de: " + resultado);
            } else {
                out.println("Seu palpite foi: " + valor + "<br>Você acertou!<br>Parabéns!");
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
