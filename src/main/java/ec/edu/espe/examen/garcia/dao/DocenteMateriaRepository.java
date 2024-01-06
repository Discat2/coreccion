package ec.edu.espe.examen.garcia.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ec.edu.espe.examen.garcia.domain.DocenteMateria;
import ec.edu.espe.examen.garcia.domain.DocenteMateriaPK;

@Repository
public interface DocenteMateriaRepository  extends CrudRepository<DocenteMateria, DocenteMateriaPK>{

    
}