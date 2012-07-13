<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultados</title>

<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript">
google.load("visualization", '1',{packages:['corechart']});
google.setOnLoadCallback(drawChart);
var candidatos = ['Votos'];
var votes = ['2012'];
function drawChart(){
	var data = google.visualization.arrayToDataTable(
	[candidatos,votes]
	);

	new google.visualization.ColumnChart(document.getElementById("chart")).draw(
		data,{title:"Resultados da Apuracao", width:"600",height:"400", hAxis:{title:"Votos"}}			
	);
}
</script>
 
</head>
<body >

	<c:set var="total" value="0" />
	<h2>Resultados ate o momento</h2>
	<div id="chart"></div>
	
	<script type="text/javascript">
	<c:forEach items="${tupleList}" var="candidato">
		candidatos.push('${candidato.element}');
		votes.push(${candidato.score});	
		<c:set var="total" value="${total + candidato.score}"	/>
	</c:forEach>
	</script>

	Total: ${total }
</body>
</html>