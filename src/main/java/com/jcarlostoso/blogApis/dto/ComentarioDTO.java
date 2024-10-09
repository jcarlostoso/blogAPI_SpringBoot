/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jcarlostoso.blogApis.dto;

import lombok.Data;

/**
 *
 * @author bynot
 */
@Data
public class ComentarioDTO {
    
    private Long id;
    
    private String nombre;
    private String email;
    private String cuerpo;

    public ComentarioDTO() {
    }

    public ComentarioDTO(Long id, String nombre, String email, String cuerpo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.cuerpo = cuerpo;
    }
    
    
}
