class NodoAVL {

    int dato;
    int altura;

    NodoAVL izquierdo;
    NodoAVL derecho;

    public NodoAVL(int dato) {

        this.dato = dato;
        this.altura = 1;
    }
}

class AVLTree {

    NodoAVL raiz;

    // ALTURA
    int altura(NodoAVL nodo) {

        if (nodo == null)
            return 0;

        return nodo.altura;
    }

    // MAXIMO
    int max(int a, int b) {

        return (a > b) ? a : b;
    }

    // FACTOR DE EQUILIBRIO
    int balance(NodoAVL nodo) {

        if (nodo == null)
            return 0;

        return altura(nodo.derecho) -
               altura(nodo.izquierdo);
    }

    // ROTACION SIMPLE DERECHA
    NodoAVL rotarDerecha(NodoAVL y) {

        NodoAVL x = y.izquierdo;
        NodoAVL t2 = x.derecho;

        x.derecho = y;
        y.izquierdo = t2;

        y.altura =
                max(altura(y.izquierdo),
                    altura(y.derecho)) + 1;

        x.altura =
                max(altura(x.izquierdo),
                    altura(x.derecho)) + 1;

        System.out.println(
                "Rotación simple derecha en "
                        + y.dato);

        return x;
    }

    // ROTACION SIMPLE IZQUIERDA
    NodoAVL rotarIzquierda(NodoAVL x) {

        NodoAVL y = x.derecho;
        NodoAVL t2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = t2;

        x.altura =
                max(altura(x.izquierdo),
                    altura(x.derecho)) + 1;

        y.altura =
                max(altura(y.izquierdo),
                    altura(y.derecho)) + 1;

        System.out.println(
                "Rotación simple izquierda en "
                        + x.dato);

        return y;
    }

    // INSERTAR
    NodoAVL insertar(NodoAVL nodo,
                     int dato) {

        if (nodo == null)
            return new NodoAVL(dato);

        if (dato < nodo.dato)

            nodo.izquierdo =
                    insertar(nodo.izquierdo,
                              dato);

        else if (dato > nodo.dato)

            nodo.derecho =
                    insertar(nodo.derecho,
                              dato);

        else
            return nodo;

        nodo.altura =
                1 + max(altura(nodo.izquierdo),
                        altura(nodo.derecho));

        int bf = balance(nodo);

        System.out.println(
                "Nodo: " + nodo.dato +
                " | BF = " + bf);

        // IZQUIERDA - IZQUIERDA
        if (bf < -1 &&
                dato < nodo.izquierdo.dato)

            return rotarDerecha(nodo);

        // DERECHA - DERECHA
        if (bf > 1 &&
                dato > nodo.derecho.dato)

            return rotarIzquierda(nodo);

        // IZQUIERDA - DERECHA
        if (bf < -1 &&
                dato > nodo.izquierdo.dato) {

            nodo.izquierdo =
                    rotarIzquierda(
                            nodo.izquierdo);

            return rotarDerecha(nodo);
        }

        // DERECHA - IZQUIERDA
        if (bf > 1 &&
                dato < nodo.derecho.dato) {

            nodo.derecho =
                    rotarDerecha(
                            nodo.derecho);

            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    void insertar(int dato) {

        raiz = insertar(raiz, dato);
    }

    // BUSCAR
    boolean buscar(NodoAVL nodo,
                   int dato) {

        if (nodo == null)
            return false;

        if (dato == nodo.dato)
            return true;

        if (dato < nodo.dato)

            return buscar(
                    nodo.izquierdo,
                    dato);

        return buscar(
                nodo.derecho,
                dato);
    }

    // NODO MINIMO
    NodoAVL nodoMinimo(NodoAVL nodo) {

        NodoAVL actual = nodo;

        while (actual.izquierdo != null)

            actual = actual.izquierdo;

        return actual;
    }

    // ELIMINAR
    NodoAVL eliminar(NodoAVL raiz,
                     int dato) {

        if (raiz == null)
            return raiz;

        if (dato < raiz.dato)

            raiz.izquierdo =
                    eliminar(
                            raiz.izquierdo,
                            dato);

        else if (dato > raiz.dato)

            raiz.derecho =
                    eliminar(
                            raiz.derecho,
                            dato);

        else {

            // UN HIJO O SIN HIJOS
            if ((raiz.izquierdo == null)
                    || (raiz.derecho == null)) {

                NodoAVL temp = null;

                if (temp == raiz.izquierdo)
                    temp = raiz.derecho;

                else
                    temp = raiz.izquierdo;

                // SIN HIJOS
                if (temp == null) {

                    temp = raiz;
                    raiz = null;
                }

                // UN HIJO
                else
                    raiz = temp;
            }

            // DOS HIJOS
            else {

                NodoAVL temp =
                        nodoMinimo(
                                raiz.derecho);

                raiz.dato = temp.dato;

                raiz.derecho =
                        eliminar(
                                raiz.derecho,
                                temp.dato);
            }
        }

        if (raiz == null)
            return raiz;

        raiz.altura =
                max(altura(raiz.izquierdo),
                    altura(raiz.derecho)) + 1;

        int bf = balance(raiz);

        // IZQUIERDA - IZQUIERDA
        if (bf < -1 &&
                balance(raiz.izquierdo) <= 0)

            return rotarDerecha(raiz);

        // IZQUIERDA - DERECHA
        if (bf < -1 &&
                balance(raiz.izquierdo) > 0) {

            raiz.izquierdo =
                    rotarIzquierda(
                            raiz.izquierdo);

            return rotarDerecha(raiz);
        }

        // DERECHA - DERECHA
        if (bf > 1 &&
                balance(raiz.derecho) >= 0)

            return rotarIzquierda(raiz);

        // DERECHA - IZQUIERDA
        if (bf > 1 &&
                balance(raiz.derecho) < 0) {

            raiz.derecho =
                    rotarDerecha(
                            raiz.derecho);

            return rotarIzquierda(raiz);
        }

        return raiz;
    }

    void eliminar(int dato) {

        raiz = eliminar(raiz, dato);
    }

    // RECORRIDO INORDEN
    void inorden(NodoAVL nodo) {

        if (nodo != null) {

            inorden(nodo.izquierdo);

            System.out.print(
                    nodo.dato + " ");

            inorden(nodo.derecho);
        }
    }

    void mostrarArbol() {

        System.out.print("Inorden: ");

        inorden(raiz);

        System.out.println();
    }

    public void recorridoAmplitud() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recorridoAmplitud'");
    }

    public void preorden(NodoAVL raiz2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'preorden'");
    }
}

public class GestorTicketsAVL {

    public static void main(String[] args) {

        AVLTree avl = new AVLTree();

        int tickets[] =
                {30, 10, 20, 40, 50, 25};

        System.out.println(
                "========== INSERCIONES ==========");

        for (int x : tickets) {

            System.out.println(
                    "\nInsertando ticket: "
                            + x);

            avl.insertar(x);

            avl.mostrarArbol();
        }

        System.out.println(
                "\n========== BUSQUEDAS ==========");

        System.out.println(
                "Buscar 20: " +
                avl.buscar(avl.raiz, 20));

        System.out.println(
                "Buscar 60: " +
                avl.buscar(avl.raiz, 60));

        System.out.println(
                "\n========== ELIMINACIONES ==========");

        int eliminar[] =
                {10, 40, 30};

        for (int e : eliminar) {

            System.out.println(
                    "\nEliminando ticket: "
                            + e);

            avl.eliminar(e);

            avl.mostrarArbol();
        }
    }
}