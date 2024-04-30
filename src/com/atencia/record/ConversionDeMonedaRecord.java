package com.atencia.record;

public record ConversionDeMonedaRecord(String timeLastUpdateUtc,
                                       String timeNextUpdateUtc,
                                       String baseCode, String targetCode,
                                       double conversionRate, double conversionResult) {
}
