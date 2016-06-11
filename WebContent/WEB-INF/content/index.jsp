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
								<li class="active"><a href="#">Home</a></li>
								<li><a href="<s:url action="list-cat-vehicules"/>">Catégories véhicules</a></li>
								<li><a href="#">Contact</a></li>
							</ul>
						</nav>
					</div>
				</div>

				<div class="inner cover">
					<h1 class="cover-heading">Bienvenue sur le site de la mobilité
						2.0</h1>
					<p class="lead">Louez au lieu d'acheter et faites des économies</p>
				</div>

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