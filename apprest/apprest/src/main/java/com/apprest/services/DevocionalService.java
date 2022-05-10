package com.apprest.services;

import com.apprest.entities.Devocional;
import com.apprest.handlerexception.EntityNotFoundException;
import com.apprest.repositories.DevocionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevocionalService {
    
    private final DevocionalRepository devocionalRepository;

    public DevocionalService(DevocionalRepository devocionalRepository) {
        this.devocionalRepository = devocionalRepository;
    }

    public List<Devocional> BuscarTodos(){
        return devocionalRepository.findAll();
    }

    public Optional<Devocional> buscarPorId(Long id) {
        Optional<Devocional> devocionalId = checkIfEntityIsValid(id);
        return devocionalId;
    }

    public Devocional adicionarDevocional(Devocional devocional) {
        return devocionalRepository.save(devocional);
    }

    public Devocional atualizarDevocional(Long id, Devocional devocional) {
        @SuppressWarnings("unused")
        Optional<Devocional> devocionalUpdate = checkIfEntityIsValid(id);

        devocional.setId(id);
        devocionalRepository.save(devocional);

        return devocional;
    }

    public void deletarDevocional(Long id) {
        @SuppressWarnings("unused")
        Optional<Devocional> devocionalDelete = checkIfEntityIsValid(id);
        devocionalRepository.deleteById(id);
    }

    private Optional<Devocional> checkIfEntityIsValid(Long id) {
        Optional<Devocional> devocionalIdIsValid = devocionalRepository.findById(id);

        if (!devocionalIdIsValid.isPresent()) {
            throw new EntityNotFoundException("Id Not Found!");
        }

        return devocionalIdIsValid;
    }

}
