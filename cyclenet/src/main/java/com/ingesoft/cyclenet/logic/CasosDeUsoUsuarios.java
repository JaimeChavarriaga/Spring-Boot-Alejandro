package com.ingesoft.cyclenet.logic;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingesoft.cyclenet.dataAccess.RepositorioUsuario;
import com.ingesoft.cyclenet.domain.Usuario;

@Service
public class CasosDeUsoUsuarios {
    
    @Autowired
    protected RepositorioUsuario repositorioUsuario;

    
    
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

    public void seguirUsuario(){

    }

    public void dejarDeSeguirUsuario(){

    }

    public void realizarComentario(){

    }

    public void realizarCalificacion(){

    }


}
