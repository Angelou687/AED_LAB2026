import bstreelinklistinterfgeneric.LinkedBST;

public class PruebaInOrder {
    public static void main(String[] args) {
        // Inicialización del árbol con tipo Integer
        LinkedBST<Integer> arbol = new LinkedBST<>();
        
        // Datos a insertar
        int[] datos = {40, 20, 10, 30, 60, 50, 70};
        
        // Llenado del árbol
        for (int n : datos) {
            arbol.insert(n);
        }
        
        // Resultado esperado: 10 20 30 40 50 60 70
        System.out.println("Recorrido InOrder del BST:");
        System.out.println(arbol.toString());
    }
}

