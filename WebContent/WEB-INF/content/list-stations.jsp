<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MobiOsLo</title>

<!-- Bootstrap core CSS -->
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="Bootstrap/css/style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="site-wrapper">
		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">MobiOsLo</h3>
						<nav>
						<ul class="nav masthead-nav">
							<li><a href="./">Home</a></li>
							<li class="active"><a href="<s:url action="list-stations"/>">Stations</a></li>
							<li><a href="<s:url action="list-cat-vehicules"/>">Catégories
									véhicules</a></li>
							<li><a href="#">Contact</a></li>
						</ul>
						</nav>
					</div>
				</div>

				<h1>Liste des stations</h1>
				<%--<a class="btn btn-success btn-sm" style="margin-bottom: 5px;" href="<s:url action="edit-cat-vehicule"/>"> Ajouter une station</a> --%>
										
				<table class="table table-stripped">
					<tr>
						<th class="text-center">Nom</th>
						<th class="text-center">Pays</th>
						<th class="text-center">Ville</th>
						<th class="text-center">Autos diponibles</th>
						<th class="text-center">Vélos disponibles</th>
						<th class="text-center">Places libres</th>
						<th></th>
						<th></th>
					</tr>
					<s:iterator value="stations">
						<tr>
							<td><s:property value="nom" /></td>
							<td><s:property value="pays" /></td>
							<td><s:property value="ville" /></td>
							<td><s:property value="NbAutosDispos" /></td>
							<td><s:property value="NbVelosDispo" /></td>
							<td><s:property value="placesLibres" /></td>
							<td><s:url action="gerer-location" var="urlText">
									<s:param name="stationId" value="id"/>
								</s:url> <a class="btn btn-success btn-xs btn-block"
								href="<s:property value="urlText"/>&action=louer" >Louer</a></td>
							<td><s:url action="gerer-location" var="urlText2">
									<s:param name="stationId" value="id"/>
								</s:url> <a class="btn btn-info btn-xs btn-block"
								href="<s:property value="urlText2"/>&action=rendre"">Rendre</a></td>
						</tr>
					</s:iterator>
				</table>

				<div class="mastfoot">
					<div class="inner">
						<p>
							Réalisé par Oscar da Silva & Loic Brait <a href="www.heig-vd.ch">Heig-VD</a>,
							&copy; 2016</a>
						</p>
					</div>
				</div>

			</div>

		</div>

	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="Bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
