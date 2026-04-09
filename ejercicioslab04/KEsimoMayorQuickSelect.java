package ejercicio;

import java.util.Scanner;

public class KEsimoMayorQuickSelect {

    public static int kthLargest(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío.");
        }

        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("k está fuera de rango.");
        }

        // k=1 significa el mayor, por eso buscamos el índice k-1
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickSelect(int[] arr, int left, int right, int targetIndex) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = partition(arr, left, right);

        if (pivotIndex == targetIndex) {
            return arr[pivotIndex];
        } else if (targetIndex < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, targetIndex);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, targetIndex);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        // Queremos los mayores a la izquierda
        for (int j = left; j < right; j++) {
            if (arr[j] > pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada sugerida:
        // Primero N
        // Luego los N elementos del arreglo
        // Finalmente k
        //
        // Ejemplo:
        // 6
        // 4 2 7 10 4 17
        // 3

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        try {
            int resultado = kthLargest(arr, k);
            System.out.println(resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}



