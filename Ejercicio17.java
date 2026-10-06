 import java.util.Random;
 
public class Ejercicio17 {

    public static void main(String[] args) {

        int[][] matriz = new int[3][3];

        Random aleatorio = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = aleatorio.nextInt(10) + 1;
            }
        }

        System.out.println("Matriz:");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nSuma de cada fila:");

        for (int i = 0; i < matriz.length; i++) {

            int sumaFila = 0;

            for (int j = 0; j < matriz[i].length; j++) {
                sumaFila = sumaFila + matriz[i][j];
            }

            System.out.println("Fila " + (i + 1) + ": " + sumaFila);
        }

        System.out.println("\nSuma de cada columna:");

        for (int j = 0; j < matriz[0].length; j++) {

            int sumaColumna = 0;

            for (int i = 0; i < matriz.length; i++) {
                sumaColumna = sumaColumna + matriz[i][j];
            }

            System.out.println("Columna " + (j + 1) + ": " + sumaColumna);
        }
    }
}

