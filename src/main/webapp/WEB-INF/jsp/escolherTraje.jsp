<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

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

    <div class="container box-left">

        <div class="page-header">
            <h4>Bem vindo(a), <span sec:authentication="name"></span>!</h4>
        </div>
        <div class="row">
            <div class="col-3"><i class="fas fa-address-book fa-3x float-left "></i></div>
            <div class="col-9 text-left"><a href="/gerenciarCli" class="text-left">Gerenciar Cliente.</a></div>
            <br>
            <br>
            <br>
        </div>

        <div class="row">
            <div class="col-3"><i class="fas fa-tshirt fa-3x float-left"></i></div>
            <div class="col-9 text-left"><a href="/gerenciarRoupaUtensilios" class="text-left">Gerenciar Trajes.</a>
            </div>
            <br>
            <br>
            <br>
        </div>
        <div class="row">
            <div class="col-3"><i class="fas fa-link fa-3x float-left"></i></div>
            <div class="col-9 text-left"><a href="/gerenciarAluguel" class="tamfonte text-left">Gerenciar Aluguel.</a>
            </div>
            <br>
            <br>
            <br>
        </div>


    </div>
    <div class="text-center"><h3>Escolher Roupa ou Utensílio</h3></div>
    <div class="container pesquisa col-auto ">

        <form action="${'/cor'}" method="POST">

            <label for="cor">Buscar</label>
            <input type="text" id="cor" name="cor">
            <button type="submit"><i class="fas fa-search fa-1x"></i></button>
        </form>

    </div>

    <div class="card posicao" style="width: 50%;">
        <div class="panel-heading letra">
            <div class="form-group ${error != null ? 'has-error' : ''}">
                <span><b>${error}</b></span>

                <span><b>${message}</b></span>
            </div>
            <%--            <span th:text="${#strings.isEmpty(message)} ? '' : ${message}"><b></b></span>--%>
        </div>
        <div class="card-body">
            <form method="GET" action="/cadastrarAluguel" >
                <input type="hidden" name="idCli" id="idCli" value="${cliente.idCli}" class="form-control" >

                <label for="dataEvento">Data do Evento:<input type="date" name="dataEvento" id="dataEvento" class="form-control"></label>

                <label for="dataProva">Data da Prova do Traje:<input type="date" name="dataProva" id="dataProva" class="form-control" ></label>
                <br>
                <label for="dataRetirada">Data de Retirada:<input type="date" name="dataRetirada" id="dataRetirada" class="form-control" ></label>

                <label for="dataEntrega">Data de Entrega:<input type="date" name="dataEntrega" id="dataEntrega" class="form-control"></label>
                <br>
                <br>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Código</th>
                    <th scope="col">Cor</th>
                    <th scope="col">Tamanho</th>
                    <th scope="col">Tipo de Vestuário</th>
                    <th scope="col">Ação</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="roupaUtensilio" items="${roupaUtensilios}">
                    <tr>
                        <th scope="row">${roupaUtensilio.codRoupaUtensilios}</th>
                        <td>${roupaUtensilio.cor}</td>
                        <td>${roupaUtensilio.tamanho}</td>
                        <td>${roupaUtensilio.tipoRoupa.descricao}</td>
                        <td > <input type="radio" aria-label="Radio button for following text input"></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <a class="btn btn-danger ml-5" href="/gerenciarAluguel" role="button">Cancelar</a>
            </form>
        </div>
    </div>
    <!--</div>-->
</header>


<!-- Bootstrap core JavaScript -->
<script src="./../vendor/jquery/jquery.min.js"></script>
<script src="./../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
