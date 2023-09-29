package com.ingesoft.cyclenet.logic;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CasosDeUsoUsuarioTest {
    
    @Autowired
    protected CasosDeUsoUsuarios casosDeUsoUsuarios;    

    @Test
    public void pruebaLogin(){
        try {
            casosDeUsoUsuarios.iniciarSesion("X", "Y");
                
        } catch (Exception e) {
            // TODO: handle exception
            fail("Fallo");
            assertEquals(1, 0, "Fallo2");   
        }
    }
}
