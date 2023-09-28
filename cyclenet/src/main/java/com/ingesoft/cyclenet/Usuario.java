package com.ingesoft.cyclenet;

import java.util.ArrayList;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode
public class Usuario {
    
    @Id
    protected String identificacion;
    
    protected String nombre;
    protected String contraseña;
    protected String correo;
    protected String celular;

    @OneToMany
    protected ArrayList<Comentario> comentarios;
    
    @OneToMany
    protected ArrayList<Publicacion> publicaciones;

    @OneToMany
    protected ArrayList<Calificacion> calificaciones;


}
