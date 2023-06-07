package co.edu.unbosque.ProyectoProgramacion.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unbosque.ProyectoProgramacion.model.Policia;
import co.edu.unbosque.ProyectoProgramacion.model.Redada;
import co.edu.unbosque.ProyectoProgramacion.repository.PoliciaRepository;
import co.edu.unbosque.ProyectoProgramacion.repository.RedadaRepository;

@RestController
@CrossOrigin(origins = "*") // desde que maquinas se puede conectar
@RequestMapping("/sebasapi") // separar

public class RedadaController {

	@Autowired // que cualquier operacion que se realice utilice solo 1 instancia
	private RedadaRepository rr;
	@Autowired
	private PoliciaRepository pr;

	@PostMapping("/redada")
	public ResponseEntity<String> agregarRedada(@RequestParam String fecha_ejecucion, @RequestParam String hora_inicio,
			@RequestParam String hora_final, @RequestParam int cantidadCapturados, @RequestParam String tipo_narcotico,
			@RequestParam double peso_narcotico, @RequestParam ArrayList<String> nombresPolicias) {

		Redada redada = new Redada();

		DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");

		try {
			LocalDate fechaEjecucionParsed = LocalDate.parse(fecha_ejecucion, fechaFormatter);
			LocalTime horaInicioParsed = LocalTime.parse(hora_inicio, horaFormatter);
			LocalTime horaFinalParsed = LocalTime.parse(hora_final, horaFormatter);

			redada.setFecha_ejecucion(fechaEjecucionParsed);
			redada.setHora_inicio(horaInicioParsed);
			redada.setHora_final(horaFinalParsed);
			redada.setCantidad_capturados(cantidadCapturados);
			redada.setTipo_narcotico(tipo_narcotico);
			redada.setPeso_narcotico(peso_narcotico);

			// Obtener los objetos Policia a partir de los nombres
			List<Policia> policias = nombresPolicias.stream().map(nombre -> {
				List<Policia> existentes = pr.findAllByNombre(nombre);
				if (!existentes.isEmpty()) {
					// Puedes manejarlo de diferentes maneras, como tomar el primer resultado o
					// lanzar una excepción
					return existentes.get(0);
				}
				throw new RuntimeException("El policía '" + nombre + "' no existe.");
			}).collect(Collectors.toList());
			redada.setNombresPolicias(policias); // Opcional: puedes eliminar la lista de nombres de policias si ya no
													// la
													// necesitas

			rr.save(redada);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Redada creada con éxito: 201");
		} catch (DateTimeParseException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al convertir las fechas y horas.");
		}
	}

	@PostMapping("/policia")
	public ResponseEntity<String> agregarPolicia(@RequestParam String nombre, @RequestParam int edad,
			@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate entrada, @RequestParam String rango, @RequestParam int numero_redadas) {

		Policia temp = new Policia();
		temp.setNombre(nombre);
		temp.setEdad(edad);
		temp.setEntrada(entrada);
		temp.setRango(rango);
		temp.setNumero_redadas(numero_redadas);

		pr.save(temp);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Policia: " + nombre + " creado con exito: 201");

	}

	@GetMapping("/redada")
	public ResponseEntity<List<Redada>> mostrarRedadas() {
		List<Redada> lista = rr.findAll();

		if (lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(lista);
	}

	@GetMapping("/policia")
	public ResponseEntity<List<Policia>> mostrarPolicias() {

		List<Policia> lista = pr.findAll();

		if (lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

		}

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(lista);
	}

	@DeleteMapping("/redada/{id}")
	public ResponseEntity<String> eliminarRedada(@PathVariable Long id) {
	    Optional<Redada> redadaExistente = rr.findById(id);
	    
	    if (redadaExistente.isPresent()) {
	        Redada redada = redadaExistente.get();
	        
	        rr.delete(redada);
	        
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Redada eliminada con éxito");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la redada con el ID proporcionado");
	    }
	}

	@DeleteMapping("/policia/{id}")
	public ResponseEntity<String> eliminarPolicia(@PathVariable Long id) {
	    Optional<Policia> policiaExistente = pr.findById(id);
	    
	    if (policiaExistente.isPresent()) {
	        Policia policia = policiaExistente.get();
	        
	        pr.delete(policia);
	        
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Policía eliminado con éxito");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el policía con el ID proporcionado");
	    }
	}

	@PutMapping("/redada/{id}")
	public ResponseEntity<String> actualizarRedada(@PathVariable Long id, @RequestParam String fecha_ejecucion,
			@RequestParam String hora_inicio, @RequestParam String hora_final, @RequestParam int cantidadCapturados,
			@RequestParam String tipo_narcotico, @RequestParam double peso_narcotico,
			@RequestParam ArrayList<String> nombresPolicias) {
		Optional<Redada> redadaExistente = rr.findById(id);

		if (redadaExistente.isPresent()) {
			Redada redada = redadaExistente.get();

			DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");

			LocalDate fechaEjecucionParsed = LocalDate.parse(fecha_ejecucion, fechaFormatter);
			LocalTime horaInicioParsed = LocalTime.parse(hora_inicio, horaFormatter);
			LocalTime horaFinalParsed = LocalTime.parse(hora_final, horaFormatter);

			// Actualizar todos los campos de la redada existente con los valores de la
			// redada actualizada
			redada.setFecha_ejecucion(fechaEjecucionParsed);
			redada.setHora_inicio(horaInicioParsed);
			redada.setHora_final(horaFinalParsed);
			redada.setCantidad_capturados(cantidadCapturados);
			redada.setTipo_narcotico(tipo_narcotico);
			redada.setPeso_narcotico(peso_narcotico);

			// Obtener los objetos Policia a partir de los nombres
			List<Policia> policias = nombresPolicias.stream().map(nombre -> {
				List<Policia> existentes = pr.findAllByNombre(nombre);
				if (!existentes.isEmpty()) {
					// Puedes manejarlo de diferentes maneras, como tomar el primer resultado o
					// lanzar una excepción
					return existentes.get(0);
				}
				throw new RuntimeException("El policía '" + nombre + "' no existe.");
			}).collect(Collectors.toList());
			redada.setNombresPolicias(policias); // Opcional: puedes eliminar la lista de nombres de policias si ya no
													// la
													// necesitas

			rr.save(redada);

			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Redada actualizada con éxito");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la redada con el ID proporcionado");
		}
	}

	@PutMapping("/policia/{id}")
	public ResponseEntity<String> actualizarPolicia(@PathVariable Long id, @RequestParam String nombre,
	        @RequestParam int edad, @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate entrada,
	        @RequestParam String rango, @RequestParam int redadas) {
	    Optional<Policia> policiaExistente = pr.findById(id);

	    if (policiaExistente.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Policía no encontrado");
	    }

	    Policia policia = policiaExistente.get();
	    policia.setNombre(nombre);
	    policia.setEdad(edad);
	    policia.setEntrada(entrada);
	    policia.setRango(rango);
	    policia.setNumero_redadas(redadas);

	    pr.save(policia);
	    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Policía " + nombre + " actualizado con éxito");
	}

}
