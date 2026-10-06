import java.util.Scanner;

public class Ejercicio19 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el numero de filas: ");
        int n = entrada.nextInt();

        System.out.print("Ingrese el numero de columnas: ");
        int m = entrada.nextInt();

        int[][] matriz = new int[n][m];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (i == j) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}