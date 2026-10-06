 import java.util.Random;
import java.util.Scanner;

public class Ejercicio12 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();

        int[] A = new int[10];
        int[] B = new int[10];

        for (int i = 0; i < A.length; i++) {
            A[i] = aleatorio.nextInt(10) + 1;
        }

        System.out.println("Arreglo A:");

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }

        System.out.print("\n\nIngrese el valor X: ");
        int x = entrada.nextInt();

        int cantidad = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] == x) {
                B[cantidad] = i + 1;
                cantidad++;
            }
        }

        System.out.println("\nPosiciones donde aparece " + x + ":");

        for (int i = 0; i < cantidad; i++) {
            System.out.print(B[i] + " ");
        }

        System.out.println();
    }
}

