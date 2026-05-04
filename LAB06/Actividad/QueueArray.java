package actividad1;

public class QueueArray<E> implements Queue<E> {
    private E[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    @SuppressWarnings("unchecked")
    public QueueArray(int n) {
        this.capacity = n;
        this.array = (E[]) new Object[n]; // Casting genérico
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    public void enqueue(E x) {
        if (!isFull()) {
            // Manejo circular del índice rear[cite: 1]
            this.rear = (this.rear + 1) % this.capacity;
            this.array[rear] = x;
            this.size++;
        } else {
            System.out.println("La cola está llena. No se puede agregar: " + x);
        }
    }
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía, no se puede desencolar.");
        }
        E element = this.array[front];
        this.array[front] = null; // Ayuda al Garbage Collector
        // Manejo circular del índice front[cite: 1]
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return element;
    }
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía.");
        }
        return this.array[front];
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public boolean isFull() {
        return this.size == this.capacity;
    }
    @Override
    public String toString() {
        if (isEmpty()) return "Cola vacía";
        String res = "Elementos en la cola: ";
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            res += array[index] + " ";
        }
        return res;
    }
}
