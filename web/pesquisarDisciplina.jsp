<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Disciplina</title>
    </head>
    <body>
        <h1>Pesquisa de Disciplina</h1>
        <table border="1">
            <tr>
                <th>Código Disciplina</th>
                <th>Nome Disciplina</th>
                <th>Num Aulas</th>
                <th>Ementa</th>
                <th>Bibliografia</th>
                <th colspan="2">Ação</th>                         
            </tr>
            <c:forEach items="${disciplinas}" var="disciplina">
                <tr>
                    <td><c:out value="${disciplina.codigo}"/></td>
                    <td><c:out value="${disciplina.descricao}"/></td>
                    <td><c:out value="${disciplina.numAula}"/></td>
                    <td><c:out value="${disciplina.ementa}"/></td>
                    <td><c:out value="${disciplina.bibliografia}"/></td>
                    <td><a href="ManterDisciplinaController?acao=prepararEditar&codigo=<c:out value="${disciplina.codigo}"/>">Editar</a></td>
                    <td><a href="ManterDisciplinaController?acao=prepararExcluir&codigo=<c:out value="${disciplina.codigo}"/>">Excluir</a></td>          
                </tr>      
            </c:forEach>
        </table>
        <form action="ManterMatriculaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>

