import dominio.Estrela;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class listarEstrelas extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Estrela> estrela = buscarEstrela();
        request.setAttribute("estrela", estrela);
        request.getRequestDispatcher("Estrelas.jsp").forward(request, response);
    }
    private List<Estrela> buscarEstrela(){
        List<Estrela> result = new ArrayList<Estrela>();
        try {
            //Carrega o driver na memória
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // Conecta ao banco
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app", "app");
            Statement transacao = con.createStatement(); 
            String  query = "SELECT * FROM BANCOESTRELA";
            ResultSet resposta = transacao.executeQuery(query);
            while(resposta.next()){
                Estrela estrela = new Estrela();
                estrela.setNome(resposta.getString("NOME"));
                estrela.setConstelacao(resposta.getString("Constelacao"));
                estrela.setDistancia(resposta.getInt("Distancia"));
                result.add(estrela);
            }
        } catch (Exception ex) {
            Logger.getLogger(listarEstrelas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
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
