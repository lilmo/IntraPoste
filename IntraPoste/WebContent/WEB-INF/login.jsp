<title>Identification</title>
<style type="text/css">
/* Général ------------------------------------------------------------------------------------- */
body {
	margin: auto;
	margin-top: 100px;
	width: 350px;
}

body,p,legend,label,input {
	font: normal 8pt verdana, helvetica, sans-serif;
}

fieldset {
	padding: 10px;
	border: 1px #0568CD solid;
}

legend {
	font-weight: bold;
	color: #0568CD;
}

/* Forms --------------------------------------------------------------------------------------- */
form input {
	margin: 3px 3px 0px 0px;
	border: 1px #999 solid;
	width: 150px;
}

label {
	width: 300px;
}

.ui-state-error {
	margin-top: .3em;
	width: 50%;
	align: center;
	margin-top: .3em;
}
</style>
</head>
<body>
	<fieldset>
		<legend>Identification</legend>
		<form method="post" action="#">
			<label for="Identifiant">Code agent :</label> <input type="text"
				name="codeAgent" id="codeAgent" /> <br><br> <label for="motDePasse">Mot
				de passe :</label> <input type="password" id="motDePasse" name="motDePasse"
				size="32" maxlength="32" />
			<c:out value="${this.erreur }" />
			<br><br>
			<input type="submit" value="Connexion" />
		</form>
	</fieldset>

</body>
</html>