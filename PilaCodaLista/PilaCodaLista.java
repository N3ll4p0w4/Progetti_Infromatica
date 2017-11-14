package pilacodalista;

/**
 *
 * @author Luca Daminato
 */
public class PilaCodaLista {

    public static void main(String[] args) {
        testPila();
        System.out.println("\n\n");
        testCoda();
        System.out.println("\n\n");
        testLista();
    }
    
    private static void testPila(){
        Pila p = new Pila();
        for(int i=0; i<10; i++)
            p.push(i);
        
        p.pop();
        
        for(int i=0; i<p.size();){
            System.out.println(p.top());
            p.pop();
        }
    }
    
    private static void testCoda(){
        Coda c = new Coda();
        for(int i=0; i<10; i++)
            c.enqueue(i);
        
        c.dequeue();
        
        for(int i=0; i<c.size();){
            System.out.println(c.front());
            c.dequeue();
        }
    }
    
    private static void testLista(){
        ListaConcatenata<Integer> l = new ListaConcatenata();
        for(int i=0; i<10; i++)
            l.add(i);
        
        l.remove(5);
        l.set(5, 5);
        
        for(int i=0; i<l.size(); i++)
            System.out.println(l.get(i));
    }
    
}
