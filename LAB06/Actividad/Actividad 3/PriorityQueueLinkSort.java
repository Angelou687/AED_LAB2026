package actividad3;

import actividad1.ExceptionIsEmpty;

class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {
    
    class EntryNode {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x, N pr) {
        EntryNode newEntry = new EntryNode(x, pr);
        Node<EntryNode> newNode = new Node<>(newEntry);

        if (isEmpty()) {
            first = last = newNode;
        } else if (pr.compareTo(first.getData().priority) > 0) {
            // Caso 1: Nueva mayor prioridad (va al inicio)
            newNode.setNext(first);
            first = newNode;
        } else {
            // Caso 2: Buscar posición de inserción
            Node<EntryNode> actual = first;
            while (actual.getNext() != null && 
                   pr.compareTo(actual.getNext().getData().priority) <= 0) {
                actual = actual.getNext();
            }
            newNode.setNext(actual.getNext());
            actual.setNext(newNode);
            if (newNode.getNext() == null) {
                last = newNode;
            }
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        E aux = this.first.getData().data;
        this.first = this.first.getNext();
        if (this.first == null) this.last = null;
        return aux;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        return first.getData().data;
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        return last.getData().data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Cola de prioridad vacía";
        String str = "";
        Node<EntryNode> aux = first;
        while (aux != null) {
            str += "[" + aux.getData().data + " (P:" + aux.getData().priority + ")]" + 
                   (aux.getNext() != null ? " -> " : "");
            aux = aux.getNext();
        }
        return str;
    }
}
