package com.formacionbdi.examenes.services;

import com.formacionbdi.commons.services.CommonServiceImp;
import com.formacionbdi.examenes.models.Examen;
import com.formacionbdi.examenes.repository.ExamenRepository;
import org.springframework.stereotype.Service;

@Service
public class ExamenServiceImp  extends CommonServiceImp<Examen, ExamenRepository> implements ExamenService {
}
