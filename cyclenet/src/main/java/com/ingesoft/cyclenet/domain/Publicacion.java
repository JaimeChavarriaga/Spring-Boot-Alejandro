package com.ingesoft.cyclenet.domain;

import java.sql.Date;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
 public class Publicacion {

    @Id
    private Long id;

    protected String mensaje;
    protected Boolean foto;
    protected Boolean lugar;

    @Temporal(TemporalType.DATE)
    protected Date fecha;

    @OneToMany(mappedBy = "publicacion")
    protected ArrayList<Comentario> comentarios;

    @ManyToOne
    protected Usuario usuario;

    @OneToMany(mappedBy = "publicacion")
    protected ArrayList<Calificacion> calificaciones;


    // Constructor por defecto
    public Publicacion() {
    }

    // Constructor con parámetros
    public Publicacion(String mensaje, Boolean foto, Boolean lugar, Date fecha) {
        this.mensaje = mensaje;
        this.foto = foto;
        this.lugar = lugar;
        this.fecha = fecha;
    }

}
