package ec.edu.espe.examen.garcia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.garcia.dao.EspecialidadRepository;
import ec.edu.espe.examen.garcia.domain.Especialidad;
import ec.edu.espe.examen.garcia.service.exeption.CreateException;

@Service
public class EspecialidadService {
    private final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }
    public Iterable<Especialidad> GetAll(){
        return this.especialidadRepository.findAll();
    }
    public Especialidad create(Especialidad especialidad) {
        try {
            return this.especialidadRepository.save(especialidad);
        } catch (Exception e) {
            throw new CreateException("Ocurrio un error al crear la especialidad: " + especialidad.toString(), e);
        }
    }

    public List<Especialidad> BuscarEspecialidad(String nombre) {
        return this.especialidadRepository.findByNombreContaining(nombre);
    }
}
