package Jegmezo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Menu {
	
	private int answer = 0;
	private Scanner in = new Scanner(System.in);
	
	
		public void main () {	
			//p�ld�nyok:
			Jegmezo jm=new Jegmezo();
			Jegtabla jt=new Jegtabla();
			List<Targy> targyak=new ArrayList<Targy>();
			Sarkkutato j=new Sarkkutato(jm,jt,0,5,5,targyak,Irany.Jobb);
			Aso a=new Aso();
			
			
		System.out.print("Mit szeretne? (nyomja meg a megfelel� men�pontot)\n 1 - �s�s\n 2 - �s� felvesz\n 3 - �s� haszn�l");
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
				System.out.println("V�lasszon a megadott men�pontok k�z�l");
		}
	}
}
