package controller.ejercicios;

import java.util.Scanner;

enum Zona {
    AMERICA_DEL_NORTE(12, 2.75),
    AMERICA_CENTRAL(15, 1.89),
    AMERICA_DEL_SUR(18, 1.60),
    EUROPA(19, 3.5),
    ASIA(23, 4.5),
    AFRICA(25, 3.1),
    OCEANIA(29, 3.0),
    RESTO_DEL_MUNDO(31, 6.0);

    private final int clave;
    private final double minutos;

    Zona(int clave, double minutos) {
        this.clave = clave;
        this.minutos = minutos;
    }

    public int clave() {
        return clave;
    }

    public double minutos() {
        return minutos;
    }

    public static Zona obtenerZonaPorClave(int clave) {
        for (Zona zona : Zona.values()) {
            if (zona.clave() == clave) {
                return zona;
            }
        }
        return null;
    }
}

public class LlamadasInternacionales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Costo de Llamadas Internacionales ---");

        // Zonas disponibles
        System.out.println("Zonas disponibles:");
        for (Zona zona : Zona.values()) {
            System.out.printf("%s (Clave: %d, Precio por minuto: $%.2f)%n", 
                              zona.name().replace("_", " "), 
                              zona.clave(), 
                              zona.minutos());
        }

        // pon la clave
        System.out.print("\nIngrese la clave de la zona: ");
        int clave = scanner.nextInt();
        Zona zonaSeleccionada = Zona.obtenerZonaPorClave(clave);

        if (zonaSeleccionada == null) {
            System.out.println("Clave de zona no válida. Intente de nuevo.");
            return;
        }

        // minutos
        System.out.print("Ingrese el número de minutos hablados: ");
        int minutos = scanner.nextInt();

        // costo
        double costoTotal = minutos * zonaSeleccionada.minutos();

        // resumensito
        System.out.println("\n--- Resumen de la Llamada ---");
        System.out.printf("Zona: %s%n", zonaSeleccionada.name().replace("_", " "));
        System.out.printf("Clave: %d%n", zonaSeleccionada.clave());
        System.out.printf("Precio por minuto: $%.2f%n", zonaSeleccionada.minutos());
        System.out.printf("Minutos hablados: %d%n", minutos);
        System.out.printf("Costo total: $%.2f%n", costoTotal);

        scanner.close();
    }
}
