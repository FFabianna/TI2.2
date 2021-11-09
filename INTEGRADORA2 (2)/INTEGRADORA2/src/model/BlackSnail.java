package model;
public class BlackSnail {
	
	private Subscriber[] subscribers;
	private String nit;
	private String webside;
	public static final int NUMSUBS = 50;
	public static final int NUMPRO = 85;
	private int cont;
	private Product [] products;
	private Serie seriee;
	
	public BlackSnail(String nit,String webside){
		this.webside=webside;
		this.nit=nit;
		cont=0;
		subscribers= new Subscriber[NUMSUBS];
		this.products = new Product[NUMPRO];
	}

	/*
	 * ====================================== Getters & setters
	 */
	public String getNit(){
		return nit;
	}
	public void setNit(String nit){
		this.nit=nit;
	}
	public String getWebside(){
		return nit;
	}
	public void setWebside(String webside){
	this.webside=webside;
	}
	
	
	/** metodo que agrega un Subscriber al sistema
	@param fullName, String es el nombre completo del Subscriber. 
	@param cc, int es el numero de cedula del Subscriber.
	@param age, int es la edad del Subscriber.
	@param type, String es el tipo de Subscriber (normal, platino, diamante).
	@param cantHrs, int es la cantidad de horas que el Subscriber consume.
	*/
	public void addSubscriber(String fullName, String cc, int age,int cantHrs, TypeSus type,String status){
		for(int i=0; i<subscribers.length;i++){
			subscribers[i]= new Subscriber(fullName,cc,age,cantHrs,type,status);
		}
	}
	
	
	/** metodo que verifica si el numero de cedula ya se encuentra en el arreglo
	@param cc, int es el numero de cedula del Subscriber.
	@return boolean que es true si el producto esta registrado, false en el caso contrario.
	*/
	public boolean verifycc(String cc){
		String status="";
		boolean flag= false;
		for(int i=0;i<subscribers.length&&!flag;i++){
			if(subscribers[i]!=null){
				subscribers[i].getCc();
				if(subscribers[i].getCc().equals(cc)){
					System.out.println("estado suscriptor: INACTIVO");
					status= "INACTIVE";
					subscribers[i].setStatus(status);
				}
			}else if(subscribers[i]!=null){
				flag=true;
			}
		}return flag;
	}
	
	
	/** metodo tipo TypeSus (usando numeracion)que se encarga de asignar el tipo de cliente, según la opcion marcadapor el usuario.
	@param optionType, int es el numero de opcion elegido.
	@return type, TypeSus es el tipo de cliente.
	*/
	public TypeSus typeSubscriber(int optionType){
		TypeSus type= null;
		switch(optionType){
		case 1: 
			type=TypeSus.NORMAL;
			break;
		case 2: 
			type=TypeSus.PLATINO;
			break;
		case 3: 
			type=TypeSus.ORO;
			break;
		case 4: 
			type=TypeSus.DIAMANTE;
			break;
		}
		return type;
	}
	
	public void deleteSubscriber(String cc){
		String status="";
		boolean flag= false;
		for(int i=0;i<subscribers.length&&!flag;i++){
			if(subscribers[i]!=null){
				subscribers[i].getCc();
				if(subscribers[i].getCc().equals(cc)){
					System.out.println("estado suscriptor: INACTIVO");
					status= "INACTIVE";
					subscribers[i].setStatus(status);
				}
			}else if(subscribers[i]==null){
				System.out.println("error, este suscriptor no existe");
				flag=true;
			}
		}
	}
	
	public void countTypeSubs(){
		int iNormal=0;
		int iOro=0;
		int iPlatino=0;
		int iDiamante=0;
		for(int i = 0; i < cont; i++){
			if(subscribers[i].getType()!=null){
				if(subscribers[i].getType() == TypeSus.NORMAL){
					iNormal++;
				}else if(subscribers[i].getType() == TypeSus.ORO){
					iOro++;
				}else if(subscribers[i].getType() == TypeSus.PLATINO){
					iPlatino++;
				}else if(subscribers[i].getType() == TypeSus.DIAMANTE){
					iDiamante++;
				}
			}
		}
		System.out.println("total suscriptores activos: "+subscribers.length);
		System.out.println("Normal: "+iNormal);
		System.out.println("Oro: "+iOro);
		System.out.println("Platino: "+iPlatino);
		System.out.println("Diamante: "+iDiamante);
	}
	
	/**
	 * subsList This method will print all subscribers.
	 */
	public void subsList() {
		for (Subscriber subscriber1 : subscribers) {
			if (subscriber1 != null) {
				System.out.println("\nThe id is: " + subscriber1.getCc() + 
				"\nSubs name is: " + subscriber1.getFullName() + "\nSubs age is: " + subscriber1.getAge() + 
				"\nHours per week are: " + subscriber1.getCantHrs() + "\nThe actual status is: " + subscriber1.getStatus() + 
				"\nThe type of subscription is: " + subscriber1.getType());
			}
		}
	}

