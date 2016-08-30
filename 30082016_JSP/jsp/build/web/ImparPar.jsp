<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body align="center">
        <h2><b>PAR OU ÍMPAR</b></h2>
        <%
            String choice = request.getParameter("opcao");
            int numero = Integer.parseInt(request.getParameter("numero"));
            int numServ = new Random().nextInt(10);
            int soma = numero + numServ;
            String result = "par";
            if ((soma % 2) != 0){
                result = "impar";
            }
            if (choice.equals(result)){
                out.println("<b>Você ganhou!</b><br>");
            } else {
                out.println("<b>Você perdeu!</b><br>");
            }
            out.println("Computador: " + numServ + "<br>");
            out.println("Usuário: " + numero + "<br>");
        %>
    </body>
</html>
