package it.polito.tdp.bar;

import java.util.*;

import it.polito.tdp.bar.Event.EventType;
import it.polito.tdp.bar.Tavolo.TavoloStatus;

public class Simulator {

	private List<Tavolo>tavoli = new ArrayList <>(); //numero tavoli
	
	private int clientiTot = 0 ;
	private int clientiSoddisfatti = 0 ;
	private int time ;
	private PriorityQueue<Event> queue ;

	
	public Simulator(List<Tavolo> tavoli) {
		super();
		this.tavoli = tavoli;
		this.queue = new PriorityQueue<>() ;
	}

	public void addGruppo(Gruppo g, int t){
		time+=t;
		
		Event e = new Event(time, g, Event.EventType.IN_GRUPPO);
		clientiTot+=g.getNumeroclienti() ;
		queue.add(e);
		System.out.println("Nuovo gruppo"+g.getCount()+" da "+g.getNumeroclienti()+" persone\n");
	}
	
	public void run(){
		while(!queue.isEmpty()){
			Event e = queue.poll() ;
			
			switch(e.getType()){
			case IN_GRUPPO:
				this.inGruppo(e);
				break;
			case OUT_GRUPPO:
				this.outGruppo(e);
				break;
				
			}
		}
		
		System.out.println("Clienti totali: "+clientiTot);
		System.out.println("Clienti soddisfatti: "+clientiSoddisfatti);
		int num = clientiTot - clientiSoddisfatti ;
		System.out.println("Clienti insoddisfatti: "+num);
	}
	
	public void inGruppo(Event e){
		//ci sono tavoli liberi?
		Tavolo tavolo = null;
		Gruppo g = e.getGruppo() ;
		for(Tavolo t : tavoli){
			if(t.getStatus()==TavoloStatus.TAVOlO_LIBERO){
				if(g.getNumeroclienti()>=(t.getNumeroposti()/2) && g.getNumeroclienti()<=t.getNumeroposti()){
					tavolo = t ;
					
					t.setStatus(TavoloStatus.TAVOLO_OCCUPATO);
					this.surgeSatisfiedClient(g);
					Event ev = new Event(e.getTime()+g.getDurata(), g, EventType.OUT_GRUPPO);
					queue.add(ev);
				}
			}
		}
		if(tavolo!=null){
			System.out.println("Aggiunto gruppo "+g.getCount()+" al tavolo");
		}
		
		if(tavolo== null){
			//non ci sono tavoli disponibili
			if(this.valutaTolleranza(g) ){
				this.surgeSatisfiedClient(g);
				Event ev = new Event(e.getTime()+g.getDurata(), g, EventType.OUT_GRUPPO);
				queue.add(ev);
				System.out.println("Aggiunto gruppo "+g.getCount()+" al bancone");
			}
			else{
				Event ev = new Event(e.getTime(), g, EventType.OUT_GRUPPO);
				queue.add(ev);
				System.out.println("Il gruppo "+g.getCount()+" ha rifiutato il bancone");
			}
		}
	}
	
	private boolean valutaTolleranza(Gruppo g) {
		// TODO Auto-generated method stub
		float casuale = (float)Math.random() ;
		if(casuale<=g.getTolleranza()){
			return true;
		}
		else{
			return false;
		}
	}

	public void outGruppo(Event e){
		Gruppo g = e.getGruppo();
		for(Tavolo t : tavoli){
			if(t.getStatus()==TavoloStatus.TAVOLO_OCCUPATO){
				if(t.getGruppo()!=null){
					if(t.getGruppo().equals(g)){
						t.setStatus(TavoloStatus.TAVOlO_LIBERO);
						t.setGruppo(null);
					}
				}
			}
		}
		System.out.println("Il gruppo"+g.getCount()+" ha lasciato il tavolo");
	}
	
	public void surgeSatisfiedClient(Gruppo g){
		clientiSoddisfatti+=g.getNumeroclienti();
	}
}
