package com.formacionbdi.usuarios.controller;

import com.formacionbdi.usuarios.models.Alumno;
import com.formacionbdi.usuarios.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){
        Optional<Alumno> o = service.findById(id);
        if (o.isEmpty()){
           return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(o.get());

    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno,@PathVariable Long id){
        Optional<Alumno> o = service.findById(id);
        if (o.isEmpty()){
           return ResponseEntity.notFound().build();}
        Alumno alumnoDb= o.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
       service.deleteById(id);
       return ResponseEntity.noContent().build();
    }



}
