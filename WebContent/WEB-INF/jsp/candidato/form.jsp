<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar Candidato</title>
</head>
<body>
	<div id="message">${message }</div>
	<form action="<c:url value="/candidato/adiciona"/>" method="post">
	    Nome: <input type="text" name="candidato.nome" /><br/>
	    Numero: <input type="text" name="candidato.numero" /><br/>
	    Resumo: <input type="text" name="candidato.resumo" /><br/>
	    <input type="submit" value="Salvar" />
	</form>
</body>
</html>