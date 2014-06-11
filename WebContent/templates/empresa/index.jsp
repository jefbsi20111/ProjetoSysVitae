<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="models.*" %>
<%@page import="dao.*"%>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html lang="br"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Estágio Fácil</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- <meta HTTP-EQUIV="refresh" CONTENT="5"> -->

<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
</head><body>
<div class="container">

<nav class="navbar navbar-inverse" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Estágio Fácil</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <!-- <li class="active"><a href="#login-empresa" data-toggle="modal" data-target=".login-empresa"></a></li>
        <li><a href="#"></a></li> -->
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

 

<!-- Inicio tabela empresas. -->


<h3>Candidatos no sistema</h3>


<form action="/templates/empresa/result-pesquisa.jsp" method="POST">
 
  <div class="col-md-2">
     <label>Pesquisar pelo nome:</label>
  </div>
  
  <div class="col-md-3">
    <input name="nome" id="nome" class="form-control required">
  </div>
  
  <button type="POST" class="btn btn-primary" type="submit">Pesquisar</button>

</form>

<br>
<table columns="3" colsplan="20" >
    <thead>
        <tr>
            <td>Nome</td>
            <td>Esperiências</td>
            <td>Area de atauação</td>
        </tr>
    </thead>

<tbody>
<%

List<Candidato> candidatos = new ArrayList<Candidato>();
CandidatoDAO acessoCandidato = new CandidatoDAO();

candidatos = acessoCandidato.listar();
for (Candidato candidato : candidatos) {
    
    out.println("<tr>");
    
    out.println("<td>");
    out.println(candidato.getNome());
    out.println("</td>");
    
    out.println("<td>");
    out.println(candidato.getExp());
    out.println("</td>");
    
    out.println("<td>");
    out.println(candidato.getArea_atuacao());
    out.println("</td>");
    
    out.println("</tr>");
  
}

%>

</tbody>
</table>
</div> <!-- /.container -->

  <script src="http://code.jquery.com/jquery-latest.js"></script>

  <script src="bootstrap/js/bootstrap.js"></script>
  <script type="text/javascript" src="bootstrap/js/jquery-mask-plugin.js"></script>
  
  <script type="text/javascript" src="bootstrap/js/jquery-validate.js"></script>

<!--

  <script type="text/javascript">
  $(document).ready(function(){
    $(".telefone").mask("(99) 9999-9999");
    $('.datanascimento').mask("99/99/9999");
  });
  </script>

-->
   <script>
    $(document).ready(function(){
      
      $("#form-empresa").validate();
      $("#form-candidato").validate();
    });
  </script>

</body>