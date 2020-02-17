package it.objectmethod.supermarket.model;

public class ArticleCart extends Article {

	private int quantita;

	public ArticleCart() {
	}

	public ArticleCart(Article article) {

		this.setCodArt(article.getCodArt());
		this.setDescrizione(article.getDescrizione());
		this.setFamAssDesc(article.getFamAssDesc());
		this.setIdFamAss(article.getIdFamAss());
		this.setIdIva(article.getIdIva());
		this.setIvaDesc(article.getIvaDesc());
		this.setPzCart(article.getPzCart());

	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

}
