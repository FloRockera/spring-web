<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<link rel="stylesheet" href="create_message.css">
<title>HumanContact</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>


</head>

<body>

	<!-- Liste des onglets -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Admin<span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="#">Chat</a></li>
			</ul>
		</div>

	</nav>


	

	<!-- Formulaire d'ajout d'un nouveau message -->
	<div class="container">
	<h3>Créer un message</h3>

		<c:url var="formAction"
			value="${requestScope['javax.servlet.forward.servlet_path']}/admin/messages/new" />


		<form:form method="POST" action="${formAction}"
			modelAttribute="message" id="CreationForm">

			<form:errors path="*" cssClass="invalid-feedback"
				cssStyle="display:block" />

			<div class="form-row">

				<!-- Saisir l'expéditeur-->
				<div class="col">
					<label for="fromUser">Utilisateur expéditeur</label>
					<form:input path="fromUser" class="form-control" id="fromUser"
						placeholder="Expéditeur" />
					<form:errors path="fromUser" cssClass="invalid-feedback"
						cssStyle="display:block" />
				</div>

				<div class="w-100"></div>

				<!-- Saisir le destinataires -->
				<div class="col">
					<label for="toUser">Utilisateur destinataire</label>
					<form:input path="toUser" class="form-control" id="toUser"
						placeholder="Destinataire" />
					<form:errors path="toUser" cssClass="invalid-feedback"
						cssStyle="display:block" />
				</div>

				<div class="w-100"></div>

				<!-- Saisir le message -->
				<div class="col">
					<label for="content">Message</label>
					<form:textarea path="content" class="form-control" id="content"
						placeholder="Message" rows="3" />
					<form:errors path="content" cssClass="invalid-feedback"
						cssStyle="display:block" />
				</div>
			</div>
			<button type="submit" class="btn btn-primary" onclick="document.getElementById('CreationForm')">Valider</button>
		</form:form>
	</div>


</body>
</html>