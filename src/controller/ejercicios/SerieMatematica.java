package controller.ejercicios;
import java.util.Scanner;

public class SerieMatematica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // num de term
        System.out.print("Ingrese el número de términos de la serie: ");
        int n = scanner.nextInt();

        double suma = 0;
        int signo = 1; // positivo o negativo bro
        int numeradorAnterior = 0;
        int denominadorAnterior = 1;

        System.out.println("Términos de la serie:");

        for (int i = 1; i <= n; i++) {
            // numerador
            int numerador = (i <= 2) ? i : numeradorAnterior + denominadorAnterior;
            numeradorAnterior = denominadorAnterior;
            denominadorAnterior = numerador;

            // denominador
            int denominador = 2 * i + 1;

            // el exponente
            int exponente = 2 * i;

            // termino actual
            double termino = Math.pow((double) numerador / denominador, exponente);

            // se suma o se resta
            suma += signo * termino;
            signo *= -1; // Alternar signo

            // termino
            System.out.printf("Término %d: (%d / %d)^%d = %.6f%n", i, numerador, denominador, exponente, signo * termino);
        }

        System.out.printf("\nSuma de la serie: %.6f%n", suma);

        scanner.close();
    }
}
