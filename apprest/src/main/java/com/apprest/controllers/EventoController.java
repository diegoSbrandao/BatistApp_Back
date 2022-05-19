package com.apprest.controllers;

import com.apprest.entities.Evento;
import com.apprest.services.EventoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(value="EventoEndpoint", description = "Evento, Descrição dos Métodos",tags = {"EventoEndpoint"})
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @ApiOperation(value = "Retorna uma lista de todos os eventos cadastrados.")
    @GetMapping
    public ResponseEntity<List<Evento>> obterTodos(){
        List<Evento> eventos = eventoService.BuscarTodos();
        return ResponseEntity.ok(eventos);
    }

    @ApiOperation(value = "Retorna um único evento pelo seu id.")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Evento>> obterPorId(@PathVariable Long id){
        Optional<Evento> evento = eventoService.buscarPorId(id);
        return ResponseEntity.ok(evento);
    }

    @ApiOperation(value = "Adiciona (salva) um evento.")
    @PostMapping()
    public ResponseEntity<Evento> adicionarEvento(@Valid @RequestBody Evento evento){
        evento = eventoService.adicionarEvento(evento);
        return new ResponseEntity<>(evento,HttpStatus.CREATED);
    }

    @ApiOperation(value = "Atualiza um evento existente.")
    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizarEvento(@PathVariable Long id, @Valid @RequestBody Evento evento){
        evento = eventoService.atualizarEvento(id,evento);
        return new ResponseEntity<>(
                evento,
                HttpStatus.OK);
    }

    @ApiOperation(value = "Deleta um evento existente.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEvento(@PathVariable Long id){
        eventoService.deletarEvento(id);
        return ResponseEntity.noContent().build();
    }

}