import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class IncluirIngrediente extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
 
        try {
            //Carrega o driver na memória
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // Conecta ao banco
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app", "app");
            // Cria a comando
            java.sql.Statement comando = con.createStatement(); 
            String nome = request.getParameter("nome");
            String calorias = request.getParameter("calorias");
            String query = "INSERT INTO INGREDIENTE VALUES ('" + nome + "', " + calorias + ")";
            int linhas = comando.executeUpdate(query);
            request.getRequestDispatcher("sucesso.jsp").forward(request, response);
            
        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
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
