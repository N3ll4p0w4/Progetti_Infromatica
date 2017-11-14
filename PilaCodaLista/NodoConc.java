package pilacodalista;

/**
 *
 * @author Luca Daminato
 */
public class NodoConc<T> {
    
    protected T info;
    protected NodoConc<T> next;
    
    NodoConc(T info, NodoConc next){
        this.info = info;
        this.next = next;
    }
    
}
