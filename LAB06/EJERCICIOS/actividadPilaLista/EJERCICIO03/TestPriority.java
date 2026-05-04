package EJERCICIO03;


public class TestPriority {

    public static void main(String[] args) {

        PriorityQueueMultiple<String> pq = new PriorityQueueMultiple<>(3);

        try {
            pq.enqueue("A", 0);
            pq.enqueue("B", 2);
            pq.enqueue("C", 1);
            pq.enqueue("D", 2);

            while (!pq.isEmpty()) {
                System.out.println("Atendiendo: " + pq.dequeue());
            }

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}