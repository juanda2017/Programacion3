 import java.util.Scanner;
import java.util.Stack;

public class Problema92 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Problema 9.2 - Comprobar cadena inversa");
        System.out.print("Escriba una cadena con un solo &: ");
        String entrada = sc.nextLine();

        int separador = entrada.indexOf('&');

        if (separador == -1 || separador != entrada.lastIndexOf('&')) {
            System.out.println("Entrada incorrecta: debe contener exactamente un &.");
            return;
        }

        String x = entrada.substring(0, separador);
        String y = entrada.substring(separador + 1);

        Stack<Character> pila = new Stack<Character>();

        for (int i = 0; i < x.length(); i++) {
            pila.push(x.charAt(i));
        }

        boolean esInversa = true;

        if (pila.size() != y.length()) {
            esInversa = false;
        } else {
            for (int i = 0; i < y.length(); i++) {
                if (pila.pop() != y.charAt(i)) {
                    esInversa = false;
                    break;
                }
            }
        }

        if (esInversa) {
            System.out.println("Si cumple: Y es la inversa de X.");
        } else {
            System.out.println("No cumple: Y no es la inversa de X.");
        }
    }
} {
    
}
