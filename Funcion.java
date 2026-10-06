public class Funcion {
  public static void main(String[] args) {
    
  }
    private String horario;
    private Pelicula pelicula;

    // 6 filas x 12 sillas
    private boolean[][] sillasGenerales;

    // 2 filas x 9 sillas
    private boolean[][] sillasPreferenciales;

    private boolean tienePreferencial;

    public Funcion(String horario, boolean tienePreferencial) {

        this.horario = horario;
        this.tienePreferencial = tienePreferencial;

        sillasGenerales = new boolean[6][12];

        if (tienePreferencial) {
            sillasPreferenciales = new boolean[2][9];
        }
    }

    public String getHorario() {
        return horario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void asignarPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public boolean tienePelicula() {
        return pelicula != null;
    }

    public int sillasDisponibles() {

        int disponibles = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 12; j++) {
                if (!sillasGenerales[i][j]) {
                    disponibles++;
                }
            }
        }

        if (tienePreferencial) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 9; j++) {
                    if (!sillasPreferenciales[i][j]) {
                        disponibles++;
                    }
                }
            }
        }

        return disponibles;
    }

    public void mostrarSillas() {

        System.out.println("\n--- SILLAS GENERALES ---");

        char letra = 'A';

        for (int i = 0; i < 6; i++) {

            System.out.print(letra + ": ");

            for (int j = 0; j < 12; j++) {

                if (sillasGenerales[i][j]) {
                    System.out.print("[X] ");
                } else {
                    System.out.print("[" + (j + 1) + "] ");
                }
            }

            System.out.println();
            letra++;
        }

        if (tienePreferencial) {

            System.out.println("\n--- SILLAS PREFERENCIALES ---");

            letra = 'G';

            for (int i = 0; i < 2; i++) {

                System.out.print(letra + ": ");

                for (int j = 0; j < 9; j++) {

                    if (sillasPreferenciales[i][j]) {
                        System.out.print("[X] ");
                    } else {
                        System.out.print("[" + (j + 1) + "] ");
                    }
                }

                System.out.println();
                letra++;
            }
        }

        System.out.println("\n[X] = Ocupada");
    }

    public int comprarSilla(String silla) {

        silla = silla.toUpperCase();

        if (silla.length() < 2) {
            return -1;
        }

        char fila = silla.charAt(0);

        int numero;

        try {
            numero = Integer.parseInt(silla.substring(1));
        } catch (Exception e) {
            return -1;
        }

        int filaMatriz = -1;

        if (fila >= 'A' && fila <= 'F') {

            filaMatriz = fila - 'A';

            if (numero < 1 || numero > 12) {
                return -1;
            }

            if (sillasGenerales[filaMatriz][numero - 1]) {
                return 0;
            }

            sillasGenerales[filaMatriz][numero - 1] = true;

            return 8000;

        } else if (fila == 'G' || fila == 'H') {

            if (!tienePreferencial) {
                return -1;
            }

            filaMatriz = fila - 'G';

            if (numero < 1 || numero > 9) {
                return -1;
            }

            if (sillasPreferenciales[filaMatriz][numero - 1]) {
                return 0;
            }

            sillasPreferenciales[filaMatriz][numero - 1] = true;

            return 12000;
        }

        return -1;
    }

    public int comprarSilla3D(String silla) {

        silla = silla.toUpperCase();

        if (silla.length() < 2) {
            return -1;
        }

        char fila = silla.charAt(0);

        int numero;

        try {
            numero = Integer.parseInt(silla.substring(1));
        } catch (Exception e) {
            return -1;
        }

        if (fila < 'A' || fila > 'F') {
            return -1;
        }

        if (numero < 1 || numero > 12) {
            return -1;
        }

        int filaMatriz = fila - 'A';

        if (sillasGenerales[filaMatriz][numero - 1]) {
            return 0;
        }

        sillasGenerales[filaMatriz][numero - 1] = true;

        return 10000;
    }
}