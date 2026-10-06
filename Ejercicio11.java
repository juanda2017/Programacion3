
    import java.util.Random;

public class Ejercicio11 {

    public static void main(String[] args) {

        Random aleatorio = new Random();

        int[] A = new int[20];

        int[] negativos = new int[20];
        int[] ceros = new int[20];
        int[] positivos = new int[20];

        int cantidadNegativos = 0;
        int cantidadCeros = 0;
        int cantidadPositivos = 0;

        for (int i = 0; i < A.length; i++) {
            A[i] = aleatorio.nextInt(21) - 10;
        }

        for (int i = 0; i < A.length; i++) {

            if (A[i] < 0) {
                negativos[cantidadNegativos] = A[i];
                cantidadNegativos++;
            } else if (A[i] == 0) {
                ceros[cantidadCeros] = A[i];
                cantidadCeros++;
            } else {
                positivos[cantidadPositivos] = A[i];
                cantidadPositivos++;
            }
        }

        System.out.println("Arreglo A:");

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }

        System.out.println("\n\nElementos negativos:");

        for (int i = 0; i < cantidadNegativos; i++) {
            System.out.print(negativos[i] + " ");
        }

        System.out.println("\n\nElementos iguales a cero:");

        for (int i = 0; i < cantidadCeros; i++) {
            System.out.print(ceros[i] + " ");
        }

        System.out.println("\n\nElementos positivos:");

        for (int i = 0; i < cantidadPositivos; i++) {
            System.out.print(positivos[i] + " ");
        }

        System.out.println();
    }
}

