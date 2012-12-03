<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Agent Comptable</title>
<link
	href=<c:url value="/jquery-ui-1.9.2.custom/css/redmond/jquery-ui-1.9.2.custom.css" />
	rel="stylesheet">
<script src=<c:url value="/jquery-ui-1.9.2.custom/js/jquery-1.8.3.js" />></script>
<script
	src=<c:url value="/jquery-ui-1.9.2.custom/js/jquery-ui-1.9.2.custom.js" />></script>

<link
	href=<c:url value="/table-sorter/themes/blue/style.css" />
	rel="stylesheet">	
<script type="text/javascript"
	src=<c:url value="/table-sorter/jquery.tablesorter.js" />></script>

<script>
	$(function() {
		$("#dateDebut").datepicker({
			dateFormat : "dd/mm/yy"
		});
		$("#dateFin").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});

	$("button").button();

	$(document).ready(function() {
		$("#myTable").tablesorter({sortList: [[1,0], [5,0]]});
	});
</script>

<style type="text/css">
body {
	font: 62.5% "Trebuchet MS", sans-serif;
	margin: 50px;
}

.ui-state-error {
	margin-top: .3em;
	width: 50%;
	align: center;
	margin-top: .3em;
}

label {
	display: block;
	width: 150px;
	float: left;
}

</style>

</head>
<body>
	<c:import url="/HeaderServlet" />
	<fieldset>
		<legend>Rechercher une erreur</legend>
		<form method="get" action="#">

			<table>
				<tr>
					<td><label for="dateDebut">Date de début :</label> <input
						type="text" name="dateDebut" id="dateDebut" tabindex="10" /></td>
					<td><label for="dateFin">Date de fin :</label> <input
						type="text" name="dateFin" id="dateFin" tabindex="20" /></td>
				</tr>
				<tr>
					<td><label for="typeErreur">Type d'erreur :</label> <select
						name="typeErreur" id="typeErreur" tabindex="30">
							<option value=""></option>
							<c:forEach var="typeEnCours" items="${this.typesErreurs}">
								<option value="${typeEnCours.codeTypeErreur}">${typeEnCours.nomTypeErreur}</option>
							</c:forEach>
					</select></td>
					<td><label for="statusRegularisationRecherche">Statut
							:</label> <select name="statusRegularisationRecherche"
						id="statusRegularisationRecherche" tabindex="40">
							<option value=""></option>
							<c:forEach var="statusEnCours"
								items="${this.statusRegularisation}">
								<option value="${statusEnCours.codeStatusRegularisation}">${statusEnCours.nomStatusRegularisation}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><label for="agentID">N° Agent :</label> <input type="text"
						name="agentID" id="agentID" tabindex="50" /></td>
					<td><label for="agenceID">N° Agence :</label> <input
						type="text" name="agenceID" id="agenceID" tabindex="60" /></td>
				</tr>
			</table>
			<div class="erreur">
				<c:if test="${not empty this.erreurs['dateDebut']}">
					<div class="ui-widget">
						<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin-right: .3em;"> </span>${this.erreurs['dateDebut']
								}
							</p>
						</div>
					</div>
				</c:if>

				<c:if test="${not empty this.erreurs['dateFin']}">
					<div class="ui-widget">
						<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin-right: .3em;"> </span>${this.erreurs['dateFin']}
							</p>
						</div>
					</div>
				</c:if>
				<c:if test="${not empty this.erreurs['typeErreur']}">
					<div class="ui-widget">
						<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin-right: .3em;"> </span>${this.erreurs['typeErreur']}
							</p>
						</div>
					</div>
				</c:if>

				<c:if
					test="${not empty this.erreurs['statusRegularisationRecherche']}">
					<div class="ui-widget">
						<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin-right: .3em;"> </span>${this.erreurs['statusRegularisationRecherche']}
							</p>
						</div>
					</div>
				</c:if>

				<c:if test="${not empty this.erreurs['agentID']}">
					<div class="ui-widget">
						<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin-right: .3em;"> </span>${this.erreurs['agentID']}
							</p>
						</div>
					</div>
				</c:if>

				<c:if test="${not empty this.erreurs['agenceID']}">
					<div class="ui-widget">
						<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin-right: .3em;"> </span>${this.erreurs['agenceID']}
							</p>
						</div>
					</div>
				</c:if>

				<c:if test="${not empty this.erreurs['noResult']}">
					<div class="ui-widget">
						<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin-right: .3em;"> </span>${this.erreurs['noResult']}
							</p>
						</div>
					</div>
				</c:if>
				<c:if test="${not empty this.erreurs['bdd']}">
					<div class="ui-widget">
						<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin-right: .3em;"> </span>${this.erreurs['bdd']}
							</p>
						</div>
					</div>
				</c:if>

				<c:if test="${not empty this.erreurs['droit']}">
					<div class="ui-widget">
						<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin-right: .3em;"> </span>${this.erreurs['droit']}
							</p>
						</div>
					</div>
				</c:if>
			</div>

			<input type="submit" value="Rechercher" /> <input type="submit"
				value="Réinitialiser" name="reset" />
		</form>

	</fieldset>

	<c:if test="${!empty this.erreursCaisse }">
		<table id="myTable" class="tablesorter">
			<thead>
				<tr>
					<th>N° Agence</th>
					<th>N° Agent</th>
					<th>N° Erreur</th>
					<th>Type Erreur</th>
					<th>Status Regularisation</th>
					<th>Date</th>
					<th>Montant</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="erreur" items="${this.erreursCaisse}">
					<tr>
						<td>
								<c:out value="${erreur.agence.codeAgence}" />
						</td>
						<td><a
							href="<c:url	value="AccueilAgentComptableServlet">
								<c:param name="agentID" value="${erreur.agent.codeAgent}" />
							</c:url>">
								<c:out value="${erreur.agent.codeAgent}" />
						</a></td>
						<td><c:choose>
								<c:when
									test="${erreur.statusRegularisation.codeStatusRegularisation == 0}">
									<c:set var="url" value="RegulariserServlet" />
								</c:when>
								<c:otherwise>
									<c:set var="url" value="ListeRegularisationsServlet" />
								</c:otherwise>
							</c:choose> <a
							href="<c:url
								value="${ url }">
								<c:param name="erreurCaisseId" value="${erreur.erreurCaisseId}" />
								<c:param name="codeStatusRegularisation" value="${erreur.statusRegularisation.codeStatusRegularisation}" />
							</c:url>">
								<c:out value="${erreur.erreurCaisseId}" />
						</a></td>
						<td><c:out value="${erreur.typeErreur.nomTypeErreur}" /></td>
						<td><c:out
								value="${erreur.statusRegularisation.nomStatusRegularisation}" /></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy"
								value="${erreur.dateVacation}" /></td>
						<td><c:out value="${erreur.montant}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<a href="<c:url value="DeclarerErreurServlet"></c:url>">Declarer
		une erreur de caisse </a>
</body>
</html>