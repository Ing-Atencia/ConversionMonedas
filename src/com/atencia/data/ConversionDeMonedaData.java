package com.atencia.data;

import com.atencia.models.ConversionDeMonedaModels;
import com.atencia.request.MonedasPermitidasModels;
import com.atencia.record.ConversionDeMonedaRecord;
import com.atencia.util.GuardarHistorialConversion;
import com.google.gson.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.Scanner;

public class ConversionDeMonedaData {

    public void conversionDeMoneda() throws IOException, IOException {
        Scanner scanner = new Scanner(System.in);
        MonedasPermitidasModels monedasPermitidasModels = new MonedasPermitidasModels();


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting().create();

        System.out.println("Ingrese su divisa a convertir: ");
        String dato1 = scanner.nextLine().toUpperCase(Locale.ROOT);
        System.out.println("Ingrese su divisa de conversion: ");
        String dato2 = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese el monto a convertir: ");
        double monto = scanner.nextDouble();

// Setting URL

        boolean exisDivisa1 = monedasPermitidasModels.comprobarDivisa(dato1);
        boolean exisDivisa2 = monedasPermitidasModels.comprobarDivisa(dato2);

        if (exisDivisa1 && exisDivisa2) {
            String url_str = "https://v6.exchangerate-api.com/v6/a16b267f31a11c756a009d96/pair/" + dato1 + "/" + dato2 + "/" + monto;
// Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

// Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            String dataApi = jsonobj.toString();

            ConversionDeMonedaRecord monedaRecordConversion = gson.fromJson(dataApi, ConversionDeMonedaRecord.class);
            ConversionDeMonedaModels modenaEspecifica = new ConversionDeMonedaModels(monedaRecordConversion);

            GuardarHistorialConversion.guardar(modenaEspecifica);

            System.out.println(modenaEspecifica);
        }else {
            System.out.println(monedasPermitidasModels.getMensaje());

        }
    }
}



