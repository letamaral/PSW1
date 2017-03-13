<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page session="false"%>
<%@ page import="java.sql.*"%>
<%
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        System.out.println("Driver do derby carregado");
    } catch (ClassNotFoundException e) {
        System.out.println("Erro ao carregar o driver " + e.toString());
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Página de Login</title>
        <style>
            #msgNok{
            color: #FF0000;
            font-size: 12px;
            }
            #msgOk{
            color: #00FF00;
            font-size: 12px;
            }
        </style>
        <script>
            function exibeMsgNok() {
                var objMsg = document.getElementById("msgNok");
                objMsg.innerHTML = "Usuário/Senha inválidos";
            }
            function exibeMsgOk() {
                var objMsg = document.getElementById("msgOk");
                objMsg.innerHTML = "Usuário/Senha válidos";
            }
        </script>
    </head>
    <body><center>
        <form name="f1" ACTION="senha.jsp" METHOD="POST">
            <h2>Teste de login</h2> <br>
            <table>
                <tr>
                    <td>Usuário: </td>
                    <td>
                        <input TYPE="TEXT" NAME="usuario">
                    </td>
                </tr>
                <tr>
                    <td>Senha: </td>
                    <td>
                        <input TYPE="PASSWORD" NAME="senha">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input TYPE="RESET" VALUE="Limpa">
                    </td>
                    <td>
                        <input TYPE="SUBMIT" VALUE="Login">
                    </td>
                </tr>
            </table>
        <div id="msgNok"></div>
        <div id="msgOk"></div>
        <%
        try {
            Connection con = DriverManager.getConnection ("jdbc:derby://localhost:1527/clinica","adm", "123");
            System.out.println("Conexão com sucesso...");
            Statement st = con.createStatement();
            String usr = request.getParameter("usuario");
            String pas = request.getParameter("senha");
            if (usr != null && pas != null) {
                String sql = "SELECT COUNT(*) FROM USUARIO" + " WHERE LOGIN = '" + usr + "' AND SENHA='" + pas + "'";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int qtd = rs.getInt(1);
            if (qtd == 0) {
                %><script>exibeMsgNok();</script><%
            } else {
                %><script>exibeMsgOk();</script><%
            }
                rs.close();
            }
        st.close();
        con.close();
        } catch (SQLException e) {
            System.out.println("Erro na conexão com o banco...");
        }
        %>
        </form></center>
    </body>
</html>