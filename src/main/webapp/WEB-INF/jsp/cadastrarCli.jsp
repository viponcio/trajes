<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en"
      xmlns:th="http://thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>To Dress</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/landing-page.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-light backgroundnav static-top">
    <div class="container" style="display:flex;justify-content:center;align-items:center;">
        <a class="navbar-brand" href="/home"><b>To Dress</b></a>
        <span class="navbar-text">Sistema de Gerenciamento de Aluguel de Trajes</span>
        <form action="@{/logout}" method="post">
            <button class="btn btn-dark" type="submit">Sair</button>
        </form>
    </div>
</nav>

<!-- Masthead -->
<header class="masthead text-dark text-center">
    <div class="container box-left" >
        <div class="page-header">
            <h4>Bem vindo(a), !</h4>
        </div>
        <div class="row">
            <div class="col-3"> <i class="fas fa-address-book fa-3x float-left "></i></div>
            <div class="col-9 text-left">    <a href="/gerenciarCli" class="text-left">Gerenciar Cliente.</a> </div>
            <br>
            <br>
            <br>
        </div>

        <div class="row">
            <div class="col-3"> <i class="fas fa-tshirt fa-3x float-left"></i></div>
            <div class="col-9 text-left">  <a href="/gerenciarRoupaUtensilios" class="text-left">Gerenciar Trajes.</a></div>
            <br>
            <br>
            <br>
        </div>
        <div class="row">
            <div class="col-3"><i class="fas fa-link fa-3x float-left"></i></div>
            <div class="col-9 text-left"><a href="/gerenciarAluguel" class="tamfonte text-left">Gerenciar Aluguel.</a></div>
            <br>
            <br>
            <br>
        </div>



    </div>
    <h3 class="text-center" >Cadastro de Cliente</h3>
    <div class="container box">

        <form method="POST" action="/salvarCli">
            <label for="nomeCli">Nome:<input type="text" name="nomeCli" id="nomeCli" class="form-control" placeholder="digite o seu nome" ></label>

            <label for="nascimentoCli">Data de Nascimento:<input type="date" name="nascimentoCli" id="nascimentoCli" class="form-control" ></label>
            <br>
            <label for="sobrenomeCli">Sobrenome:<input type="text" name="sobrenomeCli" id="sobrenomeCli" class="form-control" placeholder="digite o seu sobrenome"></label>

            <label for="cpfCli">CPF:<input type="text" name="cpfCli" id="cpfCli" class="form-control cpf" placeholder="digite o cpf" ></label>
            <br>
            <label for="ruaCli">Rua:<input type="text" name="ruaCli" id="ruaCli" class="form-control" placeholder="digite a sua rua"></label>

            <label for="numeroCli">N°:<input type="number" name="numeroCli" id="numeroCli" class="form-control" placeholder="digite o seu n°" ></label>
            <br>
            <label for="cepCli">Cep:<input type="text" name="cepCli" id="cepCli" class="form-control cep" placeholder="digite o seu cep"></label>

            <label for="bairroCli">Bairro:<input type="text" name="bairroCli" id="bairroCli" class="form-control" placeholder="digite o seu bairro" ></label>
            <br>
            <label for="cidadeCli">Cidade:<input type="text" name="cidadeCli" id="cidadeCli" class="form-control" placeholder="digite a cidade" ></label>

            <label for="estadoCli">Estado:<input type="text" name="estadoCli" id="estadoCli" class="form-control" placeholder="digite o estado"></label>
            <br>
            <label for="foneCli">Telefone:<input type="text" name="foneCli" id="foneCli" class="form-control telefone" placeholder="digite o fone" ></label>

            <label for="emailCli">E-mail:<input type="text" name="emailCli" id="emailCli" class="form-control" placeholder="digite o email"></label>
            <br>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <a class="btn btn-danger ml-5" href="/gerenciarCli" role="button">Cancelar</a>
        </form>
        <!--</div>-->
    </div>
    <!--</div>-->
</header>


<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="vendor/jquery/mascaras.js"></script>
<script src="vendor/jquery/jquery.maskedinputs.js"></script>
</body>

</html>
