package co.edu.unbosque.ProyectoProgramacion.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Redada {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private LocalDate fecha_ejecucion;
	private LocalTime hora_inicio;
	private LocalTime hora_final;
	private int cantidad_capturados;
	private String tipo_narcotico;
	private double peso_narcotico;
	@ElementCollection
	@OneToMany(fetch = FetchType.EAGER)
	private List<Policia> nombresPolicias;
	
	public Redada() {
		// TODO Auto-generated constructor stub
	}

	public Redada(Integer id, LocalDate fecha_ejecucion, LocalTime hora_inicio, LocalTime hora_final,
			int cantidad_capturados, String tipo_narcotico, double peso_narcotico, List<Policia> nombresPolicias) {
		super();
		this.id = id;
		this.fecha_ejecucion = fecha_ejecucion;
		this.hora_inicio = hora_inicio;
		this.hora_final = hora_final;
		this.cantidad_capturados = cantidad_capturados;
		this.tipo_narcotico = tipo_narcotico;
		this.peso_narcotico = peso_narcotico;
		this.nombresPolicias = nombresPolicias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha_ejecucion() {
		return fecha_ejecucion;
	}

	public void setFecha_ejecucion(LocalDate fecha_ejecucion) {
		this.fecha_ejecucion = fecha_ejecucion;
	}

	public LocalTime getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(LocalTime hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public LocalTime getHora_final() {
		return hora_final;
	}

	public void setHora_final(LocalTime hora_final) {
		this.hora_final = hora_final;
	}

	public int getCantidad_capturados() {
		return cantidad_capturados;
	}

	public void setCantidad_capturados(int cantidad_capturados) {
		this.cantidad_capturados = cantidad_capturados;
	}

	public String getTipo_narcotico() {
		return tipo_narcotico;
	}

	public void setTipo_narcotico(String tipo_narcotico) {
		this.tipo_narcotico = tipo_narcotico;
	}

	public double getPeso_narcotico() {
		return peso_narcotico;
	}

	public void setPeso_narcotico(double peso_narcotico) {
		this.peso_narcotico = peso_narcotico;
	}

	public List<Policia> getNombresPolicias() {
		return nombresPolicias;
	}

	public void setNombresPolicias(List<Policia> policias) {
		this.nombresPolicias = policias;
	}

}

