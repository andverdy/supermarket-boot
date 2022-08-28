package it.objectmethod.supermarket.model;

import lombok.Data;

@Data
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

}
