import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MontaFormIncluirReceita extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Ingrediente> ingredientes;
        ingredientes = recuperarListaIngdoBD();
        request.setAttribute("ingredientes", ingredientes);
        request.getRequestDispatcher("incluirReceita.jsp").forward(request, response);
    }
    private List<Ingrediente> recuperarListaIngdoBD(){
        try {
            //Carrega o driver na memória
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // Conecta ao banco
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app", "app");
            java.sql.Statement comando = con.createStatement();    
            String query = "SELECT * FROM Receita";
            //Executa uma query
            ResultSet res = comando.executeQuery(query);
            while(res.next()){
                System.out.println("Preparo:" + res.getString("PREPARO"));    
            }
        } catch (Exception ex) {
            Logger.getLogger(MontaFormIncluirReceita.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Ingrediente>();
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
