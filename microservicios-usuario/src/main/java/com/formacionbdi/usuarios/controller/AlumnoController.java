package com.formacionbdi.usuarios.controller;

import com.formacionbdi.commons.controllers.CommonController;
import com.formacionbdi.commonsalumnos.models.Alumno;
import com.formacionbdi.usuarios.service.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController extends CommonController<Alumno,AlumnoService> {




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

    @GetMapping("/filtrar/{term}")
    public ResponseEntity<?> filtrar(@PathVariable String term){
        return ResponseEntity.ok(service.findByNombreOrApellido(term));
    }




}
