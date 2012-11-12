<%@page import="action.LoginPageAction"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<body>
	<!--    <div id='login'>-->
	<fieldset>
		<s:form method="post" action="LoginPage" namespace="/">
			<s:textfield label="Identifiant" name="login" />
			<s:password label="Mot de passe" name="password" size="32"
				maxlength="32" />
			<s:label name="error" />
			<s:submit value="Valider" />
		</s:form>
	</fieldset>
	<!--    </div>-->
</body>
</html>
