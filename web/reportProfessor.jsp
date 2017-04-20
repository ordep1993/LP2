<%-- 
    Document   : reportProfessor
    Created on : 20/04/2017, 08:31:45
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <div id="top">
            <h1>Sistema de Controle de Curso de Extensão</h1>
        </div>
        <div id="container">
            <h4>Manter Professor</h4>

        <form action="RelatorioProfessorController?acao=confirmar${operacao}" method="post" name="frmManterProfessor" onsubmit="return validarFormulario(this)">
            <table id="tbManter">
                <tr>
                    <td>Matricula:</td> 
                    <td><input type="text" name="txtMatricula" value="${professor.matricula}"</td>
                    </tr>
                    <tr>
                        <td>Nome:</td> 
                        <td><input type="text" name="txtNome" value="${professor.nome}"</td>
                    </tr>         
                     <tr>
                        <td ><input type="submit" name="btnConfirmar" value="Confirmar" class="btnConf"></td>
                    </tr>
            </table>
        </form>
    </body>
</html>
