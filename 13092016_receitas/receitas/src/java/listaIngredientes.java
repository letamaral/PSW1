import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class listaIngredientes extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Ingrediente> ingredientesDisponiveis = buscaIngredientes();
        request.setAttribute("ingredientesDisponiveis", ingredientesDisponiveis);
        request.getRequestDispatcher("selecaoIngredientes.jsp").forward(request,response);
        
        /*Ingrediente i;
        i = new Ingrediente();
        System.out.println(i.getCalorias());
        i.setCalorias(20);
        System.out.println(i.getCalorias());
        
         CONSTRUTOR
        Ingrediente i;
        i = new Ingrediente("Batata", 200);
        System.out.println(i.calorias);
            <<OU>>
        Ingrediente i;
        i = new Ingrediente();
        System.out.println(i.calorias); //Chama valor da classe
        i.calorias=20
        System.out.println(i.calorias);
        */
        
        }
        private List<Ingrediente> buscaIngredientes(){
            List<Ingrediente> result = new ArrayList<Ingrediente>();
            
            Ingrediente i1 = new Ingrediente();
            i1.setNome("Cenoura");
            i1.setCalorias(320);
            result.add(i1);
            
            Ingrediente i2 = new Ingrediente();
            i2.setNome("Açaí");
            i2.setCalorias(300);
            result.add(i2);
            
            Ingrediente i3 = new Ingrediente();
            i3.setNome("Beterraba");
            i3.setCalorias(530);
            result.add(i3);
            
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
