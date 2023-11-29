<html lang="pt-br">

<head>
 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Controle de dados</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width initial-scale, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/bootstrap-theme.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
        <link rel="stylesheet" type="css" href="estilo/menu.css">
        <style>
           body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            overflow: hidden; /* Impede a barra de rolagem no corpo */
        }
         
            .inicio {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .inicio img {
            width: 100px;
            height: 100px;
            object-fit: cover;
            
        }
   
        </style>
</head>

<body>
               <%@include file="menu.jsp" %>

    
               <div class="inicio">
                   <img src="img/logo.png" alt="Imagem de Início"/>

                  </div>
               
               

    <script src="menu.js"></script>
</body>

</html>