package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Turma;

public class ManterTurmaController extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
            String acao = request.getParameter("acao");
            if(acao.equals("prepararIncluir")){
                prepararIncluir(request , response);
            } else {
                if(acao.equals("confirmarIncluir")){
                    //confirmarIncluir(request , response);
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
         request.setAttribute("turmas", Turma.obterTurma());
         RequestDispatcher view = request.getRequestDispatcher("/manterTurma.jsp");
         view.forward(request , response);
     }catch (ServletException ex){
     }catch (IOException ex){
     }catch (ClassNotFoundException ex){
    }
    }
     
}