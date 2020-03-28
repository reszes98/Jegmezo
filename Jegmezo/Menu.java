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
			
			
		System.out.print("Mit szeretne? (nyomja meg a megfelelõ menüpontot)\n 1 - Ásás\n 2 - Ásó felvesz\n 3 - Ásó használ");
		answer =  in.nextInt();
		
		switch(answer) {
			case 1:
				j.asas();
		    	break;
			case 2:
				
		    	break;
			case 3:
				
		    	break;
			default:
				System.out.println("Válasszon a megadott menüpontok közül");
		}
	}
}
