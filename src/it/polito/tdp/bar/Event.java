package it.polito.tdp.bar;

public class Event implements Comparable<Event>{

	public enum EventType {IN_GRUPPO, OUT_GRUPPO} ;

	private int time ;
	private Gruppo gruppo ;
	
	private EventType type ;

	public Event(int time, Gruppo gruppo, EventType type) {
		super();
		this.time = time;
		this.gruppo = gruppo;
		this.type = type;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Gruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public int compareTo(Event arg0) {
		// TODO Auto-generated method stub
		return this.time - arg0.getTime();
	}

	
}
