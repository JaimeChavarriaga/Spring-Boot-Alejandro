package com.ingesoft.cyclenet.domain;

import java.util.ArrayList;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class Usuario {
    
    @Id
    protected String nombreUsuario;
    
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

    public Usuario(String nombreUsuario, String nombre, String contraseña, String correo, String celular){
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.celular = celular;

        this.calificaciones = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
    }

}
