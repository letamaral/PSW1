<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Objeto session</title>
    </head>
    <body>
        <h1>Objeto sessão</h1>
        <br>Algumas propriedades da sessão
        <br>A sessão foi criada em <%=session.getCreationTime()%>
        <br>O tempo de inatividade de <%=session.getMaxInactiveInterval() %>
        <br>O id da sessão é <%=session.getId() %>
    </body>
</html>
