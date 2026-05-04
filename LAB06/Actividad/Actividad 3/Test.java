package actividad3;

import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            PriorityQueue<String, Integer> pq = new PriorityQueueLinkSort<>();
            
            // Insertar elementos desordenados
            pq.enqueue("Proceso Bajo", 1);
            pq.enqueue("Proceso Critico", 10);
            pq.enqueue("Proceso Medio", 5);
            
            System.out.println(pq.toString());
            System.out.println("Frente (Mayor P): " + pq.front());
            System.out.println("Fondo (Menor P): " + pq.back());
            
            System.out.println("Desencolando: " + pq.dequeue());
            System.out.println("Nuevo frente: " + pq.front());
            
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
```</N>
