<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Regulariser erreur n°<c:out
		value="${this.erreurCaisseId}" /></title>
</head>
<body>

	<fieldset>
		<legend>
			Regulariser erreur n° <c:out value="${this.erreurCaisseId}" />
		</legend>
		<form method="post" action="#">
			<span>Reste à regulariser : <c:out value="${ this.reste }" /></span>
			<label for="montant">Montant :</label> 
			<input type="text"
				name="montant" id="montant" tabindex="10" /> 
			<label
				for="motif">Motif :</label> 
			<select name="motif"
				id="motif" tabindex="30">
				<option value=""></option>
				<c:forEach var="motifEnCours" items="${this.motifs}">
					<option value="${motifEnCours.codeMotifRegularisation}">${motifEnCours.nomMotifRegularisation}</option>
				</c:forEach>
				<option value="-1">Autre</option>
			</select> 
			<label for="autreMotif">Autre motif :</label> 
			<input type="text"
				name="autreMotif" id="autreMotif" tabindex="10" /> 
			<input type="submit" value="Regulariser" />
		</form>
	</fieldset>

</body>
</html>