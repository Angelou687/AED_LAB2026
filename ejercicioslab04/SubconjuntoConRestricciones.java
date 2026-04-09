package ejercicio;

import java.util.Scanner;

public class SubconjuntoConRestricciones {

    public static boolean puedeFormarSuma(int[] arr, int objetivo) {
        return backtrack(arr, 0, objetivo);
    }

    private static boolean backtrack(int[] arr, int i, int restante) {
        // Caso base: ya revisamos todo el arreglo
        if (i == arr.length) {
            return restante == 0;
        }

        int actual = arr[i];

        // Regla 1: todos los múltiplos de 3 deben incluirse obligatoriamente
        if (actual % 3 == 0) {
            // Si además está prohibido elegirlo por la regla de pares consecutivos,
            // entonces no existe solución válida
            if (esPar(actual) && i + 1 < arr.length && esPar(arr[i + 1])) {
                return false;
            }
            return backtrack(arr, i + 1, restante - actual);
        }

        // Regla 2: si es par y el siguiente también es par, no puede elegirse
        if (esPar(actual) && i + 1 < arr.length && esPar(arr[i + 1])) {
            return backtrack(arr, i + 1, restante);
        }

        // Opción 1: incluir el elemento actual
        if (backtrack(arr, i + 1, restante - actual)) {
            return true;
        }

        // Opción 2: no incluir el elemento actual
        return backtrack(arr, i + 1, restante);
    }

    private static boolean esPar(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Formato:
        // primer número = N
        // luego N enteros del arreglo
        // último número = objetivo
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int objetivo = sc.nextInt();

        boolean resultado = puedeFormarSuma(arr, objetivo);
        System.out.println(resultado);

        sc.close();
    }
}





