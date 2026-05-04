package actividadPilaLista;

public class TestStack {

    public static void main(String[] args) {

        Stack<Integer> pila = new StackLink<>();

        try {
            pila.push(10);
            pila.push(20);
            pila.push(30);

            System.out.println("Pila: " + pila);

            System.out.println("Top: " + pila.top());

            System.out.println("Pop: " + pila.pop());
            System.out.println("Pop: " + pila.pop());

            System.out.println("Pila actual: " + pila);

            System.out.println("Pop: " + pila.pop());

            // ERROR
            System.out.println("Pop: " + pila.pop());

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}