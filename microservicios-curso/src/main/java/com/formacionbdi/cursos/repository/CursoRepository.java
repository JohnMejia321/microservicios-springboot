package com.formacionbdi.cursos.repository;

import com.formacionbdi.cursos.model.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso,Long> {
}