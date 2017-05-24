package it.polito.tdp.bar;

import java.util.*;

public class TestSimulatore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Tavolo> tavoli = new ArrayList<>();
		
		Tavolo t1 = new Tavolo(10) ;
		Tavolo t2 = new Tavolo(10) ;
		Tavolo t3 = new Tavolo(8) ;
		Tavolo t4 = new Tavolo(8) ;
		Tavolo t5= new Tavolo(8) ;
		Tavolo t6 = new Tavolo(8) ;
		Tavolo t7= new Tavolo(6) ;
		Tavolo t8 = new Tavolo(6) ;
		Tavolo t9 = new Tavolo(6) ;
		Tavolo t10 = new Tavolo(6) ;
		Tavolo t11 = new Tavolo(4) ;	
		Tavolo t12 = new Tavolo(4) ;
		Tavolo t13 = new Tavolo(4) ;
		Tavolo t14 = new Tavolo(4) ;	
		Tavolo t15 = new Tavolo(4) ;	
		
		tavoli.add(t1);
		tavoli.add(t2);
		tavoli.add(t3);
		tavoli.add(t4);
		tavoli.add(t5);
		tavoli.add(t6);
		tavoli.add(t7);
		tavoli.add(t8);
		tavoli.add(t9);
		tavoli.add(t10);
		tavoli.add(t11);
		tavoli.add(t12);
		tavoli.add(t13);
		tavoli.add(t14);
		tavoli.add(t15);
		
		Simulator s = new Simulator(tavoli);
		
		
		for(int i =0 ; i<2000 ; i++){
			Random r1 = new Random();
			Random r2 = new Random();
			
			
			Gruppo g = new Gruppo((int)(1+r1.nextFloat()*10), i);
			
			s.addGruppo(g, (int)r2.nextFloat()*10);
			
		}
		
		
		s.run();
	}

}
