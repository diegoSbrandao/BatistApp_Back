package com.apprest.controllers;

import com.apprest.entities.Devocional;
import com.apprest.services.DevocionalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(value="DevocionalEndpoint", description = "Devocional, Descrição dos Métodos",tags = {"DevocionalEndpoint"})
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/devocional")
public class DevocionalController {
    
    private final DevocionalService devocionalService;

    public DevocionalController(DevocionalService devocionalService) {
        this.devocionalService = devocionalService;
    }

    @ApiOperation(value = "Retorna uma lista de todos os devocionais cadastrados.")
    @GetMapping
    public ResponseEntity<List<Devocional>> obterTodos(){
        List<Devocional> devocionals = devocionalService.BuscarTodos();
        return ResponseEntity.ok(devocionals);
    }

    @ApiOperation(value = "Retorna um único devocional pelo seu id.")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Devocional>> obterPorId(@PathVariable Long id){
        Optional<Devocional> devocional = devocionalService.buscarPorId(id);
        return ResponseEntity.ok(devocional);
    }

    @ApiOperation(value = "Adiciona (salva) um devocional.")
    @PostMapping()
    public ResponseEntity<Devocional> adicionarDevocional(@Valid @RequestBody Devocional devocional){
        devocional = devocionalService.adicionarDevocional(devocional);
        return new ResponseEntity<>(devocional, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Atualiza um devocional existente.")
    @PutMapping("/{id}")
    public ResponseEntity<Devocional> atualizarDevocional(@PathVariable Long id, @Valid @RequestBody Devocional devocional){

        devocional = devocionalService.atualizarDevocional(id,devocional);
        return new ResponseEntity<>(
                devocional,
                HttpStatus.OK);
    }
    
    @ApiOperation(value = "Deleta um devocional existente.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDevocional(@PathVariable Long id){
        devocionalService.deletarDevocional(id);
        return ResponseEntity.noContent().build();
    }

}