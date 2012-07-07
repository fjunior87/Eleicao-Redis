<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Candidatos</title>
</head>
<body >
	<div id="message">${message }</div>
	<a href="<c:url value="/candidato/form"/>">Adicionar Candidato</a>
	<div id="candidatos">
	</div>	
	<script type="text/javascript" src="<c:url value="/js/jquery-1.7.2.min.js"/> "></script>
	<script type="text/javascript">
		var candidatosJson = ${jsonList};
		$(document).ready(function(){
			for(var i = 0; i< candidatosJson.length;i++){
				var candidato = candidatosJson[i];
				var nome = candidato.candidato.nome;
				var numero = candidato.candidato.numero;
				var resumo = candidato.candidato.resumo;
				var html = "<div class='candidato'>";
				html += numero + " - " + nome + "<hr/>";
				html += "</div>";
				$("#candidatos").append(html);		
			}
		});
		
	</script>
</body>
</html>