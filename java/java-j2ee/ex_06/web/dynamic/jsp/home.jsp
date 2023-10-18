<%-- 
    Document   : home
    Created on : 09/11/2017, 16:56:23
    Author     : fabriciogmc
--%>

<%@page import="api.modelo.Papel"%>
<%@page import="api.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/estilos.css">
        <title>Aplicação Agenda Eletrônica</title>
    </head>
    <body>
        <% Usuario u = (Usuario)request.getAttribute("usuarioLogado"); %>
        <%@include file= "menu.jsp" %>      
        <div class="conteudo">
            <p>Olá usuário <%= u.getNome() %></p>
            <p>Seu e-mail cadastrado é: <%= u.getNome() %></p>
            <p>Sua senha cadastrada é: <%= u.getSenha() %> </p>
            <p>Você tem privilégios de: </p>
            <ul>
            <% for(Papel p: u.getPapeis() ){ %>
            <li><%= p.getDescricao().toString() %></li>
            <%} %>
            </ul>
        </div>
    </body>
</html>
