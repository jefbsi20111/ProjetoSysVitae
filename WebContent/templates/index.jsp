<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="dao.VagaDAO"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="controlador.*" %>
<%@page import="models.*" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@page import="jdbc.*" %>

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

<div class="panel-group" id="accordion">
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
          Login da Empresa
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in">
      <div class="panel-body">
        
      <form action="login-empresa" class="form" method="POST" id="form-empresa">
        <div class="form-group">
          <div class="col-md-2">
            <label>Email</label>
          </div>    
          <div class="col-md-3">
            <input name="email" type="text" class="email required form-control">
          </div>    
        </div>
        <div class="form-group">
          <div class="col-md-2">
            <label>Senha</label>
          </div>
          <div class="col-md-3">
            <input name="senha" type="password" class="form-control required">
          </div>
        </div>
        <button type="POST" class="btn btn-primary" type="submit">Logar</button>
      </form>
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
          Login Candidato
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse">
      <div class="panel-body">
        <form action="login-candidato" class="form" method="POST" id="form-candidato">
        <div class="form-group">
          <div class="col-md-2">
            <label>Email</label>
          </div>    
          <div class="col-md-3">
            <input name="email" type="text" class="email required form-control">
          </div>    
        </div>
        <div class="form-group">
          <div class="col-md-2">
            <label>Senha</label>
          </div>
          <div class="col-md-3">
            <input name="senha" type="password" class="form-control required">
          </div>
        </div>
        <button type="POST" class="btn btn-primary" type="submit">Logar</button>
      </form>

      </div>
    </div>
  </div>

  <hr>

  <c:url var="caminho" value="/cadastrar.jsp" context="/ProjetoSysVitae/WebContente/templates/empresa" scope="page"/>
  <a href="${requestScope.caminho}" class="btn-primary">Cadastro Empresa</a>
  <br>
  <c:url var="caminho" value="/cadastrar.jsp" context="/ProjetoSysVitae/templates/candidato" scope="page"/>
  <a href="${requestScope.caminho}" class="btn-primary">Cadastro Candidato</a>
 

<!-- Inicio tabela vagas. -->


<h3>Vagas cadastradas no sistema</h3>
<br>
<!-- <table>
    <thead>
        <th>
            <tr>Carga Horário</tr>
            <tr>Remuneração</tr>
            <tr>Requisitos</tr>
        </th>
    </thead>

<tbody>
</tbody>
</table> -->
<%
//ListarVaga lv = new ListarVaga();
/**VagaDAO dao = new VagaDAO();   		
List<Vaga> vagas = new ArrayList<Vaga>();
vagas = dao.listar();//new ListarVaga().getLista();//lv.getLista();

for (Vaga vaga : vagas) {
    
    out.println("<tr>");
    
    out.println("<td>");
    out.println(vaga.getCarga_horaria());
    out.println("</td>");
    
    out.println("<td>");
    out.println(vaga.getRemuneracao());
    out.println("</td>");
    
    out.println("<td>");
    out.println(vaga.getRequisitos());
    out.println("</td>");
    
    out.println("</tr>");
  
}**/
//ListarVaga lv = new ListarVaga();
%>
<form action="ListarVaga" method="post">
<%
VagaDAO dao = new VagaDAO();   		
List<Vaga> vagas = new ArrayList<Vaga>();
vagas = dao.listar();//new ListarVaga().getLista();//lv.getLista();

for (Vaga vaga : vagas) {
 %> 
  		Carga Horaria: <%=vaga.getCarga_horaria()%><br>
  		Remuneração: <%= vaga.getRemuneracao()%><br>
  		Requisistos: <%=vaga.getRequisitos()%><br>
  	
<% }%>
</form>


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