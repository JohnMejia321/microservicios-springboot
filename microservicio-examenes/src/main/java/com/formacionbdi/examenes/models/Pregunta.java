package com.formacionbdi.examenes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="preguntas")
@Data
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"preguntas"})
    @JoinColumn(name="examen_id")
    private Examen examen;
}
