package Actividad_2; 
 
import Node.Node; import exceptions.ItemDuplicated; import exceptions.ItemNotFound; import exceptions.ExceptionIsEmpty; 
import Actividad_1.LinkedBST; 
 
public class AVLTree<E extends Comparable<E>> extends LinkedBST<E> {     protected static class NodeAVL<E> extends Node<E> {         int bf; // Factor de balance: -1, 0, 1 
 
        public NodeAVL(E data) {             super(data);             this.bf = 0; 
        } 
 
        @Override 
        public String toString() { 
            return data + "(bf:" + bf + ")"; 
        } 
    }      private boolean height; // Indicador de cambio de altura 

