package Ejercicio08;

public class Main {
    public static void main(String[] args) {

        ColaReproduccion<Cancion> cola = new ColaReproduccion<>();

        cola.agregarCancion(new Cancion("Bohemian Rhapsody", "Queen", 354));
        cola.agregarCancion(new Cancion("Blinding Lights", "The Weeknd", 200));
        cola.agregarCancion(new Cancion("Shape of You", "Ed Sheeran", 234));
        cola.agregarCancion(new Cancion("Levitating", "Dua Lipa", 203));
        cola.agregarCancion(new Cancion("Bad Guy", "Billie Eilish", 194));
        cola.agregarCancion(new Cancion("Viva La Vida", "Coldplay", 242));

        System.out.println("=== Cola Inicial ===");
        cola.mostrarCola();

        System.out.println("\nAvanzando canciones:");
        for (int i = 0; i < 3; i++) {
            System.out.println("► " + cola.reproducirSiguiente());
        }

        System.out.println("\nRetrocediendo:");
        System.out.println("◄ " + cola.reproducirAnterior());

        System.out.println("\n=== Mezclando ===");
        cola.mezclar();
        cola.mostrarCola();

        int total = cola.duracionTotal();
        System.out.println("\nDuración total: " + (total / 60) + ":" + (total % 60));
    }
}