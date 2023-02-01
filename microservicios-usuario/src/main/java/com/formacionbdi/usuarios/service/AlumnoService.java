package com.formacionbdi.usuarios.service;

import com.formacionbdi.commons.services.CommonService;
import com.formacionbdi.commonsalumnos.models.Alumno;

import java.util.List;


public interface AlumnoService extends CommonService<Alumno> {

    public List<Alumno> findByNombreOrApellido(String term);



}
