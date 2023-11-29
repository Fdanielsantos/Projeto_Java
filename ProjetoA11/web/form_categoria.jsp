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
        <title>Cadastrar Categoria</title>
    </head>
    <body>
         <%@include file="banner.jsp" %>
         <%@include file="menu.jsp" %>
        
        <h1 class="text-center">Cadastrar Categoria</h1>
        <br>
        <div class="container-fluid">
            
            

            <form action="gerenciar_categoria.do" method="POST">
                <input type="hidden" name="id" value="${c.id}"/>
                <div class="row">
                    <div class="form-group col-sm-12">
                        <label form="duracao" class="control-label">Duração</label>
                        <input type="text" class="form-control" id="duracao" name="duracao" required="" value="${c.duracao}" maxlength="45"/>                         
                    </div>
                    <div class="form-group col-sm-5">
                        <label for="nome" class="control-label">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" required="" value="${c.nome}" maxlength="45"/> 
                        
                    </div>
                </div>        
                <div class="row">
                    <button class="btn btn-success">
                        Gravar <i class="glyphicon glyphicon-floppy-disk"></i>
                    </button>
                    <a href="gerenciar_categoria.do?acao=listar" class="btn btn-info">
                        Voltar <i class="glyphicon glyphicon-circle-arrow-left"></i>
                    </a>
                </div> 
            </form>
        </div>
       
    </body>
</html>

