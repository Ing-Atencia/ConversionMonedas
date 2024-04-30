package com.atencia.record;

public record ConsultaMonedaRecordEspecifica(String timeLastUpdateUtc,
                                             String timeNextUpdateUtc,
                                             String baseCode, String targetCode,
                                             double conversionRate) {
}

