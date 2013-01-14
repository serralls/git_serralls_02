// Testclass by Pascal Schirmer

package test.java.de.dhbw.maven.bl;

import static org.junit.Assert.assertEquals;
import main.java.de.dhbw.maven.bl.Contact;

import org.junit.Test;
public class ContactTest {


@Test	
	public void testGetLastName() {
		Contact lastname=new Contact(8000,"Schirmer","Pascal","xxx","yyy","zzz");
		assertEquals("Schirmer",lastname.getLastName());
	}//Rueckgabewert ("Schirmer") wird mit dem Initialwert verglichen...


@Test
	
	public void testToString() {
	Contact kunde = new Contact(8000,"test","test","test","test","test");
	String s=kunde.toString();
	assertEquals("addressCode = 8000, lastName = test, firstName = test, street = test, zip = test, city = test\n",s);
	}	
	
}
