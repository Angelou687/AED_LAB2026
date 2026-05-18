package Actividad_2;

import Node.Node;
import exceptions.ItemDuplicated;
import Actividad_1.LinkedBST;

public class AVLTree<E extends Comparable<E>> extends LinkedBST<E> {

    protected static class NodeAVL<E> extends Node<E> {

        int bf; // Factor de balance: -1, 0, 1

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
        }

        @Override
        public String toString() {
            return data + "(bf:" + bf + ")";
        }
    }

    private boolean height; // Indicador de cambio de altura

    @Override
    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.root = insert(x, (NodeAVL<E>) this.root);
    }

    protected NodeAVL<E> insert(E x, NodeAVL<E> node) throws ItemDuplicated {
        if (node == null) {
            this.height = true;
            return new NodeAVL<>(x);
        }

        int resC = x.compareTo(node.data);

        if (resC == 0) {
            throw new ItemDuplicated(x + " ya se encuentra en el árbol");
        }

        if (resC < 0) { 
            // Inserción por izquierda
            node.left = insert(x, (NodeAVL<E>) node.left);

            if (this.height) {
                switch (node.bf) {
                    case 1:
                        node.bf = 0;
                        this.height = false;
                        break;

                    case 0:
                        node.bf = -1;
                        this.height = true;
                        break;

                    case -1:
                        // bf = -2, necesita balanceo
                        node = balanceToRight(node);
                        this.height = false;
                        break;
                }
            }

        } else { 
            // Inserción por derecha
            node.right = insert(x, (NodeAVL<E>) node.right);

            if (this.height) {
                switch (node.bf) {
                    case -1:
                        node.bf = 0;
                        this.height = false;
                        break;

                    case 0:
                        node.bf = 1;
                        this.height = true;
                        break;

                    case 1:
                        // bf = 2, necesita balanceo
                        node = balanceToLeft(node);
                        this.height = false;
                        break;
                }
            }
        }

        return node;
    }
}
