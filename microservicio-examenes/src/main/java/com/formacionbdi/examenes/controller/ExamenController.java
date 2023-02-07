package com.formacionbdi.examenes.controller;

import com.formacionbdi.commons.controllers.CommonController;
import com.formacionbdi.examenes.models.Examen;
import com.formacionbdi.examenes.models.Pregunta;
import com.formacionbdi.examenes.services.ExamenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {
        Optional<Examen> o = service.findById(id);
        if (!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Examen examenDb = o.get();
        examenDb.setNombre(examen.getNombre());
        List<Pregunta> eliminadas = new ArrayList<>();
        examenDb.getPreguntas().forEach(pdb -> {
            if (examen.getPreguntas().contains(pdb)) {
                eliminadas.add(pdb);
            }
        });
        eliminadas.forEach(p -> {
            examenDb.removePregunta(p);
        });
        examenDb.setPreguntas(examen.getPreguntas());
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
    }
}
