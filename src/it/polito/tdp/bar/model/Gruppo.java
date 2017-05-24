package it.polito.tdp.bar.model;

public class Gruppo implements Comparable<Gruppo>{
	
	private String name;
	private int queueTime;
	private int numPersone;
	private Tavolo tavolo;
	private int durata;//in minuti
	private float tolleranza;

	public Gruppo(String name, int queueTime, int numPersone, int durata, float tolleranza) {
		super();
		this.name = name;
		this.queueTime = queueTime;
		this.numPersone = numPersone;
		this.durata = durata;
		this.tolleranza = tolleranza;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQueueTime() {
		return queueTime;
	}
	public void setQueueTime(int queueTime) {
		this.queueTime = queueTime;
	}
	public int getNumPersone() {
		return numPersone;
	}
	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}
	public Tavolo getTavolo() {
		return tavolo;
	}
	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public float getTolleranza() {
		return tolleranza;
	}
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	@Override
	public int compareTo(Gruppo g) {
		return this.queueTime-g.queueTime;
	}

	@Override
	public String toString() {
		return name+" "+queueTime+" "+numPersone+" "+tavolo+" "+durata+" "+tolleranza+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gruppo other = (Gruppo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
}
