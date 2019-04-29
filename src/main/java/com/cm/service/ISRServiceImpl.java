package com.cm.service;

import com.cm.entity.SueldoEntity;
import com.google.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import reactor.core.publisher.Mono;

import java.text.DecimalFormat;



@ToString
@Getter @Setter
//@Service
public class ISRServiceImpl implements ISRService {
    private SueldoEntity sueldoEntity;

    private static final double[][] isrTable = new double[][]{
            { 0.01, 496.07, 0.0, 1.92 },
            { 496.08, 4210.41, 9.52, 6.40 },
            { 4210.42, 7399.42, 247.24, 10.88 },
            { 7399.43, 8601.50, 594.21, 16.00 },
            { 8601.51, 10298.35, 786.54, 17.92},
            { 10298.36, 20770.29, 1090.61, 21.36},
            { 20770.30, 32737.83, 3327.42, 23.52},
            { 32737.84, 62500.00, 6141.95, 30.00},
            { 62500.00, 83333.33, 15070.90, 32.00},
            { 83333.33, 250000, 21737.57, 34.00}

    };

    @Inject
    public ISRServiceImpl(SueldoEntity sueldoEntity) {
        this.sueldoEntity=sueldoEntity;
    }

    private Double sueldoDiario=0.0;
    private Double salarioMinimo= 102.68;


    @Override
    public Mono<Double> calculaSueldoMensual(Double sueldoDiario) {
        this.sueldoDiario=sueldoDiario>0 ? sueldoDiario : salarioMinimo;
        return Mono.just(sueldoDiario*30);

    }


    public  Mono<Double> calculaISR(Double sueldoDiario){
        this.sueldoDiario=sueldoDiario>0 ? sueldoDiario : salarioMinimo;
        double sueldoMensual = this.sueldoDiario*30;
        double limiteInferior = -1;
        double base = -1;
        double coutaFija=-1;
        double tasa = -1;
        double isrPagar = -1;

        for(int i=0;i<isrTable.length;i++) {
            if(sueldoMensual>=isrTable[i][0] && sueldoMensual<=isrTable[i][1]) {
                tasa = isrTable[i][3];
                limiteInferior = isrTable[i][0];
                coutaFija= isrTable[i][2];
                base = sueldoMensual-limiteInferior;
                isrPagar = base * (tasa/100)+coutaFija;
                System.out.println("el impuesto a pagar es "+isrPagar);
            }
        }
        if( tasa == -1 ) return Mono.just(-1.0);
        DecimalFormat df = new DecimalFormat("####0.00");
        return  Mono.just(Double.parseDouble(df.format(isrPagar)));

    }


}
