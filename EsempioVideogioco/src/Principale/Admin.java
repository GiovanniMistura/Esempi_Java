package Principale;

import java.util.ArrayList;
import java.util.Scanner;

//Scopo = scrivere uno scheletro del codice che sia leggibile e implementabile anche da altri
public class Admin {
	
	private String username;
	private String password;
	
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	// aggiunge videogioco al catalogo
	public void aggiungiVideogioco(ArrayList<Videogioco> catalogo) {
		Scanner S = new Scanner(System.in);
		String titolo = "";
		String genere = "";
		
		System.out.println("Inserisci nome del videogioco: ");
		titolo = S.next();
		
		System.out.println("Inserisci genere del videogioco: ");
		genere = S.next();
		
		if (genere.equals("Azione")) {
			catalogo.add(new VideogiocoAzione(titolo,genere));
		} else if (genere.equals("Strategia")) {
			catalogo.add(new VideogiocoStrategia(titolo,genere));
		} else {
			catalogo.add(new Videogioco(titolo,genere));
		}
		System.out.println("Videogioco aggiunto");
		
	}
	
	// elimina un videogioco dal catalogo
	public void eliminaVideogioco(ArrayList<Videogioco> catalogo) {
		Scanner S = new Scanner(System.in);
		String titolo = "";
		Videogioco eliminare = null;
		System.out.println("Inserisci nome del videogioco: ");
		titolo = S.next();
		
		for (Videogioco v : catalogo) {
			if (v.getNome().equals(titolo));
			eliminare = v;
		}
		
		if (eliminare != null) {
			catalogo.remove(eliminare);
			System.out.println("Gioco eliminato ");
		} else {
			System.out.println("Nome gioco non esistente nel catalogo ");
		}
		
	}
	
	// modifica un videogioco dal catalogo
	public void modificaVideogioco(ArrayList<Videogioco> catalogo) {
		Scanner S = new Scanner(System.in);
		String titolo = "";
		String titoloModificato = "";
		String genereModificato = "";
		Videogioco modificare = null;
		System.out.println("Inserisci nome del videogioco da modificare: ");
		titolo = S.next();
		
		for (Videogioco v : catalogo) {
			if (v.getNome().equals(titolo));
			modificare = v;
		}
		
		if (modificare != null) {
			System.out.println("Inserisci nuovo nome del videogioco: ");
			titoloModificato = S.next();
			
			System.out.println("Inserisci nuovo genere del videogioco: ");
			genereModificato = S.next();
			
			modificare.setNome(titoloModificato);
			modificare.setGenere(genereModificato);
			
			System.out.println("Modifica fatto ");
		} else {
			System.out.println("Nome gioco non esistente nel catalogo ");
		}
		
	}
	
	
	// elimina una richiesta
	public void eliminaRichieste(ArrayList<Videogioco> richieste) {
		Scanner S = new Scanner(System.in);
		String titolo = "";
		Videogioco eliminare = null;
		System.out.println("Inserisci nome del videogioco: ");
		titolo = S.next();
		
		for (Videogioco v : richieste) {
			if (v.getNome().equals(titolo));
			eliminare = v;
		}
		
		if (eliminare != null) {
			richieste.remove(eliminare);
			System.out.println("Richiesta eliminato ");
		} else {
			System.out.println("Nome gioco non esistente nelle richieste ");
		}
		
	}
	
	// approva una richiesta
	public void approvaRichieste(ArrayList<Videogioco> richieste, ArrayList<Videogioco> catalogo) {
		Scanner S = new Scanner(System.in);
		String titolo = "";
		Videogioco approvato = null;
		System.out.println("Inserisci nome del videogioco: ");
		titolo = S.next();
		
		for (Videogioco v : richieste) {
			if (v.getNome().equals(titolo));
			approvato = v;
		}
		
		if (approvato != null) {
			richieste.remove(approvato);
			catalogo.add(approvato);
			System.out.println("Richiesta approvata ");
		} else {
			System.out.println("Nome gioco non esistente nelle richieste ");
		}
		
	}
	
	
	// getters and setters 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
