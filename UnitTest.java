// Testclass by Pascal Schirmer

package test.java.de.dhbw.maven.bl;

import junit.framework.TestCase;
import main.java.de.dhbw.maven.bl.*;
public class UnitTest extends TestCase  {

	private Unit x1;
	private Unit x2;

	public UnitTest( String testName )
	{
		super( testName );
	}
	
	protected void setUp() throws Exception 

	{ 
		x1 = new Unit (1001, "Soja");
		x2 = new Unit (2001, "Baramundi");
		
	}

	public void testPrice() throws Exception
	{
		assertEquals(1001, x1.getUnitCode(), 0.001);
		assertEquals(2001, x2.getUnitCode(), 0.001);
	}	
		
}