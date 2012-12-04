<c:import url="/HeaderServlet" />
</body>
<head>
<style>
label {
	width: 150px;
}
</style>
<title>Regulariser erreur n°<c:out
		value="${this.erreurCaisseId}" /></title>
</head>
<body>
	<fieldset>
		<legend>
			Regulariser erreur n°
			<c:out value="${this.erreurCaisseId}" />
		</legend>
		<form method="post" action="#">
			<span>Reste à regulariser : <c:out value="${ this.reste }" />
				&#8364;
			</span><br>
			<br> <label class="myLabel" for="montant">Montant :</label> <input type="text"
				name="montant" id="montant" tabindex="10" /> <br>
			<br>
			<label class="myLabel" for="motif">Motif :</label> <select name="motif" id="motif"
				tabindex="30">
				<option value=""></option>
				<c:forEach var="motifEnCours" items="${this.motifs}">
					<option value="${motifEnCours.codeMotifRegularisation}">${motifEnCours.nomMotifRegularisation}</option>
				</c:forEach>
				<option value="-1">Autre</option>
			</select> <br>
			<br> <label class="myLabel" for="autreMotif">Autre motif :</label> <input
				type="text" name="autreMotif" id="autreMotif" tabindex="10" /> <br>
			<br>
			<input type="submit" value="Regulariser" />
		</form>
		<c:out value="${this.erreur }"></c:out>
	</fieldset>

</body>
</html>