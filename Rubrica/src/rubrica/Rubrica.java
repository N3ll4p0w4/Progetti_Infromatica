package rubrica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author luca.daminato
 */
public class Rubrica {

    static String path = "./build/classes/rubrica/";

    static File fileInput = new File(path+"Contatti.txt");
    static Scanner scanFile;

    static String ordinamento;

    static ArrayList<Contatto> contatti = new ArrayList();

    public static void main(String[] args) throws FileNotFoundException {
        ordinamento = getImpostazioni();
        try {
                scanFile = new Scanner(fileInput);
                leggiFileInput();
        } catch (FileNotFoundException ex) {
                System.out.println("Inizializzazione rubrica...");
        }
        
        System.out.println("Benvenuto nella rubrica!");
        boolean esegui = true;
        while(esegui){
            System.out.println("Cosa hai intenzione di fare?");
            System.out.println("[V, visualizza contatti][A, aggiungi contatto][E, modifica contatto][D, elimina contatto][I, impostazioni][C, chiudi]");
            Scanner in = new Scanner(System.in);
            String risposta = in.next().toLowerCase();
            while(risposta.compareTo("v") != 0 && risposta.compareTo("a") != 0 && risposta.compareTo("e") != 0 && risposta.compareTo("d") != 0 && risposta.compareTo("i") != 0  && risposta.compareTo("c") != 0){
                System.out.println("Errore! Reinserire risposta:");
                risposta = in.next().toLowerCase();
            }
            switch(risposta){
                case "v":printRubrica();break;
                case "a":aggiungiContatto();break;
                case "e":modificaContatto();break;
                case "d":eliminaContatto();break;
                case "i":impostazioni();ordinamento = getImpostazioni();leggiFileInput();break;
                case "c":esegui = false; break;
            }
        }
    }
    
    public static void printRubrica(){
        System.out.println("Tutti i contatti registrati nella rubrica sono:");
        for(int i=0; i<contatti.size(); i++){
            System.out.println(contatti.get(i).toString(i+1, ordinamento));
        }
    }
    
    public static void aggiungiContatto() throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci nome contatto: [C, chiudi]");
        String nome = in.nextLine();
        while(nome.isEmpty()){
            System.out.println("Errore! Reinserisci nome contatto:");
            nome = in.nextLine();
        }
        
        if(nome.toLowerCase().compareTo("c") == 0)
            return;
       
        System.out.println("Inserisci cognome contatto:");
        String cognome = in.nextLine();
        
        System.out.println("Inserisci numero contatto:");
        String numero = in.nextLine();
        while(!isValidNumber(numero)){
            System.out.println("Errore! Reinserisci numero contatto:");
            numero = in.nextLine();
        } 
        long num = Long.parseLong(numero);
        
        System.out.println("Inserisci email contatto:");
        String email = in.nextLine();
        
        System.out.println("Inserisci indirizzo contatto:");
        String indirizzo = in.nextLine();
        
        Contatto c = new Contatto(nome, cognome, num, email, indirizzo);
        
        contatti.add(trovaPosizioneInserimento(c), c);
        
