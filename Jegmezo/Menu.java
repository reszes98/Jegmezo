package Jegmezo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Menu {
	
	private int answer = 0;
	private Scanner in = new Scanner(System.in);
	
	
		public void main () {	
			//példányok:
			Jegmezo jm=new Jegmezo();
			Jegtabla jt=new Jegtabla();
			List<Targy> targyak=new ArrayList<Targy>();
			Sarkkutato j=new Sarkkutato(jm,jt,0,5,5,targyak,Irany.Jobb);
			Aso a=new Aso();
			Kotel k = new Kotel();
			Buvarruha b = new Buvarruha();
			Elelem e = new Elelem();
			Jelzopisztoly jp = new Jelzopisztoly();
			
			
		System.out.print("Mit szeretne? (nyomja meg a megfelelõ menüpontot)\n "
				+ "1 - Ásás\n 2 - Ásó felvesz\n 3 - Ásó használ\n "
				+ "4 - Búvárruha felvesz\n 5 - Búvárruha használ\n "
				+ "6 - Élelem felvesz\n 7 - Élelem használ/testhõ növelése\n"
				+ "8 - Hóvihar\n 9 - Iglu építés\n 10 - Jelzõpisztoly felvesz\n "
				+ "11 - Jelzõpisztoly használ\n 12 - Kötél felvesz\n "
				+ "13 - Kötél használ\n 14 - Lépés\n 15 - Szomszédos Jégtábla "
				+ "vizsgálata\n 66 - Kilép");
		
		do {
			answer =  in.nextInt();
			
			switch(answer) {
				case 1:
					j.asas();
			    	break;
				case 2:
					a.felvesz(j);
			    	break;
				case 3:
					a.hasznal(j);
			    	break;
				case 4:
					b.felvesz(j);
			    	break;
				case 5:
					b.hasznal(j);
					break;
				case 6:
					e.felvesz(j);
			    	break;
				case 7:
					e.hasznal(j);
					break;
				case 8:
					
			    	break;	
				case 10:
					jp.felvesz(j);
			    	break;
			    	
				case 12:
					k.felvesz(j);
			    	break;
				case 13:
					k.hasznal(j);
			    	break;
				case 15:
					j.kepesseg(jt);
				default:
					System.out.println("Válasszon a megadott menüpontok közül");
			}
		}while(answer != 66);
	}
}
