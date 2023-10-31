package Principale;

//Scopo = scrivere uno scheletro del codice che sia leggibile e implementabile anche da altri
public class VideogiocoStrategia extends Videogioco {
	
		
		public VideogiocoStrategia(String nome, String genere) {
			super(nome, genere);
		}
		
		//deve stampare quele tipo di azione sta venendo fatta (Strategia in corso..)
		public void combatti() {
			System.out.println("Calcolo strategia in corso [45%].....");
		}
}
