<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Votação</title>
</head>
<body >
	<form action="<c:url value="/urna/votar"/>" method="post">
	<c:forEach items="${numbers}" var="number">
	<input type="radio" name="numero" value="${number }"/> ${number}
	</c:forEach>
	<input type="submit" value="Votar"/>
	</form>
</body>
</html>