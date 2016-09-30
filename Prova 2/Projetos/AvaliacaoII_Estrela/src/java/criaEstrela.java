import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class criaEstrela extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //Conecta com banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app", "app");
            
            //Envia para o banco
            java.sql.Statement envioBanco = con.createStatement();
            
            String nome = request.getParameter("Nome");
            String constelacao = request.getParameter("Constelacao");
            String distancia = request.getParameter("Distancia_da_terra");
            
            String query = "INSERT INTO bancoEstrela values ('" + nome + "," + constelacao + "," + distancia + ")";
            
            int valores = envioBanco.executeUpdate(query);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Criar um novo Estrela</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Novo Estrela\n" + "<br/>\n" + "<img src=\"logo.jpg\">\n" + "<br/>");
            out.println("Nome: " + request.getParameter("Nome") + "<br/>");
            out.println("Constelacao: " + request.getParameter("Constelacao") + "<br/>");
            out.println("Distancia_da_terra: " + request.getParameter("Distancia_da_terra") + "<br/>");
            out.println("</body>");
            out.println("</html>");
            
            envioBanco.close();
            con.close();
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
