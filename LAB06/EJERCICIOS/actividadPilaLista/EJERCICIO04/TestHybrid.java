package EJERCICIO04;

public class TestHybrid {

    public static void main(String[] args) {

        PriorityQueueHybrid<String, Integer> pq = new PriorityQueueHybrid<>(3);

        try {
            pq.enqueue("A", 2, 5);
            pq.enqueue("B", 2, 1);
            pq.enqueue("C", 1, 3);
            pq.enqueue("D", 2, 3);

            while (!pq.isEmpty()) {
                System.out.println("Atendiendo: " + pq.dequeue());
            }

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}