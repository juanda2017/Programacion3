
import java.util.Random;

public class Ejercicio8 {

    public static void main(String[] args) {

        int[] numeros = new int[30];
        Random aleatorio = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = aleatorio.nextInt(100) + 1;
        }

        int mayor = numeros[0];
        int menor = numeros[0];

        for (int i = 1; i < numeros.length; i++) {

            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }

            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }

        int vecesMayor = 0;
        int vecesMenor = 0;

        for (int i = 0; i < numeros.length; i++) {

            if (numeros[i] == mayor) {
                vecesMayor++;
            }

            if (numeros[i] == menor) {
                vecesMenor++;
            }
        }

        System.out.println("Numeros del arreglo:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        System.out.println("\n");
        System.out.println("Numero mayor: " + mayor);
        System.out.println("Veces que se repite el mayor: " + vecesMayor);
        System.out.println("Numero menor: " + menor);
        System.out.println("Veces que se repite el menor: " + vecesMenor);
    }
}