package com.ingesoft.cyclenet.logic;

import java.util.Optional;
import java.util.Scanner;

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

    public void seguirUsuario(Usuario uActual, String nombreSeguir) throws Exception{
        // 1. El Usuario Inicia sesión.
        if( !uActual.isLog() ){
            throw new Exception("Usuario no ha iniciado sesión");
        }
        // 2. Busca al usuario que desea seguir  
        Optional<Usuario> uSeguirOptional = repositorioUsuario.findById(nombreSeguir);
        if (uSeguirOptional.isEmpty()) {
            throw new Exception("Usuario a seguir no encontrado");
        }

        Usuario usuarioASeguir = uSeguirOptional.get();

        // 3.  Muestra en pantalla el perfil de ese usuario
        mostrarPerfilUsuario(usuarioASeguir);


        // 4. Pregunta si lo quiere seguir
        boolean seguir = obtenerDecisionUsuario("¿Desea seguir a este usuario? (S/N)");

        if (seguir) {
            // 5. Añade a ese usuario de la lista de seguidos por el usuario registrado
            Usuario usuarioActual = repositorioUsuario.getUsuarioLogeado();
            usuarioActual.getSeguidos().add(usuarioASeguir);
            repositorioUsuario.save(usuarioActual);

            // 6. Show confirmation message
            System.out.println("Ahora estás siguiendo a " + usuarioASeguir.getNombreUsuario());
        } else {
            System.out.println("No has seguido a " + usuarioASeguir.getNombreUsuario());
        }

    }

    public void dejarDeSeguirUsuario(Usuario uActual, String nombreNoSeguir) throws Exception{
        // 1. El Usuario Inicia sesión.
        if( !uActual.isLog() ){
            throw new Exception("Usuario no ha iniciado sesión");
        }
        // 2. Busca al usuario que desea dejar de seguir  
        Optional<Usuario> uNoSeguirOptional = repositorioUsuario.findById(nombreNoSeguir);
        if (uNoSeguirOptional.isEmpty()) {
            throw new Exception("Usuario a seguir no encontrado");
        }

        Usuario uNoSeguir = uNoSeguirOptional.get();

        // 3.  Muestra en pantalla el perfil de ese usuario
        mostrarPerfilUsuario(uNoSeguir);


        // 4. Pregunta si lo quiere seguir
        boolean noSeguir = obtenerDecisionUsuario("¿Desea dejar de seguir a este usuario? (S/N)");

        if (noSeguir) {
            // 5. Añade a ese usuario de la lista de seguidos por el usuario registrado
            Usuario usuarioActual = repositorioUsuario.getUsuarioLogeado();
            usuarioActual.getSeguidos().remove(uNoSeguir);
            repositorioUsuario.save(usuarioActual);

            // 6. Show confirmation message
            System.out.println("Dejaste de seguir a " + uNoSeguir.getNombreUsuario());
        } else {
            System.out.println("No dejaste de seguir a " + uNoSeguir.getNombreUsuario());
        }
    }

    public void realizarComentario(){

    }

    public void realizarCalificacion(){
        
    }

    private boolean obtenerDecisionUsuario(String mensaje) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(mensaje);
        System.out.print("Ingrese S para Sí o N para No: ");

        String decision = scanner.nextLine().toUpperCase();

        return decision.equals("S");
    }
    
    private void mostrarPerfilUsuario(Usuario usuario) {
        // Display relevant information about the user (e.g., username, name, etc.)
        System.out.println("Perfil de usuario:");
        System.out.println("Nombre de usuario: " + usuario.getNombreUsuario());
        System.out.println("Nombre: " + usuario.getNombre());
        // Add other details you want to display
    }

}
