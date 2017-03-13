<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page errorPage = "trataErro.jsp" %>
<%
    // verifica se o campo escondido está visível, se sim erro
    String escondido = request.getParameter("valorCampo");
    if ((escondido != null) && !(escondido.equals("")))
        throw new java.lang.NullPointerException();
%>
<html>
    <head>
        <title>Gera o erro</title>
    </head>
    <body>
        <h1>Gera o erro</h1>
        Essa página gera uma erro quando o botão é pressionado
        <form action="geraErro.jsp" method="POST">
            <input type="hidden" name="valorCampo" value="Bang!">
            <input type="submit" value="Gera exceção">
        </form>
    </body>
</html>
