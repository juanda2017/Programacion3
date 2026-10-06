 public class Teatro {
    public static void main(String[] args) {
        
    }

    private Pelicula[] peliculas;
    private int cantidadPeliculas;

    private Sala[] salas;

    public Teatro() {

        peliculas = new Pelicula[50];
        cantidadPeliculas = 0;

        salas = new Sala[3];

        // Salas 1 y 2 tienen zona preferencial
        salas[0] = new Sala(1, true);
        salas[1] = new Sala(2, true);

        // Sala 3 no tiene zona preferencial
        salas[2] = new Sala(3, false);
    }

    public boolean agregarPelicula(Pelicula pelicula) {

        if (cantidadPeliculas >= peliculas.length) {
            return false;
        }

        peliculas[cantidadPeliculas] = pelicula;
        cantidadPeliculas++;

        return true;
    }

    public void mostrarPeliculas() {

        if (cantidadPeliculas == 0) {
            System.out.println("\nNo hay peliculas registradas.");
            return;
        }

        System.out.println("\n===== PELICULAS REGISTRADAS =====");

        for (int i = 0; i < cantidadPeliculas; i++) {

            System.out.println("\nPelicula " + (i + 1));
            peliculas[i].mostrarDatos();
        }
    }

    public Pelicula obtenerPelicula(int posicion) {

        if (posicion < 0 || posicion >= cantidadPeliculas) {
            return null;
        }

        return peliculas[posicion];
    }

    public int getCantidadPeliculas() {
        return cantidadPeliculas;
    }

    public Sala obtenerSala(int numero) {

        if (numero < 1 || numero > 3) {
            return null;
        }

        return salas[numero - 1];
    }

    public void mostrarSalas() {

        for (int i = 0; i < 3; i++) {
            salas[i].mostrarFunciones();
        }
    }
}
 