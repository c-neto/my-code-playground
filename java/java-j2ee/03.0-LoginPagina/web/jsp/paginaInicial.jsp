<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página inicial da agenda</title>
    </head>
    <body>
        Olá. Você digitou: 
        <%
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            String nomeUsuario = (String) request.getAttribute("nomeUsuario");
            String senha = (String) request.getAttribute("senha");
            out.print(nomeUsuario);
            out.print(senha);            
            for(int i=0; i<10; ++i){    
                out.print("<p> Funcionou!!! </p>");
            }
        %>
    </body>
</html>
