<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Agent Guichet</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td>N° Erreur</td>
				<td>Type Erreur</td>
				<td>Status Regularisation</td>
				<td>Date</td>
				<td>Montant</td>
			</tr>
		</thead>
		<tbody>
				<c:forEach var="erreur" items="${erreurs}">
				<tr>
					<td><c:out value="${erreur.erreurCaisseId}" /></td>
					<td><c:out value="${erreur.typeErreur.nomTypeErreur}" /></td>
					<td><c:out value="${erreur.statusRegularisation.nomStatusRegularisation}" /></td>
					<td><c:out value="${erreur.dateVacation}" /></td>
					<td><c:out value="${erreur.montant}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>