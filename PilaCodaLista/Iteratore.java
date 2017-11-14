package pilacodalista;

/**
 *
 * @author Luca Daminato
 */
public class Iteratore<T> implements Iterable{

    private ListaConcatenata<T> l;
    private int posizione;
    
    Iteratore(ListaConcatenata lista){
        this.l = lista;
        this.posizione=0;
    }

    @Override
    public boolean inside(){
        if(posizione < l.size())
            return true;
        return false;
    }
    
    @Override
    public T current(){
        return l.get(posizione);
    }
    
    @Override
    public void goFirst() {
        posizione = 0;
    }
    
    @Override
    public void goNext() {
        posizione++;
    }
}
