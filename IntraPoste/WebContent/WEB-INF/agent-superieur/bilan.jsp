<c:import url="/HeaderServlet" />
</body>
<head>
<style type="text/css">
.gauche {
	width: 46%;
	float: left;
}

.droite {
	width: 46%;
	float: right;
}
</style>
<title>Bilan</title>
</head>
<body>
	<fieldset class="gauche">
		<legend>Voir le bilan de l'agence</legend>
		<form method="get" action="#">

			<input type="radio" name="checkDate" value="journee" checked>Pour
			la journée <input type="text" name="dateJournee" id="dateJournee"
				tabindex="10" /> <span class="erreur">${this.erreurs['dateJournee']
				}</span> <input type="radio" name="checkDate" value="periode">Pour
			la période jusqu'au <input type="text" name="datePeriode"
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