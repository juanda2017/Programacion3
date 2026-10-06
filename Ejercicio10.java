
    import java.util.Random;

public class Ejercicio10 {

    public static void main(String[] args) {

        Random aleatorio = new Random();

        int[] A = new int[7];

        for (int i = 0; i < A.length; i++) {
            A[i] = aleatorio.nextInt(20) + 1;
        }

        int tamañoB = A.length / 2;
        int[] B = new int[tamañoB];

        for (int i = 0; i < tamañoB; i++) {
            B[i] = A[i] + A[A.length - 1 - i];
        }

        System.out.println("Arreglo A:");

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }

        System.out.println("\n\nArreglo B:");

        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }

        System.out.println();
    }
}

