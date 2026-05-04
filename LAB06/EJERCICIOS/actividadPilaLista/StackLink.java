package actividadPilaLista;

public class StackLink<E> implements Stack<E> {

    private Node<E> top;

    public StackLink() {
        this.top = null;
    }

    @Override
    public void push(E x) {
        Node<E> newNode = new Node<>(x);
        newNode.setNext(top);
        top = newNode;
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }

        E data = top.getData();
        top = top.getNext();
        return data;
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }

        return top.getData();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        String result = "";
        Node<E> current = top;

        while (current != null) {
            result += current.getData() + " -> ";
            current = current.getNext();
        }

        return result + "null";
    }
}