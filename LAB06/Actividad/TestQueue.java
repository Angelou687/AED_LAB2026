package actividad1;
public class TestQueue {
    public static void main(String[] args) {
        try {
            // Prueba con Integer
            System.out.println("--- Prueba con Integer ---");
            QueueArray<Integer> qInt = new QueueArray<>(3);
            qInt.enqueue(10);
            qInt.enqueue(20);
            qInt.enqueue(30);
            System.out.println(qInt.toString());
            System.out.println("Atendiendo a: " + qInt.dequeue());
            System.out.println("Frente actual: " + qInt.front());
            // Prueba con String
            System.out.println("\n--- Prueba con String ---");
            QueueArray<String> qStr = new QueueArray<>(5);
            qStr.enqueue("Cliente A");
            qStr.enqueue("Cliente B");
            System.out.println(qStr.toString());
            
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
