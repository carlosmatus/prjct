package com.cm.controller;

import com.cm.service.ISRService;
import com.google.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ISRController {
    private ISRService isrService;

    @Inject
    public ISRController(ISRService sueldoService) {
        this.isrService =sueldoService;
    }

    @GetMapping(path = "/employees/{employeeId}/{sueldoDiario}")
    public Mono<Double> calculaSueldoMensual(@PathVariable(value = "sueldoDiario", required = true) Double sueldoDiario){

        return isrService.calculaISR(sueldoDiario);

    }
}
