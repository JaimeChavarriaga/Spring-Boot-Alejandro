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
    
    @ManyToOne
    protected Usuario usuario;

    @ManyToOne
    protected Publicacion publicacion;
    
    @ManyToOne
    protected Comentario comentario;
    
}
