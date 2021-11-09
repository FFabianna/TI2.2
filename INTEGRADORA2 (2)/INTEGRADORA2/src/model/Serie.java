package model;

// CLASE HIJA DE PRODUCT
//	CLASE MEDIA 
public class Serie extends Product{
	
	//relationship
	/**
	 * Category (censorade)of the serie: YES, NO
	 */
	private String censored;
	private String nameProta;
	private Season [] seasons;
	
	
	//constructor
	public Serie(String nameD, String synopsis,String premiereDate,String title,String nameProta, String censored){
		super(nameD, synopsis,premiereDate,title);
		this.censored=censored;
		this.nameProta=nameProta;
		this.seasons=new Season [20];
		
	}
	public String getCensored(){
		return censored;
	}
	public void setCensored(String censored){
		this.censored=censored;
	}
	
	public String getNameProta(){
		return nameProta;
	}
	public void setNameProta(String nameProta){
		this.nameProta=nameProta;
	}
	
	public Season[] getSeasons(){
		return seasons;
	}
	public void setSeasons(Season[] seasons){
		this.seasons=seasons;
	}

	public String getLastSeason(){
		Season lastSeason=null;
		for (int i=0;i<seasons.length;i++){
			if(seasons[i]!=null){
				lastSeason=seasons[i];
			}
		}
		return lastSeason.toString();
	}
	
	public String toString(){
		String mssg="";
		mssg=super.toString()+"Nombre del director: "+getNameD()+
				"\nSynopsis : "+getSynopsis()+
				"\nFecha de estreno: "+getPremiereDate()+
				"\nla serie esta censurada?: "+censored+
				"\nNombre de los protagonistas: "+nameProta;

				for(int i=0;i<seasons.length;i++){
					if(seasons[i]!=null){
						mssg+= seasons[i].toString();
					}
				}

				
		
		return mssg;
	}
	
	public String addSeason(String titleSeason,int numSeasons,int cantEpiPr,int cantEpiPu,String premierDteSeason){
		String out="";
		for(int i=0;i<seasons.length;i++){
			if(verifySeason(titleSeason)){
				if (seasons[i]==null){
					seasons[i]=new Season(titleSeason,numSeasons,cantEpiPr,cantEpiPu,premierDteSeason);
					out="ok, the season has been registered";
				}
			}
		}
		return out;
	}
	
	public boolean verifySeason(String titleSeason){
		boolean verifyS=false;
		for(int i=0;i<seasons.length;i++){
			if(seasons[i]!=null){
				if(titleSeason.equals(seasons[i].getTitleSeason())){
					verifyS=true;
				}
				
			}
		}
		return verifyS;
	}
}



