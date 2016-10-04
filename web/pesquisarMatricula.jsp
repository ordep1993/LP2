<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Matricula</title>
    </head>
    <body>
        <h1>Pesquisa de Matricula</h1>
        <table border="1">
            <tr>
                <th>Código Matricula</th>
                <th>Nome Matricula</th>
                <th colspan="2">Ação</th>                         
            </tr>
            <c:forEach items="${matriculas}" var="curso">
                <tr>
                    <td><c:out value="${matricula.codigo}"/></td>
                    <td><c:out value="${matricula.curso}"/></td>
                    <td><c:out value="${matricula.disciplina}"/></td>
                    <td><c:out value="${matricula.turma}"/></td>
                    <td><c:out value="${matricula.aluno}"/></td>
                    <td><a href="ManterMatriculaController?acao=prepararEditar&codigo=<c:out value="${matricula.codigo}"/>">Editar</a></td>
                    <td><a href="ManterMatriculaController?acao=prepararExcluir&codigo=<c:out value="${matricula.codigo}"/>">Excluir</a></td>          
                </tr>      
            </c:forEach>
        </table>
        <form action="ManterMatriculaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>

