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
<title>Lisää uusi sana</title>
<link rel="stylesheet" type="text/css"
	href="../resources/main.css">
</head>
<body>
<p><a href="../j_spring_security_logout" style="float: right;"> Kirjaudu ulos</a></p>
<h3>Sisäänkirjautuneena: <sec:authentication property="principal.username"/></h3>

	<div class="div">
		<form:form modelAttribute="sana" method="post">
		  	<fieldset>		
				<legend><spring:message code="sana.create.legend" /></legend>
				
				<spring:hasBindErrors name="sana">
					<p class="Virheotsikko"><spring:message code="sana.create.errors" />:</p>
					<div class="Virheblokki"><form:errors path="*"/></div>
				</spring:hasBindErrors>
				
			<p>
					<form:label path="sana"><spring:message code="sana.create.word" /></form:label><br/>
					<form:input path="sana" cssErrorClass="VirheellinenKentta"/> <br>
					<form:errors path="sana" cssClass="Virheteksti"/>		
			</p>
			
			<p>
					<form:label path="seloste"><spring:message code="sana.create.description" /></form:label><br/>
					<form:input path="seloste" cssErrorClass="VirheellinenKentta"/> <br>
					<form:errors path="seloste" cssClass="Virheteksti"/>		
			</p>
					<form:label	path="kayttaja_id"><spring:message code="sana.create.user" /></form:label><br/>
					<select name="kayttaja_id">
						<c:forEach var="data" items="${kayttajat}">
							<option value=${data.id} >${data.nimi}</option>
						</c:forEach>
					</select>
					<form:errors path="kayttaja_id" cssClass="Virheteksti"/>	
			
			<p><button type="submit" class="button"><spring:message code="sana.create.add" /></button></p>
			
		</fieldset>
		</form:form>
		<a href="main" ><button class="button">Peruuta</button></a>
	</div>	



</body>
</html>