import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ListarReceitas extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String[] ingredientes = request.getParameterValues("ingred");
        List<Receita> receitas = buscarReceitas(ingredientes);
        request.setAttribute("recei", receitas);
        request.getRequestDispatcher("receitasEncontradas.jsp").forward(request, response);
    }
    private List<Receita> buscarReceitas(String[] ings){
        List<Receita> receitas = new ArrayList<Receita>();
        Receita r1 = new Receita();
        r1.setNome("Torta de palmito");
        r1.setModoPreparo("Mistura tudo e vai fundo!");
        r1.setPessoas(5);
        //r1.setIngredientes(buscaIngredientes());
        List<Ingrediente> in = buscaIngredientes();
        r1.setIngredientes(in);
        receitas.add(r1);
        return receitas;
    }
    private List<Ingrediente> buscaIngredientes(){
        List<Ingrediente> resultado = new ArrayList<Ingrediente>();
        
        Ingrediente i1 = new Ingrediente();
        i1.setNome("Cenoura");
        i1.setCalorias(30);
        resultado.add(i1);
        
        Ingrediente i2 = new Ingrediente();
        i2.setNome("Catupiry");
        i2.setCalorias(300);
        resultado.add(i2);
        
        Ingrediente i3 = new Ingrediente();
        i3.setNome("Frango");
        i3.setCalorias(150);
        resultado.add(i3);
        
        return resultado;
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
