import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParImpar extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>JSP</title>");            
            out.println("</head>");
            out.println("<body align=\"center\">");
            out.println("<p><b>PAR OU ÍMPAR</b></p>");
            
            String choice = request.getParameter("opcao");
            int numero = Integer.parseInt(request.getParameter("numero"));
            int numServ = new Random().nextInt(10);
            int soma = numero + numServ;
            String result = "par";
            if ((soma % 2) != 0){
                result = "impar";
            }
            if (choice.equals(result)){
                out.println("<b>Você ganhou!</b><br>");
            } else {
                out.println("<b>Você perdeu!</b><br>");
            }
            out.println("Computador: " + numServ + "<br>");
            out.println("Usuário: " + numero + "<br>");
            
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
