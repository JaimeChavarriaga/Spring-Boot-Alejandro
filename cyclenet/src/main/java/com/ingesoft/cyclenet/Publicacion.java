package com.ingesoft.cyclenet;

import java.sql.Date;
import java.util.ArrayList;



public class Publicacion {
    protected String mensaje;
    protected Boolean foto;
    protected Boolean lugar;

    protected Date fechaPublicacion;


    
    protected ArrayList<Comentario> comentarios;

    protected Usuario usuario;
}
