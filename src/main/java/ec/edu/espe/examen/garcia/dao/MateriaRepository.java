package ec.edu.espe.examen.garcia.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.examen.garcia.domain.Materia;

@Repository
public interface MateriaRepository extends CrudRepository<Materia, Integer>{

    
}
