package actividad2;
import actividad1.ExceptionIsEmpty;
class DequeLink<E> implements Deque<E> {
    private Node<E> first;
    private Node<E> last;
    public DequeLink() {
        this.first = null;
        this.last = null;
    }
    public void addFirst(E x) {
        Node<E> newNode = new Node<>(x);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
    }
    public void addLast(E x) {
        Node<E> newNode = new Node<>(x);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }
    public E removeFirst() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Deque is empty");
        E aux = first.getData();
        first = first.getNext();
        if (first == null) last = null;
        return aux;
    }
    public E removeLast() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Deque is empty");
        E aux = last.getData();
        if (first == last) {
            first = last = null;
        } else {
            Node<E> actual = first;
            while (actual.getNext() != last) {
                actual = actual.getNext();
            }
            actual.setNext(null);
            last = actual;
        }
        return aux;
    }
    public E getFirst() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Deque is empty");
        return first.getData();
    }
    public E getLast() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Deque is empty");
        return last.getData();
    }
    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        if (isEmpty()) return "Deque vacía";
        String str = "";
        Node<E> aux = first;
        while (aux != null) {
            str += aux.getData() + (aux.getNext() != null ? " -> " : "");
            aux = aux.getNext();
        }
        return str;
    }
}
