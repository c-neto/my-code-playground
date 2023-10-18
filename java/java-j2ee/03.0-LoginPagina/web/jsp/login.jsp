<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Aplicação Web Agenda Eletrônica</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css"  href="static/css/estilos.css"/>
    </head>
    <body>
        <form class="baseForm" method="post" action="Autenticar">
            Nome de Usuário:
            <input class="formInput formTextInput" id=nomeUsuario type="text" name="nomeUsuario"> 
            Senha:
            <input class="formInput formTextInput" id=senha type="password" name="senha">
            <input class="formInput submitButton" type="submit" value="Autenticar">       
        </form>
        <% 
            if ( request.getAttribute("falhaAutenticacao")!=null )
                out.print("<p class=\"warning\"> Usuário ou senha inválidos.</p>"); 
        %>  
        
        <%-- <c:forEach var="x" begin="1" end="3">
            <c:out value="${x}"> a </c:out>
        </c:forEach> --%>
    </body>
</html>
