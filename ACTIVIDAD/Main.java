package GeneAct01;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bolsa de Chocolatinas");
        Bolsa<Chocolatina> bolsaCho = new Bolsa<>(3);

        Chocolatina c1 = new Chocolatina("Milka");
        Chocolatina c2 = new Chocolatina("Ferrero");
        Chocolatina c3 = new Chocolatina("Sublime");

        bolsaCho.add(c1);
        bolsaCho.add(c2);
        bolsaCho.add(c3);

        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }

        System.out.println();

        System.out.println("Bolsa de Golosinas");
        Bolsa<Golosina> bolsaGol = new Bolsa<>(3);

        Golosina g1 = new Golosina("Gomita", 10.5);
        Golosina g2 = new Golosina("Caramelo", 5.0);
        Golosina g3 = new Golosina("Chicle", 2.3);

        bolsaGol.add(g1);
        bolsaGol.add(g2);
        bolsaGol.add(g3);

        for (Golosina golosina : bolsaGol) {
            System.out.println(golosina.getNombre() + " - " + golosina.getPeso() + " g");
        }
    }
}