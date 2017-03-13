<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
// declarando a página de erro
<%@ page isErrorPage = "true" %>
<html>
    <head>
        <title>Trata o erro</title>
    </head>
    <body>
        <h1>Trata o erro</h1>
        <% // utilizando o objeto implícito exception
            if (exception != null)
                out.write("Um erro ocorreu. Esta página é para " + "te informar o que ocorreu");
            else
                out.write("Você chegou nesta página, mas " + "nenhuma informação do erro está disponível");
        %>
    </body>
</html>
