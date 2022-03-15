package com.apprest.apprest.controllers;

import com.apprest.apprest.entities.Devocional;
import com.apprest.apprest.services.DevocionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/devocional")
public class DevocionalController {
    
    private final DevocionalService devocionalService;

    public DevocionalController(DevocionalService devocionalService) {
        this.devocionalService = devocionalService;
    }
    @GetMapping
    public ResponseEntity<List<Devocional>> obterTodos(){
        List<Devocional> devocionals = devocionalService.BuscarTodos();
        return ResponseEntity.ok(devocionals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Devocional>> obterPorId(@PathVariable Long id){
        Optional<Devocional> devocional = devocionalService.buscarPorId(id);
        return ResponseEntity.ok(devocional);
    }

    @PostMapping()
    public ResponseEntity<Devocional> adicionarDevocional(@Valid @RequestBody Devocional devocional){
        devocional = devocionalService.adicionarDevocional(devocional);
        return new ResponseEntity<>(devocional, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Devocional> atualizarDevocional(@PathVariable Long id, @Valid @RequestBody Devocional devocional){

        devocional = devocionalService.atualizarDevocional(id,devocional);
        return new ResponseEntity<>(
                devocional,
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDevocional(@PathVariable Long id){
        devocionalService.deletarDevocional(id);
        return ResponseEntity.noContent().build();
    }

}