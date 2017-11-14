package pilacodalista;

/**
 *
 * @author Luca Daminato
 */
public interface Iterable<T> {
    public boolean inside();
    public T current();
    public void goFirst();
    public void goNext();
}
