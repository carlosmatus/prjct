package com.cm.guice;

import com.cm.entity.SueldoEntity;
import com.cm.entity.SueldoEntityImpl;
import com.cm.service.ISRService;
import com.cm.service.ISRServiceImpl;
import com.google.inject.AbstractModule;

public class SueldoGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        System.out.println("Desde el configu de abstract Module");
        bind(ISRService.class).to(ISRServiceImpl.class);
        bind(SueldoEntity.class).to(SueldoEntityImpl.class);
    }
}
