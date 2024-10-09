/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jcarlostoso.blogApis.servicio;

import com.jcarlostoso.blogApis.dto.ComentarioDTO;
import com.jcarlostoso.blogApis.entidades.Comentario;
import com.jcarlostoso.blogApis.entidades.Publicacion;
import com.jcarlostoso.blogApis.excepciones.ResourceNotFoundException;
import com.jcarlostoso.blogApis.repositorio.ComentarioRepositorio;
import com.jcarlostoso.blogApis.repositorio.PublicacionRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bynot
 */
@Service
public class ComentarioServicioImpl implements ComentarioServicio{

    @Autowired
    private ComentarioRepositorio comentarioRepositorio;
    
    @Autowired
    private PublicacionRepositorio publicacionRepositorio;
    @Override
    public ComentarioDTO crearComentario(long publicacionId, ComentarioDTO comentariodto) {
        Comentario comentario = maperEntidad(comentariodto);
        Publicacion publicacion= publicacionRepositorio.findById(publicacionId)
                .orElseThrow(()->new ResourceNotFoundException("Publicacion","id",publicacionId));
        comentario.setPublicacion(publicacion);
        Comentario nuevoComentario = comentarioRepositorio.save(comentario);
        return mapearDTO(comentario);
    }

    @Override
    public List<ComentarioDTO> obtenerComentariosPorPublicacionId(long publicacionId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ComentarioDTO obtenerComentarioPorId(Long publicacionId, Long comentarioId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ComentarioDTO actualizarComentario(Long publicacionId, Long comentarioId, ComentarioDTO solicitudDeComentario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarComentario(Long publicacionId, Long comentarioId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private ComentarioDTO mapearDTO(Comentario comentario){
        ComentarioDTO comentarioDTO = new ComentarioDTO();
        comentarioDTO.setId(comentario.getId());
        comentarioDTO.setNombre(comentario.getNombre());
        comentarioDTO.setEmail(comentario.getEmail());
        comentarioDTO.setCuerpo(comentario.getCuerpo());
        return comentarioDTO;
    }
    
    private Comentario maperEntidad(ComentarioDTO comentarioDTO){
        Comentario comentario = new Comentario();
        comentario.setId(comentarioDTO.getId());
        comentario.setNombre(comentarioDTO.getNombre());
        comentario.setEmail(comentarioDTO.getEmail());
        comentario.setCuerpo(comentarioDTO.getCuerpo());
        return comentario;
    }
    
}
