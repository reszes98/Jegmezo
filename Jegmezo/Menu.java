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
			Kotel k = new Kotel();
			Buvarruha b = new Buvarruha();
			Elelem e = new Elelem();
			Jelzopisztoly jp = new Jelzopisztoly();
			
			
		System.out.print("Mit szeretne? (nyomja meg a megfelel� men�pontot)\n "
				+ "1 - �s�s\n 2 - �s� felvesz\n 3 - �s� haszn�l\n "
				+ "4 - B�v�rruha felvesz\n 5 - B�v�rruha haszn�l\n "
				+ "6 - �lelem felvesz\n 7 - �lelem haszn�l/testh� n�vel�se\n"
				+ "8 - H�vihar\n 9 - Iglu �p�t�s\n 10 - Jelz�pisztoly felvesz\n "
				+ "11 - Jelz�pisztoly haszn�l\n 12 - K�t�l felvesz\n "
				+ "13 - K�t�l haszn�l\n 14 - L�p�s\n 15 - Szomsz�dos J�gt�bla "
				+ "vizsg�lata\n 66 - Kil�p");
		
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
					System.out.println("V�lasszon a megadott men�pontok k�z�l");
			}
		}while(answer != 66);
	}
}
