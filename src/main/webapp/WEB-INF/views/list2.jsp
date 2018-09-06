<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<link rel="stylesheet" href="list.css">
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

	<div class=container>
		<h2>Administration des messages</h2>

		<!-- Liste avec itération -->

		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">Expéditeur</th>
					<th scope="col">Destinataire</th>
					<th scope="col">Message</th>
					<th scope="col">Date et heure</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${messages}" var="variable">
					<tr>
						<td><c:out value="${variable.fromUser}" /></td>

						<td><c:out value="${variable.toUser}" /></td>

						<td><c:out value="${variable.content}" /></td>

						<td><c:out value="${variable.eventTime}" /></td>

						<td><div class="btn-group btn-group-toggle"
								data-toggle="modal" data-target="#exampleModal">

								<label class="btn btn-secondary active"> <input
									type="radio" name="options" id="edit" autocomplete="off"
									checked> Editer
								</label> <label class="btn btn-secondary"> <input type="radio"
									name="options" id="delete" autocomplete="off">
									Supprimer
								</label>

							</div></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="CreationFormulaire">Création d'un
						message</h5>
					<div class="w-100"></div>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Vous êtes sur le point de créer un
					nouveau message</div>

				<!-- Formulaire d'ajout d'un nouveau message -->
				<div class="container">
					<form class="needs-validation" novalidate>
						<div class="form-row">

							<!-- Saisir l'expéditeur-->
							<div class="col-md-4 mb-3">
								<label for="validationExp">Utilisateur expéditeur</label> <input
									type="text" class="form-control" id="validationExp"
									placeholder="Utilisateur expéditeur" required>
								<div class="invalid-feedback">L'utilisateur expéditeur est
									obligatoire</div>
							</div>

							<div class="w-100"></div>

							<!-- Saisir le destinataires -->
							<div class="col-md-4 mb-3">
								<label for="validationDest">Utilisateur destinataire</label> <input
									type="text" class="form-control" id="validationDest"
									placeholder="Utilisateur destinataire" required>
								<div class="invalid-feedback">L'utilisateur destinataire
									est obligatoire</div>
							</div>

							<div class="w-100"></div>

							<!-- Saisir le message -->
							<div class="col-md-4 mb-3">
								<label for="validationMsg">Message</label> <input type="text"
									class="form-control" id="validationMsg" placeholder="Message"
									required>
								<div class="invalid-feedback">Le message est obligatoire</div>
							</div>
						</div>
					</form>
				</div>

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