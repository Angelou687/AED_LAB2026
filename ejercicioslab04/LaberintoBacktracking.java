package ejercicio;

import java.util.Scanner;

public class LaberintoBacktracking {

    public static boolean resolverLaberinto(int[][] laberinto, int[][] solucion) {
        int filas = laberinto.length;
        int columnas = laberinto[0].length;

        // Si inicio o fin están bloqueados, no hay solución
        if (laberinto[0][0] == 1 || laberinto[filas - 1][columnas - 1] == 1) {
            return false;
        }

        boolean[][] visitado = new boolean[filas][columnas];
        return buscarCamino(laberinto, solucion, visitado, 0, 0);
    }

    private static boolean buscarCamino(int[][] laberinto, int[][] solucion, boolean[][] visitado, int fila, int col) {
        int filas = laberinto.length;
        int columnas = laberinto[0].length;

        // Verificar si la posición es válida
        if (!esValido(laberinto, visitado, fila, col)) {
            return false;
        }

        // Marcar como parte del camino actual
        solucion[fila][col] = 1;
        visitado[fila][col] = true;

        // Caso base: llegamos a la meta
        if (fila == filas - 1 && col == columnas - 1) {
            return true;
        }

        // Intentar moverse en 4 direcciones
        // Abajo
        if (buscarCamino(laberinto, solucion, visitado, fila + 1, col)) {
            return true;
        }

        // Derecha
        if (buscarCamino(laberinto, solucion, visitado, fila, col + 1)) {
            return true;
        }

        // Arriba
        if (buscarCamino(laberinto, solucion, visitado, fila - 1, col)) {
            return true;
        }

        // Izquierda
        if (buscarCamino(laberinto, solucion, visitado, fila, col - 1)) {
            return true;
        }

        // Backtracking: desmarcar porque este camino no funcionó
        solucion[fila][col] = 0;
        visitado[fila][col] = false;

        return false;
    }

    private static boolean esValido(int[][] laberinto, boolean[][] visitado, int fila, int col) {
        int filas = laberinto.length;
        int columnas = laberinto[0].length;

        return fila >= 0 && fila < filas
                && col >= 0 && col < columnas
                && laberinto[fila][col] == 0
                && !visitado[fila][col];
    }

    private static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de filas: ");
        int filas = sc.nextInt();

        System.out.print("Ingrese el número de columnas: ");
        int columnas = sc.nextInt();

        int[][] laberinto = new int[filas][columnas];
        int[][] solucion = new int[filas][columnas];

        System.out.println("Ingrese la matriz del laberinto (0 = libre, 1 = pared):");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                laberinto[i][j] = sc.nextInt();
            }
        }

        boolean hayCamino = resolverLaberinto(laberinto, solucion);

        System.out.println("Resultado: " + hayCamino);

        if (hayCamino) {
            System.out.println("Matriz de solución:");
            imprimirMatriz(solucion);
        } else {
            System.out.println("No existe un camino hasta la meta.");
        }

        sc.close();
    }
}



