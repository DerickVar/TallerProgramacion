package controller.ejercicios;

public class SemanaLaboral {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Ingrese un día (1-5): ");
        int dia = scanner.nextInt();
        
        if (dia < 1 || dia > 5) {
            System.out.println("Entrada inválida. Por favor ingrese un número entre 1 y 5.");
            scanner.close();
            return;
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println("El día de la semana es: " + i);

            if (i % 2 == 0) {
                System.out.println("Hoy es un gran día para Teoría de la Programación");
            }

            if (dia == i) {
                break;
            }
        }

        scanner.close();
    }
}
