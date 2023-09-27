package com.ingesoft.cyclenet;

import java.sql.Date;
import java.util.ArrayList;



public class Publicacion {
    protected String mensaje;
    protected Boolean foto;
    protected Date fechaPublicacion;
    protected Recorrido recorrido;
    protected ArrayList<Comentario> comentarios;

    protected Usuario usuario;
}
