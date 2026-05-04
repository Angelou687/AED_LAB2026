package EJERCICIO04;

public class PriorityQueueHybrid<E, T extends Comparable<T>> {

    class Entry {
        E data;
        T secondary;

        Entry(E data, T secondary) {
            this.data = data;
            this.secondary = secondary;
        }
    }

    private Node<Entry>[] queues;
    private int levels;

    public PriorityQueueHybrid(int levels) {
        this.levels = levels;
        queues = new Node[levels];
    }

    // ENQUEUE
    public void enqueue(E x, int priority, T secondary) {

        Entry newEntry = new Entry(x, secondary);
        Node<Entry> newNode = new Node<>(newEntry);

        // insertar en lista ordenada
        if (queues[priority] == null || 
            secondary.compareTo(queues[priority].getData().secondary) < 0) {

            newNode.setNext(queues[priority]);
            queues[priority] = newNode;

        } else {

            Node<Entry> current = queues[priority];

            while (current.getNext() != null &&
                   current.getNext().getData().secondary.compareTo(secondary) <= 0) {
                current = current.getNext();
            }

            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    // DEQUEUE
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = levels - 1; i >= 0; i--) {

            if (queues[i] != null) {

                E data = queues[i].getData().data;
                queues[i] = queues[i].getNext();

                return data;
            }
        }
        throw new ExceptionIsEmpty("Cola vacía");
    }

    public boolean isEmpty() {
        for (int i = 0; i < levels; i++) {
            if (queues[i] != null) return false;
        }
        return true;
    }
}