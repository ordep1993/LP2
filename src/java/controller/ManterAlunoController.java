
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;

public class ManterAlunoController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request , response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request , response);
        } else if (acao.equals("confirmarEditar")) {
            //confirmarEditar(request , response);
        } else if (acao.equals("prepararExcluir")) {
            //prepararExcluir(request , response);
        } else if (acao.equals("confirmarExcluir")) {
            //confirmarExcluir(request , response);
        }
    }

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("alunos", Aluno.obterAlunos());
            RequestDispatcher view = request.getRequestDispatcher("/manterAluno.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int matricula = Integer.parseInt(request.getParameter("txtMatricula"));
        String nome = request.getParameter("txtNome");
        String dataNasc = request.getParameter("txtDataNasc");
        int cpf = Integer.parseInt(request.getParameter("txtCPF"));
        String dataExpedicao = request.getParameter("txtDataExpedicao");
        String email = request.getParameter("txtEmail");
        int telefone = Integer.parseInt(request.getParameter("txtTelefone"));
        int celular = Integer.parseInt(request.getParameter("txtCelular"));
        String logradouro = request.getParameter("txtLogradouro");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        int cep = Integer.parseInt(request.getParameter("txtCEP"));
        int anoInicio = Integer.parseInt(request.getParameter("txtAnoInicio"));
        int semestreInicio = Integer.parseInt(request.getParameter("txtSemestreInicio"));
        int estadoAluno = Integer.parseInt(request.getParameter("txtEstadoAluno"));
//    boolean estadoAluno = Boolean.parseBoolean(request.getParameter("txtEstadoAluno")); 
        
        try{
        /*  caso seja necessário
            Professor professor = null;
            if (coordenador != 0) {
                professor = Professor.obterProfessor(coordenador);
        }
         */
        Aluno aluno = new Aluno(matricula, nome, dataNasc, cpf, dataExpedicao, email, telefone, celular, logradouro, numero, complemento, bairro, cep, anoInicio, semestreInicio, estadoAluno);
        aluno.gravar();
        RequestDispatcher view = request.getRequestDispatcher("PesquisarAlunoController");
        view.forward(request, response);
        }catch (ServletException ex){
        }catch (IOException ex){
        }catch (ClassNotFoundException ex){    
        }catch (SQLException ex){    
        }     
    }
    
        public void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("alunos", Aluno.obterAlunos());
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Aluno aluno = Aluno.obterAluno(codigo);
            request.setAttribute("aluno", aluno);
            RequestDispatcher view = request.getRequestDispatcher("/manterAluno.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex){
        }

    }
    }

