/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jcarlostoso.blogApis.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 *
 * @author bynot
 */
@Data
public class ComentarioDTO {
    
    private Long id;
    
@NotEmpty(message = "El nombre no debe ser vacio o nulo")
	private String nombre;
	
	@NotEmpty(message = "El email no debe ser vacio o nulo")
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 10,message = "El cuerpo del comentario debe tener al menos 10 caracteres")
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
