package controller.ejercicios;

import java.util.Scanner;

enum RangoConsumo {
    BASE(0, 15, 3.00, 0),
    RANGO_1(15, 25, 0.10, 15),
    RANGO_2(25, 40, 0.20, 25),
    RANGO_3(40, 60, 0.30, 40),
    EXCEDENTE(60, Integer.MAX_VALUE, 0.35, 60);

    private final int limiteInferior;
    private final int limiteSuperior;
    private final double costoPorMetroAdicional;
    private final int baseAnterior;

    RangoConsumo(int limiteInferior, int limiteSuperior, double costoPorMetroAdicional, int baseAnterior) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.costoPorMetroAdicional = costoPorMetroAdicional;
        this.baseAnterior = baseAnterior;
    }

    public int getLimiteInferior() {
        return limiteInferior;
    }

    public int getLimiteSuperior() {
        return limiteSuperior;
    }

    public double getCostoPorMetroAdicional() {
        return costoPorMetroAdicional;
    }

    public int getBaseAnterior() {
        return baseAnterior;
    }

    public static RangoConsumo obtenerRango(int consumo) {
        for (RangoConsumo rango : RangoConsumo.values()) {
            if (consumo > rango.getLimiteInferior() && consumo <= rango.getLimiteSuperior()) {
                return rango;
            }
        }
        return null;
    }
}

public class CalculoTarifasAgua {

    public static double calcularCostoBase(int consumo) {
        double costoTotal = 0.0;
        for (RangoConsumo rango : RangoConsumo.values()) {
            if (consumo > rango.getLimiteInferior()) {
                int consumoEnRango = Math.min(consumo, rango.getLimiteSuperior()) - rango.getLimiteInferior();
                costoTotal += consumoEnRango * rango.getCostoPorMetroAdicional();
            } else {
                break;
            }
        }
        return costoTotal;
    }

    public static double aplicarDescuentoTerceraEdad(int consumo, double costoBase) {
        if (consumo <= 15) {
            return costoBase * 0.5;
        } else {
            double descuentoBase = 15 * 0.5; // 50% 
            double restoCosto = costoBase - (15 * 0.10); // no ahi descuento xd
            return descuentoBase + restoCosto;
        }
    }

    public static double aplicarDescuentoDiscapacidad(int consumo, double costoBase, double porcentajeDiscapacidad) {
        double descuento = (15 * porcentajeDiscapacidad / 100);
        return costoBase - descuento;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el consumo de agua en m³: ");
        int consumo = scanner.nextInt();

        System.out.print("¿El contribuyente es de tercera edad? (true/false): ");
        boolean esTerceraEdad = scanner.nextBoolean();

        System.out.print("¿El contribuyente tiene discapacidad? (true/false): ");
        boolean tieneDiscapacidad = scanner.nextBoolean();

        double porcentajeDiscapacidad = 0.0;
        if (tieneDiscapacidad) {
            System.out.print("Ingrese el porcentaje de discapacidad: ");
            porcentajeDiscapacidad = scanner.nextDouble();
        }

        // los costitos
        double costoBase = calcularCostoBase(consumo);
        double impuestoAlcantarillado = costoBase * 0.35;
        double tasaBasura = 0.75;
        double tasaProcesamiento = 0.50;
        double costoFinal = costoBase + impuestoAlcantarillado + tasaBasura + tasaProcesamiento;

        // descuentitos
        if (esTerceraEdad) {
            costoBase = aplicarDescuentoTerceraEdad(consumo, costoBase);
        } else if (tieneDiscapacidad) {
            costoBase = aplicarDescuentoDiscapacidad(consumo, costoBase, porcentajeDiscapacidad);
        }

        costoFinal = costoBase + impuestoAlcantarillado + tasaBasura + tasaProcesamiento;

        // resultraditos
        System.out.println("\n--- Detalle de la Factura ---");
        System.out.printf("Consumo en m³: %d%n", consumo);
        System.out.printf("Costo base: $%.2f%n", costoBase);
        System.out.printf("Impuesto de alcantarillado: $%.2f%n", impuestoAlcantarillado);
        System.out.printf("Tasa por recolección de basura: $%.2f%n", tasaBasura);
        System.out.printf("Tasa por procesamiento de datos: $%.2f%n", tasaProcesamiento);
        System.out.printf("Costo total: $%.2f%n", costoFinal);

        scanner.close();
    }
}
