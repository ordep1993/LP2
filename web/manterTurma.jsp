<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Turma</title>
    </head>
    <body>
        <h1>Manter Turma - ${operacao}</h1>

        <form action="ManterTurmaController?acao=confirmar${operacao}" method="post" name="frmManterTurma" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código da Turma:</td> 
                    <td><input type="text" name="txtCodigo" value="${turma.codigo}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
            </table>
        </form>              
    </body>
</html>
