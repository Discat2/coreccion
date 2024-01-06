package ec.edu.espe.examen.garcia.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.garcia.dao.DocenteMateriaRepository;
import ec.edu.espe.examen.garcia.dao.DocenteRepository;
import ec.edu.espe.examen.garcia.dao.MateriaRepository;
import ec.edu.espe.examen.garcia.domain.Docente;
import ec.edu.espe.examen.garcia.domain.Materia;
import ec.edu.espe.examen.garcia.domain.DocenteMateria;
import ec.edu.espe.examen.garcia.service.exeption.CreateException;

import java.util.Optional;

@Service
public class PlanificacionService {
    private final DocenteRepository docenteRepository;
    private final MateriaRepository materiaRepository;
    private final DocenteMateriaRepository docenteMateriaRepository;

    public PlanificacionService(DocenteRepository docenteRepository, MateriaRepository materiaRepository,
            DocenteMateriaRepository docenteMateriaRepository) {
        this.docenteRepository = docenteRepository;
        this.materiaRepository = materiaRepository;
        this.docenteMateriaRepository = docenteMateriaRepository;
    }

    public Iterable<DocenteMateria> GetAll() {
        return this.docenteMateriaRepository.findAll();
    }

    public DocenteMateria create(DocenteMateria docenteMateria) {
        try {
            Optional<Docente> docente = docenteRepository.findById(docenteMateria.getPK().getCodDocente());
            Optional<Materia> materia = materiaRepository.findById(docenteMateria.getPK().getCodMateria());

            if (docente.isPresent() && materia.isPresent()) {
                return this.docenteMateriaRepository.save(docenteMateria);
            } else {
                throw new RuntimeException("El Docente: " + docenteMateria.getPK().getCodDocente() + " o la materia  "
                        + docenteMateria.getPK().getCodMateria() + "son invalidos: ");
            }
        } catch (Exception e) {
            throw new CreateException("Ocurrio un error al crear docente-materia: " + docenteMateria.toString(), e);
        }
    }
}
