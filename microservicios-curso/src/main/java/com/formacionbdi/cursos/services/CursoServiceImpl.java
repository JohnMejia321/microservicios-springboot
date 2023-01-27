package com.formacionbdi.cursos.services;

import com.formacionbdi.commons.services.CommonServiceImp;
import com.formacionbdi.cursos.model.Curso;
import com.formacionbdi.cursos.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends CommonServiceImp<Curso, CursoRepository> implements CursoService {

}
