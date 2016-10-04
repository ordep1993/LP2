
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Turmas</title>
    </head>
    <body>
        <h1>Pesquisar Turmas</h1>
        <table border="1">
            <tr>
                <th>Código Turma</th>
                <th> Ano</th>
                <th> Semestre</th>
                <th> MaxAluno</th>
            </tr>
            <c:forEach items="${turmas}" var="turma">
                <tr>
                    <td> <c:out value="${turma.codigo}" />
                    <td> <c:out value="${turma.ano}" />
                    <td> <c:out value="${turma.semestre}" />
                    <td> <c:out value="${turma.maxAlunos}" />
                    <td><a href="ManterTurmaController?acao=prepararEditar&codigo=<c:out value="${turma.codigo}"/>">Editar</a></td>
                    <td><a href="ManterTurmaController?acao=prepararEditar&codigo=<c:out value="${turma.codigo}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
         </table>
        <form action="ManterTurmaController?acao=prepararIncluir" method="post">
            <input type="submit" name"btnIncluir" value="incluir">
        </form>
        </form>
    </body>
</html>
