package ec.edu.espe.examen.garcia.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ec.edu.espe.examen.garcia.domain.Docente;

@Repository
public interface DocenteRepository extends CrudRepository<Docente, Integer> {

    
} 