<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Professor</title>
    </head>
    <body>
        <h1>Pesquisa Professor</h1>
        <table border="1">
            <tr>
                <th>Matricula</th>
                <th>Nome</th>
                <th>Data de Nascimento</th>
                <th>CPF</th>
                <th>Data de Expedicao</th>
                <th>Orgão Expedidor</th>
                <th>UF Expedicao</th>
                <th>Email</th>
                <th>Telefone</th>
                <th>Celular</th>
                <th>Logradouro</th>
                <th>Numero</th>
                <th>Complemento</th>
                <th>Bairro</th>
                <th>Cep</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${professores}" var="professor">
                <tr>
                    <td><c:out value="${professor.matricula}"/></td>
                    <td><c:out value="${professor.nome}"/></td>
                    <td><c:out value="${professor.dataNasc}"/></td>
                    <td><c:out value="${professor.cpf}"/></td>
                    <td><c:out value="${professor.dataExpedicao}"/></td>
                    <td><c:out value="${professor.orgaoExpedidor}"/></td>
                    <td><c:out value="${professor.ufExpedicao}"/></td>
                    <td><c:out value="${professor.email}"/></td>
                    <td><c:out value="${professor.telefone}"/></td>
                    <td><c:out value="${professor.celular}"/></td>
                    <td><c:out value="${professor.logradouro}"/></td>
                    <td><c:out value="${professor.numero}"/></td>
                    <td><c:out value="${professor.complemento}"/></td>
                    <td><c:out value="${professor.bairro}"/></td>
                    <td><c:out value="${professor.cep}"/></td>
                    <td><a href="ManterProfessorController?acao=prepararEditar&codCurso="<c:out value="${professor.matricula}"/>">Editar</a></td>
                    <td><a href="ManterProfessorController?acao=prepararExcluir&codCurso="<c:out value="${professor.matricula}"/>">Excluir</a></td>
                </tr> 
            </c:forEach>
        </table>
        <form action="ManterProfessorController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
