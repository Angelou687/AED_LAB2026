import bstreeInterface.BinarySearchTree;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    private Node<E> root;

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void destroy() {
        // Elimina la referencia, el recolector de basura hará el resto
        root = null;
    }

    @Override
    public void insert(E data) {
        root = insert(root, data);
    }

    private Node<E> insert(Node<E> node, E data) {
        if (node == null) {
            return new Node<>(data);
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(node.left, data);
        } else if (cmp > 0) {
            node.right = insert(node.right, data);
        } else {
            throw new ItemDuplicated("El dato ya existe: " + data);
        }
        return node;
    }

    @Override
    public boolean search(E data) {
        return search(root, data);
    }

    private boolean search(Node<E> node, E data) {
        if (node == null) {
            throw new ItemNotFound("Dato no encontrado: " + data);
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            return search(node.left, data);
        } else if (cmp > 0) {
            return search(node.right, data);
        } else {
            return true;
        }
    }

    @Override
    public void delete(E data) {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Árbol vacío");
        }
        root = delete(root, data);
    }

    private Node<E> delete(Node<E> node, E data) {
        if (node == null) {
            throw new ItemNotFound("Dato no encontrado: " + data);
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = delete(node.left, data);
        } else if (cmp > 0) {
            node.right = delete(node.right, data);
        } else {
            // Caso 1 y 2: Nodo con un solo hijo o ninguno
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Caso 3: Nodo con dos hijos
            // Se busca el sucesor (mínimo en el subárbol derecho)
            Node<E> successor = findMin(node.right);
            node.data = successor.data;
            node.right = delete(node.right, successor.data);
        }
        return node;
    }

    private Node<E> findMin(Node<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}

