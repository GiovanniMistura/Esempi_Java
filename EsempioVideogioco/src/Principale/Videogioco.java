package Principale;

//Scopo = scrivere uno scheletro del codice che sia leggibile e implementabile anche da altri
public class Videogioco {
	
	private String nome;
	private String genere;
	
	public Videogioco(String nome, String genere) {
		this.nome = nome;
		this.genere = genere;
	}
	
	// questo metodo deve stampare il nome del gioco a cui si sta giocando
	public void gioca() {
		System.out.println("Stai giocando a " + this.nome);
	}

	
	@Override
	public String toString() {
		return "Videogioco [nome=" + nome + ", genere=" + genere + "]";
	}

	// getters and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
}
