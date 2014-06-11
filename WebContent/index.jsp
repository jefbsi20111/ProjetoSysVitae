<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${empty vagas}">
	<h3>Nenhuma vaga encontrada.</h3><br>		
</c:if>

<c:forEach items="${vagas}" var="vaga">
  	
  	
    Descrição: ${vaga.descricao}<br>
    Remuneração: ${vaga.remuneracao} R$<br>
    Requisitos: ${vaga.requisitos}<br>
    Carga Horaria: ${vaga.carga_horaria} horas<br>
    <hr>
</c:forEach>

</body>
</html>