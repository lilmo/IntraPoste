<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Déclarer erreur</title>
</head>
<body>
	<fieldset>
		<legend>Déclarer une erreur</legend>
		<form method="post" action="#">

			<label for="codeAgent">Code Agent :</label> 
			<input type="text" name="codeAgent" id="codeAgent" tabindex="10" /> 
				
			<label for="typeErreur">Type d'erreur :</label> 
			<select name="typeErreur" id="typeErreur" tabindex="30">
				<c:forEach var="typeEnCours" items="${this.typesErreurs}">
					<option value="${typeEnCours.codeTypeErreur}">${typeEnCours.nomTypeErreur}</option>
				</c:forEach>
			</select> 
			
<%-- 			<span class="erreur">${this.erreurs['typeErreur'] }</span>  --%>
			
			<label for="montant">Type d'erreur :</label> 
			<input type="text" name="montant" id="montant" tabindex="40" /> 

			<input type="submit" value="Declarer" /> 

		</form>
		<span class="erreur">${this.erreurs['droit'] }</span>
	</fieldset>

</body>
</html>