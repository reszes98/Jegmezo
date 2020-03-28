package Jegmezo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Menu {
	
	private int answer = 0;
	private Scanner in = new Scanner(System.in);
	
	
		public void main () {	
			//példányok:
			Jegmezo jm=new Jegmezo(4);
			Jegtabla jt = new Jegtabla(jm, false, 1, 2,false, a);
			List<Targy> targyak=new ArrayList<Targy>();
			Sarkkutato j=new Sarkkutato(jm,jt,0,5,5,targyak,Irany.Jobb);
			Aso a=new Aso();
			Kotel k = new Kotel();
			Buvarruha b = new Buvarruha();
			Elelem e = new Elelem();
			Jelzopisztoly jp = new Jelzopisztoly();
			
			
		System.out.print("Mit szeretne? (nyomja meg a megfelelõ menüpontot)\n 1 - Ásás\n 2 - Ásó felvesz\n 3 - Ásó használ");
		
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
					
			    	break;
				case 4:
					b.felvesz(j);
			    	break;
			    	
				case 6:
					e.felvesz(j);
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
				default:
					System.out.println("Válasszon a megadott menüpontok közül");
			}
		}while(answer != 66);
	}
}
