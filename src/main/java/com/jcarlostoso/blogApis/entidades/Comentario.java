/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jcarlostoso.blogApis.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author bynot
 */
@Entity
@Table(name ="comentarios")
@Data
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String email;
    private String cuerpo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacion_id",nullable = false)
    private Publicacion publicacion;

    public Comentario() {
    }

    public Comentario(Long id, String nombre, String email, String cuerpo, Publicacion publicacion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.cuerpo = cuerpo;
        this.publicacion = publicacion;
    }
    
    
    
}
