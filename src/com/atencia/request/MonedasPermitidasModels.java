package com.atencia.request;

import java.util.ArrayList;
import java.util.List;

public class MonedasPermitidasModels {
    private List<String> divisas = new ArrayList<>(List.of(

            "ARS",
            "BOB",
            "BRL",
            "CLP",
            "COP",
            "USD"
    ));
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public boolean comprobarDivisa(String divisa) {
        boolean existeDivisa =  this.divisas.contains(divisa);
        if (!existeDivisa){

            this.mensaje = "Esta divisa " + divisa + " no esta en el sistema";

        }return existeDivisa;

    }

}
