/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jcarlostoso.blogApis.repositorio;

import com.jcarlostoso.blogApis.entidades.Comentario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bynot
 */
public interface ComentarioRepositorio extends JpaRepository<Comentario, Long>{
   
    public List<Comentario> findByPublicacionId(long publicacionId);
}
