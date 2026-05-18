class NodoBST {

    int dato;

    NodoBST izquierdo;
    NodoBST derecho;

    public NodoBST(int dato) {

        this.dato = dato;
    }
}

class BST {

    NodoBST raiz;

    NodoBST insertar(NodoBST nodo,
                     int dato) {

        if (nodo == null)
            return new NodoBST(dato);

        if (dato < nodo.dato)

            nodo.izquierdo =
                    insertar(nodo.izquierdo,
                              dato);

        else

            nodo.derecho =
                    insertar(nodo.derecho,
                              dato);

        return nodo;
    }

    void insertar(int dato) {

        raiz = insertar(raiz, dato);
    }

    void inorden(NodoBST nodo) {

        if (nodo != null) {

            inorden(nodo.izquierdo);

            System.out.print(
                    nodo.dato + " ");

            inorden(nodo.derecho);
        }
    }

    int altura(NodoBST nodo) {

        if (nodo == null)
            return 0;

        int izq =
                altura(nodo.izquierdo);

        int der =
                altura(nodo.derecho);

        return Math.max(izq, der) + 1;
    }

    boolean buscar(NodoBST nodo,
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
}

public class ComparacionBSTAVL {

    public static void main(String[] args) {

        // CASO 1
        int caso1[] =
                {10, 20, 30, 40, 50};

        BST bst1 = new BST();
        AVLTree avl1 = new AVLTree();

        for (int x : caso1) {

            bst1.insertar(x);
            avl1.insertar(x);
        }

        System.out.println(
                "========= CASO 1 =========");

        System.out.println(
                "\nRecorrido BST:");

        bst1.inorden(bst1.raiz);

        System.out.println(
                "\nRecorrido AVL:");

        avl1.inorden(avl1.raiz);

        System.out.println(
                "\n\nAltura BST: "
                        + bst1.altura(bst1.raiz));

        System.out.println(
                "Altura AVL: "
                        + avl1.altura(avl1.raiz));

        System.out.println(
                "\nBuscar 30 BST: "
                        + bst1.buscar(
                                bst1.raiz, 30));

        System.out.println(
                "Buscar 30 AVL: "
                        + avl1.buscar(
                                avl1.raiz, 30));

        // CASO 2
        int caso2[] =
                {50, 40, 30, 20, 10};

        BST bst2 = new BST();
        AVLTree avl2 = new AVLTree();

        for (int x : caso2) {

            bst2.insertar(x);
            avl2.insertar(x);
        }

        System.out.println(
                "\n\n========= CASO 2 =========");

        System.out.println(
                "\nRecorrido BST:");

        bst2.inorden(bst2.raiz);

        System.out.println(
                "\nRecorrido AVL:");

        avl2.inorden(avl2.raiz);

        System.out.println(
                "\n\nAltura BST: "
                        + bst2.altura(bst2.raiz));

        System.out.println(
                "Altura AVL: "
                        + avl2.altura(avl2.raiz));

        System.out.println(
                "\nBuscar 20 BST: "
                        + bst2.buscar(
                                bst2.raiz, 20));

        System.out.println(
                "Buscar 20 AVL: "
                        + avl2.buscar(
                                avl2.raiz, 20));
    }
}