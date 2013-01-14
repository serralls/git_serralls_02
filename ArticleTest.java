// Testclass by Pascal Schirmer

package test.java.de.dhbw.maven.bl;

import junit.framework.TestCase;
import main.java.de.dhbw.maven.app.*;
import main.java.de.dhbw.maven.bl.*;

public class ArticleTest extends TestCase  {

	private Article x1;
	private Article x2;

	public ArticleTest( String testName )
	{
		super( testName );
	}


	//erzeugt die Stammdaten und zwei neue Articles vor jedem Test
	
	protected void setUp() throws Exception 

	{ 
		x1 = new Article(1001, "Verpackung", 1.2,100);
		x2 = new Article(1007, "Pizza Funghi",5.9,101);
	}

	public void testPrice() throws Exception
	{
		assertEquals(1.2, x1.getArticlePrice(), 0.001);
		assertEquals(5.9, x2.getArticlePrice(), 0.001);
	}
	
	public void testCode() throws Exception
	{
		assertEquals(1001, x1.getArticleCode(), 0.001); // fehlt die methode getArticleCode in Klasse Article
		assertEquals(1007, x2.getArticleCode(), 0.001);	// fehlt die methode getArticleCode	in Klasse Article
	}
		
		
}
