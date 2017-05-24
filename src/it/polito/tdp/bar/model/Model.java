package it.polito.tdp.bar.model;

public class Model {
	
	public Statistiche generaSimulatore(){
		Simulator sim=new Simulator();
		
		sim.setGruppi();
		sim.run();
		
		Statistiche stat=new Statistiche(sim.getNumTotClienti(),sim.getNumClientiSod(),sim.getNumClientiInsod());
		
		return stat;	
	}
}
