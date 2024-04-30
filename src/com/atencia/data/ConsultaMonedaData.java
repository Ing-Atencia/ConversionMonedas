package com.atencia.data;

import com.atencia.models.ConsultaMonedaModels;
import com.atencia.request.MonedasPermitidasModels;
import com.atencia.record.ConsultaMonedaRecord;
import com.google.gson.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.Scanner;

public class ConsultaMonedaData {
    public void convierteMoneda() throws IOException {
        Scanner lectura = new Scanner(System.in);
        MonedasPermitidasModels monedasPermitidasModels = new MonedasPermitidasModels();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting().create();

        System.out.println("Ingrese la Divisa a Consultar: ");
        String tipoMoneda = lectura.nextLine().toUpperCase(Locale.ROOT);

        boolean exisDivisa = monedasPermitidasModels.comprobarDivisa(tipoMoneda);

        if (exisDivisa) {

// Setting URL
            String url_str = "https://v6.exchangerate-api.com/v6/a16b267f31a11c756a009d96/latest/" + tipoMoneda;
// Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

// Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

// Accessing object
            ConsultaMonedaRecord moneda = gson.fromJson(jsonobj.getAsJsonObject("conversion_rates"), ConsultaMonedaRecord.class);
            ConsultaMonedaModels consultaMonedaModels = new ConsultaMonedaModels(moneda);


            System.out.println(consultaMonedaModels);

        }else {
            System.out.println(monedasPermitidasModels.getMensaje());
        }
    }
}
