<%-- 
    Document   : listar_professor
    Created on : 17/10/2023, 15:04:07
    Author     : 342009
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width initial-scale, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/bootstrap-theme.min.css">
        <style>
            .container-fluid{
                justify-content: center;
                display: flex;
            }
        </style>
        <title>Cadastrar Esporte</title>
    </head>
    <body>
         <%@include file="banner.jsp" %>
         <%@include file="menu.jsp" %>
        
        <h1 class="text-center">Cadastrar Esporte</h1>
        <br>
        <div class="container-fluid">
            
            

            <form action="gerenciar_esporte.do" method="POST">
                <input type="hidden" name="id" value="${e.id}"/>
                <div class="row">
                    <div class="form-group col-sm-12">
                        <label form="nome" class="control-label">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" required="" value="${e.nome}" maxlength="45"/>                         
                    </div>
                    <div class="form-group col-sm-5">
                        <label for="descrição" class="control-label">Descrição</label>
                        <input type="text" class="form-control" id="descrição" name="descrição" required="" value="${e.descrição}" maxlength="45"/> 
                        
                    </div>
                    <div class="form-group col-sm-5">
                        <label for="duracao" class="control-label">Duração</label>
                        <input type="text" class="form-control" id="duracao" name="duracao" required="" value="${e.duracao}" maxlength="45"/> 
                        
                    </div>
                </div>        
                <div class="row">
                    <button class="btn btn-success">
                        Gravar <i class="glyphicon glyphicon-floppy-disk"></i>
                    </button>
                    <a href="gerenciar_esporte.do?acao=listar" class="btn btn-info">
                        Voltar <i class="glyphicon glyphicon-circle-arrow-left"></i>
                    </a>
                </div> 
            </form>
        </div>
       
    </body>
</html>

