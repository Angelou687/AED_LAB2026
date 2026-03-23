package EjeFinal;

public class Chocolatina {
    private String marca;

    public Chocolatina(String marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;

        Chocolatina c = (Chocolatina) obj;
        return marca.equals(c.marca);
    }

    @Override
    public String toString() {
        return marca;
    }
}