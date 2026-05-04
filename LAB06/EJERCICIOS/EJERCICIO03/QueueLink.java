package EJERCICIO03;

public class QueueLink<E> {

    private Node<E> front;
    private Node<E> rear;

    public QueueLink() {
        front = rear = null;
    }

    public void enqueue(E x) {
        Node<E> newNode = new Node<>(x);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }

        E data = front.getData();
        front = front.getNext();

        if (front == null) {
            rear = null;
        }

        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}