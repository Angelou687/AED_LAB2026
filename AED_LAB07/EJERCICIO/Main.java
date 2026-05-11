package EJERCICIO;
public class Main {

    // =========================================
    // sameArea()
    // =========================================

    public static boolean sameArea(
            LinkedBST<Integer> bst1,
            LinkedBST<Integer> bst2) {

        return bst1.areaBST()
                == bst2.areaBST();
    }

    public static void main(String[] args) {

        LinkedBST<Integer> bst1 =
                new LinkedBST<>();

        LinkedBST<Integer> bst2 =
                new LinkedBST<>();

        // =====================================
        // INSERTAR BST1
        // =====================================

        bst1.insert(15);
        bst1.insert(8);
        bst1.insert(22);
        bst1.insert(5);
        bst1.insert(12);
        bst1.insert(18);
        bst1.insert(30);

        // =====================================
        // INSERTAR BST2
        // =====================================

        bst2.insert(10);
        bst2.insert(6);
        bst2.insert(20);
        bst2.insert(3);
        bst2.insert(8);
        bst2.insert(15);
        bst2.insert(25);

        // =====================================
        // RECORRIDOS
        // =====================================

        System.out.println(
                "===== INORDER =====");

        bst1.inOrder();

        System.out.println();

        System.out.println(
                "\n===== PREORDER =====");

        bst1.preOrder();

        System.out.println();

        System.out.println(
                "\n===== POSTORDER =====");

        bst1.postOrder();

        // =====================================
        // COUNT ALL
        // =====================================

        System.out.println(
                "\n\nTOTAL NODOS:");

        System.out.println(
                bst1.countAllNodes());

        // =====================================
        // COUNT NON LEAF
        // =====================================

        System.out.println(
                "\nNODOS NO HOJA:");

        System.out.println(
                bst1.countNodes());

        // =====================================
        // HEIGHT
        // =====================================

        System.out.println(
                "\nALTURA DESDE 22:");

        System.out.println(
                bst1.height(22));

        // =====================================
        // AMPLITUDE
        // =====================================

        System.out.println(
                "\nAMPLITUD:");

        System.out.println(
                bst1.amplitude());

        // =====================================
        // AREA
        // =====================================

        System.out.println(
                "\nAREA BST1:");

        System.out.println(
                bst1.areaBST());

        // =====================================
        // SAME AREA
        // =====================================

        System.out.println(
                "\n¿MISMA AREA BST1 Y BST2?");

        System.out.println(
                sameArea(bst1, bst2));

        // =====================================
        // DRAW BST
        // =====================================

        System.out.println(
                "\n===== DRAW BST =====");

        bst1.drawBST();

        // =====================================
        // PARENTHESIZE
        // =====================================

        System.out.println(
                "\n===== PARENTHESIZE =====");

        bst1.parenthesize();

        // =====================================
        // VALID BST
        // =====================================

        System.out.println(
                "\n¿ES BST VALIDO?");

        System.out.println(
                bst1.isValidBST());

        // =====================================
        // SEARCH RANGE
        // =====================================

        System.out.println(
                "\n===== SEARCH RANGE =====");

        bst1.searchRange(8, 22);

        // =====================================
        // COUNT LEAVES
        // =====================================

        System.out.println(
                "\n\nCOUNT LEAVES:");

        System.out.println(
                bst1.countLeaves());

        // =====================================
        // DESCENDING
        // =====================================

        System.out.println(
                "\nPRINT DESCENDING:");

        bst1.printDescending();

        // =====================================
        // SEARCH
        // =====================================

        System.out.println(
                "\n\nBUSCAR 12:");

        System.out.println(
                bst1.search(12));

        // =====================================
        // DELETE
        // =====================================

        bst1.delete(22);

        System.out.println(
                "\nINORDER DESPUÉS DE ELIMINAR 22:");

        bst1.inOrder();

        // =====================================
        // DESTROY
        // =====================================

        bst1.destroyNodes();

        System.out.println(
                "\n\n¿ARBOL VACIO?");

        System.out.println(
                bst1.isEmpty());
    }
}