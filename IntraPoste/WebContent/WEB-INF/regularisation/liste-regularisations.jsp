<c:import url="/HeaderServlet" />
</body>
<head>
<title>Liste des regularisations de l'erreur n°<c:out
		value="${this.erreurCaisseId}" /></title>
</head>
<body>
	<fieldset>
		<legend>
			Liste des regularisations de l'erreur n°
			<c:out value="${this.erreurCaisseId}" />
			<c:choose>
				<c:when test="${this.codeStatusRegularisation == 1}">
					<span>- Partiellement régularisée</span>
				</c:when>
				<c:otherwise>
					<span>- Totalement régularisée</span>
				</c:otherwise>
			</c:choose>
		</legend>

		<c:forEach var="erreurEnCours" items="${this.erreurs}">
			<span class="erreur">${erreurEnCours}</span>
		</c:forEach>

		<c:if test="${!empty this.regularisations}">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th>N° Agent Régularisateur</th>
						<th>Date</th>
						<th>Motif</th>
						<th>Type Regularisation</th>
						<th>Montant</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="regularisation" items="${this.regularisations}">
						<tr>
							<td><c:out
									value="${regularisation.agentRegularisateur.codeAgent}" /></td>
							<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm"
									value="${regularisation.timestamp}" /></td>
							<td><c:out
									value="${regularisation.motifRegularisation.nomMotifRegularisation}" /></td>
							<td><c:out
									value="${regularisation.typeRegularisation.nomTypeRegularisation}" /></td>
							<td><c:out value="${regularisation.montantRegularisation}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if
			test="${this.codeStatusRegularisation == 1 && this.agent.typeAgent.codeTypeAgent == 1}">
			<form method="get" action="RegulariserServlet">
				<input type="hidden" name="erreurCaisseId" id="erreurCaisseId"
					value="${this.erreurCaisseId}" /> <input type="submit"
					value="Regulariser l'erreur">
			</form>
			<%-- <a
				href="<c:url value="/RegulariserServlet"> 
					<c:param name="erreurCaisseId" value="${this.erreurCaisseId}" />
				</c:url>">
				Regulariser l'erreur </a> --%>
		</c:if>
	</fieldset>

</body>
</html>