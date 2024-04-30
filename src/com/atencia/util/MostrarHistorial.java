package com.atencia.util;

import com.atencia.models.ConversionDeMonedaModels;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MostrarHistorial {

    public static void historialConversionMoneda() throws IOException {
        if (!Files.exists(Paths.get("conversionDeMonedaData.json"))) {
            System.out.println("No hay historial por mostar");
            return;
        }
        String contenido = new String(Files.readAllBytes(Paths.get("conversionDeMonedaData.json")));
        Gson gson = new Gson();
        ConversionDeMonedaModels[] conversionDeMonedaModels = gson.fromJson(contenido, ConversionDeMonedaModels[].class);
        System.out.println("\n📜 Historial de Conversiones 📜\n");
        for (ConversionDeMonedaModels historial : conversionDeMonedaModels) {

            System.out.println("⏰ Última actualización: " + historial.getTimeLastUpdateUtc() + "\n" +
                    "⏳ Próxima actualización: " + historial.getTimeNextUpdateUtc() + "\n" +
                    "🌐 Código base: " + historial.getBaseCode() + "\n" +
                    "🎯 Código objetivo: " + historial.getTargetCode() + "\n" +
                    "💱 Tasa de conversión: " + historial.getConversionRate() + "\n" +
                    "💲 Resultado de la conversión: " + historial.getConversionResult() + "\n" +
                    "========================================================");

        }
    }


}
