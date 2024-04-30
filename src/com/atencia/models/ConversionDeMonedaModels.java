package com.atencia.models;

import com.atencia.record.ConversionDeMonedaRecord;

public class ConversionDeMonedaModels {
    private final String timeLastUpdateUtc;
    private final String timeNextUpdateUtc;
    private final String baseCode;
    private final String targetCode;
    private final double conversionRate;
    private final double conversionResult;

    public ConversionDeMonedaModels(ConversionDeMonedaRecord monedaRecordConversion) {

        this.timeNextUpdateUtc = monedaRecordConversion.timeNextUpdateUtc();
        this.timeLastUpdateUtc = monedaRecordConversion.timeLastUpdateUtc();
        this.baseCode = monedaRecordConversion.baseCode();
        this.targetCode = monedaRecordConversion.targetCode();
        this.conversionRate = monedaRecordConversion.conversionRate();
        this.conversionResult = monedaRecordConversion.conversionResult();
    }

    public String getTimeLastUpdateUtc() {
        return timeLastUpdateUtc;
    }

    public String getTimeNextUpdateUtc() {
        return timeNextUpdateUtc;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    @Override
public String toString() {
    return "Conversion De Moneda \n" +
            "⏰ Última actualización: " + timeLastUpdateUtc + "\n" +
            "⏳ Próxima actualización: " + timeNextUpdateUtc + "\n" +
            "🌐 Código base: " + baseCode + "\n" +
            "🎯 Código objetivo: " + targetCode + "\n" +
            "💱 Tasa de conversión: " + conversionRate + "\n" +
            "💲 Resultado de la conversión: " + conversionResult + "\n";
}

}
