package com.ingesoft.cyclenet.logic;

import java.util.ArrayList;
import java.util.Optional;
import java.time.LocalDate;
import java.time.Instant;
import java.time.ZoneId;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingesoft.cyclenet.dataAccess.RepositorioPublicacion;
import com.ingesoft.cyclenet.dataAccess.RepositorioUsuario;
import com.ingesoft.cyclenet.domain.Publicacion;
import com.ingesoft.cyclenet.domain.Usuario;

@Service
public class CasosDeUsoUsuarios {
    
    @Autowired
    protected RepositorioUsuario repositorioUsuario;

    @Autowired
    protected RepositorioPublicacion repositorioPublicacion;
    
    public void iniciarSesion(String login, String password) throws Exception{

        // Valida que exista un registro con ese usuario 
        Optional<Usuario> u = repositorioUsuario.findById(login);
        if(u.isEmpty()){
            throw new Exception("Usuario no existe");
        }

        //Valida que la contraseña es correcta
        if(!u.get().getContraseña().equals(password)){
            throw new Exception("Contraseña no coincide"); 
        }
        return;
    }

    public void crearUsuario(String nombreUsuario, String nombre, String contraseña, String correo, String celular) throws Exception{
        
        Optional<Usuario> optional = repositorioUsuario.findById(nombreUsuario);
        if(optional.isEmpty()){
            //Guardar usuario
        Usuario u = new Usuario(nombreUsuario, nombre, contraseña, correo, celular);
        repositorioUsuario.save(u);
        } else {
            throw new Exception("Nombre de usuario ya existe");
        }
        return;
    }

    

    public void subirPublicacion(Usuario usuario, String mensaje, Boolean foto, Boolean lugar){
        //Guardar publicación
        Date fecha = Date.valueOf(LocalDate.now());
        Publicacion publicacion = new Publicacion(mensaje, foto, lugar, fecha, usuario);
        usuario.getPublicaciones().add(publicacion);
        repositorioPublicacion.save(publicacion);

        if(lugar == true){
            mostrarPublicacionLugar(publicacion);
            return;
        }

        //Mostrar publicacion
         //Mostrar texto, e imagen
         return;
    }

    public void mostrarPublicacionLugar(Publicacion publicacion){
        //Procedimiento para obtener y mostrar el lugar
        return;
    }

    public void seguirUsuario(){

    }

    public void dejarDeSeguirUsuario(){

    }

    public void realizarComentario(){

    }

    public void realizarCalificacion(){
        
    }


}
