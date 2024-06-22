package com.foro_hub.foro.controller;

import com.foro_hub.foro.Topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/foro")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void CrearTopico(@RequestBody DatosRegistroTopico datos){
        topicoRepository.save(new Topico(datos));
    }

    @GetMapping
    public Page<DatosListaTopicos> listadoTopicos(@PageableDefault(size = 5) Pageable paginacion){
        //return topicoRepository.findAll(paginacion).map(DatosListaTopicos::new);
        return topicoRepository.findByActivoTrue(paginacion).map(DatosListaTopicos::new);
    }

    @GetMapping("/{id}")
    public Optional<DatosListaTopicos> listadoTopicos(@PathVariable Long id){
        if(topicoRepository.findById(id) == null){
            System.out.println("No existe dicho topico puedes crearlo");
        }
        return topicoRepository.findById(id).stream().map(DatosListaTopicos::new).findFirst();
    }

    @PutMapping
    @Transactional
    public void actualizaTopico(@RequestBody @Valid DatosActualizaTopico datosActualizaTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizaTopico.id());

        topico.actualizarDatos(datosActualizaTopico);
    }

    /*@DeleteMapping("/{id}")
    @Transactional
    public void eliminadoLogico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }*/

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminadoLogico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
    }

}
