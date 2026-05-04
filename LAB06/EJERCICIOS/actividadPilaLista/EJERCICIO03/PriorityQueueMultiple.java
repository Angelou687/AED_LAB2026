package EJERCICIO03;

public class PriorityQueueMultiple<E> {

    private QueueLink<E>[] queues;
    private int levels;

    public PriorityQueueMultiple(int levels) {
        this.levels = levels;
        queues = new QueueLink[levels];

        for (int i = 0; i < levels; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    // ENQUEUE
    public void enqueue(E x, int priority) {
        queues[priority].enqueue(x);
    }

    // DEQUEUE
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = levels - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Cola vacía");
    }

    public boolean isEmpty() {
        for (int i = 0; i < levels; i++) {
            if (!queues[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }
}