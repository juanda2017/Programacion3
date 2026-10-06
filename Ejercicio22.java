import java.util.Scanner;

public class Ejercicio22 {

    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el numero de filas: ");
        int filas = entrada.nextInt();

        System.out.print("Ingrese el numero de columnas: ");
        int columnas = entrada.nextInt();

        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = entrada.nextInt();
            }
        }

        System.out.println("\nMatriz:");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        int mayor = matriz[0][0];
        int menor = matriz[0][0];
        int filaMayor = 0;
        int columnaMayor = 0;
        int filaMenor = 0;
        int columnaMenor = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                if (matriz[i][j] > mayor) {
                    mayor = matriz[i][j];
                    filaMayor = i;
                    columnaMayor = j;
                }

                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                    filaMenor = i;
                    columnaMenor = j;
                }
            }
        }

        System.out.println("\nNumero mayor: " + mayor);
        System.out.println("Posicion del mayor: fila " + (filaMayor + 1) + ", columna " + (columnaMayor + 1));

        System.out.println("\nNumero menor: " + menor);
        System.out.println("Posicion del menor: fila " + (filaMenor + 1) + ", columna " + (columnaMenor + 1));
    }
}