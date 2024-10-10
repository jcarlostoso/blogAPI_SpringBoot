/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jcarlostoso.blogApis.dto;

import com.jcarlostoso.blogApis.entidades.Comentario;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author bynot
 */
@Data
public class PublicacionDTO {

    private Long id;
    @NotEmpty
    @Size(min = 2, message = "El titulo de la publicacion debe tener al menos 2 caracteres")
    private String titulo;
    @NotEmpty
    @Size(min = 2, message = "La descripcion de la publicacion debe tener al menos 10 caracteres")
    private String descripcion;
    
    private String contenido;
    private Set<Comentario> comentarios;
  
}
