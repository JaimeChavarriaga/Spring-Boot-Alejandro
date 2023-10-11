package com.ingesoft.cyclenet.logic;

import java.time.LocalDate;
import java.sql.Date;

import com.ingesoft.cyclenet.dataAccess.RepositorioPublicacion;
import com.ingesoft.cyclenet.dataAccess.RepositorioUsuario;
import com.ingesoft.cyclenet.domain.Publicacion;
import com.ingesoft.cyclenet.domain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasosDeUsoPublicacion {

    @Autowired
    protected RepositorioPublicacion repositorioPublicacion;

    @Autowired
    protected RepositorioUsuario repositorioUsuario;

    public Long subirPublicacion(Usuario usuario, String mensaje, Boolean foto, Boolean lugar){

        //Guardar publicación
        Date fecha = Date.valueOf(LocalDate.now());

        Publicacion publicacion = new Publicacion(mensaje, foto, lugar, fecha, usuario);
        usuario.getPublicaciones().add(publicacion);

        publicacion = repositorioPublicacion.save(publicacion);
        usuario = repositorioUsuario.save(usuario);

        //Retornar datos a mostrar
         return publicacion.getId();
    }

    public void mostrarPublicacionLugar(Publicacion publicacion){
        //Retornar datos a mostrar
        return;
    }
    
}