	/**
	 * subsList This method will print the status of the subscribers
	 */
	public void users(){
		int totalActive = 0;
		int totalInactive = 0;
		for(int i = 0; i < cont; i++){
			if(subscribers[i].getStatus()!=null){
				if(subscribers[i].getStatus().equals("ACTIVE")){
					totalActive+= 1;
				}else if(subscribers[i].getStatus().equals("INACTIVE")){
					totalInactive += 1;
				}
			}
		}
		System.out.println("\nThere are " + totalActive + " active subscribers");
		System.out.println("\nThere are " + totalInactive + " inactive subscribers");
	}

/** metodo que registra un nuevo producto pelicula al sistema
	*pos: el producto corresponde al numero (1,2,3,4 o 5) es distinto de null. 
	@param nameD, String es el nombre del director.
	@param synopsis, String es la sinopsis de la obra.
	@param title, String es el titulo de la obra.
	@param premiereDate, Date es la fecha de estreno.
	@return out, boolean que es true si el producto esta registrado, false en esl caso contrario.
	*/
	public String addMovie(String nameD, String synopsis,String premiereDate,String title, String minAge, String productor,Category categoryMovie){
		String out="";
		Product product=searchProduct(title);

		if(product!=null){
			out="the movie already exists";
		}else{
			for(int i=0;i<products.length;i++){
				if (products[i]==null){
					products[i]=new Movie(nameD,synopsis,premiereDate,title,minAge,productor,categoryMovie);
					out="ok, the movie has been registered";
				}else{
					out="no more space";
				}
				
			}
			
		}
		return out;
	}
	
	/** metodo que registra un nuevo producto serie al sistema
	*pos: el producto corresponde al numero (1,2,3,4 o 5) es distinto de null.
	@param nameProta, String es el nombre del productor.
	@param nameD, String es el nombre del director.
	@param synopsis, String es la sinopsis de la obra.
	@param title, String es el titulo de la obra.
	@param premiereDate, Date es la fecha de estreno.
	*/
	public void addSerie(String nameD, String synopsis,String premiereDate,String title,String nameProta, String censored){
		if(searchProduct(title) != null){
			
		}else{
			for(int i=0;i<products.length;i++){
				if (products[i]==null){
					products[i]=new Serie(nameD,synopsis,premiereDate,title,nameProta,
					censored);
				
				}
			}
		}
	}
	
	/** metodo tipo Category (usando numeracion)que se encarga de asignar la categoria de la pelicula
	*según la opcion marcada por el usuario.
	@param optionCateory, int es el numero de opcion elegido.
	@return categoryMovie, categoryMovie es la categoria de la pelicula.
	*/
	public Category movieCategory(int optionCategory){
		Category categoryMovie= null;
		switch(optionCategory){
		case 1: 
			categoryMovie=Category.ROMANTIC;
			break;
		case 2: 
			categoryMovie=Category.ACTION;
			break;
		case 3: 
			categoryMovie=Category.SUSPENSE;
			break;
		case 4: 
			categoryMovie=Category.HORROR;
			break;
		case 5: 
			categoryMovie=Category.COMEDY;
			break;
		}
		return categoryMovie;
	}
	
	
	public boolean typeProduct(String title){
		boolean search=false;
		for(int i=0;i<products.length;i++){
			if(products[i]!=null){
				if(products[i] instanceof Serie){
					search=true;
				}else if(products[i] instanceof Movie){
					search=false;
				}
				
			}
		}
		return search;
	}
	
	
	/** metodo que verifica si el producto ya ha sido registrado 
	@param tite,String es como se titula el producto.
	@return out, boolean que es true si el producto esta registrado, false en el caso contrario.
	*/
	public Product searchProduct(String title){
		boolean found=false;
		Product foundProduct=null;
		for(int i=0;i<products.length && !found;i++){
			if(products[i]!=null){
				if(products[i].getTitle().equals(title)){
					foundProduct = products[i];
					found = true;
				}
			}
		}
		return foundProduct;
	}
	
	
	public String showProduct(String title){
		String out="";
		Product find=searchProduct(title);
		if(find==null){
			out="no existe";
		}else{
			 
		}
		return out;
		
	}

	public String addSeason(String titleSeason,int numSeasons,int cantEpiPr,int cantEpiPu,String premierDteSeason){
		String message="";

		Product serie=searchProduct(titleSeason);
		for(int amountSeason=0;amountSeason<products.length;amountSeason++){
			amountSeason++;
			if (serie==null ||  serie instanceof Movie){
			message="Error";
			}else{
			message=seriee.addSeason(titleSeason,numSeasons,cantEpiPr,cantEpiPu,premierDteSeason);
			
			}
			
		}
		return message;
		
	}

	public void searchSerie(){
		for(int i=0;i<products.length;i++){
			if(products[i]!=null){
				if (products[i] instanceof Serie);
				System.out.println(products[i].toString());
			}
		}
	}


	
}