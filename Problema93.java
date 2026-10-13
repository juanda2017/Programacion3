import java.util.Scanner;
import java.util.Stack;

public class Problema93 {

    public static boolean estaBalanceada(String expresion) {
        Stack<Character> pila = new Stack<Character>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {

                if (pila.isEmpty()) {
                    return false;
                }

                char apertura = pila.pop();

                if ((c == ')' && apertura != '(')
                        || (c == ']' && apertura != '[')
                        || (c == '}' && apertura != '{')) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Problema 9.3 - Verificar delimitadores");
        System.out.print("Escriba una expresion: ");
        String expresion = sc.nextLine();

        if (estaBalanceada(expresion)) {
            System.out.println("La expresion esta balanceada.");
        } else {
            System.out.println("La expresion NO esta balanceada.");
        }
    }
}