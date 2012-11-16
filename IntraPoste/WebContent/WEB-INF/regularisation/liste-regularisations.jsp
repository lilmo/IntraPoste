<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des regularisations de l'erreur n°<c:out
		value="${this.erreurCaisseId}" /></title>
</head>
<body>
	<h1>
		Liste des regularisations de l'erreur n°
		<c:out value="${this.erreurCaisseId}" />
		<c:choose>
			<c:when test="${codeStatusRegularisation == 1}">
				<span>Partiellement régularisée</span>
			</c:when>
			<c:otherwise>
				<span>Totalement régularisée</span>
			</c:otherwise>
		</c:choose>
	</h1>

	<c:out value="${this.erreur }"></c:out>

	<table border="1">
		<thead>
			<tr>
				<td>N° Agent Régularisateur</td>
				<td>Date</td>
				<td>Motif</td>
				<td>Type Regularisation</td>
				<td>Montant</td>
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

	<!-- TODO: Verifier le code agent en session -->
	<c:if test="${this.codeStatusRegularisation == 1}">
		<a
			href="<c:url value="RegulariserServlet"> 
					<c:param name="erreurCaisseId" value="${this.erreurCaisseId}" />
				</c:url>">
			Regulariser l'erreur </a>
	</c:if>

</body>
</html>