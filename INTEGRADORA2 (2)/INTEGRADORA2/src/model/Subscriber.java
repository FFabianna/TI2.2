package model;

public class Subscriber {
	
	private String fullName;
	private String cc;
	private int age;
	private int cantHrs;
	public TypeSus type;
	private String status;
	private int totalActive;


// ====================================== constructor
	public Subscriber(String fullName, String cc,int age, int cantHrs,TypeSus type, String status){
		super();
		this.fullName= fullName;
		this.cc= cc;
		this.age= age;
		this.cantHrs= cantHrs;
		this.type= type;
		this.status= status;
		totalActive=0;
	}
	/*
	 * ====================================== Getters & setters
	 */
	// full name Subscriber 
	public String getFullName(){
		return fullName;
	} 
	public void setFullName(String fullName){
		this.fullName=fullName;
	}
	// identification number
	public String getCc(){
		return cc;
	}
	public void setCc(String cc){
		this.cc=cc;
	}
	// edad 
	public int getAge(){
		return age;
	}
	public void setSAge(int age){
		this.age=age;
	}
	// number of hours willing to consume
	public int getCantHrs(){
		return cantHrs;
	}
	public void setCantHrs(int cantHrs){
		this.cantHrs=cantHrs;
	}
	// type(normal, platino,diamante)
	public TypeSus getType(){
		return type;
	}
	public void setType(TypeSus type){
		this.type=type;
	}
	// subscriber status (active, inactive)
	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public int getTotalActive(){
		return totalActive;
	}
	public void setTotalActive(int totalActive){
		this.totalActive=totalActive;
	}
	// ================================================================================  
	
	
	public String toString() {
		return "Subscriber [nombre completo]=" + fullName +"Edad= "+age+ "ID= "+cc+ "Horas que consume=" + cantHrs + " Tipo="
				+ type + " Estado=" +status+" ";
	}
}