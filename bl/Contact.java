package bl;

public class Contact {
	int addressCode;
	String lastName;
	String firstName;
	String street;
	String zip;
	String city;

	public Contact(int addressCode, String lastName, String firstName, String street, String zip, String city) {
		this.addressCode = addressCode;
		this.lastName = lastName;
		this.firstName = firstName;
		this.street = street;
		this.zip = zip;
		this.city = city;
	}

	@Override
	public String toString () {
		String tmp="";
		tmp =  "addressCode = " + this.addressCode + ", " +
				"lastName = " + this.lastName +  ", " +
				"firstName = " + this.firstName  + ", " +
				"street = " + this.street  + ", " +
				"zip = " + this.zip  + ", " +
				"city = " + this.city + "\n" ;

		return tmp;
	}
	
	public String getLastName (){
		return this.lastName;
	}

}
