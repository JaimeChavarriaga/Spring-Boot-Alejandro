package com.ingesoft.cyclenet;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Calificacion {
    
    @Id
    @GeneratedValue
    protected String id;

    protected int numCalificacion;
    
    @ManyToOne(targetEntity = Publicacion.class,  fetch = FetchType.LAZY) // Poner nombre de la otra columna
    protected Usuario usuario;

    @ManyToOne(targetEntity = Publicacion.class, fetch = FetchType.LAZY)
    protected Publicacion publicacion;
    
    @ManyToOne(targetEntity = Comentario.class, fetch = FetchType.LAZY)
    protected Comentario comentario;
    
}

/*
     * @ManyToOne
        @JoinColumn(name = "department_id")
        private Department department;

        // In the Department entity
        @OneToMany(mappedBy = "department")
        private List<Employee> employees;
     */