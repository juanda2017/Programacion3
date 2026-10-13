import java.util.Scanner;
import java.util.Stack;

public class Problema95 {

    private static final int CANTIDAD_PILAS = 5;

    private static boolean eliminarValor(Stack<Integer> pila, int valor) {
        Stack<Integer> auxiliar = new Stack<Integer>();
        boolean eliminado = false;

        while (!pila.isEmpty()) {
            int actual = pila.pop();

            if (actual == valor && !eliminado) {
                eliminado = true;
                break;
            } else {
                auxiliar.push(actual);
            }
        }

        while (!auxiliar.isEmpty()) {
            pila.push(auxiliar.pop());
        }

        return eliminado;
    }

    private static void mostrarPilas(Stack<Integer>[] pilas) {
        for (int i = 0; i < pilas.length; i++) {
            System.out.print("P" + (i + 1) + " (desde la cima): ");

            if (pilas[i].isEmpty()) {
                System.out.println("(vacia)");
            } else {
                for (int j = pilas[i].size() - 1; j >= 0; j--) {
                    System.out.print(pilas[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer>[] pilas = new Stack[CANTIDAD_PILAS];

        for (int i = 0; i < CANTIDAD_PILAS; i++) {
            pilas[i] = new Stack<Integer>();
        }

        System.out.println("Problema 9.5 - Administrar cinco pilas");
        System.out.println("Ingrese tripletas i, j y k. Use i=0 para terminar.");
        System.out.println("k=-1: vaciar la pila P|i|.");
        System.out.println("k=0: realizar la operacion normal.");

        while (true) {
            System.out.print("i: ");
            int i = sc.nextInt();

            if (i == 0) {
                break;
            }

            System.out.print("j: ");
            int j = sc.nextInt();

            System.out.print("k (-1 o 0): ");
            int k = sc.nextInt();

            if (Math.abs(i) < 1 || Math.abs(i) > CANTIDAD_PILAS) {
                System.out.println("Error: |i| debe estar entre 1 y 5.");
                continue;
            }

            if (k != -1 && k != 0) {
                System.out.println("Error: k solo puede ser -1 o 0.");
                continue;
            }

            Stack<Integer> pila = pilas[Math.abs(i) - 1];

            if (k == -1) {
                pila.clear();
                System.out.println("Se vacio completamente P" + Math.abs(i) + ".");
            } else if (i > 0) {
                pila.push(j);
                System.out.println("Se inserto " + j + " en P" + i + ".");
            } else {
                if (eliminarValor(pila, j)) {
                    System.out.println("Se elimino una aparicion de " + j
                            + " de P" + Math.abs(i) + ".");
                } else {
                    System.out.println("El valor " + j + " no se encontro en P"
                            + Math.abs(i) + ".");
                }
            }
        }

        System.out.println("\nContenido final de las pilas:");
        mostrarPilas(pilas);
    }
}