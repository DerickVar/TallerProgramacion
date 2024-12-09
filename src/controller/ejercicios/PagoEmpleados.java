package controller.ejercicios;

import java.util.Scanner;
import controller.util.Utilidades;

class Empleado {
    private String nombre;
    private final double sueldoBase = 2500.00;
    private int autosVendidos;
    private double valorTotalVentas;
    private double comisionTotal;
    private double utilidadTotal;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.autosVendidos = 0;
        this.valorTotalVentas = 0.0;
        this.comisionTotal = 0.0;
        this.utilidadTotal = 0.0;
    }

    public void registrarVenta(double precioAuto) {
        autosVendidos++;
        valorTotalVentas += precioAuto;
        // se supera $10,000 para sumar la comisión
        if (precioAuto > 10000.00) {
            comisionTotal += 250.00;
        }
        // utilidad como el 5% del totalsito
        utilidadTotal = valorTotalVentas * 0.05;
    }

    public void generarInforme() {
        double sueldoTotal = sueldoBase + comisionTotal + utilidadTotal;

        System.out.println("\n--- Informe del Empleado ---");
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Sueldo base: $" + Utilidades.redondear((float) sueldoBase));
        System.out.println("Autos vendidos: " + autosVendidos);
        System.out.println("Valor total de ventas: $" + Utilidades.redondear((float) valorTotalVentas));
        System.out.println("Comisión total: $" + Utilidades.redondear((float) comisionTotal));
        System.out.println("Utilidad por ventas: $" + Utilidades.redondear((float) utilidadTotal));
        System.out.println("Sueldo total: $" + Utilidades.redondear((float) sueldoTotal));
    }
}

public class PagoEmpleados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del empleado: ");
        String nombreEmpleado = scanner.nextLine();
        Empleado empleado = new Empleado(nombreEmpleado);

        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingrese el precio del automóvil vendido (o -1 para terminar): ");
            String input = scanner.next();

            if (input.equals("-1")) {
                continuar = false;
            } else if (Utilidades.validate(input)) {
                double precioAuto = Utilidades.transformStringDouble(input);
                empleado.registrarVenta(precioAuto);
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
            }
        }

        empleado.generarInforme();
        scanner.close();
    }
}
