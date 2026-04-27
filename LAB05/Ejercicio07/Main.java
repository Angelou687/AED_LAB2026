package Ejercicio07;

public class Main {
    public static void main(String[] args) {

        SortedListLinked<Tarea> lista = new SortedListLinked<>();

        // Insertar tareas DESORDENADAS
        lista.insertOrden(new Tarea("Diseñar BD", 2, "pendiente"));
        lista.insertOrden(new Tarea("Deploy produccion", 1, "pendiente"));
        lista.insertOrden(new Tarea("Documentar API", 3, "completada"));
        lista.insertOrden(new Tarea("Code review", 2, "pendiente"));
        lista.insertOrden(new Tarea("Corregir bug", 1, "completada"));

        // Mostrar resultado
        System.out.println("=== LISTA ORDENADA POR PRIORIDAD ===");
        lista.print();
    }
}