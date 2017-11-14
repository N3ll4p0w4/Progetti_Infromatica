package albero;

import static java.util.Arrays.sort;

/**
 *
 * @author andrea.dattero
 * @param <T>
 * sinistra < padre < destra
 */
public class Albero<T> {
	private T valore;
	private Albero sinistro,destro;

	public Albero(T[] array){
		sort(array);
		generaAlbero(this, array, 0, array.length-1);
	}
	
	public Albero(T valore, Albero sinistro, Albero destro) {
		this.valore = valore;
		this.sinistro = sinistro;
		this.destro = destro;
	}

	public Albero() {
		this.valore = null;
		this.sinistro = null;
		this.destro = null;
	}
	
	public T getValore() {
		return valore;
	}

	public void setValore(T valore) {
		this.valore = valore;
	}

	public Albero getSinistro() {
		return sinistro;
	}

	public void setSinistro(Albero sinistro) {
		this.sinistro = sinistro;
	}

	public Albero getDestro() {
		return destro;
	}

	public void setDestro(Albero destro) {
		this.destro = destro;
	}
	
	public boolean isEmpty(){
		return this.getValore()==null;
	}
	
	public void visitaAnticipata(){
		visitaAnticipata(this);
	}
	private void visitaAnticipata(Albero a){
		System.out.println(a.getValore());
		if(a.getSinistro() != null)
			visitaAnticipata(a.getSinistro());
		if(a.getDestro() != null)
			visitaAnticipata(a.getDestro());
	}
	
	public void visitaDifferita(){
		visitaDifferita(this);
	}
	private void visitaDifferita(Albero a){
		if(a.getSinistro() != null)
			visitaDifferita(a.getSinistro());
		if(a.getDestro() != null)
			visitaDifferita(a.getDestro());
		System.out.println(a.getValore());
	}
	
	public void visitaSimmetrica(){
		visitaSimmetrica(this);
	}
	private void visitaSimmetrica(Albero a){
		if(a.getSinistro() != null)
			visitaSimmetrica(a.getSinistro());
		System.out.println(a.getValore());
		if(a.getDestro() != null)
			visitaSimmetrica(a.getDestro());
	}
	
	private void generaAlbero(Albero padre, T[] array, int posIn, int posFin){
		if(posIn == posFin || posIn+1 == posFin){
			padre.valore = array[posIn];
		} else {
			int meta = (posFin+posIn)/2;
			padre.valore = array[meta];
			padre.sinistro = new Albero();
			padre.destro = new Albero();
			generaAlbero(padre.sinistro, array, posIn, meta);
			generaAlbero(padre.destro, array, meta+1, posFin);
		}
	}

	public Albero getAlbero(Albero a, T valore){
		if(a.getValore().equals(valore))
			return a;
		Albero s = null, d = null;
		if(a.getSinistro() != null)
			s = getAlbero(a.getSinistro(), valore);
		if(a.getDestro() != null)
			d = getAlbero(a.getDestro(), valore);
		
		if(s != null)
			return s;
		else if (d != null)
			return d;
		else return null;
	}
	
	public void remove(T valore) {
		Albero a = getAlbero(this, valore);
		if(a != null){
			eliminaElemento(a, null);
		} else throw new NullPointerException();
	}
	private void eliminaElemento(Albero padre, Albero nonno){
		if(padre.getSinistro()!=null){
			padre.setValore(padre.getSinistro().getValore());
			eliminaElemento(padre.getSinistro(), padre);
		} else if(padre.getDestro()!=null){
			padre.setValore(padre.getDestro().getValore());
			eliminaElemento(padre.getDestro(), padre);
		} else if(padre.getSinistro()==null){
			nonno.setSinistro(null);
		} else if(padre.getDestro()==null){
			nonno.setDestro(null);
		}
	} 

}
