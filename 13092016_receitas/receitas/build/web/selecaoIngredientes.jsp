<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">RECEITAS</h1>
        <h2 align="center">Ingredientes disponíveis: </h2>
        <c:forEach items="${requestScope.ingredientesDisponiveis}" var="ingr">
        <input type="checkbox" name="ingred" value="${ingr.nome}"> ${ingr.nome} (${ingr.calorias} calorias)<br>
        </c:forEach>
    </body>
</html>
