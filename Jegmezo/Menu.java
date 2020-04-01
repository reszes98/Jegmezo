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
			Jegtabla jt = new Jegtabla(jm, false, 1, 2,null, null);
			List<Targy> targyak=new ArrayList<Targy>();
			Sarkkutato j=new Sarkkutato(jm,0,5,5,targyak,Irany.Jobb);
			Eszkimo eszk= new Eszkimo(jm,0,5,5,targyak,Irany.Jobb);
			jt.addJatekos(j);
			jt.addJatekos(eszk);
			
			//jégtábla szomszédai, hogy ne nullra hívjuk a függvényeket
			Jegtabla jtj = new Jegtabla(jm, false, 1, 2,null, null);
			Jegtabla jtb = new Jegtabla(jm, false, 1, 2,null, null);
			Jegtabla jtf = new Jegtabla(jm, false, 1, 2,null, null);
			Jegtabla jtl = new Jegtabla(jm, false, 1, 2,null, null);
			
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
			System.out.println("\n\n");
			System.out.println("Mit szeretne? (nyomja meg a megfelelõ menüpontot)\n "
					+ "1 - Ásás\n 2 - Ásó felvesz\n 3 - Ásó használ\n "
					+ "4 - Búvárruha felvesz\n 5 - Búvárruha használ\n "
					+ "6 - Élelem felvesz\n 7 - Élelem használ/testhõ növelése\n"
					+ "8 - Hóvihar\n 9 - Iglu építés\n 10 - Jelzõpisztoly felvesz\n "
					+ "11 - Jelzõpisztoly használ\n 12 - Kötél felvesz\n "
					+ "13 - Kötél használ\n 14 - Lépés\n 15 - Szomszédos Jégtábla vizsgálata\n"
					+ "16 - Targyakat hasznal \n"
					+ " 66 - Kilép ");
			
			System.out.print("Valasztas: ");
			answer =  in.nextInt();
			System.out.println("\n\n");
			
			switch(answer) {
				case 1:
					Asas();
			    	break;
				case 2:
					AsotFelvesz();
			    	break;
				case 3:
					AsotHasznal();
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
					Jegtabla jt2 = new Jegtabla(jm2, false, 1, 2,null, null);
					Jegtabla jt3 = new Jegtabla(jm2, false, 1, 2,null, null);
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
					pisztolyepit();
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
				case 66:
					System.out.println("Kilépett");
					break;
				default:
					System.out.println("Válasszon a megadott menüpontok közül");
			}
		}while(answer != 66);
	}
		
		public static void Asas()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, 1, 55, null, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			j.addJatekos(sk);
			
			Eszkimo e = new Eszkimo(jm, 55,55,55, null, Irany.Bal);
			j.addJatekos(e);
			
			int kezdetiHomenny = j.getHo();
			
			System.out.println("Kezdetben a jegtablan a " + kezdetiHomenny + " db ho van");
			
			System.out.println("Eloszor a sarkutato as");
			sk.asas();
			System.out.println("Most a jegtablan " + j.getHo() + " db ho van");
			
			System.out.println("Most az az eszkimo as");
			e.asas();
			System.out.println("Most a jegtablan " + j.getHo() + " db ho van");
			
			System.out.println("Most az az eszkimo as megint");
			e.asas();
			System.out.println("Most a jegtablan " + j.getHo() + " db ho van");
		}
		
		public static void AsotFelvesz()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			j.addJatekos(sk);
			Aso a = new Aso();
			j.setTargy(a);
			
			sk.TargyakListazasa();
			System.out.println("Most a jatekos megprobalja felvenni az asot a tablarol");
			sk.targyFelvetel();
			sk.TargyakListazasa();
		}
		
		public static void AsotHasznal()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, 2, 55, null, null);
			Jegtabla j1 = new Jegtabla(jm, false, 2, 55, null, null);
			
			j.setSzomszed(j1, Irany.Jobb);
			j1.setSzomszed(j, Irany.Bal);
			
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Jobb);
			j.addJatekos(sk);
			Aso a = new Aso();
			sk.targyHozzadasa(a);
			
			int kezdetiHomenny = j1.getHo();
			
			System.out.println("Kezdetben a jegtablan a " + kezdetiHomenny + " db ho van");
			
			System.out.println("Most a jatekos megprobalja hasznalni az asot");
			sk.targyHasznalat(0);
			System.out.println("Most " + j1.getHo() + " db ho van a jegtablan");
			
			System.out.println("Most a jatekos megprobalja hasznalni megint az asot");
			sk.targyHasznalat(0);
			System.out.println("Most " + j1.getHo() + "db ho van a jegtablan");
		}
		
		public static void BuvarruhaFelvesz()
		{
			
		}
		
		public static void BuvarruhaHasznal()
		{
			
		}
		
		public static void ElelemFelvesz()
		{
			
		}
		
		public static void ElelemHasznal()
		{
			
		}
		
		public static void KotelFelvesz()
		{
			
		}
		
		public static void KotelHasznal()
		{
			
		}
		
		public static void SatorFelvesz()
		{
			
		}
		
		public static void SatorHasznal()
		{
			
		}
		
		public static void SatorHovihar()
		{
			
		}
		
		public static void SatorFrissit()
		{
			
		}
		
		public static void IgluHovihar()
		{
			
		}
		
		public static void IgluFrissit()
		{
			
		}
		
		public static void JelzopisztolyFelvesz()
		{
			
		}
		
		public static void JelzopisztolyHasznal()
		{
			
		}
		
		public static void TorkenyAsoFelvesz()
		{
			
		}
		
		public static void TorekenyAsoHasznal()
		{
			
		}
		
		
		public static void targyHasznal()
		{
			List<Targy> targyak = new ArrayList<>();
			Jegmezo jm=new Jegmezo(4);
			Jegtabla jt = new Jegtabla(jm, false, 1, 0,null, null);
			Jegtabla jt0 = new Jegtabla(jm, false, 1, 0,null, null);
			Jegtabla jt1 = new Jegtabla(jm, false, 1, 2,null, null);
			Jegtabla jt2 = new Jegtabla(jm, false, 1, 2,null, null);
			Jegtabla jt3 = new Jegtabla(jm, false, 1, 2,null, null);
			
			jt.setSzomszed(jt0, Irany.Jobb);
			jt.setSzomszed(jt1, Irany.Bal);
			jt.setSzomszed(jt2, Irany.Fel);
			jt.setSzomszed(jt3, Irany.Le);
			
			Aso a=new Aso();
			Kotel k = new Kotel();
			Buvarruha b = new Buvarruha();
			//Jelzopisztoly jp = new Jelzopisztoly();
			Elelem e = new Elelem(1);
			
			targyak.add(a);
			targyak.add(k);
			targyak.add(b);
			//targyak.add(jp);
			targyak.add(e);
			
			
			Sarkkutato j = new Sarkkutato(jm,0,5,5,targyak,Irany.Jobb);
			jt.addJatekos(j); // berakjuk a vízbe, hogy kipróbálhassa a búvárruhát 
			
			Eszkimo eszk = new Eszkimo(jm,0,5,5,null,Irany.Jobb);
			jt0.addJatekos(eszk); // egy játékost belerakunk a vízbe, hogy ki tudja menteni a másik játékos
			
			for(int i = 0; i < targyak.size(); i++)
				j.targyHasznalat(i);
			
		}
		public void pisztolyepit() {
			Jegmezo jm=new Jegmezo(4);
			Jegtabla jt = new Jegtabla(jm, false, 1, 2,null, null);
			List<Targy> targyak=new ArrayList<Targy>();
			Sarkkutato j=new Sarkkutato(jm,0,5,5,targyak,Irany.Jobb);
			jt.addJatekos(j);
			Jelzopisztoly jp=new Jelzopisztoly();
			jp.felvesz(j);
			jp.felvesz(j);
			jp.felvesz(j);
			j.targyHasznalat(0);
		}
		
}
