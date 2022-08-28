package it.objectmethod.supermarket.model;

import lombok.Data;

@Data
public class Article {

    private String codArt;
    private String descrizione;
    private int pzCart;
    private String ivaDesc;
    private String famAssDesc;
    private int idIva;
    private int idFamAss;


}
