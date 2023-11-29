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
import model.Esporte;
import model.EsporteDAO;

/**
 *
 * @author flavi
 */
public class GerenciarEsporte extends HttpServlet {

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
        
        Esporte e = new Esporte();
        
        try{
            EsporteDAO eDAO = new EsporteDAO();
            if(acao.equals("listar")){
                ArrayList<Esporte> listaEsporters = eDAO.getLista();
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/listar_esporte.jsp");
                request.setAttribute("listaEsporte", listaEsporters);
                disp.forward(request, response);
            }
            if(acao.equals("alterar")){
                e = eDAO.getCarregaPorID(Integer.parseInt(id));
                if(e.getId()>0){
                     RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_esporte.jsp");
                     request.setAttribute("e", e);
                     disp.forward(request, response);
                }else{
                    mensagem = "Esporte não encontrado";
                }
              
            }
            if(acao.equals("deletar")){
               
                    e.setId(Integer.parseInt(id));
                    if(eDAO.deletar(e)){
                        mensagem = "Esporte Deletado com sucesso!";
                    }else{
                        mensagem = "Erro ao Deletar o Esporte";
                    }
               
            }
            
        
        }catch(Exception ee){
            out.print(ee);
            mensagem = "Erro ao executar a lista de esportes";
        }
        
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='gerenciar_esporte.do?acao=listar';");
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
        String descricao = request.getParameter("descricao");
        String nome = request.getParameter("nome");
        String duracao = request.getParameter("duracao");

        Esporte e = new Esporte();
        
        try {
            EsporteDAO eDAO = new EsporteDAO();
            if(!id.isEmpty()){
                e.setId(Integer.parseInt(id));
            }
            if(descricao.equals("")||(descricao.isEmpty())||nome.equals("")||(nome.isEmpty())||duracao.equals("")||(duracao.isEmpty())){
                mensagem = "Preencha os campos obrigatórios!";
                
            }else{
                e.setNome(nome);
                e.setDescricao(descricao);
                e.setDuracao(duracao);
                if(eDAO.gravar(e)){
                    mensagem = "Gravado com sucesso!";
                }
            }
   
        } catch (Exception ee) {
            out.print(ee);
            mensagem = "Erro ao gravar o Esporte no banco de dados";

        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='gerenciar_esporte.do?acao=listar';");
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
