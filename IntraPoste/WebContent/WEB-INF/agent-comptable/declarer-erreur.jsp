<c:import url="/HeaderServlet" />
</body>
<head>
<style>
form label {
	float: left;
	width: 100px;
	margin: 3px 0px 0px 0px;
}
</style>
<title>Déclarer erreur</title>
</head>
<body>
	<fieldset>
		<legend>Déclarer une erreur</legend>
		<form method="post" action="#">

			<label for="codeAgent">Code Agent :</label> <input type="text"
				name="codeAgent" id="codeAgent" tabindex="10" /> <br> <br>
			<label for="typeErreur">Type d'erreur :</label> <select
				name="typeErreur" id="typeErreur" tabindex="30">
				<c:forEach var="typeEnCours" items="${this.typesErreurs}">
					<option value="${typeEnCours.codeTypeErreur}">${typeEnCours.nomTypeErreur}</option>
				</c:forEach>
			</select>

			<%-- 			<span class="erreur">${this.erreurs['typeErreur'] }</span>  --%>
			<br> <br> <label for="montant">Montant :</label> <input
				type="text" name="montant" id="montant" tabindex="40" />
				
			<div class="erreur">
				<c:if test="${not empty this.erreurs['codeAgent']}">
					<div class="ui-widget">
						<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin-right: .3em;"> </span>${this.erreurs['codeAgent']}
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
				<c:if test="${not empty this.erreurs['montant']}">
					<div class="ui-widget">
						<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin-right: .3em;"> </span>${this.erreurs['montant']}
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

			<br> <br> <input type="submit" value="Declarer" />

		</form>
	</fieldset>

</body>
</html>