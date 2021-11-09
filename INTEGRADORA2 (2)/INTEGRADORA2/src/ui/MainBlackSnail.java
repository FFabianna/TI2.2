package ui;
import java.util.Scanner;
import model.BlackSnail;
import model.TypeSus;


public class MainBlackSnail {
	
	/**
	 * systemBlack es la conexiOn con la clase BlackSnail en el paquete model
	 */
	private BlackSnail systemBlack;

	/**
	 * sc es el objeto que permite leer informaciOn digitada por el usuario
	 */
	private Scanner sc;

	/**
	 * Constructor de la clase, no recibe prametros.
	 * El mEtodo inicializa el objeto lector
	 */
	public MainBlackSnail() {
		sc= new Scanner(System.in);
		
	}

	public static void main (String[] args){
		// creando un objeto de la clase principal
		MainBlackSnail obBlack = new MainBlackSnail();
		obBlack.initSystem();
	
	
		

		// variable para leer la entrada
		int option= 0;

		//ciclo para ejecutar el menu mientras que el usuario no
		// elija la opciOn para salir (0)
		do {
		    obBlack.showMenuAndGetOption();
		    
		}while (option !=0);
	}

	public void initSystem(){
		System.out.println("");
		System.out.println("**************BIENVENIDO A BALCKSNAIL***************");
		System.out.println("");
		System.out.println("Digite el NIT de BlackSnail: ");
		String nit= sc.nextLine();
		System.out.println("Digite la webside de BlackSnail: ");
		String webside= sc.nextLine();
		systemBlack = new BlackSnail(nit,webside);
		showMenuAndGetOption();
	}

	public void showMenuAndGetOption() {
		int input;
		System.out.println("\n*-*-*-*-*-*MENU PRINCIAL-*-*-*-*-*-*\n"+
		                    "(1) PRODUCTOS \n" +
		                    "(2) SUBSCRIPTORES" + //
		                    "(0) Para salir");
		input = sc.nextInt();
		sc.nextLine();
	
		switch(input) {
			case 0:
				System.out.println("cerrando la aplicaciOn, bye");
				break;
			case 1:
				showMenuAndGetOptionProduct();
				break;
			case 2:
				showMenuSUBSAndGetOption();
				break;
		}
	}





	/**
	 * Metodo que muestra el menu de la aplicaciOn, a este metod hace falta implementar la validaciOn
	 * del valor ingresado por el usuario
	 * @return input, int es la opciOn elegida por el usuario
	 */
	public void showMenuSUBSAndGetOption() {
		int input;
		System.out.println("\n*-*-*-*-*-*-SUSCRIPTOR-*-*-*-*-*-*\n"+
		                    "(1) Nuevo suscriptor \n" +
		                    "(2) Desactivar suscriptor" + //
		                    "(3) Lista info suscriptores\n"+
							"(4) Suscriptor joven estrella \n"+
		                    "(0) Para salir"
		);
		input = sc.nextInt();
		sc.nextLine();

		switch(input) {
			case 0:
				System.out.println("cerrando la aplicaciOn, bye");
				break;
			case 1:
				New();
				break;
			case 2:
				Delete();
				break;
			case 3:
				systemBlack.subsList();
				systemBlack.countTypeSubs();
				systemBlack.users();
				break;
			case 4:
				SubsYoung();
				break;
	
			}
	}
	

