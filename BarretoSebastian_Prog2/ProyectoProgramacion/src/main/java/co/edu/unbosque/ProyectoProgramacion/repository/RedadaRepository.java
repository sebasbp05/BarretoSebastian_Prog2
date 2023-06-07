package co.edu.unbosque.ProyectoProgramacion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.ProyectoProgramacion.model.Policia;
import co.edu.unbosque.ProyectoProgramacion.model.Redada;

public interface RedadaRepository extends CrudRepository<Redada, Integer> {
	
	public Optional<Redada> findById(Long id);

	public List<Redada> findAll();

}
