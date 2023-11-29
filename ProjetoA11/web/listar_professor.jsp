<%-- 
    Document   : listar_professor
    Created on : 17/10/2023, 15:04:07
    Author     : 342009
--%>
<%@page import="model.ProfessorDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Professor"%>
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
                if(confirm('Deseja realmente deletar o Professor ' +nome+'?')){
                    location.href='gerenciar_professor.do?acao=deletar&id='+id;
                }
            }
        </script> 
        
        <title>Professor</title>
        <style>
                 .container-fluid{
              color: black;  
              margin-left: 0px;
              width: 1300px;
              padding-left: 500%;
            }
     
            .centralizar{
             position: absolute;
             top: 50px;
             left: 300px; 
             width: 1270px;
            }
            .thead-text{
                color: black;
            }
            #listarProfessor th,
            #listarProfessor td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }

            
            #listarProfessor th {
                background-color: #c8e6c9;
            }

            #listarProfessor tr:hover {
                background-color: #a2aec7;
            }
           .dataTables_filter input {
        border-radius: 3px; /* Ajuste o valor conforme necessário */
        padding: 3px; /* Ajuste o valor conforme necessário */
        box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1); /* Adiciona uma sombra suave */
    }
   @media screen and (max-width: 1760px){
           .container-fluid{
              color: black;  
               display: flex;
              justify-content: flex-end;
             
                 
               }
          
        </style>
</head>
    
    <body>
     <%@include file="menu.jsp"%>

        <div class="container">
            <div class="centralizar">

                <h1 class="text-center" style="color: black;">Lista de Professores</h1><br>
            <a href="form_professor.jsp" class="btn btn-info">Novo Cadastro</a>
            
            <table class="table table-hover table-striped table-bordered display"
                   id="listarProfessor" style="font-size: 14px; color: black;">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Matricula</th>
                    <th>Nome</th>
                    <th>Opções</th>
                </tr>
                </thead>
                
                <tbody>
                <c:forEach var="p" items="${listaProfessor}">
               
                 <tr>
                     <td>${p.id}</td>
                     <td>${p.matr}</td>
                     <td>${p.nome}</td>
                     <td>
                         <a class="btn btn-primary" href="gerenciar_professor.do?acao=alterar&id=${p.id}">
                             <i class="glyphicon glyphicon-pencil"></i>
                         </a>    
                         
                             <button class="btn btn-danger" onclick="confirmarExclusao(${p.id},'${p.nome}')">
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
                    $("#listarProfessor").dataTable({
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
          </div>  
        </div>
                <script src="menu.js"></script>

    </body>
</html>

