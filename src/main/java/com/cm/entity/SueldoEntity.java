package com.cm.entity;

import reactor.core.publisher.Mono;

import java.util.Map;

public interface SueldoEntity {
    public Mono<Map> getTablasSalarioDiario();
}
