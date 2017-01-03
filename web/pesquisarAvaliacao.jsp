<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Avaliações</title>
        <link rel="stylesheet" type="text/css" href="Style/style.css">
    </head>
    <body>
        <div id="top">
            <h1>Sistema de Controle de Curso de Extensão</h1>
        </div>
        <div id="container">
            <h4>Pesquisa Avaliações</h4>
        <table id="tbPesqAvaliacao">
            <tr>
                <th class="title"> Codigo </th>
                <th class="title"> Avaliação 1</th> 
                <th class="title"> Avaliação 2</th>
                <th class="title"> Avaliação Final</th>
                <th class="title"> Aluno </th>
                <th class="title"> Disciplina </th>
                <th colspan="2" class="title">Ação</th>  
            </tr>
            <c:forEach items="${avaliacoes}" var="avaliacao">
                <tr>
                    <td> <c:out value="${avaliacao.codigo}" />
                    <td> <c:out value="${avaliacao.avaliacao1}" />
                    <td> <c:out value="${avaliacao.avaliacao2}" />
                    <td> <c:out value="${avaliacao.avaliacaoFinal}" />
                    <td> <c:out value="${avaliacao.aluno.nome}" />
                    <td> <c:out value="${avaliacao.disciplina.descricao}" />
                    <td><a href="ManterAvaliacaoController?acao=prepararEditar&codigo=<c:out value="${avaliacao.codigo}"/>">Editar</a></td>
                    <td><a href="ManterAvaliacaoController?acao=prepararExcluir&codigo=<c:out value="${avaliacao.codigo}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterAvaliacaoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="incluir">
        </form>
            <br><a href="index.jsp"><button>Inicio</button></a>
        </div>
    </body>
</html>
