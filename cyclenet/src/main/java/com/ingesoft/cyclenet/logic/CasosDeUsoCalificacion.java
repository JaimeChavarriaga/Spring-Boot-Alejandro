package com.ingesoft.cyclenet.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingesoft.cyclenet.dataAccess.RepositorioCalificacion;
import com.ingesoft.cyclenet.domain.Calificacion;
import com.ingesoft.cyclenet.domain.Comentario;
import com.ingesoft.cyclenet.domain.Publicacion;
import com.ingesoft.cyclenet.domain.Usuario;

@Service
public class CasosDeUsoCalificacion {
    @Autowired
    protected RepositorioCalificacion repositorioCalificacion;

    public void realizarCalificacionPublicacion(Usuario usuario, int valorCalificado, Publicacion publicacion) throws Exception{
        if(valorCalificado < 1 || valorCalificado > 5){
            throw new Exception("La calificacion debe estar entre 1 y 5");
        }

        Calificacion calificacion = new Calificacion(valorCalificado, usuario ,publicacion);
        
        usuario.getCalificaciones().add(calificacion);
        publicacion.getCalificaciones().add(calificacion);

        repositorioCalificacion.save(calificacion);

        return;
    }

    public void realizarCalificacionComentario(Usuario usuario, int valorCalificado, Comentario comentario) throws Exception{
        if(valorCalificado < 1 || valorCalificado > 5){
            throw new Exception("La calificacion debe estar entre 1 y 5");
        }

        Calificacion calificacion = new Calificacion(valorCalificado, usuario ,comentario);
        
        usuario.getCalificaciones().add(calificacion);
        comentario.getCalificaciones().add(calificacion);

        repositorioCalificacion.save(calificacion);

        return;
    }
}
