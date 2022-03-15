package com.apprest.apprest.controllers;

import com.apprest.apprest.entities.Evento;
import com.apprest.apprest.services.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }
    @GetMapping
    public ResponseEntity<List<Evento>> obterTodos(){
        List<Evento> eventos = eventoService.BuscarTodos();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Evento>> obterPorId(@PathVariable Long id){
        Optional<Evento> evento = eventoService.buscarPorId(id);
        return ResponseEntity.ok(evento);
    }

    @PostMapping()
    public ResponseEntity<Evento> adicionarEvento(@Valid @RequestBody Evento evento){
        evento = eventoService.adicionarEvento(evento);
        return new ResponseEntity<>(evento,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizarEvento(@PathVariable Long id, @Valid @RequestBody Evento evento){
        evento = eventoService.atualizarEvento(id,evento);
        return new ResponseEntity<>(
                evento,
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEvento(@PathVariable Long id){
        eventoService.deletarEvento(id);
        return ResponseEntity.noContent().build();
    }

}