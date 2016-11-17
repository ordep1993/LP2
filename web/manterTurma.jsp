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
            <!--
            
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
                if (form.txtCodCurso.value == "") {
                    mensagem = mensagem + "Informe o Código do Curso\n";
                }
                if (form.txtNomeCurso.value == "") {
                    mensagem = mensagem + "Informe o Nome do Curso\n";
                }
                if (form.txtTotalPeriodos.value == "") {
                    mensagem = mensagem + "Informe o Total de Períodos\n";
                }
                if (form.txtCargaHoraria.value == "") {
                    mensagem = mensagem + "Informe a Carga Horária\n";
                }
                if (!campoNumerico(form.txtCodCurso.value)) {
                    mensagem = mensagem + "Código do Curso deve ser numérico\n";
                }
                if (!campoNumerico(form.txtTotalPeriodos.value)) {
                    mensagem = mensagem + "Total de Períodos deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCargaHoraria.value)) {
                    mensagem = mensagem + "Carga Horária deve ser numérica\n";
                }
                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
            //-->
        </SCRIPT>        
    </body>
</html>
