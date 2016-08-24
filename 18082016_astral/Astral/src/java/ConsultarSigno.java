import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ConsultarSigno extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String data = request.getParameter("dtnasc");
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = (Date)formatter.parse(data);
            String signo = "aries";
            if(date.getMonth() == 0){
                signo = "Aquario";
            } else if(date.getMonth() == 1){
                signo = "Peixes";
            } else if(date.getMonth() == 2){
                signo = "Áries";
            } else if(date.getMonth() == 3){
                signo = "Touro";
            } else if(date.getMonth() == 4){
                signo = "Gêmeos";
            } else if(date.getMonth() == 5){
                signo = "Câncer";
            } else if(date.getMonth() == 6){
                signo = "Leão";
            } else if(date.getMonth() == 7){
                signo = "Virgem";
            } else if(date.getMonth() == 8){
                signo = "Libra";
            } else if(date.getMonth() == 9){
                signo = "Escorpião";
            } else if(date.getMonth() == 10){
                signo = "Sagitário";
            } else if(date.getMonth() == 11){
                signo = "Capricórnio";
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta Signo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>PORTAL ASTRAL</h1>");
            out.println("<h2>Seu signo é: " + signo "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
        catch (Exception e){
            System.out.println("ERRO! " + e.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
