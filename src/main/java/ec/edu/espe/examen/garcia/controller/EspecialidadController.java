package ec.edu.espe.examen.garcia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.garcia.domain.Especialidad;
import ec.edu.espe.examen.garcia.service.EspecialidadService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Especialidad>> GetAll() {
        return new ResponseEntity<>(especialidadService.GetAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Especialidad>> Buscar(@PathParam("nombre") String nombre) {
        return new ResponseEntity<>(especialidadService.BuscarEspecialidad(nombre), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Especialidad> Save(@RequestBody Especialidad especialidad) {
        return new ResponseEntity<>(especialidadService.create(especialidad), HttpStatus.OK);
    }
}
