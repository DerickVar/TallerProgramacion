package views;

import controller.ejercicios.CalculoTarifasAgua;
import controller.ejercicios.LlamadasInternacionales;
import controller.ejercicios.PagoEmpleados;
import controller.ejercicios.SerieMatematica;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            
            System.out.println("\n--- Menú de Ejercicios ---");
            System.out.println("1. Serie Matemática");
            System.out.println("2. Llamadas Internacionales");
            System.out.println("3. Cálculo de Tarifas de Agua");
            System.out.println("4. Pago de Empleados");
            System.out.println("5. Salir");
            System.out.print("Ingrese la opción deseada: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nEjecutando SerieMatematica:");
                    SerieMatematica.main(args);
                    break;
                case 2:
                    System.out.println("\nEjecutando LlamadasInternacionales:");
                    LlamadasInternacionales.main(args);
                    break;
                case 3:
                    System.out.println("\nEjecutando CalculoTarifasAgua:");
                    CalculoTarifasAgua.main(args);
                    break;
                case 4:
                    System.out.println("\nEjecutando PagoEmpleados:");
                    PagoEmpleados.main(args);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}
