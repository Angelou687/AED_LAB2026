package Ejercicio07;

public class ListLinked<T> {

    protected Node<T> first;

    public ListLinked() {
        first = null;
    }

    public boolean isEmptyList() {
        return first == null;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> node) {
        this.first = node;
    }

    // Método para imprimir la lista
    public void print() {
        Node<T> actual = first;

        while (actual != null) {
            System.out.println(actual.value);
            actual = actual.next;
        }
    }
}