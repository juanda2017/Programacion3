import java.util.Random;
public class Ejercicio7 {

    public static void main(String[] args) {

        Random aleatorio = new Random();

        
        int[] A = new int[10];

        
        int[] pares = new int[10];
        int[] impares = new int[10];

        
        int cantidadPares = 0;
        int cantidadImpares = 0;

        
        for (int i = 0; i < A.length; i++) {
            A[i] = aleatorio.nextInt(100) + 1;
        }

        // Separar los numeros pares e impares
        for (int i = 0; i < A.length; i++) {

            if (A[i] % 2 == 0) {
                pares[cantidadPares] = A[i];
                cantidadPares++;
            } else {
                impares[cantidadImpares] = A[i];
                cantidadImpares++;
            }
        }

        
        System.out.println("ARREGLO A");
        System.out.println("--------------------");

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }

        
        System.out.println("\n\nARREGLO DE NUMEROS PARES");
        System.out.println("--------------------");

        for (int i = 0; i < cantidadPares; i++) {
            System.out.print(pares[i] + " ");
        }

        
        System.out.println("\n\nARREGLO DE NUMEROS IMPARES");
        System.out.println("--------------------");

        for (int i = 0; i < cantidadImpares; i++) {
            System.out.print(impares[i] + " ");
        }

        System.out.println();
    }
}