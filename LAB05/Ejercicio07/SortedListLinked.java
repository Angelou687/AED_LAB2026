package Ejercicio07;

public class SortedListLinked<T extends Comparable<T>> extends ListLinked<T> {

    public void insertOrden(T x) {

        Node<T> nuevo = new Node<>(x); // crear nuevo nodo

        // Caso 1: lista vacía o insertar al inicio
        if (isEmptyList() || getFirst().value.compareTo(x) > 0) {
            nuevo.next = getFirst(); // el nuevo apunta al primero
            setFirst(nuevo); // actualizar cabeza
            return;
        }

        Node<T> actual = getFirst();

        // Buscar la posición correcta
        while (actual.next != null && actual.next.value.compareTo(x) < 0) {
            actual = actual.next; // avanzar
        }

        // Insertar en la posición encontrada
        nuevo.next = actual.next;
        actual.next = nuevo;
    }
}