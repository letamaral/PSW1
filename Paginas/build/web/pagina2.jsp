<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    // getAttribute () retorna um java.lang.Object, então é necessário fazer um cast.
    String objCompartilhado = (String) application.getAttribute ("mensagem");
%>
<html>
    <head>
        <title>O objeto application – página 2 </title>
    </head>
    <body>
        Essa página recupera a mensagem que foi armazenado pela <i>página1</i>.
        <p>
            A mensagem é <b> <%= objCompartilhado %> </b>
        </p>
    </body>
</html>
