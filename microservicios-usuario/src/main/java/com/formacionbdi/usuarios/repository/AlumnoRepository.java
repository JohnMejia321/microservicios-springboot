package com.formacionbdi.usuarios.repository;

import com.formacionbdi.usuarios.models.Alumno;
import org.springframework.data.repository.CrudRepository;


public interface AlumnoRepository extends CrudRepository<Alumno,Long> {
}
