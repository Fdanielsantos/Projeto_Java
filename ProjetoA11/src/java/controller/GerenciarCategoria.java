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
import model.Categoria;
import model.CategoriaDAO;

/**
 *
 * @author flavi
 */
public class GerenciarCategoria extends HttpServlet {

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
        
        Categoria c = new Categoria();
        
        try{
            CategoriaDAO cDAO = new CategoriaDAO();
            if(acao.equals("listar")){
                ArrayList<Categoria> listaCategoriars = cDAO.getLista();
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/listar_categoria.jsp");
                request.setAttribute("listaCategoria", listaCategoriars);
                disp.forward(request, response);
            }
            if(acao.equals("alterar")){
                c = cDAO.getCarregaPorID(Integer.parseInt(id));
                if(c.getId()>0){
                     RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_categoria.jsp");
                     request.setAttribute("c", c);
                     disp.forward(request, response);
                }else{
                    mensagem = "Categoria não encontrada";
                }
              
            }
            if(acao.equals("deletar")){
               
                    c.setId(Integer.parseInt(id));
                    if(cDAO.deletar(c)){
                        mensagem = "Categoria Deletada com sucesso!";
                    }else{
                        mensagem = "Erro ao Deletar a Categoria";
                    }
               
            }
            
        
        }catch(Exception e){
            out.print(e);
            mensagem = "Erro ao executar a lista de categorias";
        }
        
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='gerenciar_categoria.do?acao=listar';");
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
        String duracao = request.getParameter("duracao");
        String nome = request.getParameter("nome");

        Categoria c = new Categoria();
        
        try {
            CategoriaDAO cDAO = new CategoriaDAO();
            if(!id.isEmpty()){
                c.setId(Integer.parseInt(id));
            }
            if(duracao.equals("")||(duracao.isEmpty())||nome.equals("")||(nome.isEmpty())){
                mensagem = "Preencha os campos obrigatórios!";
                
            }else{
                c.setDuracao(duracao);
                c.setNome(nome);  
                if(cDAO.gravar(c)){
                    mensagem = "Gravado com sucesso!";
                }
            }
   
        } catch (Exception ex) {
            out.print(ex);
            mensagem = "Erro ao gravar a categoria no banco de dados";

        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='gerenciar_categoria.do?acao=listar';");
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
