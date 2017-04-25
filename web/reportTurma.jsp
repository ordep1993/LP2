<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <form action="RelatorioControllerTurma?acao=confirmar${operacao}" method="post" name="frmManterAluno" onsubmit="return validarFormulario(this)">
            <table id="tbManter">
                <tr>
                    <td>Código:</td> 
                    <td><input type="text" name="txtCodigo" value="${turma.codigo}" </td>
                </tr>
                 <tr>
                    <td>Ano:</td> 
                    <td><input type="text" name="txtAno" value="${turma.ano}" </td>
                </tr>
                    <tr>
                        <td ><input type="submit" name="btnConfirmar" value="Confirmar" class="btnConf"></td>
                    </tr>
             </table>
        </form>
    </body>
</html>