	//====================================== METODOS DE MENU SUSCRIPTOR
	/**
	 Metodo que registra un nuevo suscriptor (nombre completo del suscriptor, el numero de cedula, la edad,
	*la cantidad de horas que está dispuesto a consumir, el tipo de cliente), verifica la informacion dada, revisa si el numero de cedula
	*ya esxite en el sistema. finalmente lo añade a al sistema, haciendo llamado a otro metodo de BlackSnail.
	*/
	public void New(){
		String fullName="";
		String status="";
		String cc="";
		int age=0;
		int cantHrs=0;
		int optionType=0;
		boolean flag = false;
		for (int i = 0; i < 85 && !flag; i++){
			System.out.println("-_-_-_-_NUEVO SUSCRIPTOR-_-_-_-");
			System.out.println("");
			System.out.println("Registro");
	
			System.out.println("NOMBRE completo: ");
			fullName=System.console().readLine();
			System.out.println(".............................................");
			System.out.println("Numero de cedula: ");
			cc= sc.nextLine();
			while(cc=="0" ){
				System.out.println("**ERROR**");
				System.out.println("Numero de IDENTIFICACION:");
				cc= sc.nextLine();
			}
			if(systemBlack.verifycc(cc)){
				System.out.println("**Error, este documento ya ha sido registrado**");
				System.out.println("intente con otro:");
				cc= sc.nextLine();
			}
			System.out.println(".............................................");
			System.out.println("edad: ");
			age=sc.nextInt();
			if(age==0){
				System.out.println("error");
				System.out.println("Escriba la EDAD correcta: ");
				age=sc.nextInt();
			}
			System.out.println(".............................................");
			System.out.println("¿cuanto tiempo consume viendo series/peliculas? (horas)");
			cantHrs=sc.nextInt();
	
			while(cantHrs==0){
				System.out.println("error, no puede ser 0");
				System.out.println("¿cuanto tiempo consume viendo series/peliculas? (horas)");
				cantHrs=sc.nextInt();
			}

			System.out.println(".............................................");
			System.out.println("");
			System.out.println("--TIPO de suscriptor-- ");
			System.out.println("escriba el tipo de suscriptor\n"+
				"(1) Normal\n"+
				"(2) Platino\n"+
				"(3) Oro\n"+
				"(4) Diamante"
				);
			optionType=sc.nextInt();
			
				TypeSus type=systemBlack.typeSubscriber(optionType);
				System.out.println(".............................................");
				System.out.println("estado suscriptor: ACTIVO");
				status="ACTIVE";
				sc.nextLine();
				System.out.println(".............................................");
				systemBlack.addSubscriber(fullName,cc,age,cantHrs,type,status);
				
				System.out.println("El suscriptor "+fullName+" está registrado");
				System.out.println(".............................................");
				
				System.out.println("Quiere registrar otro subscriptor? ");
				System.out.println("(YES) (NO)");
				String flag1 = sc.nextLine();
	
				if(flag1.equalsIgnoreCase("YES")){
					flag = true;
				}else if(flag1.equalsIgnoreCase("NO")){
					flag = false;
				}
			} 
		}
	private void Delete() {
		String cc="";
		System.out.println("-_-_-_-_-_-_-_-_-_-SUSCRIPTOR-_-_-_-_-_-_-_-_-_-");
		System.out.println("Eliminar");
		sc.nextLine();
		System.out.println("Numero de identificacion del suscriptor a eliminar: ");
		cc= sc.nextLine();
		systemBlack.deleteSubscriber(cc);
	}

	

	public void SubsYoung(){
	System.out.println("no está habilitado");
	}

	public void showMenuAndGetOptionProduct() {
		int inputt;
		System.out.println("\n*-*-*-*-*-*-PRODUCT-*-*-*-*-*-*\n"+
		                    "(1) new product \n"+ 
							"(2) product information\n"+
							"(3) new season\n"+
							"(4) search movie\n"+
							"(5) search serie\n"+
		                    "(0) exit\n");
		inputt = sc.nextInt();
		switch(inputt) {
			case 0:
				System.out.println("cerrando la aplicaciOn, bye");
				break;
			case 1:
				NewProduct();
				break;
			case 2:
				productInfo();
				break;
			case 3:
				newSeason();
				break;
			case 4:
				showMovie();
				break;
			case 5:
				showSerie();
				break;
		}
	}
	
	

