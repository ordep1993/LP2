/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;
import modelo.Matricula;


public class ManterMatriculaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String acao = request.getParameter("acao");
            if(acao.equals("prepararIncluir")){
                prepararIncluir(request , response);
            } else {
                if(acao.equals("confirmarIncluir")){
                   // confirmarIncluir(request , response);
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
         request.setAttribute("matriculas", Matricula.obterMatriculas());
         RequestDispatcher view = request.getRequestDispatcher("/manterMatricula.jsp");
         view.forward(request,response);
     }catch (ServletException ex){
     }catch (IOException ex){
     }catch (ClassNotFoundException ex){
    }
    }
        /*public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        int codigoCurso = Integer.parseInt(request.getParameter("txtCodigoCurso"));
        int codigoDisciplina = Integer.parseInt(request.getParameter("txtCodigoDisciplina"));
        int codigoTurma = Integer.parseInt(request.getParameter("txtCodigoTurma"));
        int codigoAluno = Integer.parseInt(request.getParameter("txtCodigoAluno"));
        try{
            Curso curso = null;
            if (codigoCurso != 0) {
                curso = Curso.obterProfessor(codigo);
        }
       
        Matricula matricula = new Matricula(codigo, codigoCurso , codigoDisciplina , codigoTurma , codigoAluno);
        matricula.gravar();
        RequestDispatcher view = request.getRequestDispatcher("PesquisarMatriculaController");
        view.forward(request, response);
        }catch (ServletException ex){
        }catch (IOException ex){
        }catch (ClassNotFoundException ex){    
        }catch (SQLException ex){    
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
