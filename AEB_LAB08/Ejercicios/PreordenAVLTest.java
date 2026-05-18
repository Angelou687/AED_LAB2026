public class PreordenAVLTest {

    public static void main(String[] args) {

        // PRIMER ARBOL
        AVLTree avl1 = new AVLTree();

        int datos1[] =
                {50, 30, 70, 20,
                 40, 60, 80};

        for (int x : datos1)

            avl1.insertar(x);

        System.out.println(
                "===== ARBOL 1 =====");

        System.out.println(
                "\nRecorrido preorden:");

        avl1.preorden(avl1.raiz);

        // SEGUNDO ARBOL
        AVLTree avl2 = new AVLTree();

        int datos2[] =
                {40, 20, 60, 10,
                 30, 50, 70, 25};

        for (int x : datos2)

            avl2.insertar(x);

        System.out.println(
                "\n\n===== ARBOL 2 =====");

        System.out.println(
                "\nRecorrido preorden:");

        avl2.preorden(avl2.raiz);
    }
}