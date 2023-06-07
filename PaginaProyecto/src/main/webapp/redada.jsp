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
<link href="styleRedada.css" rel="stylesheet" type="text/css" />

</head>

<body>
	<div class="header">
		<h1>Policía Nacional - Servicios Antinarcóticos</h1>
	</div>
	<div class="container">
		<div class="description"></div>
		<div class="actions">
			<h2>Ingresar Redada</h2>
			<form>
				<div class="mb-3">
					<label for="fechaEjecucion" class="form-label">Fecha de
						Ejecución:</label> <input type="date" class="form-control"
						id="fechaEjecucion" name="fechaEjecucion" required>
				</div>
				<div class="mb-3">
					<label for="horaInicio" class="form-label">Hora de Inicio:</label>
					<input type="time" class="form-control" id="horaInicio"
						name="horaInicio" required>
				</div>
				<div class="mb-3">
					<label for="horaFinal" class="form-label">Hora Final:</label> <input
						type="time" class="form-control" id="horaFinal" name="horaFinal"
						required>
				</div>
				<div class="mb-3">
					<label for="cantidadCapturados" class="form-label">Cantidad
						de Capturados:</label> <input type="number" class="form-control"
						id="cantidadCapturados" name="cantidadCapturados" required>
				</div>
				<div class="mb-3">
					<label for="narcotico" class="form-label">Narcótico:</label> <input
						type="text" class="form-control" id="narcotico" name="narcotico"
						required>
				</div>
				<div class="mb-3">
					<label for="peso" class="form-label">Peso:</label> <input
						type="number" step="0.01" class="form-control" id="peso"
						name="peso" required>
				</div>
				<div class="mb-3">
					<label for="nombrePolicia" class="form-label">Nombre de
						Policía:</label> <input type="text" class="form-control"
						id="nombrePolicia" name="nombrePolicia" required>
				</div>
				<button type="submit"
					onclick="agregarRedada(obtenerValor('fecha_ejecucion'), obtenerValor('hora_inicio'), obtenerValor('hora_final'), obtenerValor('cantidadCapturados'), obtenerValor('tipo_narcotico'), obtenerValor('peso_narcotico'), obtenerValor('nombresPolicias'))"
					class="btn btn-primary">Ingresar</button>
			</form>

			<h2>Eliminar Redada</h2>
			<form>
				<div class="mb-3">
					<label for="idEliminar" class="form-label">ID de Redada:</label> <input
						type="text" class="form-control" id="idEliminar" name="idEliminar"
						required>
				</div>
				<button type="submit" onclick="eliminarRedada(obtenerValor('id'))" class="btn btn-danger">Eliminar</button>
			</form>

			<h2>Actualizar Redada</h2>
			<form>
				<div class="mb-3">
					<label for="idActualizar" class="form-label">ID de Redada:</label>
					<input type="text" class="form-control" id="idActualizar"
						name="idActualizar" required>
				</div>
				<!-- Aquí van los campos a actualizar, similares al formulario de ingreso -->
				<button type="submit" onclick="actualizarRedada(obtenerValor('id'), obtenerValor('fecha_ejecucion'), obtenerValor('hora_inicio'), obtenerValor('hora_final'), obtenerValor('cantidadCapturados'), obtenerValor('tipo_narcotico'), obtenerValor('peso_narcotico'), obtenerValor('nombresPolicias'))" class="btn btn-warning">Actualizar</button>
			</form>

			<h2>Listado de Redadas</h2>
			<button type="submit" onclick="get_redada()" class="btn btn-secondary">Mostrar
				Redadas</button>

		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/js/bootstrap.bundle.min.js"></script>
</body>

</html>