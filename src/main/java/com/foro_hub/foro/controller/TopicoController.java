package com.foro_hub.foro.controller;

import com.foro_hub.foro.domain.Topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/foro")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity CrearTopico(@RequestBody DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datos));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo());
        URI url = uriComponentsBuilder.path("/foro/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopicos>> listadoTopicos(@PageableDefault(size = 5) Pageable paginacion){
        //return topicoRepository.findAll(paginacion).map(DatosListaTopicos::new);
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListaTopicos::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListaTopicos> listadoTopicos(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosListaTopicos(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getStatus());
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizaTopico(@RequestBody @Valid DatosActualizaTopico datosActualizaTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizaTopico.id());
        topico.actualizarDatos(datosActualizaTopico);

        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo()));
    }

    /*@DeleteMapping("/{id}")
    @Transactional
    public void eliminadoLogico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }*/

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminadoLogico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

}
