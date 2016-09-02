import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ServJSPParImpar extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String choice = request.getParameter("opcao");
        int numero = Integer.parseInt(request.getParameter("numero"));
        int numServ = new Random().nextInt(10);
        int soma = numero + numServ;
        String result = "par";
        if ((soma % 2) != 0){
            result = "impar";
        }
        
        String resposta = "<b>perdeu</b>";
        if (choice.equals(result)){
            resposta = "<b>ganhou</b>";
        }
        request.setAttribute("rsp", resposta);
        request.setAttribute("numUser", numero);
        request.setAttribute("numCPU", numServ);
        //setAttribute - cria e exibe chave e valor
        //getAttribute - cria chave e exibe valor
        //forward - envia informações
        //include - envia informações e recebe a resposta
        request.getRequestDispatcher("ServJSPImparPar.jsp").forward(request, response);
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
