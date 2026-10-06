import java.util.Random;


public class Ejercicio13 {

    public static void main(String[] args) {

        Random aleatorio = new Random();

        int[] A = new int[10];

        int[] mayores = new int[10];
        int[] menores = new int[10];

        int suma = 0;
        double media;

        int cantidadMayores = 0;
        int cantidadMenores = 0;

        for (int i = 0; i < A.length; i++) {
            A[i] = aleatorio.nextInt(100) + 1;
            suma = suma + A[i];
        }

        media = (double) suma / A.length;

        for (int i = 0; i < A.length; i++) {

            if (A[i] > media) {
                mayores[cantidadMayores] = A[i];
                cantidadMayores++;
            } else if (A[i] < media) {
                menores[cantidadMenores] = A[i];
                cantidadMenores++;
            }
        }

        System.out.println("Arreglo A:");

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }

        System.out.println("\n\nMedia: " + media);

        System.out.println("\nElementos mayores que la media:");

        for (int i = 0; i < cantidadMayores; i++) {
            System.out.print(mayores[i] + " ");
        }

        System.out.println("\n\nElementos menores que la media:");

        for (int i = 0; i < cantidadMenores; i++) {
            System.out.print(menores[i] + " ");
        }

        System.out.println();
    }

}
