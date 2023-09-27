package com.ingesoft.cyclenet;

import java.util.ArrayList;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode
public class Usuario {
    
    @Id
    protected String Id;
    
    protected String nombre;
    protected String contraseña;
    protected String correo;
    protected String celular;
    protected ArrayList<Comentario> comentarios;
    protected ArrayList<Publicacion> publicaciones;
    protected ArrayList<Recorrido> recorridos;


}
