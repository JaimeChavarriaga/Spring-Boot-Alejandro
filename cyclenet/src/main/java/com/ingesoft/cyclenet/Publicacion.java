package main.java.com.ingesoft.cyclenet;

import java.sql.Date;
import java.util.ArrayList;

import com.ingesoft.cyclenet.Comentario;



public class Publicacion {
    protected String mensaje;
    protected Boolean foto;
    protected Date fechaPublicacion;
    protected Recorrido recorrido;
    protected ArrayList<Comentario> comentarios;
}
