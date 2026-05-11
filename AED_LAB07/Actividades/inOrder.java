private void inOrder(Node<E> node, StringBuilder sb) {
    if (node != null) {
        // 1. Visitar el subárbol izquierdo
        inOrder(node.left, sb);
        
        // 2. Procesar el dato del nodo actual
        sb.append(node.data).append(" ");
        
        // 3. Visitar el subárbol derecho
        inOrder(node.right, sb);
    }
}

