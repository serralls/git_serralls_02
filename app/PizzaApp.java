package app;

import bl.PartItem;
import bl.PartList;
import bl.PizzaConfigurator;
import bl.Receipt;


public class PizzaApp {

	private static MasterDataCache masterDataCache = new MasterDataCache(); 
	
    public static void main(String[] args){
    	
    	masterDataCache.init();
    	printMasterDataCacheToConsole();
    	
      	Receipt receipt=new Receipt("10000", new PartList(), null);
      	createTestPizzaWithConfigurator(receipt);			// Pizza mit Konfigurator hinzufügen
      	receipt.getPartList().add(new PartItem(2003,2)); 	// 2 Stück Pizza Funghi hinzufügen
    	System.out.println(receipt.toString());
    	System.out.println(receipt.receiptText());
    	
    }
    
    static void printMasterDataCacheToConsole(){
    	String tmp= masterDataCache.getStockList().toString();
    	System.out.println(tmp);
    	tmp= masterDataCache.getContacts().toString();
    	System.out.println(tmp);
    }
    
    public static MasterDataCache getMasterDataCache (){
    	return masterDataCache;
    }
    
    public static void createTestPizzaWithConfigurator(Receipt receipt) {
    	PizzaConfigurator pizzaConfigurator = new PizzaConfigurator();
    	pizzaConfigurator.setCustomerName("Muster");
    	pizzaConfigurator.setQuantityPizza(2);
    	pizzaConfigurator.setHasOlives(true);
    	pizzaConfigurator.setHasChili(true);
    	pizzaConfigurator.setMozarellaQuantity(2);
    	PartList partList = pizzaConfigurator.createPartList();
    	receipt.getPartList().add(new PartItem(3000, pizzaConfigurator.getQuantityPizza(), partList));
    	// Annahme: alle Kontakte sind bereits bekannt
    	if (receipt.getContact() == null) receipt.setContact( masterDataCache.getContact(pizzaConfigurator.getCustomerName()));

    }
}
