package bl;

import app.PizzaApp;

public class Article {
	int articleCode;					// eindeutige ID des Artikels
	String articleName;					// Name des Artikels
	private double articlePrice;		// Artikelpreis in EUR, bei SetArtikel muss der Preis mittels computePreis ermittelt werden
	int unitCode;						// Einheit
	PartList partList;					// falls SetArtikel: Cart enthält Bezug zu den anderen Artikeln

	public Article (int articleCode, String articleName,double articlePrice, int unitCode) {
		this.articleCode = articleCode;
		this.articleName = articleName;
		this.articlePrice = articlePrice;
		this.unitCode = unitCode;
	}

	public Article (int articleCode, String articleName,double articlePrice, int unitCode, PartList partList) {
		this.articleCode = articleCode;
		this.articleName = articleName;
		this.articlePrice = articlePrice;
		this.unitCode = unitCode;
		this.partList = partList;
	}
	
	public Article (int articleCode) {
		this.articleCode = articleCode;
		
		Articles articles = PizzaApp.getMasterDataCache().getStockList();
		Article article = articles.getArticle(articleCode);
		this.articleName = article.articleName;
		this.articlePrice = article.articlePrice;
		this.unitCode = article.unitCode;
		if(article.partList != null) {
			this.partList = article.partList;
		}
	}
	
	public boolean isSetArticle (){
		if(partList != null) {
			if (partList.getPartItems().size() > 0) return true;
		}
		return false;
	}
	
	public double getArticlePrice () {
		if (this.isSetArticle()==true) {
			return partList.computePrice();
		}
		else {
			return this.articlePrice;
		}
	}
	
	@Override
	public String toString() {
		String tmp, unitName = "";
		Unit unit = PizzaApp.getMasterDataCache().getUnit(this.unitCode);
		if (unit != null) unitName = unit.unitName;
		
		tmp =  "articleCode = " + this.articleCode + 
				", articleName = " + this.articleName +
				", articlePrice = " + this.getArticlePrice() + " EUR " +
				", unitCode = " + this.unitCode  + " [" + unitName + "]" + "\n";
		if (this.isSetArticle()== true) {
			tmp += "=> Set Artikel beinhaltend:" + "\n";
			tmp += partList.toString();
		}
		return tmp;		
	}

}
 