package com.ingesoft.cyclenet.logic;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ingesoft.cyclenet.dataAccess.RepositorioPublicacion;
import com.ingesoft.cyclenet.dataAccess.RepositorioUsuario;
import com.ingesoft.cyclenet.domain.Usuario;


@SpringBootTest
public class CasosDeUsoUsuarioTest {
    
    @Autowired
    protected CasosDeUsoUsuarios casosDeUsoUsuarios;   
    
    @Autowired
    protected RepositorioUsuario repositorioUsuario;
    
    @Autowired
    protected RepositorioPublicacion repositorioPublicacion;

    /* 
    //Arrange
    @BeforeAll
    public void prepararAmbienteDeTodaLaSuite(){
        System.out.println("Antes de todas la pruebas");
        System.out.println();
    }*/
    
    @BeforeEach
    public void prepararAmbienteDePruebas(){
        System.out.println("Antes de cada prueba");
        System.out.println();
        repositorioPublicacion.deleteAll();
    }

    //Casos de uso
    @Test
    public void pruebaLogin(){
        try {
            casosDeUsoUsuarios.iniciarSesion("X", "Y");
            fail("Inicio sesion");
        } catch (Exception e) {
            // OK -- No inicio sesion
        }
    }

    @Test
    public void registrarUsuarioSinErrores(){
        try {

            //arrange
            repositorioUsuario.deleteAll();

            //act
            casosDeUsoUsuarios.registrarUsuario("Jaime","Jaime Lombo","Gola123","juan@hola.net","31565431");

            //assert
            Optional<Usuario> usuariosConNombreJaime = repositorioUsuario.findById("Jaime");
            if(usuariosConNombreJaime.isEmpty()){
                fail("No se grabo el usuario");
            }

            Usuario u = usuariosConNombreJaime.get();
            assertNotNull(u, "El usuario aparece en null");
            assertNotNull(u.getPublicaciones(), "El listado de publicaciones aparece en null");
            assertNotNull(u.getCalificaciones(), "El listado de calificaciones aparece en null");


        } catch (ExcepcionUsuarios e) {
            // OK
        }
    }

    @Test
    public void registrarUsuarioConLoginQueYaExiste(){
        try {

            //Arrange
            repositorioUsuario.deleteAll();
            Usuario u = new Usuario("jaime","jaime","jaime","jaime","jaime");
            repositorioUsuario.save(u);

            //Act
            casosDeUsoUsuarios.registrarUsuario("Jaime", "Jaime", "Jaime", "Jaime", "Jaime");

            //Assert
            fail("Dejo grabar otro usuario con un login que ya existia");
        } catch (ExcepcionUsuarios e) {
            // OK - No se registra usuario con login que ya existe"
        }
    }

    @Test
    public void registrarUsuarioConContrasenaDeMenosDe4Letras(){
        try {
            //Arrange
            repositorioUsuario.deleteAll();
        
            //Act
            casosDeUsoUsuarios.registrarUsuario("Jaime","Jaime Lombo","l2","juan@hola.net","31565431");
        
            //Assert
            fail("Dejo grabar usuario con una contrasena de menos de 5 letras");

        } catch (ExcepcionUsuarios e) {
            // OK - No dejo grabar usuario con contrasena de menos de lettras
        }
    }

    //Clean up

    @AfterEach
    public void despuesDeLaPrueba(){
        System.out.println("Luego de cada prueba");
        System.out.println();
    }
/* 
    @AfterAll
    public void despuesDeTodasLasPruebas(){
        System.out.println("Despues de todas las pruebas");
        System.out.println();
    }*/
}
