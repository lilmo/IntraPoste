<title>Identification</title>
</head>
<body>
	<fieldset>
		<legend>Identification</legend>
		<form method="post" action="#">
			<label for="Identifiant">Code agent :</label> <input type="text"
				name="codeAgent" id="codeAgent" /> <label for="motDePasse">"Mot
				de passe"</label> <input type="password" id="motDePasse" name="motDePasse"
				size="32" maxlength="32" />
			<c:out value="${this.erreur }" />
			<input type="submit" value="Connexion" />
		</form>
	</fieldset>

</body>
</html>