package EJERCICIO;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBST<E extends Comparable<E>> {

    // =========================================
    // CLASE NODE
    // =========================================

    class Node {

        E data;
        Node left;
        Node right;

        public Node(E data) {

            this.data = data;

            left = null;
            right = null;
        }
    }

    // =========================================
    // ROOT
    // =========================================

    private Node root;

    // =========================================
    // CONSTRUCTOR
    // =========================================

    public LinkedBST() {

        root = null;
    }

    // =========================================
    // isEmpty()
    // =========================================

    public boolean isEmpty() {

        return root == null;
    }

    // =========================================
    // insert()
    // =========================================

    public void insert(E data) {

        root = insert(root, data);
    }

    private Node insert(Node node, E data) {

        if (node == null) {

            return new Node(data);
        }

        int cmp =
                data.compareTo(node.data);

        // izquierda

        if (cmp < 0) {

            node.left =
                    insert(node.left, data);
        }

        // derecha

        else if (cmp > 0) {

            node.right =
                    insert(node.right, data);
        }

        // duplicado

        else {

            System.out.println(
                    "Dato duplicado");
        }

        return node;
    }

    // =========================================
    // search()
    // =========================================

    public E search(E data) {

        Node current = root;

        while (current != null) {

            int cmp =
                    data.compareTo(current.data);

            // encontrado

            if (cmp == 0) {

                return current.data;
            }

            // izquierda

            else if (cmp < 0) {

                current = current.left;
            }

            // derecha

            else {

                current = current.right;
            }
        }

        return null;
    }

    // =========================================
    // delete()
    // =========================================

    public void delete(E data) {

        root = delete(root, data);
    }

    private Node delete(Node node, E data) {

        if (node == null) {

            return null;
        }

        int cmp =
                data.compareTo(node.data);

        // izquierda

        if (cmp < 0) {

            node.left =
                    delete(node.left, data);
        }

        // derecha

        else if (cmp > 0) {

            node.right =
                    delete(node.right, data);
        }

        // encontrado

        else {

            // CASO 1
            // SIN HIJOS

            if (node.left == null
                    && node.right == null) {

                return null;
            }

            // CASO 2
            // UN HIJO

            if (node.left == null) {

                return node.right;
            }

            if (node.right == null) {

                return node.left;
            }

            // CASO 3
            // DOS HIJOS

            Node min =
                    findMin(node.right);

            node.data = min.data;

            node.right =
                    delete(node.right,
                            min.data);
        }

        return node;
    }

    // =========================================
    // findMin()
    // =========================================

    private Node findMin(Node node) {

        while (node.left != null) {

            node = node.left;
        }

        return node;
    }

    // =========================================
    // destroyNodes()
    // =========================================

    public void destroyNodes() {

        if (root == null) {

            System.out.println(
                    "Arbol vacio");

            return;
        }

        root = null;
    }

    // =========================================
    // countAllNodes()
    // =========================================

    public int countAllNodes() {

        return countAllNodes(root);
    }

    private int countAllNodes(Node node) {

        if (node == null) {

            return 0;
        }

        return 1
                + countAllNodes(node.left)
                + countAllNodes(node.right);
    }

    // =========================================
    // countNodes()
    // NODOS NO HOJA
    // =========================================

    public int countNodes() {

        return countNodes(root);
    }

    private int countNodes(Node node) {

        if (node == null) {

            return 0;
        }

        // hoja

        if (node.left == null
                && node.right == null) {

            return 0;
        }

        return 1
                + countNodes(node.left)
                + countNodes(node.right);
    }

    // =========================================
    // height()
    // =========================================

    public int height(E x) {

        Node current = root;

        // buscar nodo

        while (current != null) {

            int cmp =
                    x.compareTo(current.data);

            if (cmp == 0) {

                break;
            }

            else if (cmp < 0) {

                current = current.left;
            }

            else {

                current = current.right;
            }
        }

        // no existe

        if (current == null) {

            return -1;
        }

        Queue<Node> queue =
                new LinkedList<>();

        queue.add(current);

        int height = -1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            height++;

            for (int i = 0;
                 i < size;
                 i++) {

                Node temp = queue.poll();

                if (temp.left != null) {

                    queue.add(temp.left);
                }

                if (temp.right != null) {

                    queue.add(temp.right);
                }
            }
        }

        return height;
    }

    // =========================================
    // amplitude()
    // =========================================

    public int amplitude() {

        if (root == null) {

            return 0;
        }

        Queue<Node> queue =
                new LinkedList<>();

        queue.add(root);

        int max = 0;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            if (levelSize > max) {

                max = levelSize;
            }

            for (int i = 0;
                 i < levelSize;
                 i++) {

                Node temp = queue.poll();

                if (temp.left != null) {

                    queue.add(temp.left);
                }

                if (temp.right != null) {

                    queue.add(temp.right);
                }
            }
        }

        return max;
    }

    // =========================================
    // areaBST()
    // =========================================

    public int areaBST() {

        if (root == null) {

            return 0;
        }

        Queue<Node> queue =
                new LinkedList<>();

        queue.add(root);

        int leaves = 0;

        int height = -1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            height++;

            for (int i = 0;
                 i < size;
                 i++) {

                Node temp = queue.poll();

                // hoja

                if (temp.left == null
                        && temp.right == null) {

                    leaves++;
                }

                if (temp.left != null) {

                    queue.add(temp.left);
                }

                if (temp.right != null) {

                    queue.add(temp.right);
                }
            }
        }

        return leaves * height;
    }

    // =========================================
    // drawBST()
    // =========================================

    public void drawBST() {

        drawBST(root, "", true);
    }

    private void drawBST(Node node,
                         String prefix,
                         boolean isLeft) {

        if (node != null) {

            System.out.println(
                    prefix
                    + (isLeft ? "|-- " : "`-- ")
                    + node.data);

            drawBST(node.left,
                    prefix + "│   ",
                    true);

            drawBST(node.right,
                    prefix + "    ",
                    false);
        }
    }

    // =========================================
    // parenthesize()
    // =========================================

    public void parenthesize() {

        parenthesize(root, 0);
    }

    private void parenthesize(Node node,
                              int level) {

        if (node == null) {

            return;
        }

        // sangría

        for (int i = 0;
             i < level;
             i++) {

            System.out.print("    ");
        }

        // imprimir nodo

        System.out.print(node.data);

        // tiene hijos

        if (node.left != null
                || node.right != null) {

            System.out.println(" (");

            // izquierda

            if (node.left != null) {

                parenthesize(
                        node.left,
                        level + 1);
            }

            // derecha

            if (node.right != null) {

                parenthesize(
                        node.right,
                        level + 1);
            }

            // cerrar paréntesis

            for (int i = 0;
                 i < level;
                 i++) {

                System.out.print("    ");
            }

            System.out.println(")");
        }

        else {

            System.out.println();
        }
    }

    // =========================================
    // isValidBST()
    // =========================================

    public boolean isValidBST() {

        return isValidBST(root,
                null,
                null);
    }

    private boolean isValidBST(Node node,
                               E min,
                               E max) {

        if (node == null) {

            return true;
        }

        // validar mínimo

        if (min != null
                &&

                node.data.compareTo(min)
                        <= 0) {

            return false;
        }

        // validar máximo

        if (max != null
                &&

                node.data.compareTo(max)
                        >= 0) {

            return false;
        }

        return isValidBST(
                node.left,
                min,
                node.data)

                &&

                isValidBST(
                        node.right,
                        node.data,
                        max);
    }

    // =========================================
    // searchRange()
    // =========================================

    public void searchRange(E min,
                            E max) {

        searchRange(root,
                min,
                max);
    }

    private void searchRange(Node node,
                             E min,
                             E max) {

        if (node == null) {

            return;
        }

        // izquierda

        if (node.data.compareTo(min) > 0) {

            searchRange(node.left,
                    min,
                    max);
        }

        // dentro del rango

        if (node.data.compareTo(min) >= 0
                &&

                node.data.compareTo(max) <= 0) {

            System.out.print(
                    node.data + " ");
        }

        // derecha

        if (node.data.compareTo(max) < 0) {

            searchRange(node.right,
                    min,
                    max);
        }
    }

    // =========================================
    // countLeaves()
    // =========================================

    public int countLeaves() {

        return countLeaves(root);
    }

    private int countLeaves(Node node) {

        if (node == null) {

            return 0;
        }

        // hoja

        if (node.left == null
                && node.right == null) {

            return 1;
        }

        return countLeaves(node.left)
                + countLeaves(node.right);
    }

    // =========================================
    // printDescending()
    // =========================================

    public void printDescending() {

        printDescending(root);
    }

    private void printDescending(Node node) {

        if (node != null) {

            // derecha

            printDescending(node.right);

            // raíz

            System.out.print(
                    node.data + " ");

            // izquierda

            printDescending(node.left);
        }
    }

    // =========================================
    // inOrder()
    // =========================================

    public void inOrder() {

        inOrder(root);
    }

    private void inOrder(Node node) {

        if (node != null) {

            inOrder(node.left);

            System.out.print(
                    node.data + " ");

            inOrder(node.right);
        }
    }

    // =========================================
    // preOrder()
    // =========================================

    public void preOrder() {

        preOrder(root);
    }

    private void preOrder(Node node) {

        if (node != null) {

            System.out.print(
                    node.data + " ");

            preOrder(node.left);

            preOrder(node.right);
        }
    }

    // =========================================
    // postOrder()
    // =========================================

    public void postOrder() {

        postOrder(root);
    }

    private void postOrder(Node node) {

        if (node != null) {

            postOrder(node.left);

            postOrder(node.right);

            System.out.print(
                    node.data + " ");
        }
    }
}