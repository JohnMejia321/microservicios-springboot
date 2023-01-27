package com.formacionbdi.usuarios.repository;

import com.formacionbdi.commonsalumnos.models.Alumno;
import org.springframework.data.repository.CrudRepository;


public interface AlumnoRepository extends CrudRepository<Alumno,Long> {
}
