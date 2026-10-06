public class Sala {
    public static void main(String[] args) {
        
    }
    private int numero;
    private Funcion[] funciones;

    public Sala(int numero, boolean tienePreferencial) {

        this.numero = numero;

        funciones = new Funcion[3];

        funciones[0] = new Funcion("14:00 - 16:30", tienePreferencial);
        funciones[1] = new Funcion("16:30 - 19:00", tienePreferencial);
        funciones[2] = new Funcion("19:00 - 21:00", tienePreferencial);
    }

    public int getNumero() {
        return numero;
    }

    public Funcion[] getFunciones() {
        return funciones;
    }

    public boolean asignarPelicula(int posicion, Pelicula pelicula) {

        if (posicion < 0 || posicion > 2) {
            return false;
        }

        // La sala 3 solamente acepta peliculas 3D
        if (numero == 3 && !pelicula.getTipo().equalsIgnoreCase("3D")) {
            return false;
        }

        // Las salas 1 y 2 no aceptan peliculas 3D
        if (numero != 3 && pelicula.getTipo().equalsIgnoreCase("3D")) {
            return false;
        }

        // No permitir dos peliculas en el mismo horario
        if (funciones[posicion].tienePelicula()) {
            return false;
        }

        funciones[posicion].asignarPelicula(pelicula);

        return true;
    }

    public void mostrarFunciones() {

        System.out.println("\n===== SALA " + numero + " =====");

        for (int i = 0; i < 3; i++) {

            System.out.println("\nFuncion " + (i + 1));
            System.out.println("Horario: " + funciones[i].getHorario());

            if (funciones[i].tienePelicula()) {

                System.out.println(
                        "Pelicula: "
                        + funciones[i].getPelicula().getNombre());

                System.out.println(
                        "Tipo: "
                        + funciones[i].getPelicula().getTipo());

            } else {

                System.out.println("Sin pelicula asignada");
            }

            System.out.println(
                    "Sillas disponibles: "
                    + funciones[i].sillasDisponibles());
        }
    }
}