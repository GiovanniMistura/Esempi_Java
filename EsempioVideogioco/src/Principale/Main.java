package Principale;

public class Main {

	// Scopo = scrivere uno scheletro del codice che sia leggibile e implementabile anche da altri
	// Software strutturato in diverse classi:
	// Menu -> oggetto che gestisce i vari catalogi di giochi e utenti/amministratori e che mostra i diversi menu
	// Videogioco e i figli VideogiocoAzione e VideogiocoStrategia rappresentano i Videogiochi
	public static void main(String[] args) {
		
		// creo il menu della sala giochi
		Menu start = new Menu();
		
		//aggiungo già un'ammistratore e un utente per comodità
		start.amministratori.add(new Admin("Gio","1234"));
		start.utenti.add(new Utente("Marco","password"));
		
		// starto il menu
		start.start();

	}

}
