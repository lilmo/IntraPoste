<c:import url="/HeaderServlet" />
</body>
<head>
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
			<span>Reste à regulariser : <c:out value="${ this.reste }" /></span>
			<label for="montant">Montant :</label> <input type="text"
				name="montant" id="montant" tabindex="10" /> <label for="motif">Motif
				:</label> <select name="motif" id="motif" tabindex="30">
				<option value=""></option>
				<c:forEach var="motifEnCours" items="${this.motifs}">
					<option value="${motifEnCours.codeMotifRegularisation}">${motifEnCours.nomMotifRegularisation}</option>
				</c:forEach>
				<option value="-1">Autre</option>
			</select> <label for="autreMotif">Autre motif :</label> <input type="text"
				name="autreMotif" id="autreMotif" tabindex="10" /> <input
				type="submit" value="Regulariser" />
		</form>
		<c:out value="${this.erreur }"></c:out>
	</fieldset>

</body>
</html>