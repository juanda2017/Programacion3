import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problema103 {

    static class Cliente {
        int numero;
        int carrito;

        Cliente(int numero, int carrito) {
            this.numero = numero;
            this.carrito = carrito;
        }

        public String toString() {
            return "Cliente " + numero + " (carrito " + carrito + ")";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> carritosDisponibles = new LinkedList<Integer>();
        Queue<Cliente> esperaCarrito = new LinkedList<Cliente>();
        Queue<Cliente> comprando = new LinkedList<Cliente>();
        Queue<Cliente>[] cajas = new Queue[3];

        for (int i = 1; i <= 25; i++) {
            carritosDisponibles.add(i);
        }

        for (int i = 0; i < 3; i++) {
            cajas[i] = new LinkedList<Cliente>();
        }

        int siguienteCliente = 1;
        int opcion;

        do {
            System.out.println("\n--- SUPERMERCADO ---");
            System.out.println("1. Llega un cliente");
            System.out.println("2. Un cliente termina de comprar");
            System.out.println("3. Atender cliente en una caja");
            System.out.println("4. Mostrar estado");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                int numero = siguienteCliente++;

                if (!carritosDisponibles.isEmpty()) {
                    int carrito = carritosDisponibles.remove();
                    Cliente cliente = new Cliente(numero, carrito);
                    comprando.add(cliente);

                    System.out.println(cliente + " entra a comprar.");
                } else {
                    esperaCarrito.add(new Cliente(numero, 0));
                    System.out.println("No hay carritos. Cliente "
                            + numero + " queda esperando.");
                }

            } else if (opcion == 2) {
                if (comprando.isEmpty()) {
                    System.out.println("No hay clientes que hayan terminado de comprar.");
                } else {
                    Cliente cliente = comprando.remove();
                    int cajaMenosOcupada = 0;

                    for (int i = 1; i < cajas.length; i++) {
                        if (cajas[i].size() < cajas[cajaMenosOcupada].size()) {
                            cajaMenosOcupada = i;
                        }
                    }

                    cajas[cajaMenosOcupada].add(cliente);

                    System.out.println(cliente + " pasa a la caja "
                            + (cajaMenosOcupada + 1) + ".");
                }

            } else if (opcion == 3) {
                System.out.print("Numero de caja (1-3): ");
                int numeroCaja = sc.nextInt();

                if (numeroCaja < 1 || numeroCaja > 3) {
                    System.out.println("Numero de caja invalido.");
                } else if (cajas[numeroCaja - 1].isEmpty()) {
                    System.out.println("La caja esta vacia.");
                } else {
                    Cliente atendido = cajas[numeroCaja - 1].remove();

                    System.out.println(atendido + " termina de pagar.");
                    carritosDisponibles.add(atendido.carrito);

                    if (!esperaCarrito.isEmpty()) {
                        Cliente esperando = esperaCarrito.remove();
                        esperando.carrito = carritosDisponibles.remove();
                        comprando.add(esperando);

                        System.out.println(esperando
                                + " recibe un carrito y comienza a comprar.");
                    }
                }

            } else if (opcion == 4) {
                System.out.println("Carritos disponibles: "
                        + carritosDisponibles.size());
                System.out.println("Clientes esperando carrito: "
                        + esperaCarrito);
                System.out.println("Clientes comprando: " + comprando);

                for (int i = 0; i < cajas.length; i++) {
                    System.out.println("Caja " + (i + 1) + ": " + cajas[i]);
                }

            } else if (opcion != 0) {
                System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        System.out.println("Simulacion terminada.");
    }
}