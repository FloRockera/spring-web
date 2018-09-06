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


	<h2>Formulaire</h2>

	<!-- Formulaire -->
	<div class="container">
		<h2>Créer un nouveau message</h2>

		<!-- Formulaire d'ajout d'un nouveau message -->
		<c:url var="formAction"
			value="${requestScope['javax.servlet.forward.servlet_path']}/messages/new">
			<form:form modelAttribute="messages" action="${formAction}">

				<form:errors path="*" cssClass="errorBox" />

				<div class="row">

					<!-- Saisir l'expéditeur-->
					<div class="col label">
						<label for="fromUserInput">Utilisateur expéditeur</label>
					</div>
					<div class="col input">
						<form:input class="form-control" path="fromUser"
							id="fromUserInput" type="text"
							placeholder="Utilisateur expéditeur" required />
					</div>
					<div class="invalid-feedback">L'utilisateur expéditeur est
						obligatoire</div>


					<div class="w-100"></div>

					<!-- Saisir le destinataires -->
					<div class="col label">
						<label for="toUserInput">Utilisateur destinataire</label>
					</div>
					<div class="col input">
						<form:input class="form-control" path="toUser" id="toUserInput"
							type="text" placeholder="Utilisateur destinataire" required />
					</div>
					<div class="invalid-feedback">L'utilisateur destinataire est
						obligatoire</div>

					<div class="w-100"></div>

					<!-- Saisir le message -->
					<div class="col label">
						<label for="contentInput">Message</label>
					</div>
					<div class="col input">
						<form:input class="form-control" path="content" id="content"
							type="text" placeholder="Message" required />
					</div>
					<div class="invalid-feedback">Le message est obligatoire</div>


					<div class="w-100"></div>

				</div>


				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#exampleModal">Créer</button>

			</form:form>
		</c:url>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Création d'un
						message</h5>
					<div class="w-100"></div>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Vous êtes sur le point de créer un
					nouveau message</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fermer</button>
					<button type="button" class="btn btn-primary">Valider</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>