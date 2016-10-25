package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Professor;

public class ManterProfessorController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         String acao = request.getParameter("acao");
            if(acao.equals("prepararIncluir")){
                prepararIncluir(request , response);
            } else {
                if(acao.equals("confirmarIncluir")){
                    confirmarIncluir(request , response);
                } else {
                    if (acao.equals("prepararEditar")){
                        //prepararEditar(request , response);
                    } else {
                        if (acao.equals("confirmarEditar")){
                            //confirmarEditar(request , response);
                        } else {
                            if (acao.equals("prepararExcluir")){
                                //prepararExcluir(request , response);
                            } else {
                                if (acao.equals("confirmarExcluir")){
                                    //confirmarExcluir(request , response);
                                }
                            }
                        }
                    }
                }
                
            }
        }
    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
     try {
         request.setAttribute("operacao", "Incluir");
         request.setAttribute("professores", Professor.obterProfessores());
         RequestDispatcher view = request.getRequestDispatcher("/manterProfessor.jsp");
         view.forward(request,response);
     }catch (ServletException ex){
     }catch (IOException ex){
     }catch (ClassNotFoundException ex){
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
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        int ano = Integer.parseInt(request.getParameter("txtAno"));
        int semestre = Integer.parseInt(request.getParameter("txtSemestre"));
        int maxAlunos = Integer.parseInt(request.getParameter("txtMaxAlunos"));
        try{
        /*  caso seja necessário
            Professor professor = null;
            if (coordenador != 0) {
                professor = Professor.obterProfessor(coordenador);
        }
         */
        Professor professor = new Professor(codigo, ano, semestre, maxAlunos);
        professor.gravar();
        RequestDispatcher view = request.getRequestDispatcher("PesquisarProfessorController");
        view.forward(request, response);
        }catch (ServletException ex){
        }catch (IOException ex){
        }catch (ClassNotFoundException ex){    
        }catch (SQLException ex){    
        }     
    }
}
