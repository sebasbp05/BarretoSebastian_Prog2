package co.edu.unbosque.ProyectoProgramacion.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Policia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private int edad;
	private LocalDate entrada;
	private String rango;
	private int numero_redadas;
	
	public Policia() {
		// TODO Auto-generated constructor stub
	}

	public Policia(Integer id, String nombre, int edad, LocalDate entrada, String rango, int numero_redadas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.entrada = entrada;
		this.rango = rango;
		this.numero_redadas = numero_redadas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDate getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDate entrada) {
		this.entrada = entrada;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public int getNumero_redadas() {
		return numero_redadas;
	}

	public void setNumero_redadas(int numero_redadas) {
		this.numero_redadas = numero_redadas;
	}

}

