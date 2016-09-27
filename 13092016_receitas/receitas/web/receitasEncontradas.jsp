<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RECEITAS</title>
    </head>
    <body>
        <body>
        <h1 align="center">RECEITAS</h1>
        <h2 align="center">Sugestões de receitas com base nos ingredientes selecionados: </h2>
        <c:forEach items="${requestScope.recei}" var="receita">
            ${receita.nome} <br/>
        </c:forEach>
    </body>
</html>
