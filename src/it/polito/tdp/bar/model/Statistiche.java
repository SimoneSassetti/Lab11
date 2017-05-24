package it.polito.tdp.bar.model;

public class Statistiche {
	
	private int numTotClienti;
	private int numClientiSod;
	private int numClientiInsod;
	
	public Statistiche(int numTotClienti, int numClientiSod, int numClientiInsod) {
		super();
		this.numTotClienti = numTotClienti;
		this.numClientiSod = numClientiSod;
		this.numClientiInsod = numClientiInsod;
	}
	
	public int getNumTotClienti() {
		return numTotClienti;
	}
	public void setNumTotClienti(int numTotClienti) {
		this.numTotClienti = numTotClienti;
	}
	public int getNumClientiSod() {
		return numClientiSod;
	}
	public void setNumClientiSod(int numClientiSod) {
		this.numClientiSod = numClientiSod;
	}
	public int getNumClientiInsod() {
		return numClientiInsod;
	}
	public void setNumClientiInsod(int numClientiInsod) {
		this.numClientiInsod = numClientiInsod;
	}
	
	
}
