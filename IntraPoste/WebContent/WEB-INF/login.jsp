<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Autres propri�t�s de "page" : 
          language="..." 
          extends="..." 
          import="..." 
          session="true | false" 
          buffer="none | 8kb | sizekb" 
          autoFlush="true | false" 
          isThreadSafe="true | false" 
          isELIgnored ="true | false"
          info="..." 
          errorPage="..." 
          contentType="..." 
          pageEncoding="..."
          isErrorPage="true | false" -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Identification</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<p>Ceci est une page g�n�r�e depuis une JSP.</p>

	<!-- R�cup�ration d'un attribut sett� dans le servlet -->
	<%
		String attribut = (String) request.getAttribute("test");
		out.println(attribut);
	%>
	<br>

	<!-- R�cup�ration d'un param�tre GET (depuis l'url) -->
	<%
		String parametre = request.getParameter("auteur");
		out.println("parametre : " + parametre);
	%>

	<!-- Ecrit une chaine de caract�res -->
	<%="<br>Bip bip !"%>

</body>
</html>