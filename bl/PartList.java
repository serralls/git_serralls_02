package bl;

import java.util.Vector;

public class PartList {
	Vector<PartItem> partItems;

	public PartList (Vector<PartItem> partItems){
		this.partItems = partItems;
	}

	public PartList (){
		this.partItems = new Vector<PartItem>();
	}
	
    public Vector<PartItem> getPartItems(){
    	return partItems;
    }
    
	public void add(PartItem partItem){
		partItems.add(partItem);
	}
	
	public double computePrice () {
		double price = 0;
		for (PartItem cartItem : partItems) {   
			price += cartItem.getPartItemTotalPrice();
		}
		return price;
	}
	
	@Override
	public String toString (){
		String tmp="";
		for (PartItem cartItem : partItems) {   
			tmp += cartItem.toString();
		}
		tmp += "\n";
		return tmp;
	}


}
