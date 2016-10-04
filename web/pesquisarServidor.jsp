<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Servidores</title>
    </head>
    <body>
        <h1>Pesquisar Servidores</h1>
        <table border="1">
            <tr>
                <th>Matricula</th>
                <th> Nome</th>
                <th> Data Nasc</th>
                <th> CPF</th>
                <th> Data Expediçãoo</th>
                <th> Orgao Expedidor</th>
                <th> UF Expedição</th>
                <th> Email</th>
                <th> Telefone</th>
                <th> Celular</th>
                <th> Logradouro</th>
                <th> Número</th>
                <th> Complemento</th>
                <th> Bairro</th>
                <th> CEP</th>
                <th> Data Admissão</th>
            </tr>
            <c:forEach items="${servidores}" var="servidor">
                <tr>
                    <td> <c:out value="${servidor.matricula}" />
                    <td> <c:out value="${servidor.nome}" />
                    <td> <c:out value="${servidor.dataNasc}" />
                    <td> <c:out value="${servidor.cpf}" />
                    <td> <c:out value="${servidor.dataExpedicao}" />
                    <td> <c:out value="${servidor.orgaoExpedidor}" />
                    <td> <c:out value="${servidor.ufExpedicao}" />
                    <td> <c:out value="${servidor.email}" />
                    <td> <c:out value="${servidor.telefone}" />
                    <td> <c:out value="${servidor.celular}" />
                    <td> <c:out value="${servidor.logradouro}" />
                    <td> <c:out value="${servidor.numero}" />
                    <td> <c:out value="${servidor.complemento}" />
                    <td> <c:out value="${servidor.bairro}" />
                    <td> <c:out value="${servidor.cep}" />
                    <td> <c:out value="${servidor.dataAdmissao}" />
                    <td><a href="ManterServidorController?acao=prepararEditar&codigo=<c:out value="${servidor.matricula}"/>">Editar</a></td>
                    <td><a href="ManterServidorController?acao=prepararEditar&codigo=<c:out value="${servidor.matricula}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
         </table>
        <form action="ManterServidorController?acao=prepararIncluir" method="post">
            <input type="submit" name"btnIncluir" value="incluir">
        </form>
        </form>
    </body>
</html>
