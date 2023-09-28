package com.ingesoft.cyclenet;

import java.sql.Date;
import java.util.ArrayList;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



 public class Publicacion {
    protected String mensaje;
    protected Boolean foto;
    protected Boolean lugar;

    @Temporal(TemporalType.DATE)
    protected Date fecha;

    protected ArrayList<Comentario> comentarios;

    @ManyToOne
    protected Usuario usuario;

    @OneToMany(targetEntity = Calificacion.class, mappedBy = "publicacion")
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
