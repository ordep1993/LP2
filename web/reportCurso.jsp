<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <form action="RelatorioControllerCurso?acao=confirmar${operacao}" method="post" name="frmManterAluno" onsubmit="return validarFormulario(this)">
            <table id="tbManter">
                <tr>
                    <td>Codigo:</td> 
                    <td><input type="text" name="txtMatricula" value="${curso.codigo}" </td>
                    </tr>
                    <tr>
                        <td>Nome:</td> 
                        <td><input type="text" name="txtNome" value="${codigo.nome}"></td>
                    <tr>
                        <td ><input type="submit" name="btnConfirmar" value="Confirmar" class="btnConf"></td>
                    </tr>
             </table>
        </form>
    </body>
</html>