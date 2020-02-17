<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<h1>Il tuo Carrello Acquisti</h1>
	<br>
	<br>
	<br>

	<form method="get">
		<button formaction="getArticles">HOME</button>
	</form>
	<br>


	<table>

		<c:forEach items="${cart}" var="article">
			<tr>
				<td>Codice Articolo = ${article.key}, &nbsp &nbsp &nbsp &nbsp</td>
				<td>Descrizione = ${article.value.descrizione} &nbsp &nbsp
					&nbsp &nbsp</td>
				<td>Iva = ${article.value.ivaDesc} &nbsp &nbsp</td>
				<td>Famiglia Assortimento = ${article.value.famAssDesc} &nbsp
					&nbsp &nbsp &nbsp</td>
				<td>Quantita = ${article.value.quantita} &nbsp &nbsp &nbsp
					&nbsp</td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>