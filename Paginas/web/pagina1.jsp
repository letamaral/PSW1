<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String objCompartilhado = "JSP é legal";
    application.setAttribute ("mensagem", objCompartilhado);
%>
<html>
    <head>
        <title>O objeto application – página 1 </title>
    </head>
    <body>
        Essa página cria um dado que pode ser recuperado por outra página nessa aplicação. <p>
        Pressione <a href="pagina2.jsp"> aqui</a> para ver o valor armazenado.
    </body>
</html>
