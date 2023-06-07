function get_redada() {
	var url = "http://localhost:8081/sebasapi/redada";
	var xhr = new XMLHttpRequest()
	xhr.open('GET', url, true)
	xhr.send(null);
}

function get_policia() {
	var url = "http://localhost:8081/sebasapi/policia";
	var xhr = new XMLHttpRequest()
	xhr.open('GET', url, true)
	xhr.send(null);
}


function agregarRedada(fecha_ejecucion, hora_inicio, hora_final, cantidadCapturados, tipo_narcotico, peso_narcotico, nombresPolicias) {
	var url = "http://localhost:8081/sebasapi/redada?fecha_ejecucion=" + fecha_ejecucion + "&hora_inicio=" + hora_inicio + "&hora_final=" + hora_final + "&cantidadCapturados=" + cantidadCapturados + "&tipo_narcotico=" + tipo_narcotico + "&peso_narcotico=" + peso_narcotico + "&nombresPolicias=" + nombresPolicias;

	var xhr = new XMLHttpRequest()
	xhr.open('POST', url, true)
	xhr.onload = function() {
		if (xhr.readyState == 4 && xhr.status == "201") {
			imprimirDatos(xhr.responseText);
		} else {
			imprimirDatos(xhr.responseText);
		}
	}
	xhr.send(url);
}

function agregarPolicia(nombre, edad, entrada, rango, numero_redadas) {
	var url = "http://localhost:8081/sebasapi/policia?nombre=" + nombre + "&edad=" + edad + "&entrada=" + entrada + "&rango=" + rango + "&numero_redadas=" + numero_redadas;

	var xhr = new XMLHttpRequest()
	xhr.open('POST', url, true)
	xhr.onload = function() {
		if (xhr.readyState == 4 && xhr.status == "201") {
			imprimirDatos(xhr.responseText);
		} else {
			imprimirDatos(xhr.responseText);
		}
	}
	xhr.send(url);
}

function actualizarRedada(id, fecha_ejecucion, hora_inicio, hora_final, cantidadCapturados, tipo_narcotico, peso_narcotico, nombresPolicias) {
	var url = "http://localhost:8081/sebasapi/redada/" + id + "?fecha_ejecucion=" + fecha_ejecucion + "&hora_inicio=" + hora_inicio + "&hora_final=" + hora_final + "&cantidadCapturados=" + cantidadCapturados + "&tipo_narcotico=" +  tipo_narcotico + "&peso_narcotico=" + peso_narcotico + "&nombresPolicias=" + nombresPolicias;

	var xhr = new XMLHttpRequest()
	xhr.open('PUT', url, true)
	xhr.send(url);
}

function actualizarPolicia(id, nombre, edad, entrada, rango, numero_redadas) {
	var url = "http://localhost:8081/sebasapi/policia/" + id + "?nombre=" + nombre + "&edad=" + edad + "&entrada=" + entrada + "&rango=" + rango + "&redadas=" + numero_redadas;

	var xhr = new XMLHttpRequest()
	xhr.open('PUT', url, true)
	xhr.send(url);
}

function eliminarRedada(id) {
	var url = "http://localhost:8081/sebasapi/redada/" + id;

	var xhr = new XMLHttpRequest()
	xhr.open('DELETE', url, true)
	xhr.onload = function() {
		if (xhr.readyState == 4 && xhr.status == "201") {
			imprimirDatos(xhr.responseText);
		} else {
			imprimirDatos(xhr.responseText);
		}
	}
	xhr.send(url);
}

function eliminarPolicia(id) {
	var url = "http://localhost:8081/sebasapi/policia/" + id;

	var xhr = new XMLHttpRequest()
	xhr.open('DELETE', url, true)
	xhr.onload = function() {
		if (xhr.readyState == 4 && xhr.status == "201") {
			imprimirDatos(xhr.responseText);
		} else {
			imprimirDatos(xhr.responseText);
		}
	}
	xhr.send(url);
}

function change_page(url) {
	window.location.href = url;
}

function obtenerValor(id) {
      var input = document.getElementById(id);
      var valor = input.value;
      return valor;
    }

function convertirFechaFormato(fecha) {
  var partesFecha = fecha.split("-");
  var dia = partesFecha[0];
  var mes = partesFecha[1];
  var anio = partesFecha[2];

  // Concatenar las partes de la fecha en el formato yyyy-mm-dd
  var fechaFormatted = anio + "-" + mes + "-" + dia;

  return fechaFormatted;
}

