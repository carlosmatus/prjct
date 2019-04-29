package com.cm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import reactor.core.publisher.Mono;

import java.util.Map;

@ToString
@Setter
@Getter
public class SueldoEntityImpl implements SueldoEntity {
    private String mensaje="to string de entity ";
    @Override
    public Mono<Map> getTablasSalarioDiario() {
        return null;
    }
}
