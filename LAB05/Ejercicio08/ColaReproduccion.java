package Ejercicio08;

import java.util.ArrayList;
import java.util.Collections;

public class ColaReproduccion<T extends Cancion> {

    private NodeDoble<T> head;
    private NodeDoble<T> actual;

    // Agregar canción al final
    public void agregarCancion(T cancion) {
        NodeDoble<T> nuevo = new NodeDoble<>(cancion);

        if (head == null) {
            head = nuevo;
            actual = head;
            return;
        }

        NodeDoble<T> temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = nuevo;
        nuevo.prev = temp;
    }

    // Avanzar a la siguiente canción
    public T reproducirSiguiente() {
        if (actual != null && actual.next != null) {
            actual = actual.next;
        }
        return actual.value;
    }

    // Retroceder a la canción anterior
    public T reproducirAnterior() {
        if (actual != null && actual.prev != null) {
            actual = actual.prev;
        }
        return actual.value;
    }

    // Mostrar toda la cola
    public void mostrarCola() {
        NodeDoble<T> temp = head;
        int i = 1;

        while (temp != null) {
            if (temp == actual) {
                System.out.println(i + ". ► " + temp.value);
            } else {
                System.out.println(i + ". " + temp.value);
            }
            temp = temp.next;
            i++;
        }
    }

    // Calcular duración total
    public int duracionTotal() {
        int total = 0;
        NodeDoble<T> temp = head;

        while (temp != null) {
            total += temp.value.getDuracionSeg();
            temp = temp.next;
        }

        return total;
    }

    // Mezclar canciones (shuffle)
    public void mezclar() {

        // Pasar a lista temporal
        ArrayList<T> lista = new ArrayList<>();
        NodeDoble<T> temp = head;

        while (temp != null) {
            lista.add(temp.value);
            temp = temp.next;
        }

        // Mezclar usando Collections.shuffle (Fisher-Yates interno)
        Collections.shuffle(lista);

        // Reconstruir la lista
        head = null;
        actual = null;

        for (T cancion : lista) {
            agregarCancion(cancion);
        }
    }
}