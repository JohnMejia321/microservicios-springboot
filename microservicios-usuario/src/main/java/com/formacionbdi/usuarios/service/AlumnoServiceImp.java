package com.formacionbdi.usuarios.service;

import com.formacionbdi.commons.services.CommonServiceImp;
import com.formacionbdi.commonsalumnos.models.Alumno;
import com.formacionbdi.usuarios.repository.AlumnoRepository;
import org.springframework.stereotype.Service;


@Service
public class AlumnoServiceImp  extends CommonServiceImp<Alumno,AlumnoRepository> implements AlumnoService {


}
