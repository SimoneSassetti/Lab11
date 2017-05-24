package it.polito.tdp.bar.model;

public class Event implements Comparable<Event>{
	
	public enum Type{IN,OUT};
	
	private Gruppo gruppo;
	private Type tipo;
	private int time;
	public Event(Gruppo gruppo, Type tipo, int time) {
		super();
		this.gruppo = gruppo;
		this.tipo = tipo;
		this.time = time;
	}
	
	@Override
	public int compareTo(Event o) {
		return this.time-o.time;
	}
	
	public Gruppo getGruppo() {
		return gruppo;
	}
	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}
	public Type getTipo() {
		return tipo;
	}
	public void setTipo(Type tipo) {
		this.tipo = tipo;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return gruppo+" "+ tipo +" "+time;
	}
	
	
	
}
