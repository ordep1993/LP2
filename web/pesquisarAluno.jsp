<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Alunos</title>
    </head>
    <body>
        <h1>Pesquisa de Alunos</h1>
        <table border="1">
            <tr>
                <th>Código Aluno</th>
                <th>Nome Aluno</th>
                <th colspan="2">Ação</th>                         
            </tr>
            <c:forEach items="${alunos}" var="aluno">
                <tr>
                    <td><c:out value="${aluno.matricula}"/></td>
                    <td><c:out value="${aluno.nome}"/></td>
                    <td><c:out value="${aluno.dataNasc}"/></td>
                    <td><c:out value="${aluno.cpf}"/></td>
                    <td><c:out value="${aluno.dataExpedicao}"/></td>
                    <td><c:out value="${aluno.email}"/></td>
                    <td><c:out value="${aluno.telefone}"/></td>
                    <td><c:out value="${aluno.celular}"/></td>
                    <td><c:out value="${aluno.logradouro}"/></td>
                    <td><c:out value="${aluno.numero}"/></td>
                    <td><c:out value="${aluno.complemento}"/></td>
                    <td><c:out value="${aluno.bairro}"/></td>
                    <td><c:out value="${aluno.cep}"/></td>
                    <td><c:out value="${aluno.anoInicio}"/></td>
                    <td><c:out value="${aluno.semestreInicio}"/></td>
                    <td><c:out value="${aluno.estadoAluno}"/></td>
                    <td><a href="ManterAlunoController?acao=prepararEditar&matricula=<c:out value="${aluno.matricula}"/>">Editar</a></td>
                    <td><a href="ManterAlunoController?acao=prepararExcluir&matricula=<c:out value="${aluno.matricula}"/>">Excluir</a></td>          
                </tr>      
            </c:forEach>
        </table>
        <form action="ManterAlunoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>



