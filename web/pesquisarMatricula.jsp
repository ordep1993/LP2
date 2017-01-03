<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Matricula</title>
        <link rel="stylesheet" type="text/css" href="Style/style.css">
    </head>
    <body>
       <div id="top">
            <h1>Sistema de Controle de Curso de Extensão</h1>
        </div>
        <div id="container">
            <h4>Pesquisa Matricula</h4>
        <table id="tbPesqAvaliacao">
            <tr>
                <th class="title">Matricula</th>
                <th class="title">Curso</th>
                <th class="title">Disciplina</th>
                <th class="title">Turma</th>
                <th class="title">Aluno</th>
                <th colspan="2" class="title">Ação</th>                         
            </tr>
            <c:forEach items="${matriculas}" var="matricula">
                <tr>
                    <td><c:out value="${matricula.codigo}"/></td>
                    <td><c:out value="${matricula.curso.descricao}"/></td>
                    <td><c:out value="${matricula.disciplina.descricao}"/></td>
                    <td><c:out value="${matricula.codigoTurma}"/></td>
                    <td><c:out value="${matricula.aluno.nome}"/></td>

                    <td><a href="ManterMatriculaController?acao=prepararEditar&codigo=<c:out value="${matricula.codigo}"/>">Editar</a></td>
                    <td><a href="ManterMatriculaController?acao=prepararExcluir&codigo=<c:out value="${matricula.codigo}"/>">Excluir</a></td>          
                </tr>      
            </c:forEach>
        </table>
        <form action="ManterMatriculaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        <br><a href="index.jsp"><button>Inicio</button></a>
        </div>
    </body>
</html>

