package Principale;

import java.util.ArrayList;
import java.util.Scanner;

//Scopo = scrivere uno scheletro del codice che sia leggibile e implementabile anche da altri
public class Menu {
	
	// lista degli utenti registrati
	ArrayList<Utente> utenti;
	
	// lista degli amministratori
	ArrayList<Admin> amministratori;
	
	// lista dei videogiochi
	ArrayList<Videogioco> catalogoGiochi;
	
	//lista delle richieste fatte dagli utenti
	ArrayList<Videogioco> richieste;
	
	//utente corrente
	Utente utenteOra;
	Admin adminOra;
	
	public Menu() {
		this.utenti = new ArrayList<Utente>();
		this.amministratori = new ArrayList<Admin>();
		this.catalogoGiochi = new ArrayList<Videogioco>();
		this.richieste = new ArrayList<Videogioco>();
	}
	
	// metodo che inizia il menu
	public void start() {
		int input = 0;
		boolean loop = true;
		while(loop) {
			System.out.println("----BENVENUTO ALLA SALA VIDEOGIOCHI! ----- \n"
					+ "1 -> Log in (anche per admin)\n"
					+ "2 -> Registrazione\n"
					+ "3 -> esci"
					);
			
			input = Integer.parseInt(this.scan());
			//cB = S.nextLine();
			
			switch(input) {
			case 1: { 
				this.logIn();
			
			} break;
			case 2: { 
				this.registrazione();
				
			} break;
			case 3: {
				System.out.println("Sei uscito dalla Sala giochi");
				System.exit(0);
			} break;
			default: System.out.println("Input non accettato."); break;
			}
		}
	}
	
	// funzione per il login, se è registrato chiama il menu giusto, senno manda alla registrazione
	private void logIn() {
		
		String username;
		String password;
		boolean esiste = false;
		System.out.println("----LOG IN ----- ");
		System.out.println("Inserire username: ");
		username = this.scan(); 
		
		System.out.println("Inserire password: ");
		password = this.scan();
		
		for (Utente u : this.utenti) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				this.utenteOra = new Utente(username,password);
				esiste = true;
				System.out.println("LogIn avvenuto con successo!");
				this.utenteMenu();
			}
		}
		for (Admin a : this.amministratori) {
			if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
				this.adminOra = new Admin(username,password);
				esiste = true;
				System.out.println("LogIn avvenuto con successo!");
				this.adminMenu();
			}
		}
		
		if (!esiste) {
			System.out.println("Non sei registrato, reindirizzamento all'apposita pagina");
			this.registrazione();
		}
		
	}
	

	// solo gli utenti normali si posso registrare.
	private void registrazione() {
		String username;
		String password;
		boolean loop = true;
		boolean duplicato = false;
		System.out.println("---- REGISTRAZIONE ----- ");
		while (loop) {
			System.out.println("Inserire username: ");
			username = this.scan(); 
						
			for (Utente u : this.utenti) {
				if (u.getUsername().equals(username)) {
					duplicato = true;
				}
			}

			if (!duplicato) {
				System.out.println("Inserire password: ");
				password = this.scan();
				this.utenti.add(new Utente(username,password));
				this.utenteOra = new Utente(username,password);
				System.out.println("Registrazione avvenuta con successo ");
				this.utenteMenu();
			} else {
				System.out.println("username già utilizzato ");
			}
		}
	}
	
	// mostra il menu per l'utente normale e permette di fare scelte
	private void utenteMenu() {
		boolean loop = true;
		int input;
		
		while(loop) {
			System.out.println("----- Utente " + this.utenteOra.getUsername() + " Menu ----- \n"
					+ "1 -> Visualizza catalogo Videogiochi\n"
					+ "2 -> scegli un Videogioco\n"
					+ "3 -> inserisci richiesta di un Videogioco\n"
					+ "4 -> log out\n"
					+ "5 -> esci"
					);
			
			input = Integer.parseInt(this.scan());
			//cB = S.nextLine();
			
			switch(input) {
			case 1: { 
				this.stampaCatalogo();
			
			} break;
			case 2: { 
				this.stampaCatalogo();
				this.utenteOra.scegliGioco(catalogoGiochi);
				
			} break;
			case 3: { 
				this.utenteOra.aggiungiRichiesta(richieste);
				
			} break;
			case 4: {
				this.utenteOra = null;
				this.start();
			}
			case 5: {
				System.out.println("Sei uscito dalla Sala giochi");
				System.exit(0);
			} break;
			default: System.out.println("Input non accettato."); break;
			}
		}
	}
	
	// mostra il menu per l'admin e permette di fare scelte
	private void adminMenu() {
		boolean loop = true;
		int input;
		
		while(loop) {
			System.out.println("------ Admin " + this.adminOra.getUsername() + " Menu ------ \n"
					+ "1 -> aggiungi un Videogioco\n"
					+ "2 -> elimina un Videogioco\n"
					+ "3 -> Modifica un Videogioco\n"
					+ "4 -> Visualizza richieste\n"
					+ "5 -> Approva richiesta\n"
					+ "6 -> Elimina richiesta\n"
					+ "7 -> log out\n"
					+ "8 -> esci"
					);
			
			input = Integer.parseInt(this.scan());
			//cB = S.nextLine();
			
			switch(input) {
			case 1: { 
				this.adminOra.aggiungiVideogioco(catalogoGiochi);
			
			} break;
			case 2: { 
				this.stampaCatalogo();
				this.adminOra.eliminaVideogioco(catalogoGiochi);
				
			} break;
			case 3: { 
				this.stampaCatalogo();
				this.adminOra.modificaVideogioco(catalogoGiochi);
				
			} break;
			case 4: { 
				this.stampaRichieste();
				
			} break;
			case 5: { 
				this.stampaRichieste();
				this.adminOra.approvaRichieste(richieste, catalogoGiochi);
				
			} break;
			case 6: { 
				this.stampaRichieste();
				this.adminOra.eliminaRichieste(richieste);
				
			} break;
			case 7: {
				this.adminOra = null;
				this.start();
			}
			case 8: {
				System.out.println("Sei uscito dalla Sala giochi");
				System.exit(0);
			} break;
			default: System.out.println("Input non accettato."); break;
			}
		}
	}
	
	//UTILITIES della classe ------------------------------------------------------------
	
	
	// funzione stampa catalogo videogiochi
	public void stampaCatalogo() {
		System.out.println("---- Lista videogiochi ------");
		for (Videogioco v : this.catalogoGiochi) {
			System.out.println(v.toString());
		}
		System.out.println("---------------------------");
	}
	//funzione stampa richieste
	public void stampaRichieste() {
		System.out.println("---- Lista richieste ------");
		for (Videogioco v : this.richieste) {
			System.out.println(v.toString());
		}
		System.out.println("---------------------------");
	}
	// funzione per prendere in input Stringa e ritorna una Stringa
	public String scan() {
		String input = "";
		Scanner s = new Scanner(System.in);
		input = s.nextLine();
		
		return input;
	}

	
	//getters and setters per catalogoGiochi e richieste
	public ArrayList<Videogioco> getCatalogoGiochi() {
		return catalogoGiochi;
	}

	public void setCatalogoGiochi(ArrayList<Videogioco> catalogoGiochi) {
		this.catalogoGiochi = catalogoGiochi;
	}

	public ArrayList<Videogioco> getRichieste() {
		return richieste;
	}

	public void setRichieste(ArrayList<Videogioco> richieste) {
		this.richieste = richieste;
	}


	
}
