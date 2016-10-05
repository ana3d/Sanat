<%@ page language="java" contentType="text/html; charset=UTF-16"
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
<title>Lisää käyttäjä</title>
<link rel="stylesheet" type="text/css"
	href="../resources/main.css">
</head>
<body>
<p><a href="../j_spring_security_logout" style="float: right;"> Kirjaudu ulos</a></p>
<h3>Sisäänkirjautuneena: <sec:authentication property="principal.username"/></h3>

	<div class="div">
		<form:form modelAttribute="kayttaja" method="post">
		  	<fieldset>		
				<legend><spring:message code="kayttaja.create.legend" /></legend>
				
				<spring:hasBindErrors name="kayttaja">
					<p class="Virheotsikko"><spring:message code="kayttaja.create.errors" />:</p>
					<div class="Virheblokki"><form:errors path="*"/></div>
				</spring:hasBindErrors>
				
			<p>
					<form:label path="nimi"><spring:message code="kayttaja.create.new_user" /></form:label><br/>
					<form:input path="nimi" cssErrorClass="VirheellinenKentta"/> <br>
					<form:errors path="nimi" cssClass="Virheteksti"/>		
			</p>
			
			<p><button type="submit" class="button"><spring:message code="kayttaja.create.add" /></button></p>
			
		</fieldset>
		</form:form>
		<a href="main"><button class="button">Peruuta</button></a>
	</div>	



</body>
</html>