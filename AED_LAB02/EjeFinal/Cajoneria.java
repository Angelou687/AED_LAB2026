package EjeFinal;


import java.util.ArrayList;
import java.util.Iterator;

public class Cajoneria<T> implements Iterable<Caja<T>> {

    private ArrayList<Caja<T>> lista = new ArrayList<>();
    private int tope;

    public Cajoneria(int tope) {
        this.tope = tope;
    }

    public void addCaja(Caja<T> caja) {
        if (lista.size() < tope) {
            lista.add(caja);
        } else {
            throw new RuntimeException("No caben más cajas");
        }
    }

    // SEARCH
    public String search(T objeto) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getContenido().equals(objeto)) {
                return "Posición: " + (i + 1) + 
                       ", Color: " + lista.get(i).getColor();
            }
        }
        return "Objeto no encontrado";
    }

    // DELETE
    public T delete(T objeto) {
        Iterator<Caja<T>> it = lista.iterator();

        while (it.hasNext()) {
            Caja<T> caja = it.next();

            if (caja.getContenido().equals(objeto)) {
                it.remove();
                return caja.getContenido();
            }
        }

        return null;
    }

    // COUNT
    public int contar(T elemento) {
        int contador = 0;

        for (Caja<T> caja : lista) {
            if (caja.getContenido().equals(elemento)) {
                contador++;
            }
        }

        return contador;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Pos\tColor\tObjeto\n");

        for (int i = 0; i < lista.size(); i++) {
            sb.append(i + 1)
              .append("\t")
              .append(lista.get(i).getColor())
              .append("\t")
              .append(lista.get(i).getContenido())
              .append("\n");
        }

        return sb.toString();
    }

    @Override
    public Iterator<Caja<T>> iterator() {
        return lista.iterator();
    }
}