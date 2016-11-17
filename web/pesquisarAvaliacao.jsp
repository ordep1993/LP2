<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Avaliações</title>
    </head>
    <body>
        <h1>Pesquisar Avaliações</h1>
        <table border="1">
            <tr>
                <th> Codigo </th>
                <th> Avaliação 1</th> 
                <th> Avaliação 2</th>
                <th> Avaliação Final</th>
                <th colspan="2">Ação</th>  
            </tr>
            <c:forEach items="${avaliacoes}" var="avaliacao">
                <tr>
                    <td> <c:out value="${avaliacao.codigo}" />
                    <td> <c:out value="${avaliacao.avaliacao1}" />
                    <td> <c:out value="${avaliacao.avaliacao2}" />
                    <td> <c:out value="${avaliacao.avaliacaoFinal}" />
                    <td><a href="ManterAvaliacaoController?acao=prepararEditar&codigo=<c:out value="${avaliacao.codigo}"/>">Editar</a></td>
                    <td><a href="ManterAvaliacaoController?acao=prepararExcluir&codigo=<c:out value="${avaliacao.codigo}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
         </table>
        <form action="ManterAvaliacaoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="incluir">
        </form>
        <br><a href="index.jsp"><button>Inicio</button></a>
    </body>
</html>
