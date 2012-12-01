<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bilan</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>
	$(function() {
		$("#dateJournee").datepicker({
			dateFormat : "dd/mm/yy"
		});
		$("#datePeriode").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
</script>
</head>
<body>
	<c:import url="/HeaderServlet" />
	<fieldset>
		<legend>Recherche le bilan d'une agence</legend>
		<form method="get" action="#">

			<label for="codeAgence">N° Agence :</label> <input type="text"
				name="codeAgence" id="codeAgence" tabindex="60" /> 	
			<span class="erreur">${this.erreurs['agenceId']}</span>
			
			<input type="radio" name="checkDate" value="journee" checked>Pour la journée
			<input type="text" name="dateJournee" id="dateJournee" tabindex="10" /> 
				<span class="erreur">${this.erreurs['dateJournee'] }</span> 
			<input type="radio" name="checkDate" value="periode">Pour la période jusqu'au
			<input type="text" name="datePeriode" id="datePeriode" tabindex="20" /> 
				<span class="erreur">${this.erreurs['datePeriode']}</span> 
			
			<label for="typeErreur">Type d'erreur :</label> 
			<select name="typeErreur" id="typeErreur" tabindex="30">
				<option value=""></option>
				<c:forEach var="typeEnCours" items="${this.typesErreurs}">
					<option value="${typeEnCours.codeTypeErreur}">${typeEnCours.nomTypeErreur}</option>
				</c:forEach>
			</select> 
			<span class="erreur">${this.erreurs['typeErreur'] }</span>

			<label for="statusRegularisationRecherche">Statut :</label> 
			<select	name="statusRegularisationRecherche" id="statusRegularisationRecherche" tabindex="40">
				<option value=""></option>
				<c:forEach var="statusEnCours" items="${this.statusRegularisation}">
					<option value="${statusEnCours.codeStatusRegularisation}">${statusEnCours.nomStatusRegularisation}</option>
				</c:forEach>
			</select> 
			<span class="erreur">${this.erreurs['statusRegularisationRecherche']}</span>
			
			<input type="submit" value="Rechercher" /> 
			<span class="erreur">${this.erreurs['noResult']}</span> 
			<span class="erreur">${this.erreurs['bdd'] }</span>

		</form>
	</fieldset>
		<fieldset>
			<legend>Bilan</legend>
			Bilan du <fmt:formatDate pattern="dd/MM/yyyy" value="${this.recherche.dateDebut}" /> 
			au <fmt:formatDate pattern="dd/MM/yyyy"	value="${this.recherche.dateFin}" />  
			Agence  : ${this.recherche.agence.nomAgence}
			Solde erreurs : ${this.soldeAgence}
		</fieldset>
</body>
</html>