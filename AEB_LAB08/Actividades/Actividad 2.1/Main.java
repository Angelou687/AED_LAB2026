package Actividad_1;

import bstreeInterface.BinarySearchTree;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import Node.Node;
import estructuras.LinkedQueue;
import estructuras.Queue;

public class Main {

    public static void main(String[] args) {
        try {
            LinkedBST<Integer> bst = new LinkedBST<>();

            bst.insert(50);
            bst.insert(30);
            bst.insert(70);

            System.out.println("InOrder: " + bst.toString());
            System.out.println("Existe 30? " + bst.search(30));

            bst.delete(30);
            System.out.println("Después de eliminar: " + bst);

        } catch (ItemDuplicated | ItemNotFound | ExceptionIsEmpty e) {
            e.printStackTrace();
        }
    }
}

