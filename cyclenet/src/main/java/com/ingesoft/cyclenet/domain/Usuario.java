package com.ingesoft.cyclenet.domain;

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

    @OneToMany(mappedBy = "usuario")
    protected ArrayList<Comentario> comentarios;
    
    @OneToMany(mappedBy = "usuario")
    protected ArrayList<Publicacion> publicaciones;

    @OneToMany(mappedBy = "usuario")
    protected ArrayList<Calificacion> calificaciones;


}
