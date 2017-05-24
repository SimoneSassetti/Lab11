package it.polito.tdp.bar.model;

import java.util.*;
import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Event.Type;

public class Model {
	private PriorityQueue<Gruppo> gruppi;
	private PriorityQueue<Event> listaEventi;
	private List<Tavolo> listaTavoli;
	
	private int numTotClienti=0;
	private int numClientiSod=0;
	private int numClientiInsod=0;
	
	
	
	
	public Model() {
		gruppi=new PriorityQueue<>();
		listaEventi=new PriorityQueue<>();
		listaTavoli=new ArrayList<Tavolo>();
		this.setTavoli();
	}
	
	public void setGruppi(){
		int temp=0;
		int numPersone=0;
		int durata=0;
		float toll=0;
		for(int i=0; i<2000;i++){
			temp=temp+(int)(1+Math.random()*10);
			numPersone=(int)(1+Math.random()*10);
			durata=(int)(60+(Math.random()*60));
			toll=(float) Math.random();
			if(toll>0.9){
				toll=(float) 0.9;
			}
			Gruppo g=new Gruppo("Gruppo_"+String.valueOf(i),temp,numPersone,durata,toll);
			gruppi.add(g);
			Event e=new Event(g,Type.IN,temp);
			listaEventi.add(e);
		}
		//System.out.println(gruppi);
	}
	
	private void setTavoli(){
		listaTavoli.add(new Tavolo("A_10",10));
		listaTavoli.add(new Tavolo("B_10",10));
		listaTavoli.add(new Tavolo("A_8",8));
		listaTavoli.add(new Tavolo("B_8",8));
		listaTavoli.add(new Tavolo("C_8",8));
		listaTavoli.add(new Tavolo("D_8",8));
		listaTavoli.add(new Tavolo("A_6",6));
		listaTavoli.add(new Tavolo("B_6",6));
		listaTavoli.add(new Tavolo("C_6",6));
		listaTavoli.add(new Tavolo("D_6",6));
		listaTavoli.add(new Tavolo("A_4",4));
		listaTavoli.add(new Tavolo("B_4",4));
		listaTavoli.add(new Tavolo("C_4",4));
		listaTavoli.add(new Tavolo("D_4",4));
		listaTavoli.add(new Tavolo("E_4",4));
		
		class Comparatore implements Comparator<Tavolo>{
			@Override
			public int compare(Tavolo t1, Tavolo t2) {
				return t1.getNumPosti()-t2.getNumPosti();
			}
		}
		//ORIDNO LA LISTA IN MODO DA APPENA TROVO UN TAVOLO DISPONIBILE QUESTO è ANCHE IL MIGLIORE
		Collections.sort(listaTavoli, new Comparatore());
	}
	
	
	public void run(){
		while(!listaEventi.isEmpty()){
			Event e=listaEventi.poll();
			
			
			switch(e.getTipo()){
			
			case IN:
				//gestisco il caso in cui il gruppo è appena arrivato
				this.setIN(e);
				break;
			case OUT:
				//gestisco i gruppi in uscita: libero un tavolo e posso far entrare nuovi clienti
				this.setOUT(e);
				break;
			}
			//System.out.println(e);
		}
	}
	
	private void setOUT(Event e){
		e.getGruppo().getTavolo().setLibero(true);
	}
	
	
	private void setIN(Event e){
		boolean trovato=false;
		for(Tavolo t: listaTavoli){
			if(!trovato && t.isLibero() && 50*t.getNumPosti()/100<=e.getGruppo().getNumPersone() && t.getNumPosti()<=e.getGruppo().getNumPersone()){
				t.setLibero(false);
				e.getGruppo().setTavolo(t);
				numTotClienti=numTotClienti+e.getGruppo().getNumPersone();
				numClientiSod=numClientiSod+e.getGruppo().getNumPersone();
				Event uscita=new Event(e.getGruppo(),Type.OUT,e.getTime()+e.getGruppo().getDurata());
				listaEventi.add(uscita);
				trovato=true;
			}	
		}
		if(trovato==false){
			if(disponibilitaAndareBancone(e.getGruppo().getTolleranza())){
				numTotClienti=numTotClienti+e.getGruppo().getNumPersone();
				numClientiSod=numClientiSod+e.getGruppo().getNumPersone();
			}
			else{
				numTotClienti=numTotClienti+e.getGruppo().getNumPersone();
				numClientiInsod=numClientiInsod+e.getGruppo().getNumPersone();
			}
		}
	}

	private boolean disponibilitaAndareBancone(float toll) {
		float prob=(float) Math.random();
		if(prob>toll){
			return true;
		}
		return false;
	}

	public int getNumTotClienti() {
		return numTotClienti;
	}

	public int getNumClientiSod() {
		return numClientiSod;
	}

	public int getNumClientiInsod() {
		return numClientiInsod;
	}
	
	
}
