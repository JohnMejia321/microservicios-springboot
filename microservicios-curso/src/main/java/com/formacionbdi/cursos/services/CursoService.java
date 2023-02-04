package com.formacionbdi.cursos.services;

import com.formacionbdi.commons.services.CommonService;
import com.formacionbdi.cursos.model.Curso;

public interface CursoService extends CommonService<Curso> {

    public Curso findCursoByAlumnoId(Long id);


}
