package com.formacionbdi.cursos.repository;

import com.formacionbdi.cursos.model.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CursoRepository extends CrudRepository<Curso,Long> {

    @Query("select c from Curso c join fetch c.alumnos a where a.id=?1")
    public Curso findCursoByAlumnoId(Long id);


}
