<c:import url="/HeaderServlet" />
</body>
<head>
<title>Accueil Agent Guichet</title>
</head>
<body>
	<fieldset>
		<legend>Rechercher une erreur</legend>
		<form method="get" action="#">

			<label for="dateDebut">Date de début :</label> <input type="text"
				name="dateDebut" id="dateDebut" tabindex="10" /> <span
				class="erreur">${this.erreurs['dateDebut'] }</span> <label
				for="dateFin">Date de fin :</label> <input type="text"
				name="dateFin" id="dateFin" tabindex="20" /> <span class="erreur">${this.erreurs['dateFin']
				}</span> <label for="typeErreur">Type d'erreur :</label> <select
				name="typeErreur" id="typeErreur" tabindex="30">
				<option value=""></option>
				<c:forEach var="typeEnCours" items="${this.typesErreurs}">
					<option value="${typeEnCours.codeTypeErreur}">${typeEnCours.nomTypeErreur}</option>
				</c:forEach>
			</select> <span class="erreur">${this.erreurs['typeErreur'] }</span>

			<label for="statusRegularisationRecherche">Statut :</label> <select
				name="statusRegularisationRecherche"
				id="statusRegularisationRecherche" tabindex="40">
				<option value=""></option>
				<c:forEach var="statusEnCours" items="${this.statusRegularisation}">
					<option value="${statusEnCours.codeStatusRegularisation}">${statusEnCours.nomStatusRegularisation}</option>
				</c:forEach>
			</select> <span class="erreur">${this.erreurs['statusRegularisationRecherche']
				}</span> <input type="submit" value="Rechercher" /> <span class="erreur">${this.erreurs['noResult']
				}</span> <span class="erreur">${this.erreurs['bdd'] }</span>

		</form>
		<span class="erreur">${this.erreurs['droit'] }</span>
	</fieldset>

	<c:if test="${!empty this.erreursCaisse }">
		<table id="myTable" class="tablesorter">
			<thead>
				<tr>
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
						<td><c:choose>
								<c:when
									test="${erreur.typeErreur.codeTypeErreur == 'E' && erreur.montant <= 5}">
									<c:choose>
										<c:when
											test="${erreur.statusRegularisation.codeStatusRegularisation == 0}">
											<c:set var="url" value="RegulariserServlet" />
										</c:when>
										<c:otherwise>
											<c:set var="url" value="ListeRegularisationsServlet" />
										</c:otherwise>
									</c:choose>
									<a
										href="<c:url
								value="${ url }">
								<c:param name="erreurCaisseId" value="${erreur.erreurCaisseId}" />
								<c:param name="codeStatusRegularisation" value="${erreur.statusRegularisation.codeStatusRegularisation}" />
							</c:url>">
										<c:out value="${erreur.erreurCaisseId}" />
									</a>
								</c:when>
								<c:otherwise>
									<c:out value="${erreur.erreurCaisseId}" />
								</c:otherwise>
							</c:choose></td>
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
</body>
</html>