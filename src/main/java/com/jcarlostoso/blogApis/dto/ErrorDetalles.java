/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jcarlostoso.blogApis.dto;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author bynot
 */
@Data
public class ErrorDetalles {
    private Date marcaDeTiempo;
    private String mensaje;
    private String detalles;

    public ErrorDetalles(Date marcaDeTiempo, String mensaje, String detalles) {
        this.marcaDeTiempo = marcaDeTiempo;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }
    
    
}
