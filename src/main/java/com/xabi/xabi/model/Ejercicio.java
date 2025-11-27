package com.xabi.xabi.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Ejercicio")
public class Ejercicio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotBlank
    private String nombre ;

    @Size(max = 255)
    private String descripcion  ;


    @NotBlank
    private String dificultad ;

    @ManyToOne
    @JoinColumn(name = "GrupoMuscular_Id")
    GrupoMuscular grupoMuscular ;

    public Ejercicio(){

    }

    public Ejercicio(Long id, String nombre, String descripcion, String dificultad, GrupoMuscular grupoMuscular) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.grupoMuscular = grupoMuscular;
    }

    public Ejercicio(Long id, String nombre, String descripcion, GrupoMuscular grupoMuscular) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.grupoMuscular = grupoMuscular;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
}
