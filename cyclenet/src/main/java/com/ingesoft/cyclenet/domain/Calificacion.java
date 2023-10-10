package com.ingesoft.cyclenet.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Calificacion {
    
    @Id
    @GeneratedValue
    protected Long id;

    protected int numCalificacion;

    protected Boolean esDePublicacion;

    protected Boolean esDeComentario;
    
    @ManyToOne
    protected Usuario usuario;

    @ManyToOne
    protected Publicacion publicacion;
    
    @ManyToOne
    protected Comentario comentario;
    
    public Calificacion(int numCalificacion, Usuario usuario, Publicacion publicacion){
        this.numCalificacion = numCalificacion;
        this.usuario = usuario;
        this.esDePublicacion = true;
        this.esDeComentario = false;
        this.publicacion = publicacion;
        this.comentario = null;
    }

    public Calificacion(int numCalificacion, Usuario usuario, Comentario comentario){
        this.numCalificacion = numCalificacion;
        this.usuario = usuario;
        this.esDePublicacion = false;
        this.esDeComentario = true;
        this.publicacion = null;
        this.comentario = comentario;
    }
}
