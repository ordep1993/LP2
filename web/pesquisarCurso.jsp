<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Cursos</title>
    </head>
    <body>
        <h1>Pesquisa de Cursos</h1>
        <table border="1">
            <tr>
                <th>Código do Curso</th>
                <th>Nome Cursos</th>
                <th>Carga Horária</th>
                <th>Código do Coordenador</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${cursos}" var="curso">
                <tr>
                    <td><c:out value="${curso.codigo}"/></td>
                    <td><c:out value="${curso.descricao}"/></td>
                    <td><c:out value="${curso.cargaHoraria}"/></td>
                    <td><c:out value="${curso.codigoCoordenador}"/></td>
                    <td><a href="ManterCursoController?acao=prepararEditar&codCurso="<c:out value="${curso.codigo}"/>">Editar</a></td>
                    <td><a href="ManterCursoController?acao=prepararExcluir&codCurso="<c:out value="${curso.codigo}"/>">Excluir</a></td>
                </tr> 
            </c:forEach>
        </table>
        <form action="ManterCursoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
