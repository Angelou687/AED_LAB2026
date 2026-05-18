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

    // ROTACION DERECHA
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

        return x;
    }

    // ROTACION IZQUIERDA
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
                1 + max(
                        altura(nodo.izquierdo),
                        altura(nodo.derecho));

        int bf = balance(nodo);

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
                max(
                        altura(raiz.izquierdo),
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

    // INORDEN
    void inorden(NodoAVL nodo) {

        if (nodo != null) {

            inorden(nodo.izquierdo);

            System.out.print(
                    nodo.dato + " ");

            inorden(nodo.derecho);
        }
    }

    // PREORDEN
    void preorden(NodoAVL nodo) {

        if (nodo != null) {

            System.out.print(
                    nodo.dato + " ");

            preorden(nodo.izquierdo);

            preorden(nodo.derecho);
        }
    }

    // RECORRIDO POR AMPLITUD
    void imprimirNivel(NodoAVL nodo,
                       int nivel) {

        if (nodo == null)
            return;

        if (nivel == 1)

            System.out.print(
                    nodo.dato + " ");

        else if (nivel > 1) {

            imprimirNivel(
                    nodo.izquierdo,
                    nivel - 1);

            imprimirNivel(
                    nodo.derecho,
                    nivel - 1);
        }
    }

    void recorridoAmplitud() {

        int h = altura(raiz);

        for (int i = 1; i <= h; i++)

            imprimirNivel(raiz, i);
    }
}