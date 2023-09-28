package com.ingesoft.cyclenet;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Comentario {

    

    protected String mensaje;
    protected Date fecha;
    protected int likes;
    protected int dislikes;

    
    protected Publicacion publicacion;
    
    protected Usuario usuario;

}
