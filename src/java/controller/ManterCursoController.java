/*
 * To change this license headeajfasodasdbausbdate file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;
import modelo.Professor;

/**
 *
 * @author Weber
 */
public class ManterCursoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        } else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request , response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request , response);
        }
    }

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("cursos" , Curso.obterCursos());
            request.setAttribute("professores", Professor.obterProfessores());
            RequestDispatcher view = request.getRequestDispatcher("/manterCurso.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String descricao = request.getParameter("txtDescricao");
        int cargaHoraria = Integer.parseInt(request.getParameter("txtCargaHoraria"));
        int codigoProfessor = Integer.parseInt(request.getParameter("optProfessor"));
        try {
            Professor professor = null;
            if (codigoProfessor != 0) {
              professor = Professor.obterProfessor(codigoProfessor);
            }
            Curso curso = new Curso(codigo, descricao, cargaHoraria, professor);
            curso.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisarCursoController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("cursos", Curso.obterCursos());
            request.setAttribute("professores", Professor.obterProfessores());
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Curso curso = Curso.obterCurso(codigo);
            request.setAttribute("curso", curso);
            RequestDispatcher view = request.getRequestDispatcher("/manterCurso.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String descricao = request.getParameter("txtDescricao");
        int cargaHoraria = Integer.parseInt(request.getParameter("txtCargaHoraria"));
        int codigoProfessor = Integer.parseInt(request.getParameter("optProfessor"));
        try {
            Professor professor = null;
            if (codigoProfessor != 0) {
                professor = Professor.obterProfessor(codigoProfessor);
            }
            Curso curso = new Curso(codigo, descricao, cargaHoraria, professor);
            curso.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisarCursoController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }
    private void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("cursos" , Curso.obterCursos());
            request.setAttribute("professores", Professor.obterProfessores());
            
            int codigo = Integer.parseInt(request.getParameter("codigo"));            
            Curso curso = Curso.obterCurso(codigo);
            request.setAttribute("curso", curso);
            
            RequestDispatcher view = request.getRequestDispatcher("/manterCurso.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
     public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String descricao = request.getParameter("txtDescricao");
        int cargaHoraria = Integer.parseInt(request.getParameter("txtCargaHoraria"));
        int codigoProfessor = Integer.parseInt(request.getParameter("optProfessor"));
        try {
            Professor professor = null;
            if (codigoProfessor != 0) {
                professor = Professor.obterProfessor(codigoProfessor);
            }
            Curso curso = new Curso(codigo, descricao, cargaHoraria, professor);
            curso.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisarCursoController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
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

}