        salvaRubrica();
    }
    
    public static void modificaContatto() throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci il numero del contatto da modificare: [C, chiudi]");
        String numero = in.nextLine();
        while(!isNumber(numero) || !(Integer.parseInt(numero)-1 >= 0 && Integer.parseInt(numero)-1 < contatti.size())){
            if(numero.toLowerCase().compareTo("c") == 0)
                return;
            System.out.println("Renserisci il numero del contatto da modificare:");
            numero = in.nextLine();
        }
        int n = Integer.parseInt(numero)-1;
        
        System.out.println("Hai scelto il seguente contatto:");
        boolean esegui = true;
        while(esegui){
            System.out.println(contatti.get(n).toString(ordinamento)+"\n");
            System.out.println("Cosa vuoi modificare?");
            System.out.println("[N, nome][C, cognome][0, numero][E, email][A, address][Z, chiudi]");

            String risposta = in.nextLine().toLowerCase();
            while(risposta.compareTo("n") != 0 && risposta.compareTo("c") != 0 && risposta.compareTo("0") != 0 && risposta.compareTo("e") != 0 && risposta.compareTo("a") != 0  && risposta.compareTo("z") != 0){
                System.out.println("Errore! Reinserire risposta:");
                risposta = in.next().toLowerCase();
            }

            switch(risposta){
                case "n":
                    System.out.println("Inserisci nome contatto:");
                    String nome = in.nextLine();
                    while(nome.isEmpty()){
                        System.out.println("Errore! Reinserisci nome contatto:");
                        nome = in.nextLine();
                    }
                    contatti.get(n).setName(nome);
                    break;
                case "c":
                    System.out.println("Inserisci cognome contatto:");
                    String cognome = in.nextLine();
                    while(cognome.isEmpty()){
                        System.out.println("Errore! Reinserisci cognome contatto:");
                        cognome = in.nextLine();
                    }
                    contatti.get(n).setSurname(cognome);
                    break;
                case "0":
                    System.out.println("Inserisci numero contatto:");
                    String number = in.nextLine();
                    while(!isValidNumber(number)){
                        System.out.println("Errore! Reinserisci numero contatto:");
                        number = in.nextLine();
                    }
                    contatti.get(n).setNumber(Long.parseLong(number));
                    break;
                case "e":
                    System.out.println("Inserisci email contatto:");
                    String email = in.nextLine();
                    contatti.get(n).setEmail(email);
                    break;
                case "a":
                    System.out.println("Inserisci indirizzo contatto:");
                    String indirizzo = in.nextLine();
                    contatti.get(n).setEmail(indirizzo);
                    break;
                case "z":esegui = false; break;
            }
        }
        
        salvaRubrica();
    }

    public static void eliminaContatto() throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci il numero del contatto da eliminare: [C, chiudi]");
        String numero = in.nextLine();
        while(!isNumber(numero) || !(Integer.parseInt(numero) >= 0 && Integer.parseInt(numero) < contatti.size())){
            if(numero.toLowerCase().compareTo("c") == 0)
                return;
            System.out.println("Renserisci il numero del contatto da eliminare:");
            numero = in.nextLine();
        }
        
        int n = Integer.parseInt(numero)-1;
        
        System.out.println("Hai scelto il seguente contatto:");
        System.out.println(contatti.get(n).toString(ordinamento)+"\n");
        
        System.out.println("Sicuro di volerlo eliminare? [S, N]");
        String risposta = in.nextLine().toLowerCase();
        while(risposta.compareTo("s") != 0 && risposta.compareTo("n") != 0){
            System.out.println("Renserisci risposta:");
            risposta = in.nextLine().toLowerCase();
        }
        
        if(risposta.compareTo("s") == 0){
            contatti.remove(n);
            System.out.println("Contatto rimosso");
            salvaRubrica();
        } else 
            System.out.println("Operazione annullata");
    }
    
    public static void impostazioni() throws FileNotFoundException {
        PrintWriter impostazioniFile = new PrintWriter(path+"Impostazioni.txt");
        Scanner in = new Scanner(System.in);
        String risposta;
        System.out.println("Preferisci visualizzare prima il nome o il cognome? [N, C]");
        risposta = in.next().toLowerCase();
        while(risposta.compareTo("n") != 0 && risposta.compareTo("c") != 0){
            System.out.println("Errore, reinserire risposta: [N, C]");
            risposta = in.next().toLowerCase();
        }
        if(risposta.compareTo("n") == 0)
            impostazioniFile.print("n");
        else
            impostazioniFile.print("s");
        impostazioniFile.close();
    }
    
    public static void impostazioniDefault() throws FileNotFoundException{
        PrintWriter impostazioniFile = new PrintWriter(path+"Impostazioni.txt");
        impostazioniFile.print("s");
        impostazioniFile.close();
    }

    public static String getImpostazioni() throws FileNotFoundException{
        File impostazioniFile = new File(path+"Impostazioni.txt");
        Scanner scannerImpostazioni;
        try {
            scannerImpostazioni = new Scanner(impostazioniFile);
        } catch (FileNotFoundException ex) {
            impostazioniDefault();
            return getImpostazioni();
        }
        return scannerImpostazioni.next();
    }

    public static void leggiFileInput() throws FileNotFoundException{
        scanFile = new Scanner(fileInput);
        contatti = new ArrayList();
        while(scanFile.hasNextLine()){
            String riga = scanFile.nextLine();
            Contatto c = new Contatto("", 0);
            c.setName(riga.substring(0, riga.indexOf(';')));
            riga = riga.substring(riga.indexOf(';')+1, riga.length());
            c.setSurname(riga.substring(0, riga.indexOf(';')));
            riga = riga.substring(riga.indexOf(';')+1, riga.length());
            c.setNumber(Long.parseLong(riga.substring(0, riga.indexOf(';'))));
            riga = riga.substring(riga.indexOf(';')+1, riga.length());
            c.setEmail(riga.substring(0, riga.indexOf(';')));
            riga = riga.substring(riga.indexOf(';')+1, riga.length());
            c.setAddress(riga.substring(0, riga.indexOf(';')));
            contatti.add(trovaPosizioneInserimento(c), c);
        }
    }
    
    public static void salvaRubrica() throws FileNotFoundException{
        PrintWriter file = new PrintWriter(path+fileInput.getName());
        for(int i=0; i<contatti.size(); i++){
            String s = "";
            s += contatti.get(i).getName()+";";
            s += contatti.get(i).getSurname()+";";
            s += contatti.get(i).getNumber()+";";
            s += contatti.get(i).getEmail()+";";
            s += contatti.get(i).getAddress()+";";
            file.println(s);
        }
        file.close();
    }
    
    public static int trovaPosizioneInserimento(Contatto c){
        if(ordinamento.compareTo("n") == 0){
            for(int i=0; i<contatti.size(); i++){
                if(c.getName().toLowerCase().compareTo(contatti.get(i).getName().toLowerCase()) < 0){
                    return i;
                }
            }
        } else if(ordinamento.compareTo("s") == 0){
            for(int i=0; i<contatti.size(); i++){
                if(c.getSurname().toLowerCase().compareTo(contatti.get(i).getSurname().toLowerCase()) < 0){
                    return i;
                }
            }
        }
        return contatti.size();
    }
    
    public static boolean isValidNumber(String s){
        if(s.length() != 10)
            return false;
        
        return isNumber(s);
    }
    
    public static boolean isNumber(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
        }
        return true;
    }
}