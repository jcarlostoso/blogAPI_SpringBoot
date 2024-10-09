/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jcarlostoso.blogApis.dto;

import java.util.List;
import lombok.Data;

/**
 *
 * @author bynot
 */
@Data
public class PublicacionRespuesta {
    private List<PublicacionDTO> contenido;
    private int numeroPagina;
    private int medidaPagina;
    private long totalElementos;
    private int totalPaginas;
    private boolean ultima;

    public PublicacionRespuesta() {
    }


    
    
}
