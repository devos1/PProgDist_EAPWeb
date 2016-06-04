<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des catégories de véhicules</title>
</head>
<body>
	<h1>Liste des catégories de véhicules</h1>
	<table border="1">
		<s:iterator value="catVehicules">
			<tr>
				<td><s:property value="nomCategorie" /></td>
				<td><s:property value="prixUnitaire" /></td>
				<td><s:property value="prixKM" /></td>
				<td><s:property value="unite" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>