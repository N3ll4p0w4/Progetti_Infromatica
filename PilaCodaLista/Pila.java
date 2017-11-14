package pilacodalista;

/**
 *
 * @author Luca Daminato
 */

public class Pila<T> {
    
    private int lunghezza;
    private NodoConc testa;
    
    Pila(){
        lunghezza = 0;
    }
    
    public void push(T d){
        NodoConc nuovaTesta = new NodoConc(d, null);
        if(isEmpty())
            testa = nuovaTesta;
        else{
            nuovaTesta.next = testa;
            testa = nuovaTesta;
        }
        lunghezza++;
    }
    
    public T pop(){
        T r = (T)testa.info;
        testa = testa.next;
        lunghezza--;
        return r;
    }
    
    public T top(){
        return (T)testa.info;
    }
    
    private boolean isEmpty(){
        return lunghezza == 0;
    }
    
    public int size(){
        return lunghezza;
    }
}