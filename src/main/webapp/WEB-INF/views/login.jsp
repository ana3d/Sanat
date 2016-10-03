<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Sisäänkirjautuminen</title>
<link rel="stylesheet" href="resources/main.css" type="text/css" />
</head>
<body>
	<div id="tableDiv">
	<h1>KIRJAUDU SISÄÄN</h1>

	<c:if test="${not empty loginerror}">
		<p class="Error">Sisäänkirjautuminen epäonnistui. Käyttäjätunnus tai salasana on syötetty väärin.</p>
	</c:if>

	<c:if test="${not empty loggedout}">
		<p class="Info">Uloskirjautuminen onnistui</p>
	</c:if>
	
	<form action="j_spring_security_check" method="post">
	<fieldset>
		<table class=printTable>
		<tr><td>Käyttäjätunnus:</td><td><input type='text' name='j_username' value=''></td></tr>
		<tr><td>Salasana:</td><td><input type='password' name='j_password' /></td></tr>
		<tr><td colspan="2" align="right"><button type="submit" class="button">Kirjaudu</button></td></tr>
		</table>
	</fieldset>
	</form>
	</div>
</body>
</html>