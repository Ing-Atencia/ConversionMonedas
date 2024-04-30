import com.atencia.data.ConsultaMonedaData;
import com.atencia.data.ConsultaMonedaDataEspecifica;
import com.atencia.data.ConversionDeMonedaData;
import com.atencia.util.GuardarHistorialConversion;
import com.atencia.util.MostrarHistorial;

import java.io.IOException;
import java.util.Scanner;

public class ConversorMonedasSaj {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        ConsultaMonedaData consultaMoneda = new ConsultaMonedaData();

        ConsultaMonedaDataEspecifica consultaMonedaDataEspecificac = new ConsultaMonedaDataEspecifica();

        ConversionDeMonedaData conversionDeMoneda = new ConversionDeMonedaData();


        boolean bandera = true;

        while (bandera) {

            System.out.println("Divisas Opcionadas: 💵 ARS, 💵 BOB, 💵 BRL, 💵 CLP, 💵 COP, 💵 USD");

            System.out.println("Menú Principal:");
            System.out.println("1. Convertir Moneda");
            System.out.println("2. Convertir Moneda Específica");
            System.out.println("3. Realizar Conversión de Moneda");
            System.out.println("4. Historial de conversiones de divisas");
            System.out.println("5. Salir");


            System.out.println("Escoja una opcion del menu de divisas: ");
            int opcion = scanner.nextInt();


            switch (opcion) {
                case 1:
                    consultaMoneda.convierteMoneda();

                    break;
                case 2:
                    consultaMonedaDataEspecificac.convierteMonedaEspecifica();

                    break;
                case 3:
                    conversionDeMoneda.conversionDeMoneda();

                    break;
                case 4:
                    MostrarHistorial.historialConversionMoneda();
                    break;
                case 5:
                    System.out.println("Finalizando Programa, Gracias por usar nuestro Sistema");
                    bandera = false;
                    break;

                default:
                    System.out.println("Opcion no valida, ingrese una opcion del menu");
                    break;
            }
        }

    }
}
