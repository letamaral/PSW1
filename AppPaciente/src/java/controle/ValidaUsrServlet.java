/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ALIOMAR
 */
public class ValidaUsrServlet extends HttpServlet {

    Connection con;
    ServletConfig config;
    public void init (ServletConfig config) throws ServletException{
        this.config = config;
        conexao();
    }
    public void conexao (){
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String usr = config.getInitParameter("usuario");
        String senha = config.getInitParameter("senha");
        try {
            Class.forName(driver);
            System.out.println("Driver carregado com sucesso");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro no driver do banco de dados");
            return;
        }
        // estabelecer a conexão com o banco de dados
        try {
            con = DriverManager.getConnection(url, usr, senha);
            System.out.println("Banco de dados pronto");
        } catch (SQLException e) {
            System.out.println("Erro na conexão com Banco de dados");
        }
    }
    public boolean validaUsuario (String usr, String senha){
        boolean rcode = false;
        String comando = "SELECT COUNT(*) FROM USUARIO WHERE LOGIN='"+
                usr + "' AND SENHA='" + senha + "'";
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(comando);
            rs.next();
            if (rs.getInt(1) > 0){
                rcode = true;
            }
        } catch (SQLException sqle){
            System.out.println("Erro no comando " + sqle.getMessage());
        }
        return rcode;
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String usr = request.getParameter("tfUsuario");
        String senha = request.getParameter("tfSenha");
        HttpSession sessao = request.getSession();
        boolean rcode = validaUsuario (usr, senha);
        if (rcode){
            sessao.setAttribute("conexao", con);
            response.sendRedirect("TelaCadastroServlet");
            return;
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidaUsrServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form name='f1' action='index.html'>");
            out.println("<h2>Usuário/Senha Inválidos</h2>");
            out.println("<input type='submit' value='Tela Principal' />");
            out.println("</form></body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
