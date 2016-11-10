package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Matricula;
import modelo.Turma;

public class ManterMatriculaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

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
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
        }
    }

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("matriculas", Matricula.obterMatriculas());
            request.setAttribute("cursos", Curso.obterCursos());
            request.setAttribute("disciplinas", Disciplina.obterDisciplinas());
            request.setAttribute("turmas", Turma.obterTurmas());
            request.setAttribute("alunos", Aluno.obterAlunos());
            RequestDispatcher view = request.getRequestDispatcher("/manterMatricula.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
            throw ex;
        }

    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        int codigoCurso = Integer.parseInt(request.getParameter("optCurso"));
        int codigoDisciplina = Integer.parseInt(request.getParameter("optDisciplina"));
        int codigoTurma = Integer.parseInt(request.getParameter("optTurma"));
        int codigoAluno = Integer.parseInt(request.getParameter("optAluno"));
        try {
            Curso curso = null;
            Disciplina disciplina = null;
            Turma turma = null;
            Aluno aluno = null;
            if (codigoCurso != 0) {
                curso = Curso.obterCurso(codigoCurso);
            }
            if (codigoDisciplina != 0) {
                disciplina = Disciplina.obterDisciplina(codigoDisciplina);
            }
            if (codigoTurma != 0) {
                turma = Turma.obterTurma(codigoTurma);
            }
            if (codigoAluno != 0) {
                aluno = Aluno.obterAluno(codigoAluno);
            }

            Matricula matricula = new Matricula(codigo, curso, disciplina, turma, aluno);
            matricula.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisarMatriculaController");
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
            request.setAttribute("matriculas", Matricula.obterMatriculas());
            request.setAttribute("cursos", Curso.obterCursos());
            request.setAttribute("disciplinas", Disciplina.obterDisciplinas());
            request.setAttribute("turmas", Turma.obterTurmas());
            request.setAttribute("alunos", Aluno.obterAlunos());

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Matricula matricula = Matricula.obterMatricula(codigo);
            request.setAttribute("matricula", matricula);

            RequestDispatcher view = request.getRequestDispatcher("/manterMatricula.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        int codigoCurso = Integer.parseInt(request.getParameter("optCurso"));
        int codigoDisciplina = Integer.parseInt(request.getParameter("optDisciplina"));
        int codigoTurma = Integer.parseInt(request.getParameter("optTurma"));
        int codigoAluno = Integer.parseInt(request.getParameter("optAluno"));
        try {
            Curso curso = null;
            Disciplina disciplina = null;
            Turma turma = null;
            Aluno aluno = null;
            if (codigoCurso != 0) {
                curso = Curso.obterCurso(codigoCurso);
            }
            if (codigoDisciplina != 0) {
                disciplina = Disciplina.obterDisciplina(codigoDisciplina);
            }
            if (codigoTurma != 0) {
                turma = Turma.obterTurma(codigoTurma);
            }
            if (codigoAluno != 0) {
                aluno = Aluno.obterAluno(codigoAluno);
            }
            Matricula matricula = new Matricula(codigo, curso, disciplina, turma, aluno);
            matricula.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisarMatriculaController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("matriculas", Matricula.obterMatriculas());

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Matricula matricula = Matricula.obterMatricula(codigo);
            request.setAttribute("matricula", matricula);

            RequestDispatcher view = request.getRequestDispatcher("/manterMatricula.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        int codigoCurso = Integer.parseInt(request.getParameter("optCurso"));
        int codigoDisciplina = Integer.parseInt(request.getParameter("optDisciplina"));
        int codigoTurma = Integer.parseInt(request.getParameter("optTurma"));
        int codigoAluno = Integer.parseInt(request.getParameter("optAluno"));
        try {
            Curso curso = null;
            Disciplina disciplina = null;
            Turma turma = null;
            Aluno aluno = null;
            if (codigoCurso != 0) {
                curso = Curso.obterCurso(codigoCurso);
            }
            if (codigoDisciplina != 0) {
                disciplina = Disciplina.obterDisciplina(codigoDisciplina);
            }
            if (codigoTurma != 0) {
                turma = Turma.obterTurma(codigoTurma);
            }
            if (codigoAluno != 0) {
                aluno = Aluno.obterAluno(codigoAluno);
            }
            Matricula matricula = new Matricula(codigo, curso, disciplina, turma, aluno);
            matricula.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisarMatriculaController");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterMatriculaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterMatriculaController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterMatriculaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterMatriculaController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
