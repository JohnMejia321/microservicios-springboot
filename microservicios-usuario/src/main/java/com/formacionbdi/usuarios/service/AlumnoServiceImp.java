package com.formacionbdi.usuarios.service;

import com.formacionbdi.commons.services.CommonServiceImp;
import com.formacionbdi.commonsalumnos.models.Alumno;
import com.formacionbdi.usuarios.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlumnoServiceImp  extends CommonServiceImp<Alumno,AlumnoRepository> implements AlumnoService {


    @Override
    public List<Alumno> findByNombreOrApellido(String term) {
        return repository.findByNombreOrApellido(term);
    }
}
