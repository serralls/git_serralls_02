package bl;

/**
 * @author Matthias Bachmann
 * 
 * Die Klasse Unit enthält die physlikalischen Einheiten wie Strück, Gramm Mililiter, etc 
 */


public class Unit {
	
	int unitCode;			
	String unitName;
	
	
	public Unit(int unitCode, String unitName) {
		this.unitCode = unitCode;
		this.unitName = unitName;
	}
	
	public int getUnitCode (){
		return unitCode;
	}

} 
