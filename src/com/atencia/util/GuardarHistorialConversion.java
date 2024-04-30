package com.atencia.util;

import com.atencia.models.ConversionDeMonedaModels;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GuardarHistorialConversion {
    public static void guardar(ConversionDeMonedaModels conversionDeMonedaModels) throws IOException, IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File("conversionDeMonedaData.json");
        boolean existeFile = file.exists();
        if (!existeFile) {
            List<ConversionDeMonedaModels> conversionDeMonedaModelsList = new ArrayList<>();
            conversionDeMonedaModelsList.add(conversionDeMonedaModels);

            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(gson.toJson(conversionDeMonedaModelsList));
            printWriter.close();
        } else {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder jsonString = new StringBuilder();
            String informacion;
            while ((informacion = bufferedReader.readLine()) != null) {
                jsonString.append(informacion);
            }
            bufferedReader.close();

            ConversionDeMonedaModels[] arrayInformacion = gson.fromJson(jsonString.toString(), ConversionDeMonedaModels[].class);
            List<ConversionDeMonedaModels> conversionDeMonedaModels1 = List.of();
            if (arrayInformacion != null) {
                conversionDeMonedaModels1 = new ArrayList<>(List.of(arrayInformacion));
            }
            conversionDeMonedaModels1.add(conversionDeMonedaModels);

            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(gson.toJson(conversionDeMonedaModels1));
            printWriter.close();
        }

    }
}
