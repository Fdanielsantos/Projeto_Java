<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Atma Studio</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width initial-scale, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/bootstrap-theme.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
        <link rel="stylesheet" type="css" href="estilo/menu.css">
</head>
<style>
    * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: sans-serif;
}

body {
    height: 100vh;

}

.header {
    display: flex;
    position: -webkit-sticky;
    position: sticky;
    top: 0;
    flex-direction: row;
    align-items: center;
    background-color: #202020;

}

nav.menu-lateral {
    width: 80px;
    height: 100%;
    background-color: #202020;
    padding: 40px 0 40px 1%;

    position: fixed;
    top: 0;
    left: 0;
    overflow: hidden;
    transition: .2s;
}

nav.menu-lateral.expandir {
    width: 230px;
}

.btn-expandir {
    width: 100%;
    padding-left: 10px;
}

.btn-expandir>i {
    color: #fff;
    font-size: 24px;
    cursor: pointer;
}

ul {
    height: 100%;
    list-style-type: none;
}

ul li.item-menu {
    transition: .2s;
     font-size: 9px; 
     height: 8%;
}



ul li.item-menu:hover {
    background: #868686;
}

ul li.item-menu a {
    color: #fff;
    text-decoration: none;
    font-size: 20px;
    padding: 15px 4%;
    display: flex;
    margin-bottom: 20px;
    line-height: 40px;
}

ul li.item-menu a .txt-link {
    margin-left: 70px;
    transition: 1s;
    opacity: 0;
}

nav.menu-lateral.expandir .txt-link {
    margin-left: 30px;
    opacity: 1;
}

ul li.item-menu a .icon>i {
    font-size: 30px;
    margin-left: 10px;
}

.container {
    color: #fff;
    font-size: 20px;
    padding: 0px 20%;
    display: flex;
    margin-bottom: 20px;
    line-height: 40px;
}

.container a {
    text-decoration: none;
    color: #fff;

}

.container table tr td {
    width: 30vw;
    /* Distribui igualmente as colunas */
    height: 2vw;
    /* Distribui igualmente as linhas */
 
}


table {
    border-spacing: 20px;
    color: #fff;
}

.itens-table a {
    text-decoration: none;
    display: flex;
    justify-content: center;
    align-items: center;

}

table td {
    text-align: center;
    vertical-align: middle;
    border: 1px;
    border-radius: 5px;
}

h2 {
    text-align: center;
}

.logo {
    width: 50px;
    height: 50px;
    margin-left: 1810px;
}

.logo1 {
    width: 70px;
    height: 70px;
    margin-left: 65px;
    border-radius: 50px;
}

tbody{
    color:#202020
}
</style>
<body>
    <div class="header">
        <br><br><br>
        <nav class="menu-lateral expandir">
            <div class="btn-expandir">
                <br>
            </div> <!--btn-expandir-->

            <ul>
                 <a href="index.jsp">
                     <span><img src="img/logo.png" alt="" class="logo1"></span>
                    </a>
                <br>
                <li class="item-menu ativo">
                    
                    <a href="index.jsp">
                        <span class="icon"><i class="bi bi-house-door"></i> </span>
                        <span class="txt-link">Home</span>
                    </a>
                </li>
                <li class="item-menu">
                    <a href="gerenciar_professor.do?acao=listar">
                        <span class="icon"><i  class="bi bi-people-fill"></i></span>
                        <span class="txt-link">Professores</span>
                    </a>
                </li>
                <li class="item-menu">
                    <a href="gerenciar_aluno.do?acao=listar">
                        <span class="icon"><i class="bi bi-people-fill"></i></span>
                        <span class="txt-link">Alunos</span>
                    </a>
                </li>
                <li class="item-menu">
                    <a href="gerenciar_categoria.do?acao=listar"">
                        <span class="icon"><i class="bi bi-list"></i></span>
                        <span class="txt-link">Categoria</span>
                    </a>
                </li>
               
               
             

            </ul>

        </nav><!--menu lateral-->
    </div>
   


    <script src="menu.js"></script>
</body>

</html>