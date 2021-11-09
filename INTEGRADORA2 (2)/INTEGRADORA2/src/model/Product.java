package model;
//	CLASE PADRE
public abstract class Product{
	private String nameD;
	private String synopsis;
	private String premiereDate;
	private String title;
	
	public Product(String nameD, String synopsis,String premiereDate,String title){
		this.nameD=nameD;
		this.synopsis=synopsis;
		this.premiereDate=premiereDate;
	}
	
	
	public String getNameD(){
		return nameD;
	}
	public void setNameD(String nameD){
		this.nameD=nameD;
	}
	
	public String getSynopsis(){
		return synopsis;
	}
	public void setSynopsis(String synopsis){
		this.synopsis=synopsis;
	}
	
	public String getPremiereDate(){
		return premiereDate;
	}
	public void setPremiereDate(String premiereDate){
		this.premiereDate=premiereDate;
	}
	
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title=title;
	}

	public String toString(){
		
		String mssg="";
		mssg=("Title: "+title+
				"\nName of the Director: "+nameD+
				"\nSynopsis : "+synopsis+
				"\nPremiere date: "+premiereDate);
				
		 return mssg;
	}
}		