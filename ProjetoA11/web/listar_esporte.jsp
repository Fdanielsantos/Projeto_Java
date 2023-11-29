<%-- 
    Document   : listar_professor
    Created on : 17/10/2023, 15:04:07
    Author     : 342009
--%>
<%@page import="model.EsporteDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Esporte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, 
              user-scalable=no", name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css">
        <script type="text/javascript">
            function confirmarExclusao(id, nome){
                if(confirm('Deseja realmente deletar o esporte ' +nome+'?')){
                    location.href='gerenciar_esporte.do?acao=deletar&id='+id;
                }
            }
        </script>    
        <title>Esportes</title>
    </head>
    <body>
        <div class="container">
            
            <%@include file="menu.jsp" %>
            <h1 class="text-center">Lista de Esportes</h1><br>
            <a href="form_esporte.jsp" class="btn btn-info">Novo Cadastro</a>
            
            <table class="table table-hover table-striped table-bordered display"
                   id="listarEsporte">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Duração</th>
                    <th>Opções</th>
                    
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Duração</th>
                    <th>Opções</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="e" items="${listaEsporte}">
               
                 <tr>
                     <td>${e.id}</td>
                     <td>${e.nome}</td>
                     <td>${e.descricao}</td>
                     <td>${e.duracao}</td>
                     <td>
                         <a class="btn btn-primary" href="gerenciar_esporte.do?acao=alterar&id=${e.id}">
                             <i class="glyphicon glyphicon-pencil"></i>
                         </a>    
                         
                             <button class="btn btn-danger" onclick="confirmarExclusao(${e.id},'${e.nome}')">
                             <i class="glyphicon glyphicon-trash"></i>
                         </button>
                         
                     </td>
                 </tr>
                </c:forEach>
                </tbody>
            </table>
            <script type="text/javascript" src="datatables/jquery.js"></script> 
            <script type="text/javascript" src="datatables/jquery.dataTables.min.js"></script>
            <script type="text/javascript">
                $(document).ready(function(){
                    $("#listarEsporte").dataTable({
                        "bJQueryUI": true,
                                                   "oLanguage": {
                                                       "sProcessing": "Processando...",
                                                       "sLengthMenu": "Mostrar _MENU_ registros",                        
                                                       "sZeroRecords": "Não foram encontrados resultados",
                                                       "sInfo": "Mostrar de _START_ até _END_ de _TOTAL_ registros",
                                                       "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                                                       "sInfoFiltered": "",
                                                       "sInfoPostFix": "",
                                                       "sSearch": "Pesquisar",
                                                       "sUrl": "",
                                                       "oPaginate": {
                                                           "sFirst": "Primeiro",
                                                           "sPrevious": "Anterior",
                                                           "sNext": "Próximo",
                                                           "sLast": "Último"
                                                       }
                                                   }
                    })
                })
            </script>    
                            <script src="menu.js"></script>

        </div>
    </body>
</html>

