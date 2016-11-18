<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body{
            color: black;
            background-image: url("https://secure.static.tumblr.com/0e8660998f2e7db40dffa9c811a9f4c6/vim36bd/l2on1xozo/tumblr_static_black-panda-white-dots.jpg");
            text-align: center;
        }
        body img{
            
        }
    </style>
    <body>
        <h1>Portal do astral</h1>
        <p>
            <img src="http://academiaholistica.com.br/wp-content/uploads/2014/06/mapa-astral.jpg">
        </p>
        <h2>Previsao para seu signo</h2>
        <h1>${requestScope.signo}</h1>
        <p><%= request.getAttribute("previsao") %></p>
    </body>
</html>
