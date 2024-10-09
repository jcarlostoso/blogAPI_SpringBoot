/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jcarlostoso.blogApis.servicio;

import com.jcarlostoso.blogApis.dto.PublicacionDTO;
import com.jcarlostoso.blogApis.dto.PublicacionRespuesta;
import com.jcarlostoso.blogApis.entidades.Publicacion;
import com.jcarlostoso.blogApis.excepciones.ResourceNotFoundException;
import com.jcarlostoso.blogApis.repositorio.PublicacionRepositorio;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author bynot
 */
@Service

public class PublicacionServicioImpl implements PublicacionServicio {

    @Autowired
    private PublicacionRepositorio publicacionRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO) {

        Publicacion publicacion = mapearEntidad(publicacionDTO);
        Publicacion nuevaPublicacion = publicacionRepositorio.save(publicacion);

        PublicacionDTO publicacionRespuesta = mapearDTO(nuevaPublicacion);
        return publicacionRespuesta;
    }

    @Override
public PublicacionRespuesta obtenerTodasLasPublicaciones(int numeroDePagina, int medidaDePagina, String ordenarPor,
			String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(ordenarPor).ascending()
				: Sort.by(ordenarPor).descending();
		Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);

		Page<Publicacion> publicaciones = publicacionRepositorio.findAll(pageable);

		List<Publicacion> listaDePublicaciones = publicaciones.getContent();
		List<PublicacionDTO> contenido = listaDePublicaciones.stream().map(publicacion -> mapearDTO(publicacion))
				.collect(Collectors.toList());

		PublicacionRespuesta publicacionRespuesta = new PublicacionRespuesta();
		publicacionRespuesta.setContenido(contenido);
		publicacionRespuesta.setNumeroPagina(publicaciones.getNumber());
		publicacionRespuesta.setMedidaPagina(publicaciones.getSize());
		publicacionRespuesta.setTotalElementos(publicaciones.getTotalElements());
		publicacionRespuesta.setTotalPaginas(publicaciones.getTotalPages());
		publicacionRespuesta.setUltima(publicaciones.isLast());

		return publicacionRespuesta;
	}

// Convierte entidad a DTO
    private PublicacionDTO mapearDTO(Publicacion publicacion) {

        /*
        //se quita para usar ModelMapper
        PublicacionDTO publicacionDTO = new PublicacionDTO();
        publicacionDTO.setId(publicacion.getId());
        publicacionDTO.setTitulo(publicacion.getTitulo());
        publicacionDTO.setDescripcion(publicacion.getDescripcion());
        publicacionDTO.setContenido(publicacion.getContenido());
        publicacionDTO.setComentarios(publicacion.getComentarios());
         */
        PublicacionDTO publicacionDTO = modelMapper.map(publicacion, PublicacionDTO.class);
        return publicacionDTO;
    }

    // Convierte de DTO a Entidad
    private Publicacion mapearEntidad(PublicacionDTO publicacionDTO) {
        /*
         //se quita para usar ModelMapper
        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo(publicacionDTO.getTitulo());
        publicacion.setDescripcion(publicacionDTO.getDescripcion());
        publicacion.setContenido(publicacionDTO.getContenido());
        publicacion.setComentarios(publicacionDTO.getComentarios());
         */
        Publicacion publicacion = modelMapper.map(publicacionDTO, Publicacion.class);
        return publicacion;
    }

	@Override
	public PublicacionDTO obtenerPublicacionPorId(long id) {
		Publicacion publicacion = publicacionRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", id));
		return mapearDTO(publicacion);
	}

    @Override
    public PublicacionDTO actualizarPublicacion(PublicacionDTO publicacionDTO, long id) {
        Publicacion publicacion = publicacionRepositorio
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", id));

        publicacion.setTitulo(publicacionDTO.getTitulo());
        publicacion.setDescripcion(publicacionDTO.getDescripcion());
        publicacion.setContenido(publicacionDTO.getContenido());

        Publicacion publicacionActualizada = publicacionRepositorio.save(publicacion);
        return mapearDTO(publicacionActualizada);
    }

    @Override
    public void eliminarPublicacion(long id) {
        Publicacion publicacion = publicacionRepositorio
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", id));
        publicacionRepositorio.delete(publicacion);
    }
}
