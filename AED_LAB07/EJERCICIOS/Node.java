public class LinkedBST<E extends Comparable<E>> {

    class Node {
        E data;
        Node left;
        Node right;

        Node(E data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public LinkedBST() {
        root = null;
    }
}