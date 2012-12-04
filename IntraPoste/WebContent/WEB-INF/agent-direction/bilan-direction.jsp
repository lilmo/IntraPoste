<c:import url="/HeaderServlet" />
</body>
<head>
<title>Bilan</title>
</head>
<body>
	<fieldset>
		<legend>Recherche le bilan d'une agence</legend>
		<form method="get" action="#">

			<label for="codeAgence">N� Agence :</label> <input type="text"
				name="codeAgence" id="codeAgence" tabindex="60" /> <span
				class="erreur">${this.erreurs['agenceId']}</span>

			<c:choose>
				<c:when
					test="${erreur.statusRegularisation.codeStatusRegularisation == 0}">
					<c:set var="url" value="RegulariserServlet" />
				</c:when>
				<c:otherwise>
					<c:set var="url" value="ListeRegularisationsServlet" />
				</c:otherwise>
			</c:choose>
			<input type="radio" name="checkDate" value="journee" checked>
			Pour la journ�e <input type="text" name="dateJournee"
				id="dateJournee" tabindex="10" /> <span class="erreur">${this.erreurs['dateJournee']}</span>

			<input type="radio" name="checkDate" value="periode"> Pour la
			p�riode jusqu'au <input type="text" name="datePeriode"
				id="datePeriode" tabindex="20" /> <span class="erreur">${this.erreurs['datePeriode']}</span>

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

			<input type="submit" value="Rechercher" /> <span class="erreur">${this.erreurs['noResult']}</span>
			<span class="erreur">${this.erreurs['bdd'] }</span> <span
				class="erreur">${this.erreurs['droit']}</span>
		</form>
	</fieldset>
	<fieldset class="droite">
		<legend>Bilan</legend>
		<c:if test="${this.dateDebut != null}">
			Bilan du
			<fmt:formatDate pattern="dd/MM/yyyy" value="${this.dateDebut}" />
			au
			<fmt:formatDate pattern="dd/MM/yyyy" value="${this.dateFin}" />
		</c:if>
		Agence : ${this.agenceAgent.nomAgence}<br>
		<c:if test="${this.soldeAgence != null}">
		Solde erreurs :
		${this.soldeAgence}
		</c:if>
	</fieldset>
</body>
</html>