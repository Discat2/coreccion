package ec.edu.espe.examen.garcia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.garcia.domain.Docente;
import ec.edu.espe.examen.garcia.service.DocenteService;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<Docente>> GetAll() {
        return new ResponseEntity<>(docenteService.GetAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Docente> Save(@RequestBody Docente docente) {
        return new ResponseEntity<>(docenteService.create(docente), HttpStatus.OK);
    }
}
