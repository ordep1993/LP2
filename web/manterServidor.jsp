<%-- 
    Document   : manterServidor
    Created on : 13/09/2016, 09:56:45
    Author     : Daniel
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Servidor</title>
    </head>
    <body>
        <h1>Manter Servidor - ${operacao}</h1>

        <form action="ManterServidorController?acao=confirmar${operacao}" method="post" name="frmManterServidor" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Matricula:</td> 
                    <td><input type="text" name="txtMatricula" value="${servidor.matricula}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Nome:</td> 
                        <td><input type="text" name="txtNome" value="${servidor.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Data de Nascimento:</td> 
                        <td><input type="text" name="txtDataNasc" value="${servidor.dataNasc}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>CPF:</td> 
                        <td><input type="text" name="txtCPF" value="${servidor.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Data de Expedição:</td>
                        <td><input type="text" name="txtDataExpedicao" value="${servidor.dataExpedicao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>                        
                    </tr>
                    <tr>
                        <td>Orgão Expedidor:</td>
                        <td><input type="text" name="txtOrgaoExpedidor" value="${servidor.orgaoExpedidor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>                        
                    </tr>
                    <tr>
                        <td>UF Expedição:</td>
                        <td><input type="text" name="txtUFExpedicao" value="${servidor.ufExpedicao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>                        
                    </tr>

                    <tr> 
                        <td>Email:</td> 
                        <td><input type="text" name="txtEmail" value="${servidor.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </td>
                    </tr>
                    <tr> 
                        <td>Telefone:</td> 
                        <td><input type="text" name="txtTelefone" value="${servidor.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </td>
                    </tr>
                    <tr> 
                        <td>Celular:</td> 
                        <td><input type="text" name="txtCelular" value="${servidor.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </td>
                    </tr>
                    <tr> 
                        <td>Logradouro:</td> 
                        <td><input type="text" name="txtLogradouro" value="${servidor.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </td>
                    </tr>
                    <tr>
                        <td>Numero:</td> 
                        <td><input type="text" name="txtNumero" value="${servidor.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Complemento:</td> 
                        <td><input type="text" name="txtComplemento" value="${servidor.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Bairro:</td> 
                        <td><input type="text" name="txtBairro" value="${servidor.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr> 
                        <td>CEP:</td> 
                        <td><input type="text" name="txtCEP" value="${servidor.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </td>
                    </tr>
                    <tr> 
                        <td>Data de Admissão:</td> 
                        <td><input type="text" name="txtDataAdmissao" value="${servidor.dataAdmissao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
