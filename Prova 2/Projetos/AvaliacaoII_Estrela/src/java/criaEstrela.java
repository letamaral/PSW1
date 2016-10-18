import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class criaEstrela extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            //Conecta com banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app", "app");
            //Envia para o banco
            java.sql.Statement envioBanco = con.createStatement();
            String nome = request.getParameter("Nome");
            String constelacao = request.getParameter("Constelacao");
            int distancia = Integer.parseInt(request.getParameter("Distancia"));
            String query = "INSERT INTO BANCOESTRELA VALUES ('" + nome + "', '" + constelacao + "', " + distancia + ")";
            System.out.println("query: " + query);
            int valores = envioBanco.executeUpdate(query);
            request.getRequestDispatcher("sucesso.jsp").forward(request, response);
            
        } catch (Exception ex) {
            ex.printStackTrace();
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