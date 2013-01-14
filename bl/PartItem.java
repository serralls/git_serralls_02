package bl;

import app.PizzaApp;

public class PartItem extends Article {
	public double quantity;
	public double partItemPrice;	// eigene Speicherung des Preises falls Artikelpreis sich ändert (Belege dürfen sich nicht ändern)
	public String partName;			// eigene Speicherung des Namens falls Artikelname sich ändert (Belege dürfen sich nicht ändern)
	public PartList partList;		// ein ITEM kann eine Teileliste enthalten (zB aus Konfigurator)

	public PartItem (int articleCode, double anzahl ){
		super(articleCode);
		this.quantity = anzahl;
		this.partName = this.articleName;

		this.partItemPrice = this.getArticlePrice();
	}

	public PartItem (int articleCode, double anzahl, PartList partList){
		super(articleCode);
		this.quantity = anzahl;
		this.partName = this.articleName;
		this.partList = partList;
		if (this.isSetPartItem()) {
			this.partItemPrice = this.partList.computePrice();
		} else {
			this.partItemPrice = this.getArticlePrice();
		}
	}

	public boolean isSetPartItem (){
		if(this.partList != null) {
			if (partList.getPartItems().size() > 0) return true;
		}
		return false;
	}


	public double getPartItemTotalPrice() {
		return this.quantity * this.partItemPrice;
	}

	@Override
	public String toString() {
		String tmp="", unitName ="";

		Unit unit = PizzaApp.getMasterDataCache().getUnit(this.unitCode);
		if (unit != null) unitName = unit.unitName;

		tmp =  "cartItem:" + "articleCode = " + this.articleCode + 
				", articleName = " + this.articleName +
				", cartItemPrice = " + this.getPartItemTotalPrice() + " EUR " +
				", unitCode = " + this.unitCode +  " [" + unitName + "]"  +
				", anzahl = " + this.quantity + "\n";
		if (this.isSetArticle()== true) {
			tmp += "=> Set Artikel beinhaltend:" + "\n";
			tmp += super.partList.toString();
		}
		if (this.isSetPartItem()== true) {
			tmp += "=> Set Part Item beinhaltend:" + "\n";
			tmp += this.partList.toString();
		}
		return tmp;
	}
}


