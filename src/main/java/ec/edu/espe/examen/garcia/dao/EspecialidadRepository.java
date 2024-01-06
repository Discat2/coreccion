package ec.edu.espe.examen.garcia.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import ec.edu.espe.examen.garcia.domain.Especialidad;

@Repository
public interface EspecialidadRepository extends CrudRepository<Especialidad, String>{
    public List<Especialidad> findByNombreContaining(String nombre); 
}