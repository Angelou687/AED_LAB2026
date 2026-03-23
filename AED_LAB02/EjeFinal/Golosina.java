package EjeFinal;

public class Golosina {
    private String nombre;
    private double peso;

    public Golosina(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;

        Golosina g = (Golosina) obj;
        return nombre.equals(g.nombre) && Double.compare(peso, g.peso) == 0;
    }

    @Override
    public String toString() {
        return nombre + " (" + peso + "g)";
    }
}