/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Professor;
import model.ProfessorDAO;

/**
 *
 * @author 342009
 */
public class GerenciarProfessor extends HttpServlet {

    

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
        PrintWriter out = response.getWriter();
        String mensagem = "";
        String id = request.getParameter("id");
        String acao = request.getParameter("acao");
        
        Professor p = new Professor();
        
        try{
            ProfessorDAO pDAO = new ProfessorDAO();
            if(acao.equals("listar")){
                ArrayList<Professor> listaProfessors = pDAO.getLista();
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/listar_professor.jsp");
                request.setAttribute("listaProfessor", listaProfessors);
                disp.forward(request, response);
            }
            if(acao.equals("alterar")){
                p = pDAO.getCarregaPorID(Integer.parseInt(id));
                if(p.getId()>0){
                     RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_professor.jsp");
                     request.setAttribute("p", p);
                     disp.forward(request, response);
                }else{
                    mensagem = "Professor não encontrado";
                }
              
            }
            if(acao.equals("deletar")){
               
                    p.setId(Integer.parseInt(id));
                    if(pDAO.deletar(p)){
                        mensagem = "Professor Deletado com sucesso!";
                    }else{
                        mensagem = "Erro ao Deletar o professor";
                    }
               
            }
            
        
        }catch(Exception e){
            out.print(e);
            mensagem = "Erro ao executar a lista de professores";
        }
        
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='gerenciar_professor.do?acao=listar';");
        out.println("</script>");
    
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
        
        PrintWriter out = response.getWriter();
        String mensagem = "";
        
        String id = request.getParameter("id");
        String matr = request.getParameter("matr");
        String nome = request.getParameter("nome");

        Professor p = new Professor();
        
        try {
            ProfessorDAO pDAO = new ProfessorDAO();
            if(!id.isEmpty()){
                p.setId(Integer.parseInt(id));
            }
            if(matr.equals("")||(matr.isEmpty())||nome.equals("")||(nome.isEmpty())){
                mensagem = "Preencha os campos obrigatórios!";
                
            }else{
                p.setMatr(matr);
                p.setNome(nome);  
                if(pDAO.gravar(p)){
                    mensagem = "Gravado com sucesso!";
                }
            }
   
        } catch (Exception ex) {
            out.print(ex);
            mensagem = "Erro ao gravar o professor no banco de dados";

        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='gerenciar_professor.do?acao=listar';");
        out.println("</script>");
        
    
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
