<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Matricula</title>
    </head>
    <body>
        <h1>Manter Matricula - ${operacao}</h1>

        <form action="ManterMatriculaController?acao=confirmar${operacao}" method="post" name="frmManterMatricula" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código:</td> 
                    <td><input type="text" name="txtCodigo" value="${matricula.codigo}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Codigo do Curso:</td>
                        <td>
                            <select name="optCurso" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${matricula.curso.codigo == null}"> selected</c:if>> </option>  
                            <c:forEach items="${cursos}" var="curso">
                                <option value="${curso.codigo}" <c:if test="${matricula.curso.codigo == curso.codigo}"> selected</c:if>>${curso.descricao}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Codigo da Disciplina:</td>
                    <td>
                        <select name="optDisciplina" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${matricula.disciplina.codigo == null}"> selected</c:if>> </option>  
                            <c:forEach items="${disciplinas}" var="disciplina">
                                <option value="${disciplina.codigo}" <c:if test="${matricula.disciplina.codigo == disciplina.codigo}"> selected</c:if>>${disciplina.descricao}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Codigo da Turma:</td>
                    <td>
                        <select name="optTurma" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${matricula.turma.codigo == null}"> selected</c:if>> </option>  
                            <c:forEach items="${turmas}" var="turma">
                                <option value="${turma.codigo}" <c:if test="${matricula.turma.codigo == turma.codigo}"> selected</c:if>>${turma.codigo}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Codigo do Aluno:</td>
                    <td>
                        <select name="optAluno" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${matricula.aluno.matricula == null}"> selected</c:if>> </option>  
                            <c:forEach items="${alunos}" var="aluno">
                                <option value="${aluno.matricula}" <c:if test="${matricula.aluno.matricula == aluno.matricula}"> selected</c:if>>${aluno.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
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
