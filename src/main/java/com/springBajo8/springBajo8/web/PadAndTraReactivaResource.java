package com.springBajo8.springBajo8.web;

import com.springBajo8.springBajo8.domain.PadAndTraDTOReactiva;
import com.springBajo8.springBajo8.service.PadAndTraReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PadAndTraReactivaResource {

    @Autowired
    PadAndTraReactivaService service;

    @PostMapping(value = "/padecimientos")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PadAndTraDTOReactiva> agregar(@RequestBody PadAndTraDTOReactiva padAndTraDTOReactiva){
        return service.save(padAndTraDTOReactiva);
    }

    @GetMapping(value = "/padecimientos")
    public Flux<PadAndTraDTOReactiva> obtenerTodos(){
        return service.findAll();
    }

    @GetMapping(value = "/padecimientos/{id}")
    public Mono<PadAndTraDTOReactiva> obtenerUno(@PathVariable("id") String id){
        return service.findById(id);
    }

    @GetMapping(value = "/padecimientos/{idPaciente}/pacientes")
    public Mono<PadAndTraDTOReactiva> obtenerPorIdPaciente(@PathVariable("idPaciente") String idPaciente){
        return service.findByIdPaciente(idPaciente);
    }
}
