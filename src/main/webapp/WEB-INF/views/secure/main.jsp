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
<title>Pääsivu</title>
<link rel="stylesheet" type="text/css"
	href="../resources/main.css">
</head>
<body>
<p><a href="../j_spring_security_logout" style="float: right;"> Kirjaudu ulos</a></p>
<h3>Sisäänkirjautuneena: <sec:authentication property="principal.username"/></h3>


<sec:authorize access="hasRole('ROLE_ADMIN')">
<p><a href="admin/tools">Admin tools</a></p>
</sec:authorize>

	<div class="tableDiv">
		
			<table class="printTable">
				<tr>
					<th colspan="2">Sanoja lisänneet</th>
				</tr>
				<tr><td>Kpl</td><td>Nimi</td>
				<c:forEach var="data" items="${pisteet}">
				<tr>
					<td><span>${data.sana_maara}</span></td>
					<td><span>${data.nimi}</span></td>
				</tr>
				</c:forEach>			
			</table>
	</div>

	<div class="tableDiv">
		
			<table class="printTable">
				<tr>
					<th colspan="4"> Sanalistaus</th>
				</tr>
				<tr>
				<td>Aikaleima</td><td>Sana</td><td>Seloste</td><td>Lisääjä</td>
				<c:forEach var="sanat_data" items="${sanat}">
				<tr>
					<td><span>${sanat_data.timestamp}</span></td>
					<td><span>${sanat_data.sana}</span></td>
					<td><span>${sanat_data.seloste}</span></td>
					<td><span>${sanat_data.kayttaja.nimi}</span></td>
					
				</tr>
				</c:forEach>			
			</table>
	</div>



</body>
</html>