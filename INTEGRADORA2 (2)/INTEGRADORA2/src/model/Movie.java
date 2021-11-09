package model;
//CLASE HIJA
public class Movie extends Product{
	private String minAge;
	private String productor;
	private Category categoryMovie;

	
	//constructor
	public Movie(String nameD, String synopsis,String premiereDate,String title, String minAge, String productor,Category categoryMovie){
		super(nameD,synopsis,premiereDate,title);
		this.minAge=minAge;
		this.categoryMovie=categoryMovie;
	}
	
	public String getMinAge(){
		return minAge;
	}
	public void setMinAge(String minAge){
		this.minAge=minAge;
	}
	
	public String getProductor(){
		return productor;
	}
	public void setProductor( String productor){
		this.productor=productor;
	}
	
	public Category getCategoryMovie(){
		return categoryMovie;
	}
	public void setCategoryMovie(Category categoryMovie){
		this.categoryMovie=categoryMovie;
	}
	
	
	public String toString(){
		
		String mssg="";
		mssg=super.toString()+"Title: "+getTitle()+
				"\nName of the Director: "+getNameD()+
				"\nSynopsis : "+getSynopsis()+
				"\nPremiere date: "+getPremiereDate()+
				"\nMinimun age: "+minAge+
				"\nCategory: "+categoryMovie;
				
		 return mssg;
	}
}