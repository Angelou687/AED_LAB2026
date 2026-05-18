public class RotacionesAVLTest {

    public static void main(String[] args) {

        AVLTree avl = new AVLTree();

        // CASO IZQUIERDA - IZQUIERDA
        System.out.println(
                "===== CASO II =====");

        avl.insertar(30);
        avl.insertar(20);
        avl.insertar(10);

        avl.preorden(avl.raiz);

        // NUEVO ARBOL
        avl = new AVLTree();

        // CASO DERECHA - DERECHA
        System.out.println(
                "\n\n===== CASO DD =====");

        avl.insertar(10);
        avl.insertar(20);
        avl.insertar(30);

        avl.preorden(avl.raiz);

        // NUEVO ARBOL
        avl = new AVLTree();

        // CASO IZQUIERDA - DERECHA
        System.out.println(
                "\n\n===== CASO ID =====");

        avl.insertar(30);
        avl.insertar(10);
        avl.insertar(20);

        avl.preorden(avl.raiz);

        // NUEVO ARBOL
        avl = new AVLTree();

        // CASO DERECHA - IZQUIERDA
        System.out.println(
                "\n\n===== CASO DI =====");

        avl.insertar(10);
        avl.insertar(30);
        avl.insertar(20);

        avl.preorden(avl.raiz);

        // ELIMINACIONES
        System.out.println(
                "\n\n===== ELIMINACIONES =====");

        avl.eliminar(10);

        avl.preorden(avl.raiz);
    }
}