package it.polito.tdp.bar;

import java.util.Random;

public class Gruppo {
	
	private int numeroclienti;
	private float tolleranza ;
	private int durata;
	private int count =0;
	
	public Gruppo(int numeroclienti, int cont) {
		super();
		this.numeroclienti = numeroclienti;
		this.tolleranza = (float)Math.random() ;
		
		if(tolleranza>0.9){
			tolleranza = (float)0.9;
		}
		
		Random r = new Random();
		this.durata = (int)(60+r.nextFloat()*60) ;
		this.count=cont;
	}

	public int getNumeroclienti() {
		return numeroclienti;
	}

	public void setNumeroclienti(int numeroclienti) {
		this.numeroclienti = numeroclienti;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
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
		if (count != other.count)
			return false;
		return true;
	}

	

	
	
}
