<%-- 
    Document   : login
    Created on : 09/11/2017, 16:55:42
    Author     : fabriciogmc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    String contexto = request.getContextPath();
    if (!contexto.equals(""))
        contexto = contexto + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${contexto}static/css/estilos.css">
        <title>Aplicação Agenda Eletrônica</title>
    </head>
    <body>
        <form class="baseForm" action="Autenticador.action" method="post">
            <label class="formLabel">
                Nome de Usuário:
                <input name="nomeUsuario" type="text" required class="formInput formTextInput">
            </label>
            <label class="formLabel">
                Senha:
                <input name="senha" type="password" required class="formInput formTextInput">
           </label>
                <input type="submit" value="Entrar" class="submitButton">                
        </form>       
    </body>
</html>
