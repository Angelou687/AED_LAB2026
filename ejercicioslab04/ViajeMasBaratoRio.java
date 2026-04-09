package ejercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ViajeMasBaratoRio {

    static final int INF = 1_000_000_000;

    static class Resultado {
        int[][] costos;
        int[][] split;

        Resultado(int[][] costos, int[][] split) {
            this.costos = costos;
            this.split = split;
        }
    }

    public static Resultado calcularCostosMinimos(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];
        int[][] split = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(C[i], INF);
            Arrays.fill(split[i], -1);
            C[i][i] = 0;
        }

        for (int longitud = 2; longitud <= n; longitud++) {
            for (int i = 0; i + longitud - 1 < n; i++) {
                int j = i + longitud - 1;

                if (T[i][j] < INF) {
                    C[i][j] = T[i][j];
                }

                for (int k = i + 1; k < j; k++) {
                    if (T[i][k] < INF && C[k][j] < INF) {
                        int nuevoCosto = T[i][k] + C[k][j];
                        if (nuevoCosto < C[i][j]) {
                            C[i][j] = nuevoCosto;
                            split[i][j] = k;
                        }
                    }
                }
            }
        }

        return new Resultado(C, split);
    }

    public static List<Integer> reconstruirRuta(int origen, int destino, int[][] split, int[][] C) {
        List<Integer> ruta = new ArrayList<>();

        if (C[origen][destino] >= INF) {
            return ruta;
        }

        construirRuta(origen, destino, split, ruta);
        return ruta;
    }

    private static void construirRuta(int i, int j, int[][] split, List<Integer> ruta) {
        if (i == j) {
            ruta.add(i);
            return;
        }

        int k = split[i][j];

        if (k == -1) {
            ruta.add(i);
            ruta.add(j);
        } else {
            construirRuta(i, k, split, ruta);
            ruta.remove(ruta.size() - 1);
            construirRuta(k, j, split, ruta);
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor >= INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(valor + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de embarcaderos: ");
        int n = sc.nextInt();

        int[][] T = new int[n][n];

        System.out.println("Ingrese la matriz de tarifas T:");
        System.out.println("Use -1 si no existe viaje directo.");
        System.out.println("En la diagonal principal coloque 0.");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int valor = sc.nextInt();

                if (i == j) {
                    T[i][j] = 0;
                } else if (i > j) {
                    T[i][j] = INF;
                } else {
                    T[i][j] = (valor == -1) ? INF : valor;
                }
            }
        }

        Resultado resultado = calcularCostosMinimos(T);

        System.out.println("\nMatriz de costos mínimos C:");
        mostrarMatriz(resultado.costos);

        System.out.print("\nIngrese el embarcadero de origen: ");
        int origen = sc.nextInt();

        System.out.print("Ingrese el embarcadero de destino: ");
        int destino = sc.nextInt();

        if (origen < 0 || origen >= n || destino < 0 || destino >= n || origen > destino) {
            System.out.println("Origen o destino inválido.");
        } else if (resultado.costos[origen][destino] >= INF) {
            System.out.println("No existe ruta posible entre esos embarcaderos.");
        } else {
            System.out.println("Costo mínimo desde " + origen + " hasta " + destino + ": "
                    + resultado.costos[origen][destino]);

            List<Integer> ruta = reconstruirRuta(origen, destino, resultado.split, resultado.costos);

            System.out.print("Ruta: ");
            for (int i = 0; i < ruta.size(); i++) {
                System.out.print(ruta.get(i));
                if (i < ruta.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}



