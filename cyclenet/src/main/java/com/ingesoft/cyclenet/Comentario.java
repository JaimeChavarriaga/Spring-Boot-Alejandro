package com.ingesoft.cyclenet;

import java.util.ArrayList;
import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue
    protected String id;

    protected String mensaje;
    protected Date fecha;
    protected int likes;
    protected int dislikes;

    @ManyToOne
    protected Publicacion publicacion;
    
    @ManyToOne
    protected Usuario usuario;

    @OneToMany(targetEntity = Calificacion.class, mappedBy = "comentario")
    protected ArrayList<Calificacion> calificaciones;

}
