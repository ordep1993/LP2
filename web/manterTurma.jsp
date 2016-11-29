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
                    <tr>
                        <td>Ano:</td> 
                        <td><input type="text" name="txtAno" value="${turma.ano}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Semestre:</td> 
                        <td><input type="text" name="txtSemestre" value="${turma.semestre}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Máximo de Alunos:</td> 
                        <td><input type="text" name="txtMaxAlunos" value="${turma.maxAlunos}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>              
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
        <br><a href="index.jsp"><button>Inicio</button></a>
        <SCRIPT language="JavaScript">
            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++)
                {
                    umCaracter = valor.charAt(i);
                    if (caracteresValidos.indexOf(umCaracter) == -1)
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) {
                var mensagem;
                mensagem = "";
                if (!campoNumerico(form.txtCodigo.value) || form.txtCodigo.value == "") {
                    mensagem = mensagem + "Código da Turma deve ser numérico\n";
                }
                if (!campoNumerico(form.txtAno.value) || form.txtAno.value == "") {
                    mensagem = mensagem + "Ano deve ser numrico\n";
                }
                if (!campoNumerico(form.txtSemestre.value) || form.txtSemestre.value == "") {
                    mensagem = mensagem + "Semestre deve ser numérico\n";
                }
                if (!campoNumerico(form.txtMaxAlunos.value) || form.txtMaxAlunos.value == "") {
                    mensagem = mensagem + "Máximo de Alunos deve ser numérico\n";
                }
                 if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }  
            }
           
        </SCRIPT>        
    </body>
</html>
