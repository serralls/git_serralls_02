package bl;

import java.util.Date;

public class Receipt {
    PartList partList;
    Contact contact;
    Date receiptDate;
    String orderCode;
    
    public Receipt (String orderCode, PartList partList, Contact contact) {
    	this.partList = partList;
    	this.contact = contact;
    	this.orderCode = orderCode;
    	this.receiptDate = new Date();
    }
    
    public PartList getPartList(){
    	return partList;
    }
 
   public Contact getContact(){
    	return contact;
    }
 
   public void setContact(Contact contact){
    	this.contact = contact;
    }
   
   public double getTotalPrice() {
	   return partList.computePrice();
   }
   
    @Override
    public String toString() {
    	String tmp="Receipt: [" + this.orderCode + "] für: \n" + this.getContact().toString() +  "\n" +
    			   "Receipt Date: "+ this.receiptDate.toString() + "\n" + 
    			   "TOTAL Price: " + this.getTotalPrice() + "\n" + 
    			   this.getPartList().toString();   	
    	return tmp;
    }
    
    public String receiptText() {
    	String tmp = "Auftrag für" + "\n" +
                     contact.firstName + " " + contact.lastName + "\n" +
                     contact.street + "\n" +
                     contact.zip + " " + contact.city + "\n" +
                     "am: " + this.receiptDate + "\n"+ "\n";
		for (PartItem partItem : partList.partItems) {   
			tmp += partItem.quantity + " " + partItem.partName + " EUR " + partItem.getPartItemTotalPrice()+"\n";
		}
		
		tmp += "\n" + "TOTAL: " + this.getTotalPrice();
    	
    	return tmp;
                     
    }
}
