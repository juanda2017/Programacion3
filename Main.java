import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Teatro teatro = new Teatro();

        int opcion;

        do {

            System.out.println("\n==============================");
            System.out.println("       CINEMASTAR");
            System.out.println("==============================");
            System.out.println("1. Registrar pelicula");
            System.out.println("2. Mostrar peliculas");
            System.out.println("3. Asignar pelicula a funcion");
            System.out.println("4. Mostrar funciones");
            System.out.println("5. Vender entradas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = leerEntero(teclado);

            switch (opcion) {

                case 1:
                    registrarPelicula(teatro, teclado);
                    break;

                case 2:
                    teatro.mostrarPeliculas();
                    break;

                case 3:
                    asignarPelicula(teatro, teclado);
                    break;

                case 4:
                    teatro.mostrarSalas();
                    break;

                case 5:
                    venderEntradas(teatro, teclado);
                    break;

                case 6:
                    System.out.println("\nPrograma finalizado.");
                    break;

                default:
                    System.out.println("\nOpcion no valida.");
            }

        } while (opcion != 6);

        teclado.close();
    }

    public static void registrarPelicula(
            Teatro teatro,
            Scanner teclado) {

        System.out.println("\n===== REGISTRAR PELICULA =====");

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Idioma: ");
        String idioma = teclado.nextLine();

        String tipo;

        do {

            System.out.print("Tipo (35mm o 3D): ");
            tipo = teclado.nextLine();

            if (!tipo.equalsIgnoreCase("35mm")
                    && !tipo.equalsIgnoreCase("3D")) {

                System.out.println(
                        "El tipo debe ser 35mm o 3D.");
            }

        } while (!tipo.equalsIgnoreCase("35mm")
                && !tipo.equalsIgnoreCase("3D"));

        System.out.print("Duracion en minutos: ");
        int duracion = leerEntero(teclado);

        Pelicula pelicula =
                new Pelicula(nombre, idioma, tipo, duracion);

        if (teatro.agregarPelicula(pelicula)) {

            System.out.println(
                    "\nPelicula registrada correctamente.");

        } else {

            System.out.println(
                    "\nNo se pudo registrar la pelicula.");
        }
    }

    public static void asignarPelicula(
            Teatro teatro,
            Scanner teclado) {

        if (teatro.getCantidadPeliculas() == 0) {

            System.out.println(
                    "\nPrimero debe registrar una pelicula.");

            return;
        }

        teatro.mostrarPeliculas();

        System.out.print(
                "\nSeleccione el numero de pelicula: ");

        int peliculaNumero = leerEntero(teclado);

        Pelicula pelicula =
                teatro.obtenerPelicula(peliculaNumero - 1);

        if (pelicula == null) {

            System.out.println(
                    "\nLa pelicula no existe.");

            return;
        }

        System.out.print("Numero de sala (1-3): ");

        int numeroSala = leerEntero(teclado);

        Sala sala = teatro.obtenerSala(numeroSala);

        if (sala == null) {

            System.out.println(
                    "\nLa sala no existe.");

            return;
        }

        System.out.println("\nHorarios:");

        System.out.println(
                "1. 14:00 - 16:30");

        System.out.println(
                "2. 16:30 - 19:00");

        System.out.println(
                "3. 19:00 - 21:00");

        System.out.print("Seleccione el horario: ");

        int horario = leerEntero(teclado);

        boolean resultado =
                sala.asignarPelicula(
                        horario - 1,
                        pelicula);

        if (resultado) {

            System.out.println(
                    "\nPelicula asignada correctamente.");

        } else {

            if (numeroSala == 3
                    && !pelicula.getTipo()
                            .equalsIgnoreCase("3D")) {

                System.out.println(
                        "\nLa sala 3 solamente acepta peliculas 3D.");

            } else if (numeroSala != 3
                    && pelicula.getTipo()
                            .equalsIgnoreCase("3D")) {

                System.out.println(
                        "\nLas salas 1 y 2 no aceptan peliculas 3D.");

            } else {

                System.out.println(
                        "\nNo se puede asignar la pelicula."
                        + " Revise el horario.");
            }
        }
    }

    public static void venderEntradas(
            Teatro teatro,
            Scanner teclado) {

        System.out.println("\n===== VENTA DE ENTRADAS =====");

        System.out.print("Numero de sala (1-3): ");

        int numeroSala = leerEntero(teclado);

        Sala sala = teatro.obtenerSala(numeroSala);

        if (sala == null) {

            System.out.println(
                    "\nLa sala no existe.");

            return;
        }

        System.out.println("\nFunciones disponibles:");

        Funcion[] funciones = sala.getFunciones();

        for (int i = 0; i < 3; i++) {

            System.out.println(
                    (i + 1)
                    + ". "
                    + funciones[i].getHorario()
                    + " - "
                    + (funciones[i].tienePelicula()
                    ? funciones[i].getPelicula().getNombre()
                    : "Sin pelicula"));

            System.out.println(
                    "   Sillas disponibles: "
                    + funciones[i].sillasDisponibles());
        }

        System.out.print(
                "\nSeleccione la funcion: ");

        int numeroFuncion = leerEntero(teclado);

        if (numeroFuncion < 1 || numeroFuncion > 3) {

            System.out.println(
                    "\nFuncion no valida.");

            return;
        }

        Funcion funcion =
                funciones[numeroFuncion - 1];

        if (!funcion.tienePelicula()) {

            System.out.println(
                    "\nEsta funcion no tiene pelicula.");

            return;
        }

        int total = 0;
        String continuar;

        do {

            funcion.mostrarSillas();

            System.out.print(
                    "\nDigite la silla (ejemplo A3): ");

            String silla = teclado.nextLine();

            int precio;

            if (numeroSala == 3) {

                precio = funcion.comprarSilla3D(silla);

            } else {

                precio = funcion.comprarSilla(silla);
            }

            if (precio == -1) {

                System.out.println(
                        "\nLa silla no existe o no esta disponible "
                        + "en esta sala.");

            } else if (precio == 0) {

                System.out.println(
                        "\nLa silla ya esta ocupada.");

            } else {

                total = total + precio;

                System.out.println(
                        "\nEntrada comprada correctamente.");

                System.out.println(
                        "Precio: $" + precio);

                System.out.println(
                        "Total hasta el momento: $" + total);
            }

            System.out.print(
                    "\nDesea comprar otra entrada? (S/N): ");

            continuar = teclado.nextLine();

        } while (continuar.equalsIgnoreCase("S"));

        System.out.println(
                "\n==============================");

        System.out.println(
                "TOTAL A PAGAR: $" + total);

        System.out.println(
                "Sillas disponibles: "
                + funcion.sillasDisponibles());

        System.out.println(
                "==============================");
    }

    public static int leerEntero(Scanner teclado) {

        while (!teclado.hasNextInt()) {

            System.out.println(
                    "Debe ingresar un numero.");

            teclado.nextLine();

            System.out.print("Intente nuevamente: ");
        }

        int numero = teclado.nextInt();

        teclado.nextLine();

        return numero;
    }
}