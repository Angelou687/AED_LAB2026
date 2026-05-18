public class BFSRecursivoAVL {

    public static void main(String[] args) {

        AVLTree avl = new AVLTree();

        int datos[] =
                {50, 30, 70, 20, 40,
                 60, 80, 10, 25, 65};

        for (int x : datos)

            avl.insertar(x);

        System.out.println(
                "Recorrido por amplitud:");

        avl.recorridoAmplitud();
    }
}