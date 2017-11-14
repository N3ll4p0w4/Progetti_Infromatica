package pilacodalista;

/**
 *
 * @author Luca Daminato
 */
public class Coda<T> {
    
    
    private int lunghezza;
    private NodoConc testa;
    
    Coda(){
        lunghezza = 0;
    }
    
    public void enqueue(T d){
        if(isEmpty())
            testa = new NodoConc(d, null);
        else{
            NodoConc n = testa;
            while(n.next != null)
                n = n.next;
            n.next = new NodoConc(d, null);
        }
        lunghezza++;
    }
    
    public T dequeue(){
        T r = (T)testa.info;
        testa = testa.next;
        lunghezza--;
        return r;
    }
    
    public T front(){
        return (T)testa.info;
    }
    
    private boolean isEmpty(){
        return lunghezza == 0;
    }
    
    public int size(){
        return lunghezza;
    }
}
