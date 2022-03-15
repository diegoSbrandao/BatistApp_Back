package com.apprest.apprest.services;

import com.apprest.apprest.entities.Evento;
import com.apprest.apprest.handlerexception.EntityNotFoundException;
import com.apprest.apprest.repositories.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> BuscarTodos(){
        return eventoRepository.findAll();
    }

    public Optional<Evento> buscarPorId(Long id) {
        Optional<Evento> eventoId = checkIfEntityIsValid(id);
        return eventoId;
    }

    public Evento adicionarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento atualizarEvento(Long id, Evento evento) {
        @SuppressWarnings("unused")
        Optional<Evento> eventoUpdate = checkIfEntityIsValid(id);

        evento.setId(id);
        eventoRepository.save(evento);

        return evento;
    }

    public void deletarEvento(Long id) {
        @SuppressWarnings("unused")
        Optional<Evento> eventoDelete = checkIfEntityIsValid(id);
        eventoRepository.deleteById(id);
    }

    private Optional<Evento> checkIfEntityIsValid(Long id) {
        Optional<Evento> eventoIdIsValid = eventoRepository.findById(id);

        if (!eventoIdIsValid.isPresent()) {
            throw new EntityNotFoundException("Id Not Found!");

        }

        return eventoIdIsValid;
    }

}
