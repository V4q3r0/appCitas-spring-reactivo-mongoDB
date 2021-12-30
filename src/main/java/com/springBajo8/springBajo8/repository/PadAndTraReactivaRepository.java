package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.PadAndTraDTOReactiva;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PadAndTraReactivaRepository extends ReactiveMongoRepository<PadAndTraDTOReactiva, String> {
    Mono<PadAndTraDTOReactiva> findByIdPaciente(String id);
}
