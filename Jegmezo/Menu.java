package Jegmezo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Menu {
	
	private int answer = 0;
	private Scanner in = new Scanner(System.in);
	
	
		public void main() {	
			//példányok:
			Jegmezo jm=new Jegmezo(4);
			Jegtabla jt = new Jegtabla(jm, false, 1, 2,false, null);
			List<Targy> targyak=new ArrayList<Targy>();
			Sarkkutato j=new Sarkkutato(jm,0,5,5,targyak,Irany.Jobb);
			Eszkimo eszk= new Eszkimo(jm,0,5,5,targyak,Irany.Jobb);
			jt.addJatekos(j);
			jt.addJatekos(eszk);
			eszk.setaktjegtabla(jt);
			
			//jégtábla szomszédai, hogy ne nullra hívjuk a függvényeket
			Jegtabla jtj = new Jegtabla(jm, false, 1, 2,false, null);
			Jegtabla jtb = new Jegtabla(jm, false, 1, 2,false, null);
			Jegtabla jtf = new Jegtabla(jm, false, 1, 2,false, null);
			Jegtabla jtl = new Jegtabla(jm, false, 1, 2,false, null);
			
			jt.setSzomszed(jtj, Irany.Jobb);
			jt.setSzomszed(jtb, Irany.Bal);
			jt.setSzomszed(jtf, Irany.Fel);
			jt.setSzomszed(jtl, Irany.Le);
			
			Aso a=new Aso();
			Kotel k = new Kotel();
			Buvarruha b = new Buvarruha();
			Elelem e = new Elelem(3);
			Jelzopisztoly jp = new Jelzopisztoly();
			
			
		
		
		
		
		do {
			System.out.println("Mit szeretne? (nyomja meg a megfelelõ menüpontot)\n "
					+ "1 - Ásás\n 2 - Ásó felvesz\n 3 - Ásó használ\n "
					+ "4 - Búvárruha felvesz\n 5 - Búvárruha használ\n "
					+ "6 - Élelem felvesz\n 7 - Élelem használ/testhõ növelése\n"
					+ "8 - Hóvihar\n 9 - Iglu építés\n 10 - Jelzõpisztoly felvesz\n "
					+ "11 - Jelzõpisztoly használ\n 12 - Kötél felvesz\n "
					+ "13 - Kötél használ\n 14 - Lépés\n 15 - Szomszédos Jégtábla\n"
					+ "16 - Targyakat hasznal \n"
					+ "vizsgálata\n 66 - Kilép ");
			
			System.out.print("Valasztas: ");
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
					Jegmezo jm2 = new Jegmezo(1);
					Jegtabla jt2 = new Jegtabla(jm2, false, 1, 2,false, null);
					Jegtabla jt3 = new Jegtabla(jm2, false, 1, 2,false, null);
					Sarkkutato j2 = new Sarkkutato(jm2,0,5,5,targyak,Irany.Jobb);
					j2.setaktjegtabla(jt2);

					jm2.leptet();
			    	break;	
				case 9:
					eszk.kepesseg(jt);
					break;
				case 10:
					jp.felvesz(j);
			    	break;
				case 11:
					jp.hasznal(j);
					break;
				case 12:
					k.felvesz(j);
			    	break;
				case 13:
					k.hasznal(j);
			    	break;
				case 14:
					eszk.lepes();
					break;
				case 15:
					j.kepesseg(jt);
					break;
				case 16:
					targyHasznal();
					break;
				default:
					System.out.println("Válasszon a megadott menüpontok közül");
			}
		}while(answer != 66);
	}
		
		public static void targyHasznal()
		{
			List<Targy> targyak = new ArrayList<>();
			Jegmezo jm=new Jegmezo(4);
			Jegtabla jt = new Jegtabla(jm, false, 1, 0,false, null);
			Jegtabla jt0 = new Jegtabla(jm, false, 1, 0,false, null);
			Jegtabla jt1 = new Jegtabla(jm, false, 1, 2,false, null);
			Jegtabla jt2 = new Jegtabla(jm, false, 1, 2,false, null);
			Jegtabla jt3 = new Jegtabla(jm, false, 1, 2,false, null);
			
			jt.setSzomszed(jt0, Irany.Jobb);
			jt.setSzomszed(jt1, Irany.Bal);
			jt.setSzomszed(jt2, Irany.Fel);
			jt.setSzomszed(jt3, Irany.Le);
			
			Aso a=new Aso();
			Kotel k = new Kotel();
			Buvarruha b = new Buvarruha();
			Jelzopisztoly jp = new Jelzopisztoly();
			Elelem e = new Elelem(1);
			
			targyak.add(a);
			targyak.add(k);
			targyak.add(b);
			targyak.add(jp);
			targyak.add(e);
			
			
			Sarkkutato j = new Sarkkutato(jm,0,5,5,targyak,Irany.Jobb);
			jt.addJatekos(j); // berakjuk a vízbe, hogy kipróbálhassa a búvárruhát 
			
			Eszkimo eszk = new Eszkimo(jm,0,5,5,null,Irany.Jobb);
			jt0.addJatekos(eszk); // egy játékost belerakunk a vízbe, hogy ki tudja menteni a másik játékos
			
			for(int i = 0; i < targyak.size(); i++)
				j.targyHasznalat(i);
			
		}
}
