import java.util.Scanner;
import java.util.Stack;

public class Problema96 {

    static class Nodo {
        char dato;
        Nodo siguiente;

        Nodo(char dato) {
            this.dato = dato;
        }
    }

    static class ListaCircular {
        private Nodo ultimo;
        private int cantidad;

        public void agregarFinal(char dato) {
            Nodo nuevo = new Nodo(dato);

            if (ultimo == null) {
                ultimo = nuevo;
                nuevo.siguiente = nuevo;
            } else {
                nuevo.siguiente = ultimo.siguiente;
                ultimo.siguiente = nuevo;
                ultimo = nuevo;
            }

            cantidad++;
        }

        public char quitarPrimero() {
            if (ultimo == null) {
                throw new IllegalStateException("La lista esta vacia.");
            }

            Nodo primero = ultimo.siguiente;
            char dato = primero.dato;

            if (primero == ultimo) {
                ultimo = null;
            } else {
                ultimo.siguiente = primero.siguiente;
            }

            cantidad--;
            return dato;
        }

        public boolean estaVacia() {
            return cantidad == 0;
        }
    }

    private static String normalizar(String frase) {
        String minuscula = frase.toLowerCase();
        StringBuilder limpia = new StringBuilder();

        for (int i = 0; i < minuscula.length(); i++) {
            char c = minuscula.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                limpia.append(c);
            }
        }

        return limpia.toString();
    }

    public static boolean esPalindromo(String frase) {
        String limpia = normalizar(frase);
        Stack<Character> pila = new Stack<Character>();
        ListaCircular lista = new ListaCircular();

        for (int i = 0; i < limpia.length(); i++) {
            char c = limpia.charAt(i);
            pila.push(c);
            lista.agregarFinal(c);
        }

        while (!pila.isEmpty() && !lista.estaVacia()) {
            if (pila.pop() != lista.quitarPrimero()) {
                return false;
            }
        }

        return pila.isEmpty() && lista.estaVacia();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Problema 9.6 - Comprobar palindromos");
        System.out.println("Escriba una frase por linea.");
        System.out.println("Deje la linea vacia para terminar.");

        while (true) {
            System.out.print("Frase: ");
            String frase = sc.nextLine();

            if (frase.trim().isEmpty()) {
                break;
            }

            if (esPalindromo(frase)) {
                System.out.println("Es palindromo.");
            } else {
                System.out.println("No es palindromo.");
            }
        }
    }
}