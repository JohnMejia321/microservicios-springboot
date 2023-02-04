package com.formacionbdi.examenes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="examenes")
@Data
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_at")
    private Date createAt;

    @JsonIgnoreProperties(value = {"examen"} , allowSetters = true)
    @OneToMany(mappedBy = "examen",fetch= FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pregunta> preguntas;

    public void setPregunta(List<Pregunta> preguntas){
        this.preguntas.clear();
        preguntas.forEach(p->{
            this.addPregunta(p);
        });
    }

    public Examen(){
        this.preguntas= new ArrayList<>();
    }

    public void addPregunta(Pregunta pregunta){
        this.preguntas.add(pregunta);
        pregunta.setExamen(this);
    }

    public void removePregunta(Pregunta pregunta){
        this.preguntas.remove(pregunta);
        pregunta.setExamen(null);
    }

    @PrePersist
    public void prePersist(){
        this.createAt= new Date();
    }

    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }
        if  (!(obj instanceof Pregunta)){
            return false;
        }
        Pregunta p= (Pregunta) obj;
        return this.id !=null && this.id.equals(p.getId());
    }


}
