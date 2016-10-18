<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar um novo Estrela</title>
    </head>
    <body>
        <h1>Estrelas:</h1><br>
       <c:forEach items="${requestScope.estrela}" var="estrela">
            Nome: ${estrela.nome} <br>
            Constelação: ${estrela.constelacao} <br>
            Distancia: ${estrela.distancia} <br>
        </c:forEach>
    </body>
</html>
