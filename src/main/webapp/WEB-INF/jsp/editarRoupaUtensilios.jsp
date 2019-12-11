<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      spring.mvc.view.prefix=/WEB-INF/jsp/
 spring.mvc.view.suffix=.jsp
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>To Dress</title>

    <!-- Bootstrap core CSS -->
    <link href="./../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="./../vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="./../vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="./../css/landing-page.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-light backgroundnav static-top">
    <div class="container" style="display:flex;justify-content:center;align-items:center;">
        <a class="navbar-brand" href="/home"><b>To Dress</b></a>
        <span class="navbar-text">Sistema de Gerenciamento de Aluguel de Trajes</span>
        <form action="${'/logout'}" method="post">
            <button class="btn btn-dark" type="submit">Sair</button>
        </form>
    </div>
</nav>

<!-- Masthead -->
<header class="masthead text-dark text-center">
    <h3 class="text-center">Editar Roupa ou Utensílio</h3>
    <div class="container box-left" >
        <div class="page-header">
            <h4>Bem vindo(a), </h4>
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
    <div class="container box">

        <form action="/editarRoupaUtensilios" method="POST" >
            <input type="hidden" name="codRoupaUtensilios" id="codRoupaUtensilios" class="form-control" value="${roupaU.codRoupaUtensilios}">

            <label for="tamanho">Tamanho:<input type="text" name="tamanho" id="tamanho" class="form-control" value="${roupaU.tamanho}" ></label>
            <br>
            <label for="cor">Cor:<input type="text" name="cor" id="cor" class="form-control" value="${roupaU.cor}"></label>

            <label for="precoRoupaUtensilio">Preço:<input type="number" name="precoRoupaUtensilio" id="precoRoupaUtensilio" class="form-control" value="${roupaU.precoRoupaUtensilio}"></label>
            <br>

            <label>Tipo de Roupa:
                <div><select name="codTipoRoupa" class="custom-select form-control">
                    <c:forEach var="tipoRoupa" items="${tiposRoupa}">
                        <option text="${tipoRoupa.codTipoRoupa}" value="${tipoRoupa.codTipoRoupa}">${tipoRoupa.descricao}</option>
                    </c:forEach>
                </select>
                </div>
            </label>

            <br>
            <br>
            <button type="submit" class="btn btn-primary">Editar</button>
            <a class="btn btn-danger ml-5" href="/gerenciarRoupaUtensilios" role="button">Cancelar</a>
        </form>
    </div>
</header>

<!-- Bootstrap core JavaScript -->
<script src="./../vendor/jquery/jquery.min.js"></script>
<script src="./../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="./../vendor/jquery/mascaras.js"></script>
<script src="./../vendor/jquery/jquery.maskedinputs.js"></script>
</body>

</html>
