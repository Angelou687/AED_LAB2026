package EJERCICIO02;


public class ColaArreglo {

    private int[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ColaArreglo(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // ENCOLAR
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Cola llena");
            return;
        }

        rear = (rear + 1) % capacity;
        array[rear] = x;
        size++;
    }

    // DESENCOLAR
    public int dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }

        int value = array[front];
        front = (front + 1) % capacity;
        size--;

        return value;
    }

    // VER FRENTE
    public int front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }

        return array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}