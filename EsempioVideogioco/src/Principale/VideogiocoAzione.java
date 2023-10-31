package Principale;

//Scopo = scrivere uno scheletro del codice che sia leggibile e implementabile anche da altri
public class VideogiocoAzione extends Videogioco {
	
	public VideogiocoAzione(String nome, String genere) {
		super(nome, genere);
	}
	
	//deve stampare quele tipo di azione sta venendo fatta (Combattimento in corso..)
	public void combatti() {
		System.out.println("Combattimento in corso [70%].....");
	}
	
	
}
