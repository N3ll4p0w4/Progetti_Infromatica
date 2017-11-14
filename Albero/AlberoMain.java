package albero;

/**
 *
 * @author andrea.dattero
 */
public class AlberoMain {

	public static void main(String[] args) {
		Integer[] array = {0, 2, 4, 5, 7, 9, 12};
		Albero<Integer> a = new Albero(array);		
		
		a.visitaAnticipata();
		
		a.remove(10);
		System.out.println("/");
		a.visitaAnticipata();
	}
	
	public static void stampaVisite(Albero a){
		a.visitaSimmetrica();
		a.visitaAnticipata();
		a.visitaDifferita();
	}
	
}