	public void NewProduct(){
		int innput=0;
		int optionCategory=0;
		String respCensurado="";
		String minAge="";
		String title="";
		String nameD="";
		String synopsis="";
		String premiereDate="";
		String productor="";
		String nameProta="";
		String censored="";
	
		System.out.println("(1) its serie \n"+ 
		"(2) its movie\n");
			innput =sc.nextInt();
			sc.nextLine();
		if (innput==1){
			System.out.println("Write the title of the serie");
			title=sc.nextLine();
			System.out.println("Write the name of the Director ");
			nameD= sc.nextLine();
			System.out.println("Write the synopsis: ");
			synopsis= sc.nextLine();
			System.out.println("Write the premiere date, for example: day/month/year ");
			premiereDate= sc.nextLine();
			System.out.println("Write the name of the Protagonists  ");
			nameProta= sc.nextLine();
			System.out.println("This serie must be censored? (yes) (no)");
			respCensurado =sc.nextLine();

			if(respCensurado.equals("yes")){
				System.out.println("Write the reason: ");
				censored=sc.nextLine();
			}else if(respCensurado.equals("no")){
				System.out.println("ok.");
			}
			systemBlack.addSerie(nameD,synopsis,premiereDate,title,nameProta,censored);
			System.out.println("ok");
			newSeason();
			
		}else if(innput==2){
			System.out.println("Write the title of the movie");
			title=sc.nextLine();
			System.out.println("Write the name of the Director: ");
			nameD= sc.nextLine();
			System.out.println("Write the synopsis: ");
			synopsis= sc.nextLine();
			System.out.println("Write the premiere date, for example: day/month/year ");
			premiereDate= sc.nextLine();
			System.out.println("Write the minimun age allowed: ");
			minAge=sc.nextLine();
			parseInt(minAge);
			System.out.println("Write the name of the Producer: ");
			productor= sc.nextLine();
			System.out.println("CATEGORY MOVIE ");
			System.out.println("choose the category\n"+
			"(1) Romantic\n"+
			"(2) Action\n"+
			"(3) Suspense\n"+
			"(4) Horror\n"+
			"(5) Comedy"
			);
			optionCategory=sc.nextInt();
			if(optionCategory>0 && optionCategory<=5){
				systemBlack.movieCategory(optionCategory);
				System.out.println("ok. ");
			}else{
				System.out.println("choose the category\n"+
				"(1) Romantic\n"+
				"(2) Action\n"+
				"(3) Suspense\n"+
				"(4) Horror\n"+
				"(5) Comedy"
				);
				optionCategory=sc.nextInt();
			}
			systemBlack.addMovie(nameD,synopsis,premiereDate,title,minAge,productor,systemBlack.movieCategory(optionCategory));
		}
		
		
	}
	
	
	private void parseInt(String innput) {
	}

	public void productInfo(){
		String title="";
		System.out.println("Write the title of the product that you need");
		title=sc.nextLine();
		systemBlack.showProduct(title);
	}
	
	public void newSeason(){
		int numSeasons=0;
		int cantEpiPr=0;
		int cantEpiPu=0;
		String titleSeason="";
		String premierDteSeason="";

		System.out.println("--SEASON--");
		System.out.println("Write the title of the season");
		titleSeason=sc.nextLine();
		System.out.println("Write the number seasons");
		numSeasons=sc.nextInt();
		System.out.println("number of episodes produced:");
		cantEpiPr=sc.nextInt();
		System.out.println("number of episodes published:");
		cantEpiPu=sc.nextInt();
		System.out.println("Write the premiere date of the season, for example: day/month/year ");
		premierDteSeason=sc.nextLine();
		systemBlack.addSeason(titleSeason,numSeasons,cantEpiPr,cantEpiPu,premierDteSeason);
		System.out.println("season "+titleSeason+"was saved");
	
	}

	public void showMovie(){

	}

	public void showSerie(){
		systemBlack.searchSerie();
	}

}