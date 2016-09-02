<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP</title>
    </head>
    <body align="center">
        <h2><b>PAR OU ÍMPAR</b></h2>
        <b>Você <%=request.getAttribute("rsp")%>!</b><br>
        Computador: <%=request.getAttribute("numUser")%>
        Usuário: <%=request.getAttribute("numCPU")%>
    </body>
</html>
