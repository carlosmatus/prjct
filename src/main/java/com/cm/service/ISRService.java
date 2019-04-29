package com.cm.service;

import reactor.core.publisher.Mono;

public interface ISRService {
    public Mono<Double> calculaSueldoMensual(Double SueldoDiario);
    public Mono<Double> calculaISR(Double SueldoDiario);
}
