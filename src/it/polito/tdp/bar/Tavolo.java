package it.polito.tdp.bar;

public class Tavolo implements Comparable<Tavolo>{

	public enum TavoloStatus{TAVOLO_OCCUPATO, TAVOlO_LIBERO};
	
	private int numeroposti ;
	private TavoloStatus status ;
	private Gruppo gruppo ;

	public Tavolo(int numeroposti) {
		super();
		this.numeroposti = numeroposti;
		this.setStatus(TavoloStatus.TAVOlO_LIBERO);
		this.gruppo=null;
	}

	public int getNumeroposti() {
		return numeroposti;
	}

	public void setNumeroposti(int numeroposti) {
		this.numeroposti = numeroposti;
	}

	public TavoloStatus getStatus() {
		return status;
	}

	public void setStatus(TavoloStatus status) {
		this.status = status;
	}

	@Override
	public int compareTo(Tavolo o) {
		// TODO Auto-generated method stub
		return this.numeroposti-o.getNumeroposti();
	}

	public Gruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}
	
	
	
}
