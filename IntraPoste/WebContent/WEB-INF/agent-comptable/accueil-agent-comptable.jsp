<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Agent Comptable</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>
	$(function() {
		$("#dateDebut").datepicker({
			dateFormat : "dd/mm/yy"
		});
		$("#dateFin").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
</script>
</head>
<body>
	<c:import url="/HeaderServlet" />
	<fieldset>
		<legend>Rechercher une erreur</legend>
		<form method="get" action="#">

			<label for="dateDebut">Date de début :</label> <input type="text"
				name="dateDebut" id="dateDebut" tabindex="10" /> <span
				class="erreur">${this.erreurs['dateDebut'] }</span> <label
				for="dateFin">Date de fin :</label> <input type="text"
				name="dateFin" id="dateFin" tabindex="20" /> <span class="erreur">${this.erreurs['dateFin']}</span>

			<label for="typeErreur">Type d'erreur :</label> <select
				name="typeErreur" id="typeErreur" tabindex="30">
				<option value=""></option>
				<c:forEach var="typeEnCours" items="${this.typesErreurs}">
					<option value="${typeEnCours.codeTypeErreur}">${typeEnCours.nomTypeErreur}</option>
				</c:forEach>
			</select> <span class="erreur">${this.erreurs['typeErreur'] }</span> <label
				for="statusRegularisationRecherche">Statut :</label> <select
				name="statusRegularisationRecherche"
				id="statusRegularisationRecherche" tabindex="40">
				<option value=""></option>
				<c:forEach var="statusEnCours" items="${this.statusRegularisation}">
					<option value="${statusEnCours.codeStatusRegularisation}">${statusEnCours.nomStatusRegularisation}</option>
				</c:forEach>
			</select> <span class="erreur">${this.erreurs['statusRegularisationRecherche']}</span>

			<label for="agentId">N° Agent :</label> <input type="text"
				name="agentId" id="agentId" tabindex="50" /> <span class="erreur">${this.erreurs['agentId']
				}</span> <label for="agenceId">N° Agence :</label> <input type="text"
				name="agenceId" id="agenceId" tabindex="60" /> <span class="erreur">${this.erreurs['agenceId']}</span>

			<input type="submit" value="Rechercher" /> <span class="erreur">${this.erreurs['noResult']
				}</span> <span class="erreur">${this.erreurs['bdd'] }</span> <a
				href="<c:url	value="AccueilAgentComptableServlet">
								<c:param name="reset" value="true" />
							</c:url>">
				Réinitialiser </a>

		</form>
		<span class="erreur">${this.erreurs['droit'] }</span>
	</fieldset>

	<c:if test="${!empty this.erreursCaisse }">
		<table border="1">
			<thead>
				<tr>
					<td>N° Agence</td>
					<td>N° Agent</td>
					<td>N° Erreur</td>
					<td>Type Erreur</td>
					<td>Status Regularisation</td>
					<td>Date</td>
					<td>Montant</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="erreur" items="${this.erreursCaisse}">
					<tr>
						<td><a
							href="<c:url	value="AccueilAgentComptableServlet">
								<c:param name="agenceID" value="${erreur.agence.codeAgence}" />
							</c:url>">
								<c:out value="${erreur.agence.codeAgence}" />
						</a></td>
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