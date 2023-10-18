<%-- 
    Criado por Fabricio G. M. de Carvalho
--%>
<%-- A linha seguinte é uma diretiva que especifica
 o tipo de conteúdo e a codificação do mesmo --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--
importação de dependências:
<%@page import="pacote.Classe" %>

inclusão estática de arquivo
<%@include file = "nome_arquivo.jsp" %>

utilização de biblioteca de tags 
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exemplificando Elementos JSP</title>
    </head>
    <body>
        <%! 
            public int a = 2;
            public int b = 3;
            public int soma(int a, int b){
                return a+b;
            }
        %>
        <%
            out.print("Exemplificando execução de funções: ");
            for( int x=0; x<3; ++x){
                a+= x; 
                b+= x; 
                out.println(soma(a,b)+"<br/>");         
            }            
        %>
        <%="Valor final de a e b: a = "+a+" b= "+b %>;
        
    </body>
</html>
