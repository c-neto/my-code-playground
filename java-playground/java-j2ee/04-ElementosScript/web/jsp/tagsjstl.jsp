<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exemplo de JSTL</title>
    </head>
    <body>
        <core:out value="Exemplificando iteração em variáveis: "></core:out>
        <br/>
        <core:forEach var="x" begin="1" end="10">
            <core:out value="X vale: ${x}"></core:out>
            <core:if test="${x > 6}">
                <core:out value=" -- X é maior do que 6"></core:out>
            </core:if>
            <core:choose>
                <core:when test="${x>8}">
                    <core:out value=" || X agora é maior do que 8"> </core:out>
                </core:when>
                <core:otherwise>
                    <core:out value=" ..."></core:out>
                </core:otherwise>
            </core:choose>
            <br/>
        </core:forEach>
        <core:set var="ingrs" value="${requestScope.ingredientes}"></core:set>
        
        <select>        
        <core:forEach var="itemReceita" items="${ingrs}">
            <option>${itemReceita} </option>
        </core:forEach>        
        </select>
        
    </body>
</html>
