package com.ingesoft.cyclenet.logic;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ingesoft.cyclenet.logic.CasosDeUsoPublicacionTest;
import com.ingesoft.cyclenet.dataAccess.RepositorioPublicacion;
import com.ingesoft.cyclenet.dataAccess.RepositorioUsuario;
import com.ingesoft.cyclenet.domain.Publicacion;
import com.ingesoft.cyclenet.domain.Usuario;

@SpringBootTest
public class CasosDeUsoPublicacionTest {
    
    @Autowired
    protected CasosDeUsoPublicacion casosDeUsoPublicacion;
    @Autowired
    protected CasosDeUsoUsuarios casosDeUsoUsuarios;

    @Autowired
    protected RepositorioPublicacion repositorioPublicacion;
    @Autowired
    protected RepositorioUsuario repositorioUsuario;

    @Test
    public void pruebaP(){
        try {
            //arrange
            repositorioPublicacion.deleteAll();
            repositorioUsuario.deleteAll();

            Usuario usuario = new Usuario("holaa","HOLA","jsdddd","NOO","si");
            usuario = repositorioUsuario.save(usuario);

            assertNotNull(usuario, "El usuario aparece en null");
            assertNotNull(usuario.getPublicaciones(), "El listado de publicaciones aparece en null");
            assertNotNull(usuario.getCalificaciones(), "El listado de calificaciones aparece en null");

            //act
            Long idNuevaPublicacion = casosDeUsoPublicacion.subirPublicacion(
                    usuario,
                    "Hola a todos", 
                    false, false);

            //assert
            Optional<Usuario> opcionalUsuario = repositorioUsuario.findById("holaa");
            assertFalse(opcionalUsuario.isEmpty(), "El usuario no aparece en la base de datos");
            
            Usuario usuarioModificado = opcionalUsuario.get();
            assertNotNull(usuarioModificado.getPublicaciones(), "El usuario no tiene publicaciones");
            
            Optional<Publicacion> opcionalPublicacion = repositorioPublicacion.findById(idNuevaPublicacion);
            assertFalse(opcionalPublicacion.isEmpty(), "La publicacion no aparece en la base de datos");

            Publicacion nuevaPublicacion = opcionalPublicacion.get();
            assertNotNull(nuevaPublicacion.getUsuario(), "El usuario no aparece en la publicacion");
            assertEquals(
                nuevaPublicacion.getUsuario().getNombreUsuario(), 
                usuarioModificado.getNombreUsuario(), 
                "El usuario no es el mismo");
            
            // OK: Se logro subir una publicacion exitosamente

        } catch (Exception e) {
            fail("No se logro guardar una publicacion");
        }
    }
    
}
