package Principale;

import java.util.ArrayList;
import java.util.Scanner;

//Scopo = scrivere uno scheletro del codice che sia leggibile e implementabile anche da altri
public class Utente {
	
	private String username;
	private String password;
	private Videogioco currentGioco;
	
	public Utente(String username, String password) {
		this.username = username;
		this.password = password;
		this.currentGioco = null;
	}
	
		
	// sceglie il gioco a cui giocare
	public void scegliGioco(ArrayList<Videogioco> catalogoGiochi) {
		Scanner S = new Scanner(System.in);
		String titolo = "";
		System.out.println("Inserisci nome del videogioco: ");
		titolo = S.next();
		
		for (Videogioco v : catalogoGiochi) {
			if (v.getNome().equals(titolo)) {
				this.currentGioco = v;
			}
		}
		
		if (this.currentGioco != null) {
			this.currentGioco.gioca();
		} else {
			System.out.println("Nome gioco non esistente nel catalogo ");
		}
		
	}
	
	// aggiunge una richiesta
	public void aggiungiRichiesta(ArrayList<Videogioco> richieste) {
		Scanner S = new Scanner(System.in);
		String titolo = "";
		String genere = "";
		
		System.out.println("--- Aggiungi Richiesta ------");
		System.out.println("Inserisci nome del videogioco: ");
		titolo = S.next();
		
		System.out.println("Inserisci genere del videogioco: ");
		genere = S.next();
		
		richieste.add(new Videogioco(titolo,genere));
		
		
	}
	
	
	@Override
	public String toString() {
		return "Utente [username=" + username + ", password=" + password + ", currentGioco=" + currentGioco + "]";
	}


	// setter e getter
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
