package com.formacionbdi.cursos.controller;

import com.formacionbdi.commons.controllers.CommonController;
import com.formacionbdi.cursos.model.Curso;
import com.formacionbdi.cursos.repository.CursoRepository;
import com.formacionbdi.cursos.services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id){
        Optional<Curso> o = service.findById(id);
        if (o.isEmpty()){
            return ResponseEntity.notFound().build();}
        Curso cursoDb= o.get();
        cursoDb.setNombre(cursoDb.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
    }
}
