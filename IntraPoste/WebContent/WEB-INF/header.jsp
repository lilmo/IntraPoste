<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href=<c:url value="/jquery-ui-1.9.2.custom/css/redmond/jquery-ui-1.9.2.custom.css" />
	rel="stylesheet">
<script src=<c:url value="/jquery-ui-1.9.2.custom/js/jquery-1.8.3.js" />></script>
<script
	src=<c:url value="/jquery-ui-1.9.2.custom/js/jquery-ui-1.9.2.custom.js" />></script>

<link href=<c:url value="/table-sorter/themes/blue/style.css" />
	rel="stylesheet">
<script type="text/javascript"
	src=<c:url value="/table-sorter/jquery.tablesorter.js" />></script>

<script>
	$(function() {
		$("#dateDebut").datepicker({
			dateFormat : "dd/mm/yy"
		});
		$("#dateFin").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});

	$("button").button();

	$(document).ready(function() {
		$("#myTable").tablesorter({
			sortList : [ [ 1, 0 ], [ 5, 0 ] ]
		});
	});
</script>

<style type="text/css">
/* Général ------------------------------------------------------------------------------------- */
body {
	margin: auto;
	margin-top: 100px;
	width: 1024px;
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
}

.ui-state-error {
	margin-top: .3em;
	width: 50%;
	align: center;
	margin-top: .3em;
}

.aDroite {
	text-align: right;
	margin: 0;
}
</style>
</head>
<body>
	<p class="aDroite">
		Bienvenue ${prenomAgent} ${nomAgent} <br> <a class="aDroite"
			href="<c:url value="DeconnexionServlet" />">Deconnexion</a>
	</p>
	<a
		href="
	<c:if test="${ typeAgent == 0 }">
		<c:url value="#"/>
	</c:if>
	<c:if test="${ typeAgent == 1 }">
		<c:url value="AccueilAgentComptableServlet"/>
	</c:if>
	<c:if test="${ typeAgent == 2 }">
		<c:url value="AccueilAgentGuichetServlet"/>
	</c:if>
	 ">Accueil</a>
	 <br><br>