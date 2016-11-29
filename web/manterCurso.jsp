<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Curso</title>
    </head>
    <body>
        <h1>Manter Curso - ${operacao}</h1>

        <form action="ManterCursoController?acao=confirmar${operacao}" method="post" name="frmManterCurso" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código:</td> 
                    <td><input type="text" name="txtCodigo" value="${curso.codigo}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Nome do curso:</td> 
                        <td><input type="text" name="txtDescricao" value="${curso.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Carga Horária:</td> 
                        <td><input type="text" name="txtCargaHoraria" value="${curso.cargaHoraria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>      
                    <tr>
                        <td>Coordenador:</td>
                        <td>
                            <select name="optProfessor" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${curso.professor.nome == null}"> selected</c:if>> </option>  
                            <c:forEach items="${professores}" var="professor">
                                <option value="${professor.matricula}" <c:if test="${curso.professor.matricula == professor.matricula}"> selected</c:if>>${professor.nome}</option>  
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
                var p = document.getElementsByName("optProfessor")[0];
                mensagem = "";
                if (form.txtCodigo.value == "") {
                    mensagem = mensagem + "Codigo\n";
                }
                if (form.txtDescricao.value == "") {
                    mensagem = mensagem + "Informe o NOme do Curso\n";
                }
                if (!campoNumerico(form.txtCargaHoraria.value) || form.txtCargaHoraria.value == "") {
                    mensagem = mensagem + "Carga Horária deve ser numérico\n";
                }
                if (form.p == null) {
                    mensagem = mensagem + "Informe o Professor\n";
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
