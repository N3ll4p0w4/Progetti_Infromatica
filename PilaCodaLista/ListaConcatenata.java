/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilacodalista;

/**
 *
 * @author pigro
 */
public class ListaConcatenata<T> {
    
    private NodoConc testa;
    private int lunghezza = 0;
    
    ListaConcatenata(){
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
    
    public int size(){
        return lunghezza;
    }
    
}
