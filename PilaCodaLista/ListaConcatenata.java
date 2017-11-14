package pilacodalista;

/**
 *
 * @author Luca Daminato
 */
public class ListaConcatenata<T> {
    
    private NodoConc testa;
    private int lunghezza = 0;
    
    ListaConcatenata(){
        testa = new NodoConc(null, null);
    }
    ListaConcatenata(T[] a){
        this();
        NodoConc temp = testa;
        for(int i=0; i<a.length; i++){
            temp.info = a[i];
            temp.next = new NodoConc(null, null);
            temp = temp.next;
        }
    }
    
    public void add(T valore){
        if(testa == null)
            testa = new NodoConc(valore, null);
        else{
            NodoConc temp = testa;
            while(temp.next != null)
                temp = temp.next;
            temp.next = new NodoConc(valore, null);
        }
        lunghezza++;
    }
    
    public void addHead(T elem){
        NodoConc temp = testa;
        testa = new NodoConc(elem, temp);
    } 

    public void addTail(T elem){
        NodoConc temp = testa;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.info = elem;
        temp.next = new NodoConc(null, null);
    } 
    
    public void set(T valore, int pos){
        NodoConc temp = testa;
        for(int i=0; i<pos-1; i++)
            temp = temp.next;
        temp.next = new NodoConc(valore, temp.next);
        lunghezza++;
    }
    
    public T get(int pos){
        NodoConc temp = testa;
        for(int i=0; i<pos; i++)
            temp = temp.next;
        return (T)temp.info;
    }
    
    public void remove(int pos){
        NodoConc temp = testa;
        for(int i=0; i<pos-1; i++)
            temp = temp.next;
        temp.next = temp.next.next;
        lunghezza--;
    }
    
    public void removeHead(){
        testa = testa.next;
    }

    public void removeTail(){
        NodoConc temp = testa;
        int l = size();
        for(int i=0; i<l-1; i++){
            temp = temp.next;
        }
        temp.next = null;
    }
    
    public int size(){
        return lunghezza;
    }
    
    @Override
	public String toString(){
            String r = "";
            NodoConc temp = testa;
            while(temp.next != null){
                r += "["+temp.info.toString()+"] ";
                temp = temp.next;
            }
            return r;
	}
    
}
