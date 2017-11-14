package alberobinariodiricerca;

/**
 *
 * @author Luca Daminato
 */
public class AlberoBinarioDiRicercaMain {
    public static void main(String[] args) {
        Integer[] array = {10, 12, 5, 3, 2, 14, 25, 6, 9};
        BST<Integer> a = new BST(array);
        System.out.println("L'albero appare così:");
        a.visitaSimmetrica();
        a.add(7);
        System.out.println("\nAggiungo 7");
        a.visitaSimmetrica();
    }
    
}
