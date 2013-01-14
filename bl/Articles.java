package bl;

import java.util.Vector;

public class Articles {
	Vector<Article> articles;

	public Articles (Vector<Article> articles){
		this.articles = articles;
	}

	public Articles (){
		this.articles = new Vector<Article>();
	}
	
	public void add(Article article){
		articles.add(article);
	}

	public Article getArticle (int articleCode) {
		for (Article article : articles) {   
			if (article.articleCode == articleCode) return article;
		}
		return null;
	}
	
	public String toString (){
		String tmp="";
		for (Article article : articles) {   
			tmp += article.toString();
		}
		return tmp;
	}


}
 