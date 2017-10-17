package rubrica;

/**
 *
 * @author luca.daminato
 */
public class Contatto {
	
	private String name;
	private String surname;
	private long number;
	private String email;
	private String address;

	Contatto(String name, long number){
		this.name = name; surname = ""; this.number = number; email = ""; address = "";
	}
	Contatto(String name, String surname, long number){
		this.name = name; this.surname = surname; this.number = number; email = ""; address = "";
	}
	Contatto(String name, String surname, long number, String email){
		this.name = name; this.surname = surname; this.number = number; this.email = email; address = "";
	}
	Contatto(String name, String surname, long number, String email, String address){
		this.name = name; this.surname = surname; this.number = number; this.email = email; this.address = address;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setSurname(String surname){
		this.surname = surname;
	}
	public String getSurname(){
		return surname;
	}
	
	public void setNumber(long number){
		this.number = number;
	}
	public long getNumber(){
		return number;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return email;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
        
        @Override
	public String toString(){
		String r = "";
                r += "Name:\t"+name+"\n";
                r += "Surname:\t"+surname+"\n";
                r += "Number:\t"+number+"\n";
                r += "Email:\t"+email+"\n";
                r += "Address:\t"+address;
		return r;
	}
        
        public String toString(String ordine){
		String r = "";
                if(ordine.compareTo("n") == 0){
                    r += "Name:\t"+name+"\n";
                    r += "Surname:\t"+surname+"\n";
                    r += "Number:\t"+number+"\n";
                    r += "Email:\t"+email+"\n";
                    r += "Address:\t"+address;
                } else if (ordine.compareTo("s") == 0){
                    r += "Surname:\t"+surname+"\n";
                    r += "Name:\t"+name+"\n";
                    r += "Number:\t"+number+"\n";
                    r += "Email:\t"+email+"\n";
                    r += "Address:\t"+address;
                }
		return r;
	}
        
	public String toString(int i, String ordine){
		String r = "";
                if(ordine.compareTo("n") == 0){
                    r += i+".\tName:\t"+name+"\n";
                    r += "\tSurname:\t"+surname+"\n";
                    r += "\tNumber:\t"+number+"\n";
                    r += "\tEmail:\t"+email+"\n";
                    r += "\tAddress:\t"+address;
                } else if (ordine.compareTo("s") == 0){
                    r += i+".\tSurname:\t"+surname+"\n";
                    r += "\tName:\t"+name+"\n";
                    r += "\tNumber:\t"+number+"\n";
                    r += "\tEmail:\t"+email+"\n";
                    r += "\tAddress:\t"+address;
                }
		return r;
	}
}
