package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.repository.IcitasReactivaRepository;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class citasReactivaServiceImpl implements IcitasReactivaService {

    @Autowired
    private IcitasReactivaRepository IcitasReactivaRepository;

    @Override
    public Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.save(citasDTOReactiva);
    }

    @Override
    public Mono<citasDTOReactiva> delete(String id) {
        return this.IcitasReactivaRepository
                .findById(id)
                .flatMap(p -> this.IcitasReactivaRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    citasDTOReactiva.setId(id);
                    return save(citasDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<citasDTOReactiva> findByIdPaciente(String idPaciente) {
        return this.IcitasReactivaRepository.findByIdPaciente(idPaciente);
    }


    @Override
    public Flux<citasDTOReactiva> findAll() {
        return this.IcitasReactivaRepository.findAll();
    }

    @Override
    public Mono<citasDTOReactiva> findById(String id) {
        return this.IcitasReactivaRepository.findById(id);
    }

    @Override
    public Mono<citasDTOReactiva> findCita(citasDTOReactiva cita) {
        return this.IcitasReactivaRepository.findByFechaReservaCita(cita.getFechaReservaCita())
                .filter(citasDTOReactiva ->
                        citasDTOReactiva.getHoraReservaCita().equals(cita.getHoraReservaCita()))
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<citasDTOReactiva> cancelCita(String id) {
        return this.IcitasReactivaRepository.findById(id)
                .flatMap(citasDTOReactiva -> {
                    if(citasDTOReactiva.getEstadoReservaCita()){
                        citasDTOReactiva.setEstadoReservaCita(false);
                        return save(citasDTOReactiva);
                    }
                    return Mono.empty();
                });
    }

    @Override
    public Mono<citasDTOReactiva> findByFechaReservaCita(String fecha) {
        return this.IcitasReactivaRepository.findByFechaReservaCita(fecha)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public String findByNombreMedicoCita(String id) {
        citasDTOReactiva cita = IcitasReactivaRepository.findById(id).block();
        return cita.getNombreMedico() + " " + cita.getApellidosMedico();
    }
}
