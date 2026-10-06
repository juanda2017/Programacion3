import java.util.Random;

public class Ejercicio24 {

    public static void main(String[] args) {

        Random aleatorio = new Random();

        String[] cereales = {"Arroz", "Avena", "Cebada", "Trigo"};
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                          "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        int[][] produccion = new int[4][12];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                produccion[i][j] = aleatorio.nextInt(100) + 1;
            }
        }

        int[] totalMes = new int[12];

        System.out.println("Produccion de cereales:");

        for (int i = 0; i < 4; i++) {

            System.out.print(cereales[i] + ": ");

            for (int j = 0; j < 12; j++) {
                System.out.print(produccion[i][j] + "\t");
                totalMes[j] = totalMes[j] + produccion[i][j];
            }

            System.out.println();
        }

        int totalAnual = 0;

        for (int i = 0; i < 12; i++) {
            totalAnual = totalAnual + totalMes[i];
        }

        double promedio = (double) totalAnual / 12;

        int mayores = 0;
        int menores = 0;

        for (int i = 0; i < 12; i++) {

            if (totalMes[i] > promedio) {
                mayores++;
            }

            if (totalMes[i] < promedio) {
                menores++;
            }
        }

        int mayor = totalMes[0];
        int posicionMayor = 0;

        for (int i = 1; i < 12; i++) {
            if (totalMes[i] > mayor) {
                mayor = totalMes[i];
                posicionMayor = i;
            }
        }

        System.out.println("\nPromedio anual: " + promedio);
        System.out.println("Meses con cosecha superior al promedio: " + mayores);
        System.out.println("Meses con cosecha inferior al promedio: " + menores);
        System.out.println("Mes con mayor produccion: " + meses[posicionMayor]);
    }
}

