<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Policía Nacional - Servicios Antinarcóticos</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/css/bootstrap.min.css">
<link href="stylePolicia.css" rel="stylesheet" type="text/css" />

</head>

<body>
	<div class="header">
		<h1>Policía Nacional - Servicios Antinarcóticos</h1>
	</div>
	<div class="container">
		<div class="actions">
			<h2>Formulario de Policía</h2>
			<form>
				<div class="mb-3">
					<label for="nombre" class="form-label">Nombre:</label> <input
						type="text" class="form-control" id="nombre" required
						autocomplete="off">
				</div>
				<div class="mb-3">
					<label for="edad" class="form-label">Edad:</label> <input
						type="number" class="form-control" id="edad" required
						autocomplete="off">
				</div>
				<div class="mb-3">
					<label for="fechaEntrada" class="form-label">Fecha de
						Entrada:</label> <input type="date" class="form-control" id="fechaEntrada"
						required autocomplete="off">
				</div>
				<div class="mb-3">
					<label for="rango" class="form-label">Rango:</label> <input
						type="text" class="form-control" id="rango" required
						autocomplete="off">
				</div>
				<div class="mb-3">
					<label for="redadas" class="form-label">Numero de redadas:</label>
					<input type="number" class="form-control" id="redadas" required
						autocomplete="off">
				</div>
				<button type="submit"
					onclick="agregarColaborador(obtenerValor('nombre'), obtenerValor('edad'), obtenerValor('entrada'), obtenerValor('rango'), obtenerValor('numero_redadas'))"
					class="btn btn-primary">Agregar</button>
			</form>
			<br>
			<h2>Eliminar Policía</h2>
			<form>
				<div class="mb-3">
					<label for="idEliminar" class="form-label">ID:</label> <input
						type="text" class="form-control" id="idEliminar" required>
				</div>
				<button type="submit" onclick="eliminarPolicia(obtenerValor('id'))"
					class="btn btn-danger">Eliminar</button>
			</form>
			<br>
			<h2>Actualizar Policía</h2>
			<form>
				<div class="mb-3">
					<label for="idActualizar" class="form-label">ID:</label> <input
						type="text" class="form-control" id="idActualizar" required>
				</div>
				<div class="mb-3">
					<label for="nombreActualizar" class="form-label">Nombre:</label> <input
						type="text" class="form-control" id="nombreActualizar" required
						autocomplete="off">
				</div>
				<div class="mb-3">
					<label for="edadActualizar" class="form-label">Edad:</label> <input
						type="number" class="form-control" id="edadActualizar" required
						autocomplete="off">
				</div>
				<div class="mb-3">
					<label for="fechaEntradaActualizar" class="form-label">Fecha
						de Entrada:</label> <input type="date" class="form-control"
						id="fechaEntradaActualizar" required autocomplete="off">
				</div>
				<div class="mb-3">
					<label for="rangoActualizar" class="form-label">Rango:</label> <input
						type="text" class="form-control" id="rangoActualizar" required
						autocomplete="off">
				</div>
				<button type="submit"
					onclick="actualizarPolicia(obtenerValor('id'), obtenerValor('nombre'), obtenerValor('edad'), obtenerValor('entrada'), obtenerValor('rango'), obtenerValor('numero_redadas'))"
					class="btn btn-warning">Actualizar</button>
			</form>
			<br>
			<h2>Listado de Policías</h2>
			<button type="submit" onclick="get_policia()" class="btn btn-secondary">Mostrar
				policias</button>
			<br> <br>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/js/bootstrap.bundle.min.js"></script>
</body>

</html>