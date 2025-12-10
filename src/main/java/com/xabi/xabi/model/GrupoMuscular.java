package com.xabi.xabi.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "GrupoMuscular")
public class GrupoMuscular {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotBlank
    private String nombre ;

    @Size(max = 255)
    private String descripcion ;

    @OneToMany(mappedBy = "grupoMuscular" , cascade = CascadeType.REMOVE)
    private List<Ejercicio> ejercicios ;

    public  GrupoMuscular(){

    }

    public GrupoMuscular(Long id, String nombre, String descripcion) {
        this.id = id;

        this.nombre = nombre;
        this.descripcion = descripcion;
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
}
