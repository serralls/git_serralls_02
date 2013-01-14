/**
 * 
 */
package app;

import java.util.Vector;

import bl.Article;
import bl.Articles;
import bl.Contact;
import bl.PartItem;
import bl.PartList;
import bl.Receipt;
import bl.Unit;

/**
 * @author Matthias Bachmann
 *
 */
public class MasterDataCache {
	
	private Articles stockList;
	private Vector<Unit> units;
	private Vector<Contact> contacts;
	private Vector<Receipt> receipts;

	public MasterDataCache () {
	}
	
	public void init() {
		initUnits();
		initArticles();
		initContacts();
	}
	
	public Articles getStockList(){
		return stockList;
	}

	public Vector<Unit> getUnits(){
		return units;
	}

	public Vector<Contact> getContacts(){
		return contacts;
	}

	public Vector<Receipt> getReceipts(){
		return receipts;
	}
	
	public Contact getContact(String name) {
		for (Contact contact : contacts) {   
			if (contact.getLastName() == name) return contact;
		}
		return null;
	}
	
	public Unit getUnit(int unitCode) {
		for (Unit unit : units) {   
			if (unit.getUnitCode() == unitCode) return unit;
		}
		return null;
	}

	public void initUnits(){
		// Einheiten definieren
		this.units = new Vector<Unit>();
		units.add(new Unit(1,"Stück"));
		units.add(new Unit(2,"kg"));
		units.add(new Unit(3,"Gramm"));
		units.add(new Unit(4,"l"));
		units.add(new Unit(5,"ml"));
	}

	public void initContacts(){
		// Kontakte definieren
		this.contacts = new Vector<Contact>();
		contacts.add(new Contact(101,"Muster", "Felix", "Bahnhofstrasse 34", "8000", "Zürich" ));
		contacts.add(new Contact(102,"Baumgartner", "Fritz", "Rosengarten 3", "4000", "Basel" ));
	}

	public void initArticles(){
		// Einzel Artikel definieren
		stockList = new Articles();
		stockList.add(new Article(1001,"Teig rund",0.3,1));			// 0.30 EUR pro Stück (für eine Pizza)
		stockList.add(new Article(1002,"Teig eckig",0.2,1));		// 0.20 EUR pro Stück (für eine Pizza)
		stockList.add(new Article(1003,"Tomatenpaste",14.7,2));		// 14.70 EUR pro Kilo 
		stockList.add(new Article(1004,"Mozarella",10.2,2));		// 10.20 EUR pro Kilo 
		stockList.add(new Article(1005,"Schinken",15.7,2));			// 15.70 EUR pro Kilo 
		stockList.add(new Article(1006,"Pilze",12,2));				// 12.00 EUR pro Kilo 
		stockList.add(new Article(1007,"Eier",6,2));				// 6.00 EUR pro Kilo 
		stockList.add(new Article(1008,"Chili",9,2));				// 9.00 EUR pro Kilo 
		stockList.add(new Article(1009,"Oliven",9,2));				// 9.00 EUR pro Kilo 
		stockList.add(new Article(1100,"Verpackung",0.1,1));		// 0.1 EUR pro Stück 
		stockList.add(new Article(3000,"Ihre konfigurierte Pizza",0,1));	// 0 EUR pro Stück (Preis gemäss Konfiguration)

		// Set Artikel definieren für "Pizza rund Basis"
		PartList partList = new PartList();
		partList.add(new PartItem(1001, 1));
		partList.add(new PartItem(1003, 0.1));
		partList.add(new PartItem(1100, 1));
		stockList.add(new Article(2001,"Pizza rund Basis",0,1,partList));


		// Set Artikel definieren für "Pizza rund eckig"
		partList = new PartList();
		partList.add(new PartItem(1001, 1));
		partList.add(new PartItem(1003, 0.1));
		partList.add(new PartItem(1100, 1));
		stockList.add(new Article(2002,"Pizza eckig Basis",0,1,partList));

		// Set Artikel definieren für "Pizza Funghi"
		partList = new PartList();
		partList.add(new PartItem(1001, 1));
		partList.add(new PartItem(1003, 0.1));
		partList.add(new PartItem(1004, 0.2));
		partList.add(new PartItem(1006, 0.07));
		partList.add(new PartItem(1100, 1));
		stockList.add(new Article(2003,"Pizza Funghi",0,1,partList));

	}


}
