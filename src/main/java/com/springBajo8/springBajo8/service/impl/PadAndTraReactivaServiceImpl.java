package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.PadAndTraDTOReactiva;
import com.springBajo8.springBajo8.repository.PadAndTraReactivaRepository;
import com.springBajo8.springBajo8.service.PadAndTraReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PadAndTraReactivaServiceImpl implements PadAndTraReactivaService {

    @Autowired
    private PadAndTraReactivaRepository repository;


    @Override
    public Mono<PadAndTraDTOReactiva> save(PadAndTraDTOReactiva padAndTraDTOReactiva) {
        return this.repository.save(padAndTraDTOReactiva)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<PadAndTraDTOReactiva> findAll() {
        return this.repository.findAll()
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<PadAndTraDTOReactiva> findById(String id) {
        return this.repository.findById(id)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<PadAndTraDTOReactiva> findByIdPaciente(String id) {
        return this.repository.findByIdPaciente(id)
                .switchIfEmpty(Mono.empty());
    }
}
