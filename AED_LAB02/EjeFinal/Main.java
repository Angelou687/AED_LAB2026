package EjeFinal;

public class Main {

    public static void main(String[] args) {

        // =========================
        // GOLOSINAS
        // =========================
        Cajoneria<Golosina> cajoneriaG = new Cajoneria<>(10);

        cajoneriaG.addCaja(new Caja<>("Rojo", new Golosina("Caramelo", 10.5)));
        cajoneriaG.addCaja(new Caja<>("Azul", new Golosina("Chicle", 5.0)));
        cajoneriaG.addCaja(new Caja<>("Verde", new Golosina("Caramelo", 10.5)));
        cajoneriaG.addCaja(new Caja<>("Amarillo", new Golosina("Gomita", 7.8)));
        cajoneriaG.addCaja(new Caja<>("Morado", new Golosina("Caramelo", 10.5)));

        System.out.println("=== GOLOSINAS ===");
        System.out.println(cajoneriaG);

        System.out.println("Buscar Chicle:");
        System.out.println(cajoneriaG.search(new Golosina("Chicle", 5.0)));

        System.out.println("Contar Caramelo:");
        System.out.println(cajoneriaG.contar(new Golosina("Caramelo", 10.5)));

        System.out.println("Eliminar Gomita:");
        System.out.println(cajoneriaG.delete(new Golosina("Gomita", 7.8)));

        System.out.println("Estado final:");
        System.out.println(cajoneriaG);


        // =========================
        // CHOCOLATINAS
        // =========================
        Cajoneria<Chocolatina> cajoneriaC = new Cajoneria<>(10);

        cajoneriaC.addCaja(new Caja<>("Rojo", new Chocolatina("Milka")));
        cajoneriaC.addCaja(new Caja<>("Azul", new Chocolatina("Kinder")));
        cajoneriaC.addCaja(new Caja<>("Verde", new Chocolatina("Milka")));
        cajoneriaC.addCaja(new Caja<>("Amarillo", new Chocolatina("Ferrero")));
        cajoneriaC.addCaja(new Caja<>("Morado", new Chocolatina("Milka")));

        System.out.println("\n=== CHOCOLATINAS ===");
        System.out.println(cajoneriaC);

        System.out.println("Buscar Kinder:");
        System.out.println(cajoneriaC.search(new Chocolatina("Kinder")));

        System.out.println("Contar Milka:");
        System.out.println(cajoneriaC.contar(new Chocolatina("Milka")));

        System.out.println("Eliminar Ferrero:");
        System.out.println(cajoneriaC.delete(new Chocolatina("Ferrero")));

        System.out.println("Estado final:");
        System.out.println(cajoneriaC);
    }
}