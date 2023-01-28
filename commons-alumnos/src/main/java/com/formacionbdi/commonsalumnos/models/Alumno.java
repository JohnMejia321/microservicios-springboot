package com.formacionbdi.commonsalumnos.models;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="alumnos")
@Data
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    @Column(name="create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @PrePersist
    public void prePersist(){
        this.createAt= new Date();
    }

    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }
        if  (!(obj instanceof Alumno)){
            return false;
        }
        Alumno a= (Alumno) obj;
        return this.id !=null && this.id.equals(a.getId());
    }

}
