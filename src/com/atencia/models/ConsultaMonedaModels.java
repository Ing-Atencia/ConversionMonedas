package com.atencia.models;

import com.atencia.record.ConsultaMonedaRecord;

public class ConsultaMonedaModels {


    private final double ars;
    private final double bob;
    private final double brl;
    private final double clp;
    private final double cop;
    private final double usd;

    public ConsultaMonedaModels(ConsultaMonedaRecord moneda) {
        this.ars = moneda.ars();
        this.bob = moneda.bob();
        this.brl = moneda.brl();
        this.clp = moneda.clp();
        this.usd = moneda.usd();
        this.cop = moneda.cop();

    }

@Override
public String toString() {
    return "ConsultaMonedaModels\n" +
            "💵 ARS: " + ars + "\n" +
            "💵 BOB: " + bob + "\n" +
            "💵 BRL: " + brl + "\n" +
            "💵 CLP: " + clp + "\n" +
            "💵 COP: " + cop + "\n" +
            "💵 USD: " + usd + "\n";
}
}
