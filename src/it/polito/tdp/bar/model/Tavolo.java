package it.polito.tdp.bar.model;

public class Tavolo {
	
	private String name;
	private int numPosti;
	private boolean libero;
	
	public Tavolo(String name, int numPosti) {
		super();
		this.name = name;
		this.numPosti = numPosti;
		this.libero = true;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumPosti() {
		return numPosti;
	}
	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}
	public boolean isLibero() {
		return libero;
	}
	public void setLibero(boolean libero) {
		this.libero = libero;
	}

	@Override
	public String toString() {
		return name+ " " + numPosti+ " " + libero;
	}
}
