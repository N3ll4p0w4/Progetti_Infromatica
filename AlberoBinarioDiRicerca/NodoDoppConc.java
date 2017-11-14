package alberobinariodiricerca;

/**
 *
 * @author Luca Daminato
 */
public class NodoDoppConc<T> {
    
    protected T info;
    protected NodoDoppConc<T> sinistro, destro;
    
    NodoDoppConc(T info, NodoDoppConc sinistro, NodoDoppConc destro) {
        this.info = info;
        this.sinistro = sinistro;
        this.destro = destro;
    }
}