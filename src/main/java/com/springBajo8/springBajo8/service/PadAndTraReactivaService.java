package com.springBajo8.springBajo8.service;

import com.springBajo8.springBajo8.domain.PadAndTraDTOReactiva;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PadAndTraReactivaService {

    Mono<PadAndTraDTOReactiva> save(PadAndTraDTOReactiva padAndTraDTOReactiva);

    Flux<PadAndTraDTOReactiva> findAll();

    Mono<PadAndTraDTOReactiva> findById(String id);

    Mono<PadAndTraDTOReactiva> findByIdPaciente(String id);
}
