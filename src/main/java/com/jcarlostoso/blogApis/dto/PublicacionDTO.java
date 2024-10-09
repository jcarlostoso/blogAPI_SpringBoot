/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jcarlostoso.blogApis.dto;

import com.jcarlostoso.blogApis.entidades.Comentario;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author bynot
 */
@Data
public class PublicacionDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private String contenido;
    private Set<Comentario> comentarios;
  
}
