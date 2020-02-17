package it.objectmethod.supermarket.model;

public class Article {

	private String codArt;
	private String descrizione;
	private int pzCart;
	private String ivaDesc;
	private String famAssDesc;
	private int idIva;
	private int idFamAss;

	public String getCodArt() {
		return codArt;
	}

	public void setCodArt(String codArt) {
		this.codArt = codArt;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getPzCart() {
		return pzCart;
	}

	public void setPzCart(int pzCart) {
		this.pzCart = pzCart;
	}

	public String getIvaDesc() {
		return ivaDesc;
	}

	public void setIvaDesc(String ivaDesc) {
		this.ivaDesc = ivaDesc;
	}

	public String getFamAssDesc() {
		return famAssDesc;
	}

	public void setFamAssDesc(String famAssDesc) {
		this.famAssDesc = famAssDesc;
	}

	public int getIdIva() {
		return idIva;
	}

	public void setIdIva(int idIva) {
		this.idIva = idIva;
	}

	public int getIdFamAss() {
		return idFamAss;
	}

	public void setIdFamAss(int idFamAss) {
		this.idFamAss = idFamAss;
	}

}
