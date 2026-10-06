
    import java.util.Random;
import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();

        int[] arreglo = new int[20];

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = aleatorio.nextInt(10) + 1;
        }

        System.out.println("Arreglo:");

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }

        System.out.print("\n\nIngrese el numero que desea buscar: ");
        int numero = entrada.nextInt();

        int cantidad = 0;

        for (int i = 0; i < arreglo.length; i++) {

            if (arreglo[i] == numero) {
                cantidad++;
            }
        }

        System.out.println("El numero " + numero + " se encuentra "
                + cantidad + " veces en el arreglo.");
    }
}

