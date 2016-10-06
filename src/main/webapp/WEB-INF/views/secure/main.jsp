<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sanasovellus</title>
<link rel="stylesheet" type="text/css"
	href="../resources/main.css">
</head>
<body>
<a href="LisaaSana"><button class="button">Lis�� uusi sana</button></a>
<a href="LisaaUusiKayttaja"><button class="button">Lis�� uusi k�ytt�j�</button></a>
<a href="../j_spring_security_logout" style="float: right;"><button class="button"> Kirjaudu ulos</button></a><br>
<span style="float: right;">Sis��nkirjautuneena: <sec:authentication property="principal.username"/></span>


<sec:authorize access="hasRole('ROLE_ADMIN')">
<%-- Admin h�ss�k�t t�h�n --%>
</sec:authorize>

<div class="container1">
	<div class="cardSanamaara">
				<div class="cardHeader">Sanoja lis�nneet</div>
				<c:forEach var="data" items="${pisteet}">
				<div class="cardData>">${data.sana_maara} ${data.nimi}</div>
				</c:forEach>
						

	</div>

	<div class="card">
		
		<div class="cardHeader">Sanalistaus</div>
				<c:forEach var="sanat_data" items="${sanat}">
				<div class="card">
				<div class="cardHeader">
				${sanat_data.timestamp} / ${sanat_data.kayttaja.nimi}</div>
				Sana: <span class="sana"> ${sanat_data.sana} </span>
				Seloste: <span class="sana"> ${sanat_data.seloste}</span>
				</div>
				</c:forEach>
				
	</div>
	
	
	
</div>

</body>
</html>