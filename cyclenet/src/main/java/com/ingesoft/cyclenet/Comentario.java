package com.ingesoft.cyclenet;

import java.util.Date;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Comentario {
    protected String mensaje;
    protected Date fecha;
    protected int acuerdos;
    protected int desAcuerdos;

    protected Publicacion publicacion;
}
