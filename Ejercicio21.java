
 import java.util.Random;

public class Ejercicio21 {

    public static void main(String[] args) {

        Random aleatorio = new Random();

        int M = 5;

        int[][] matriz = new int[M][M];
        int[] B = new int[M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                matriz[i][j] = aleatorio.nextInt(20) + 1;
            }
        }

        System.out.println("Matriz:");

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < M; i++) {
            int suma = 0;

            for (int j = 0; j < M; j++) {
                if (matriz[i][j] % 2 == 0) {
                    suma = suma + matriz[i][j];
                }
            }

            B[i] = suma;
        }

        System.out.println("\nVector B:");

        for (int i = 0; i < M; i++) {
            System.out.print(B[i] + " ");
        }
    }
}

