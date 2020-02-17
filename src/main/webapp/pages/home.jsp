<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supermarket</title>
</head>

<body>

		<form method="get">
		<button  name="cartView" formaction="viewArticlesToCart">Visualizza Carrello</button>
		</form>


	<h1>
		&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		&nbsp &nbsp &nbsp&nbsp &nbsp  --|| SUPERMARKET SHOP ONLINE ||--
	</h1>


	&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp
	&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp
	&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp
	&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp
	
          <p>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
           &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp${message}
          </p>
          <p>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
           &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp ${messageInsertCart}
          </p>
          
	<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>

	<form method="get">
		<button  formaction="formView">Inserisci Nuovo Articolo</button>		
	</form> <br>


	<table>
		<tr>
			<th>Codice Articolo</th>
			<th>Descrizione</th>
			<th>PzCart</th>
			<th>Iva</th>
			<th>FamAssort</th>
		</tr>

		<c:forEach items="${articleList}" var="article">
			<tr>
				<td>&nbsp&nbsp&nbsp&nbsp&nbsp ${article.codArt}
					&nbsp&nbsp&nbsp</td>

				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					${article.descrizione}
				</td>

				<td>&nbsp&nbsp&nbsp&nbsp&nbsp
					${article.pzCart}&nbsp&nbsp&nbsp&nbsp

				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					${article.ivaDesc}
					</td>

				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					${article.famAssDesc}</td>

				<td>
					<form method="post">
						<button value="${article.codArt}" name="getCod" formaction="formView">Modifica Articolo</button>
					</form> 
				</td>
				<td>
					<form method="post">
						<button value="${article.codArt}" name="codArt" formaction="addCart">Aggiungi al Carrello</button>
					</form>
				</td>
				</tr>	
		</c:forEach>

	</table>
</body>
</html>