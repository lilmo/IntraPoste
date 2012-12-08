<c:import url="/HeaderServlet" />
</body>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		$("#datePeriode").prop('disabled', true);
	});
	function change() {
		if ($("input[type='radio']:checked").attr('id') == "radiojournee") {
			$("#datePeriode").prop('disabled', true);
			$("#dateJournee").prop('disabled', false);
		} else {
			$("#datePeriode").prop('disabled', false);
			$("#dateJournee").prop('disabled', true);
		}
	};
</script>
<title>Bilan</title>
</head>
<body>
	<fieldset>
		<legend>Voir le bilan de l'agence</legend>
		<form method="get" action="BilanServlet">

			<input type="radio" name="checkDate" value="journee"
				id="radiojournee" checked onClick="change()"> Pour la
			journée <input type="text" name="dateJournee" id="dateJournee"
				tabindex="10" /> <input type="radio" name="checkDate"
				value="periode" onClick="change()"> Pour la période jusqu'au
			<input type="text" name="datePeriode" id="datePeriode" tabindex="20" />

			<label for="typeErreur">Type d'erreur :</label> <select
				name="typeErreur" id="typeErreur" tabindex="30">
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
			</select> <input type="submit" value="Rechercher" />
		</form>
		<div class="erreur">
			<c:if test="${not empty this.erreurs['dateJournee']}">
				<div class="ui-widget">
					<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
						<p>
							<span class="ui-icon ui-icon-alert"
								style="float: left; margin-right: .3em;"> </span>${this.erreurs['dateJournee']}
						</p>
					</div>
				</div>
			</c:if>

			<c:if test="${not empty this.erreurs['datePeriode']}">
				<div class="ui-widget">
					<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
						<p>
							<span class="ui-icon ui-icon-alert"
								style="float: left; margin-right: .3em;"> </span>${this.erreurs['datePeriode']}
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
	</fieldset>
	<c:if test="${this.soldeAgence != -8280}">
		<fieldset class="droite">
			<legend>Bilan</legend>
			<c:if test="${this.dateDebut != null}">
		Bilan du
			<fmt:formatDate pattern="dd/MM/yyyy" value="${this.dateDebut}" />
			au
			<fmt:formatDate pattern="dd/MM/yyyy" value="${this.dateFin}" />
			</c:if>
			Agence : ${this.agenceAgent.nomAgence}<br> Solde erreurs :
			${this.soldeAgence}

		</fieldset>
	</c:if>
</body>
</html>