package lab03;

public class MergeSortMejorado {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            // Ordenar mitad izquierda
            mergeSort(arr, left, mid);

            // Ordenar mitad derecha
            mergeSort(arr, mid + 1, right);

            // Mejora: si ya están en orden, no fusionar
            if (arr[mid] <= arr[mid + 1]) {
                return;
            }

            // Fusionar solo si es necesario
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        mergeSort(arr, 0, arr.length - 1);

        System.out.print("Arreglo ordenado: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}