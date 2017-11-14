package alberobinariodiricerca;

import java.util.Arrays;

/**
 *
 * @author Luca Daminato
 */
public class BST<T> {

    private NodoDoppConc<Comparable> testa;

    BST(Comparable[] valori) {
        Arrays.sort(valori);
        testa = new NodoDoppConc(null, null, null);
        generaAlbero(testa, valori, 0, valori.length);
    }

    public void add(Comparable a) {
        if (testa == null) {
            testa = new NodoDoppConc(a, null, null);
            return;
        }
        NodoDoppConc<Comparable> padre = (NodoDoppConc<Comparable>) testa;
        boolean destra = a.compareTo(padre.info) > 0;
        while(true){
            if(destra && padre.destro != null)
                padre = padre.destro;
            else if(!destra && padre.sinistro != null)
                padre = padre.sinistro;
            else break;
            destra = a.compareTo(padre.info) > 0;
        }      
        if (destra)
            padre.destro = new NodoDoppConc(a, null, null);
        else
            padre.sinistro = new NodoDoppConc(a, null, null);
    }

    private void generaAlbero(NodoDoppConc<Comparable> padre, Object[] array, int posIn, int posFin) {
        if (posIn == posFin || posIn+1 == posFin) {
            padre.info = (Comparable) array[posIn];
        } else {
            int meta = (posFin + posIn) / 2;
            padre.info = ((Comparable) (array[meta]));
            if(posIn < meta){
                padre.sinistro = new NodoDoppConc<Comparable>(null, null, null);
                generaAlbero(padre.sinistro, array, posIn, meta);
            }
            if(posFin > meta+1){
                padre.destro = new NodoDoppConc<Comparable>(null, null, null);
                generaAlbero(padre.destro, array, meta+1, posFin);
            }
        }
    }

    public void visitaAnticipata() {
        visitaAnticipata(this.testa);
    }
    private void visitaAnticipata(NodoDoppConc a) {
        System.out.println(a.info);
        if (a.sinistro != null) {
            visitaAnticipata(a.sinistro);
        }
        if (a.destro != null) {
            visitaAnticipata(a.destro);
        }
    }

    public void visitaDifferita() {
        visitaDifferita(this.testa);
    }
    private void visitaDifferita(NodoDoppConc a) {
        if (a.sinistro != null) {
            visitaDifferita(a.sinistro);
        }
        if (a.destro != null) {
            visitaDifferita(a.destro);
        }
        System.out.println(a.info);
    }

    public void visitaSimmetrica() {
        visitaSimmetrica(this.testa);
    }
    private void visitaSimmetrica(NodoDoppConc a) {
        if (a.sinistro != null) {
            visitaSimmetrica(a.sinistro);
        }
        System.out.println(a.info);
        if (a.destro != null) {
            visitaSimmetrica(a.destro);
        }
    }
}
