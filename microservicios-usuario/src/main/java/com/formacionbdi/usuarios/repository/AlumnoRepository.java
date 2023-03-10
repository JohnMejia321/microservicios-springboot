package com.formacionbdi.usuarios.repository;

import com.formacionbdi.commonsalumnos.models.Alumno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AlumnoRepository extends CrudRepository<Alumno,Long> {

    @Query("select a from Alumno a where a.nombre like %?1% or a.apellido like %?1% ")
    public List<Alumno> findByNombreOrApellido(String term);
}
