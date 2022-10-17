package it.objectmethod.supermarket.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class
Article {

    private String codArt;
    private String descrizione;
    private int pzCart;
    private String ivaDesc;
    private String famAssDesc;
    private int idIva;
    private int idFamAss;


}
