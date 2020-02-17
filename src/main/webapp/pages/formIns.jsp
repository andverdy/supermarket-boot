<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Articoli</title>
</head>
<body>

	<br>
	<br>

	<h1>&nbsp&nbsp&nbsp&nbsp&nbsp GESTIONE ARTICOLI SUPERMARKET</h1>
	
	<br>
	<br>
	<form method="post">
		<label for="cod">Codice Articolo</label><br>
		 <input id="cod" type="text" name="codice" value="${articleFormRefresh.codArt}"><br>
		 
		<br> <label for="descr">Descrizione</label><br> 
		<input id="descr" type="text" name="descriz" value="${articleFormRefresh.descrizione}"><br> <br>
		
		<label for="pz">Pezzi per cartone</label><br> 
		<input id="pz" name="pezziCart" value="${articleFormRefresh.pzCart}"><br>
		
		<br> <label for="cod">Iva</label><br> 
				<select name="iva">

					<c:forEach items="${ivaList}" var="varIva">
						<c:choose>

							<c:when test="${articleFormRefresh.idIva == varIva.idIva}">
								<option selected="selected"  value="${varIva.idIva}">${varIva.descrizione}</option>
        					 </c:when>

							 <c:otherwise>
							 	<option value="${varIva.idIva}">${varIva.descrizione}</option>
         					</c:otherwise>
						
						</c:choose>
			</c:forEach>

		</select> <br> <br> <label for="cod">Famiglia Assortimento</label><br>
		<select name="fam">
			<c:forEach items="${listFms}" var="varFamAssort">
					<c:choose>

							<c:when test="${articleFormRefresh.idFamAss == varFamAssort.id}">
								<option selected="selected" value="${varFamAssort.id}">${varFamAssort.descrizione}</option>
        					 </c:when>

							 <c:otherwise>
							 	<option value="${varFamAssort.id}">${varFamAssort.descrizione}</option>
         					</c:otherwise>
						
						</c:choose>
				
			</c:forEach>
		</select> <br> <br> <br>
	 
		<button  formaction="insArt">Inserisci Articolo</button>
	
	
	</form>

</body>

<p></p>
</html>