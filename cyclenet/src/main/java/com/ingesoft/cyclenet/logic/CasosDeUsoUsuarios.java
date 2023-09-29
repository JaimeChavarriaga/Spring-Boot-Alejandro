package com.ingesoft.cyclenet.logic;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingesoft.cyclenet.dataAccess.RepositorioPublicacion;
import com.ingesoft.cyclenet.dataAccess.RepositorioUsuario;
import com.ingesoft.cyclenet.domain.Usuario;

@Service
public class CasosDeUsoUsuarios {
    
    @Autowired
    protected RepositorioUsuario repositorioUsuario;

    /**
     * @param login
     * @param password
     * @throws Exception
     */

    
    public void iniciarSesion(String login, String password) throws Exception{

        //        2. Valida que exista un registro con ese usuario 
        Optional<Usuario> u = repositorioUsuario.findById(login);
        if(u.isEmpty()){
            throw new Exception("Usuario no existe");
        }

        if(!u.get().getContraseña().equals(password)){
            throw new Exception("Contraseña no coincide"); 
        }

        

    }

    public void crearUsuario(String nombre){
        Usuario u = new Usuario();
        
        repositorioUsuario.save(u);
    }


}
