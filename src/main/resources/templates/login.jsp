<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en"
        xmlns:th="http://thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
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
      <a class="navbar-brand" href="/login"><b>To Dress</b></a>
      <span class="navbar-text">Sistema de Gerenciamento de Aluguel de Trajes</span>
    </div>
  </nav>

  <!-- Masthead -->
  <header class="masthead text-dark text-center">
   <!-- <div class="overlay "></div>--> 
    <div class="container login">
      <div <c:if test="${param.error}"> >
        <div class="alert alert-danger">Usuario/senha invalidos!</div>
      </c:if>
      </div>
      <div <c:if test="${param.logout}">>
        <div class="alert alert-info">Usuário desconectado!</div>
      </div>
      </c:if>
      <h1>Login</h1>
      <!--      </div>-->
          <form  action="@{/login}" method="POST">
            <label for="username">E-mail:<input type="email" name="username" id="username" class="form-control" placeholder="digite o seu e-mail" /></label>
            <br>
            <br>
            <label for="password">Senha:<input type="password" name="password" id="password" class="form-control" placeholder="digite a sua senha"></label>
            <br>

            <button type="submit" class="btn btn-primary">Entrar</button>

            <br>

          </form>
        <br>
        <!--</div>-->
      </div>
    <!--</div>-->
  </header>


  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
