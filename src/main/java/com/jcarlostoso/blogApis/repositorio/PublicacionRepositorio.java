/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jcarlostoso.blogApis.repositorio;

import com.jcarlostoso.blogApis.entidades.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bynot
 */
public interface PublicacionRepositorio extends JpaRepository<Publicacion, Long>{
    
}
