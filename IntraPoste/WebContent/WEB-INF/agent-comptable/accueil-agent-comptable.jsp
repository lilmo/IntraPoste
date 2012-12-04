<c:import url="/HeaderServlet" />
</body>
<head>
<title>Accueil Agent Comptable</title>
</head>
<fieldset>
	<legend>Rechercher une erreur</legend>
	<form method="get" action="#">

		<label for="dateDebut">Date de début :</label> <input type="text"
			name="dateDebut" id="dateDebut" tabindex="10" /> <label
			for="dateFin">Date de fin :</label> <input type="text" name="dateFin"
			id="dateFin" tabindex="20" /> <label for="typeErreur">Type
			d'erreur :</label> <select name="typeErreur" id="typeErreur" tabindex="30">
			<option value=""></option>
			<c:forEach var="typeEnCours" items="${this.typesErreurs}">
				<option value="${typeEnCours.codeTypeErreur}">${typeEnCours.nomTypeErreur}</option>
			</c:forEach>
		</select> <label for="statusRegularisationRecherche">Statut :</label> <select
			name="statusRegularisationRecherche"
			id="statusRegularisationRecherche" tabindex="40">
			<option value=""></option>
			<c:forEach var="statusEnCours" items="${this.statusRegularisation}">
				<option value="${statusEnCours.codeStatusRegularisation}">${statusEnCours.nomStatusRegularisation}</option>
			</c:forEach>
		</select> 
		<br><label for="agentID">N° Agent :</label> <input type="text"
			name="agentID" id="agentID" tabindex="50" />

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
<br>
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
					<td><c:out value="${erreur.agence.codeAgence}" /></td>
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
<form method="get" action="DeclarerErreurServlet">
	<input type="submit" value="Declarer une erreur de caisse" />
</form>
</body>
</html>