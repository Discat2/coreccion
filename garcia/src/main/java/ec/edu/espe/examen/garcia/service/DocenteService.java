package ec.edu.espe.examen.garcia.service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.garcia.dao.DocenteRepository;
import ec.edu.espe.examen.garcia.dao.EspecialidadRepository;
import ec.edu.espe.examen.garcia.domain.Docente;
import ec.edu.espe.examen.garcia.domain.Especialidad;
import ec.edu.espe.examen.garcia.service.exeption.CreateException;

@Service
public class DocenteService {
    private final DocenteRepository docenteRepository;
    private final EspecialidadRepository especialidadRepository;

    public DocenteService(DocenteRepository docenteRepository, EspecialidadRepository especialidadRepository) {
        this.docenteRepository = docenteRepository;
        this.especialidadRepository = especialidadRepository;
    }

    public Iterable<Docente> GetAll(){
        return this.docenteRepository.findAll();
    }
    public Docente create(Docente docente) {
        try {
            String codEspecialidad = docente.getCodEspecialidad();
            Optional<Especialidad> especialidad = especialidadRepository.findById(codEspecialidad);
            if (especialidad.isPresent()) {
                Date fechaIngreso = docente.getFechaIngreso();
                Date fechaActual = new Date(System.currentTimeMillis());
                if (fechaIngreso.after(fechaActual)) {
                    return this.docenteRepository.save(docente);
                } else {
                    throw new RuntimeException("Registro Incorrecto, la fecha " + fechaIngreso
                    + " no es mayor a la actual " + fechaActual);
                }
            } else {
                throw new RuntimeException("Registro Incorrecto, la especialidad " + codEspecialidad + " no existe ");
            }
        } catch (Exception e) {
            throw new CreateException("Ocurrio un error al crear el docente: " + docente.toString(), e);
        }
    }
}
