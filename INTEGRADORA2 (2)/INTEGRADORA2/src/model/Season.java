package model;

public class Season {
	private int numSeasons;
	private int cantEpiPr; //cantidad de episodios programados
	private int cantEpiPu; // cantidad de episodios publicados 
	private String titleSeason;
	private String premierDteSeason;
	
	public Season(String titleSeason,int numSeasons,int cantEpiPr,int cantEpiPu,String premierDteSeason){
		this.titleSeason=titleSeason;
		this.numSeasons=numSeasons;
		this.cantEpiPr=cantEpiPr;
		this.cantEpiPu=cantEpiPu;
		this.premierDteSeason=premierDteSeason;
	}
	public String getTitleSeason(){
		return titleSeason;
	}
	public void setTitleSeason(String titleSeason){
		this.titleSeason=titleSeason;
	}
	public int getNumSeasons(){
		return numSeasons;
	}
	public void setNumSeasons(int numSeasons){
		this.numSeasons=numSeasons;
	}
	
	public int getCantEpiPr(){
		return cantEpiPr;
	}
	public void setCantEpiPr(int cantEpiPr){
		this.cantEpiPr=cantEpiPr;
	}
	
	public int getCantEpiPu(){
		return cantEpiPu;
	}
	public void setCantEpiPu(int cantEpiPu){
		this.cantEpiPu=cantEpiPu;
	}
	
	public String getPremierDteSeason(){
		return premierDteSeason;
	}
	public void setPremierDteSeason(String premierDteSeason){
	this.premierDteSeason=premierDteSeason;
	}
	
	public String toString(){
		String mssg="";
		mssg=("title Season"+titleSeason+
				"\nTemporada numero: "+numSeasons+
				"\nCantidad de episodios programados: "+cantEpiPr+
				"\nCntidad de episodios publicados: "+ cantEpiPu+
				"\nFecha de estreno: "+ premierDteSeason);
		return mssg;
	}

}