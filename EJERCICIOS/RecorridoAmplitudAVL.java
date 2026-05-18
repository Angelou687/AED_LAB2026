public class RecorridoAmplitudAVL {

    public static void main(String[] args) {

        AVLTree avl = new AVLTree();

        // PRIMER ARBOL
        int datos1[] =
                {50, 30, 70, 20, 40, 60, 80};

        for (int x : datos1)

            avl.insertar(x);

        System.out.println(
                "===== ARBOL 1 =====");

        System.out.println(
                "\nRecorrido amplitud:");

        avl.recorridoAmplitud();

        System.out.println(
                "\n\nRecorrido inorden:");

        avl.inorden(avl.raiz);

        System.out.println(
                "\n\nRecorrido preorden:");

        avl.preorden(avl.raiz);

        // SEGUNDO ARBOL
        AVLTree avl2 = new AVLTree();

        int datos2[] =
                {40, 20, 60, 10, 30, 50, 70, 25};

        for (int x : datos2)

            avl2.insertar(x);

        System.out.println(
                "\n\n\n===== ARBOL 2 =====");

        System.out.println(
                "\nRecorrido amplitud:");

        avl2.recorridoAmplitud();

        System.out.println(
                "\n\nRecorrido inorden:");

        avl2.inorden(avl2.raiz);

        System.out.println(
                "\n\nRecorrido preorden:");

        avl2.preorden(avl2.raiz);
    }
}