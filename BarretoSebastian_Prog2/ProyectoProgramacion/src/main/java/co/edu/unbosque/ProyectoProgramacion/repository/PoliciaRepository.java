package co.edu.unbosque.ProyectoProgramacion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.ProyectoProgramacion.model.Policia;

public interface PoliciaRepository extends CrudRepository<Policia, Integer> {
	
	public Optional<Policia> findById(Long id);

	public List<Policia> findAll();

	public List<Policia> findByNombre(String nombre);

	public List<Policia> findAllByNombre(String nombre);

}
