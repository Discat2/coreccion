package ec.edu.espe.examen.garcia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.garcia.domain.DocenteMateria;
import ec.edu.espe.examen.garcia.service.PlanificacionService;

@RestController
@RequestMapping("/planificacion")
public class PlanificacionController {
    @Autowired
    private PlanificacionService planificacionService;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<DocenteMateria>> GetAll() {
        return new ResponseEntity<>(planificacionService.GetAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<DocenteMateria> Save(@RequestBody DocenteMateria docenteMateria) {
        return new ResponseEntity<>(planificacionService.create(docenteMateria), HttpStatus.OK);
    }
}
