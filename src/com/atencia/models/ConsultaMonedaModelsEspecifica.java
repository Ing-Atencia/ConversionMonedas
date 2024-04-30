package com.atencia.models;

import com.atencia.record.ConsultaMonedaRecordEspecifica;

public class ConsultaMonedaModelsEspecifica {

    private final String timeLastUpdateUtc;
    private final String timeNextUpdateUtc;
    private final String baseCode;
    private final String targetCode;
    private final double conversionRate;

    public ConsultaMonedaModelsEspecifica(ConsultaMonedaRecordEspecifica monedaRecordEspecifica) {

        this.timeLastUpdateUtc = monedaRecordEspecifica.timeLastUpdateUtc();
        this.timeNextUpdateUtc = monedaRecordEspecifica.timeNextUpdateUtc();
        this.baseCode = monedaRecordEspecifica.baseCode();
        this.targetCode = monedaRecordEspecifica.targetCode();
        this.conversionRate = monedaRecordEspecifica.conversionRate();

    }

@Override
public String toString() {
    return "Consulta Dos Divisas: \n" +
            "⏰ Última actualización: " + timeLastUpdateUtc + "\n" +
            "⏳ Próxima actualización: " + timeNextUpdateUtc + "\n" +
            "🌐 Código base: " + baseCode + "\n" +
            "🎯 Código objetivo: " + targetCode + "\n" +
            "💱 Tasa de conversión: " + conversionRate + "\n";
}

}



