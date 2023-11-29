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
import model.Aluno;
import model.AlunoDAO;


/**
 *
 * @author flavi
 */
public class GerenciarAluno extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        
        Aluno a = new Aluno();
        
        try{
        
        AlunoDAO aDAO = new AlunoDAO();
        
        if(acao.equals("listar")){
                ArrayList<Aluno> listaAlunors = aDAO.getLista();
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/listar_aluno.jsp");
                request.setAttribute("listaAluno", listaAlunors);
                disp.forward(request, response);
            }
            if(acao.equals("alterar")){
                a = aDAO.getCarregaPorID(Integer.parseInt(id));
                if(a.getId()>0){
                     RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_aluno.jsp");
                     request.setAttribute("a", a);
                     disp.forward(request, response);
                }else{
                    mensagem = "Aluno não encontrado";
                }
              
            }
            if(acao.equals("deletar")){
               
                    a.setId(Integer.parseInt(id));
                    if(aDAO.deletar(a)){
                        mensagem = "Aluno Deletado com sucesso!";
                    }else{
                        mensagem = "Erro ao Deletar o aluno";
                    }
               
            }
            
        
        
    }catch(Exception e){
            out.print(e);
            mensagem = "Erro ao executar a lista de Alunos";
        }
        
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='gerenciar_aluno.do?acao=listar';");
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

        Aluno a = new Aluno();
        
  try {
            AlunoDAO aDAO = new AlunoDAO();
            if(!id.isEmpty()){
                a.setId(Integer.parseInt(id));
            }
            if(matr.equals("")||(matr.isEmpty())||nome.equals("")||(nome.isEmpty())){
                mensagem = "Preencha os campos obrigatórios!";
                
            }else{
                a.setMatr(matr);
                a.setNome(nome);  
                if(aDAO.gravar(a)){
                    mensagem = "Gravado com sucesso!";
                }
            }
   
        } catch (Exception ex) {
            out.print(ex);
            mensagem = "Erro ao gravar o aluno no banco de dados";

        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='gerenciar_aluno.do?acao=listar';");
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
