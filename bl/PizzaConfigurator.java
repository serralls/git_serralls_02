package bl;

import java.util.Date;

public class PizzaConfigurator {
	
	final int articleCodePizzaRound = 2001;
	final int articleCodePizzaSquare = 2002;
	final int articleCodeOlives = 1009;
	final int articleCodeEggs = 1007;
	final int articleCodeChili = 1008;
	final int articleCodeMozarella = 1004;
	final int articleCodeHam = 1005;
	final int articleCodeMushRooms = 1006;
	
	final double olivesWeight = 0.01;
	final double eggsWeight = 0.05;
	final double chiliWeight = 0.01;
	final double mozarellaWeight = 0.03;
	final double hamWeight = 0.03;
	final double mushroomsWeight = 0.03;
	
	PizzaForm pizzaForm;
	
	
 

	boolean hasOlives;
    boolean hasEggs;
    boolean hasChili;
    int mozarellaQuantity;  //(0...4)
    int hamQuantity; 		//(0...4)
    int mushroomsQuantity;   //(0...4)
    int quantityPizza;  // 1 ...
    String customerName;
    
    
    public PizzaConfigurator (){
    	pizzaForm = PizzaForm.pizzaFormRound;
    	hasOlives = false;
    	hasEggs = false;
    	hasChili = false;
    	mozarellaQuantity = 0;
    	hamQuantity = 0;
    	mushroomsQuantity=0;
    	quantityPizza = 1;
    	customerName = "";		
    }
    
    public PartList createPartList () {
    	PartList partList = new PartList();
    	if (pizzaForm == PizzaForm.pizzaFormRound) {
    		partList.add((new PartItem (articleCodePizzaRound,1)));
    	} else {
    		partList.add((new PartItem (articleCodePizzaSquare,1)));
    	}
    	if (hasOlives == true) partList.add((new PartItem (articleCodeOlives,olivesWeight)));
    	if (hasEggs == true) partList.add((new PartItem (articleCodeEggs,eggsWeight)));
    	if (hasChili == true) partList.add((new PartItem (articleCodeChili,chiliWeight)));
    	if (mozarellaQuantity > 0) partList.add((new PartItem (articleCodeMozarella,mozarellaWeight * mozarellaQuantity)));
    	if (hamQuantity > 0) partList.add((new PartItem (articleCodeChili,hamWeight * hamQuantity)));
       	if (mushroomsQuantity > 0) partList.add((new PartItem (articleCodeChili,mushroomsWeight * mushroomsQuantity)));
   	
    	return partList;
    }
    
    public double computePrice(){
    	PartList partList = this.createPartList();
    	return partList.computePrice();
    }
  
    @Override
    public String toString(){
    	PartList partList = this.createPartList();
    	Date dt = new Date(); 
    	String tmp = "Pizza für [" + this.customerName + "] bestellt am: ["  + dt.toString() + "], Preis für Pizza: [" + this.computePrice() + " EUR]" + "\n";
    	tmp += partList.toString();
    	return tmp;
    }
    /**
 	 * @return the pizzaForm
 	 */
 	public PizzaForm getPizzaForm() {
 		return pizzaForm;
 	}

 	/**
 	 * @param pizzaForm the pizzaForm to set
 	 */
 	public void setPizzaForm(PizzaForm pizzaForm) {
 		this.pizzaForm = pizzaForm;
 	}

 	/**
 	 * @return the hasOlives
 	 */
 	public boolean isHasOlives() {
 		return hasOlives;
 	}

 	/**
 	 * @param hasOlives the hasOlives to set
 	 */
 	public void setHasOlives(boolean hasOlives) {
 		this.hasOlives = hasOlives;
 	}

 	/**
 	 * @return the hasEggs
 	 */
 	public boolean isHasEggs() {
 		return hasEggs;
 	}

 	/**
 	 * @param hasEggs the hasEggs to set
 	 */
 	public void setHasEggs(boolean hasEggs) {
 		this.hasEggs = hasEggs;
 	}

 	/**
 	 * @return the hasChili
 	 */
 	public boolean isHasChili() {
 		return hasChili;
 	}

 	/**
 	 * @param hasChili the hasChili to set
 	 */
 	public void setHasChili(boolean hasChili) {
 		this.hasChili = hasChili;
 	}

 	/**
 	 * @return the mozarellaQuantity
 	 */
 	public int getMozarellaQuantity() {
 		return mozarellaQuantity;
 	}

 	/**
 	 * @param mozarellaQuantity the mozarellaQuantity to set
 	 */
 	public void setMozarellaQuantity(int mozarellaQuantity) {
 		this.mozarellaQuantity = mozarellaQuantity;
 	}

 	/**
 	 * @return the hamQuantity
 	 */
 	public int getHamQuantity() {
 		return hamQuantity;
 	}

 	/**
 	 * @param hamQuantity the hamQuantity to set
 	 */
 	public void setHamQuantity(int hamQuantity) {
 		this.hamQuantity = hamQuantity;
 	}

 	/**
 	 * @return the mushroomsQuantity
 	 */
 	public int getMushroomsQuantity() {
 		return mushroomsQuantity;
 	}

 	/**
 	 * @param mushroomsQuantity the mushroomsQuantity to set
 	 */
 	public void setMushroomsQuantity(int mushroomsQuantity) {
 		this.mushroomsQuantity = mushroomsQuantity;
 	}

 	/**
 	 * @return the quantityPizza
 	 */
 	public int getQuantityPizza() {
 		return quantityPizza;
 	}

 	/**
 	 * @param quantityPizza the quantityPizza to set
 	 */
 	public void setQuantityPizza(int quantityPizza) {
 		this.quantityPizza = quantityPizza;
 	}

 	/**
 	 * @return the customerName
 	 */
 	public String getCustomerName() {
 		return customerName;
 	}

 	/**
 	 * @param customerName the customerName to set
 	 */
 	public void setCustomerName(String customerName) {
 		this.customerName = customerName;
 	}
    
}
