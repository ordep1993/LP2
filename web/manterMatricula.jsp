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
                        <td>Curso:</td>
                        <td>
                            <select name="optCurso" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${matricula.curso.descricao == null}"> selected</c:if>> </option>  
                            <c:forEach items="${cursos}" var="curso">
                                <option value="${curso.codigo}" <c:if test="${matricula.curso.codigo == curso.codigo}"> selected</c:if>>${curso.descricao}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Disciplina:</td>
                    <td>
                        <select name="optDisciplina" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${matricula.disciplina.descricao == null}"> selected</c:if>> </option>  
                            <c:forEach items="${disciplinas}" var="disciplina">
                                <option value="${disciplina.codigo}" <c:if test="${matricula.disciplina.codigo == disciplina.codigo}"> selected</c:if>>${disciplina.descricao}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Turma:</td>
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
                    <td>Aluno:</td>
                    <td>
                        <select name="optAluno" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${matricula.aluno.nome == null}"> selected</c:if>> </option>  
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
                var c = document.getElementsByName("optCurso")[0];
                var d = document.getElementsByName("optDisciplina")[0];
                var t = document.getElementsByName("optTurma")[0];
                var a = document.getElementsByName("optAluno")[0];
                mensagem = "";
               
                if (!campoNumerico(form.txtCodigo.value)|| form.txtCodigo.value == "") {
                    mensagem = mensagem + "Código da Matrícula deve ser numérico\n";
                }
                if (form.c == null) {
                    mensagem = mensagem + "Informe um Curso\n";
                }
                if (form.d == null) {
                    mensagem = mensagem + "Informe a Disciplina\n";
                }
                if (form.t == null) {
                    mensagem = mensagem + "Informe a Turma\n";
                }
                if (form.a == null) {
                    mensagem = mensagem + "Informe o Aluno\n";
                }
                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
           
        </SCRIPT>        
    </body>
</html>
