package com.ingesoft.cyclenet.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.cyclenet.domain.Usuario;

@Repository
public interface RepositorioUsuario 
extends JpaRepository<Usuario, String>
{

    Usuario getUsuarioLogeado();
    
}
