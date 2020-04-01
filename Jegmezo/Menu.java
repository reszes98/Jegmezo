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
					+ "17 - Eszkimo kepesseget hasznal \n"
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
					BuvarruhaFelvesz();
			    	break;
				case 5:
					BuvarruhaHasznal();
					break;
				case 6:
					ElelemFelvesz();
			    	break;
				case 7:
					ElelemHasznal();
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
				case 17:
					EszkimoKepesseg();
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
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			j.addJatekos(sk);
			Buvarruha a = new Buvarruha();
			j.setTargy(a);
			
			sk.TargyakListazasa();
			System.out.println("Most a jatekos megprobalja felvenni a buvarruhat a tablarol");
			sk.targyFelvetel();
			sk.TargyakListazasa();
		}
		
		public static void BuvarruhaHasznal()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, true, -1, 0, null, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Jobb);
			Jegtabla j1 = new Jegtabla(jm, false, 2, 55, null, null);
			
			j.setSzomszed(j1, Irany.Jobb);
			j1.setSzomszed(j, Irany.Bal);
			
			j.addJatekos(sk);
			Buvarruha a = new Buvarruha();
			sk.targyHozzadasa(a);

			System.out.println("Most a balodali tabla fel van fordulva es van rajta: " 
			+ j.jatekosokLekerdez().size() 
			+ "db jatekos, mig a jobboldali nincs atfordulva  es van rajta: " 
			+ j1.jatekosokLekerdez().size() + "db jatekos");
			
			System.out.println("Most a jatekos hasznalni fogja a buvarruhat");
			sk.targyHasznalat(0);
			System.out.println("Ezutan a balodali tabla meg mindig fel van fordulva es van rajta: " 
					+ j.jatekosokLekerdez().size() 
					+ "db jatekos, mig a jobboldali nincs atfordulva es van rajta: " 
					+ j1.jatekosokLekerdez().size() + "db jatekos");
			
			
		}
		
		public static void ElelemFelvesz()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			j.addJatekos(sk);
			Elelem a = new Elelem(1);
			j.setTargy(a);
			
			sk.TargyakListazasa();
			System.out.println("Most a jatekos megprobalja felvenni az elelmet a tablarol");
			sk.targyFelvetel();
			sk.TargyakListazasa();
		}
		
		public static void ElelemHasznal()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, true, -1, 0, null, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,2, null, Irany.Jobb);
			Sarkkutato sk2 = new Sarkkutato(jm, 55,55,6, null, Irany.Jobb);
			
			j.addJatekos(sk);
			Elelem a = new Elelem(1);
			sk.targyHozzadasa(a);
			sk2.targyHozzadasa(a);
			
			System.out.println("1-es jatekos targyai kezdetben");
			sk.TargyakListazasa();
			System.out.println("Kezdetben az 1-es jatekosnak " + sk.getTestho() + " testhoje van");
			System.out.println("Most a jatekos hasznalni fogja az elelmet");
			sk.targyHasznalat(0);
			System.out.println("Most a 1-es jatekosnak " + sk.getTestho() + " testhoje van");
			System.out.println("1-es jatekos targyai az elelem hasznalata utan");
			sk.TargyakListazasa();
			
			System.out.println("2-es jatekos targyai kezdetben");
			sk2.TargyakListazasa();
			System.out.println("Kezdetben az 2-es jatekosnak " + sk2.getTestho() + " testhoje van");
			System.out.println("Most a jatekos hasznalni fogja az elelmet");
			sk2.targyHasznalat(0);
			System.out.println("Most a 1-es jatekosnak " + sk2.getTestho() + " testhoje van");
			System.out.println("2-es jatekos targyai az elelem hasznalata utan");
			sk2.TargyakListazasa();
		}
		
		public static void EszkimoKepesseg()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, true, -1, 0, null, null);
			Jegtabla j1 = new Jegtabla(jm, true, -1, 0, null, null);
			j.setSzomszed(j1, Irany.Jobb);
			
			Eszkimo e = new Eszkimo(jm, 55,55,2, null, Irany.Jobb);
			j.addJatekos(e);
			
			String jVedelme = j.getjegtablaVedelme() == null? "Semmi" : j.getjegtablaVedelme().toString();
			String j1Vedelme = j1.getjegtablaVedelme() == null? "Semmi" : j1.getjegtablaVedelme().toString();
			System.out.println("Kezdetben a bal jegtablan " 
			+ jVedelme + " van, mig a jobboldalin " + j1Vedelme + " van");
			
			System.out.println("Most hasznaljuk az eszkimo kepesseget");
			e.kepesseg(j1);
			
			jVedelme = j.getjegtablaVedelme() == null? "Semmi" : j.getjegtablaVedelme().toString();
			j1Vedelme = j1.getjegtablaVedelme() == null? "Semmi" : j1.getjegtablaVedelme().toString();
			System.out.println("Most a bal jegtablan " 
					+ jVedelme + " van, mig a jobboldalin " + j1Vedelme + " van");
			
		}
		
		
		public static void IgluHovihar()
		{

			Iglu i = new Iglu();
			i.hovihar();
		}
		
		public static void IgluFrissit()
		{
			Iglu i = new Iglu();
			i.frissit();
		}
		
		public static void IgluJegesmedveTamadas()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegesmedve je = new Jegesmedve(jm, Irany.Bal, false);
			
			Iglu i = new Iglu();
			i.tamadas(je);
		}
		
		
		
		public static void JatekosAthelyez()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, true, -1, 2, null, null);
			Jegtabla j1 = new Jegtabla(jm, true, -1, 1, null, null);
			Jegtabla j2 = new Jegtabla(jm, true, -1, 0, null, null);
			
			j.setSzomszed(j1, Irany.Jobb);
			j.setSzomszed(j2, Irany.Bal);
			
			System.out.println();
			Eszkimo e = new Eszkimo(jm, 55,55,2, null, Irany.Jobb);
			j.addJatekos(e);
			
			e.athelyez(Irany.Jobb);
			
			
	
		}
		
		public static void JatekosFrissit()
		{
			
		}
		
		
		public static void JatekosHovihar()
		{
			
		}
		
		
		public static void JatekosLep()
		{
			
		}
		
		public static void JatekosTargyatHasznal()
		{
			
		}
		
		
		public static void JegesmedveFrissit()
		{
			
		}
		
		public static void JegesmedveHovihar()
		{
			
		}
		
		public static void JegmezoAddFrissitheto()
		{
			
		}
		
		public static void JegtablaHovihar()
		{
			
		}
		
		public static void JegtablaFrissit()
		{
			
		}
		
		public static void JegtablaAtfordit()
		{
			
		}
		
		
		public static void JegtablaSetSzomszed()
		{
			
		}
		
		public static void KotelFelvesz()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			j.addJatekos(sk);
			Kotel a = new Kotel();
			j.setTargy(a);
			
			sk.TargyakListazasa();
			System.out.println("Most a jatekos megprobalja felvenni a kotelet a tablarol");
			sk.targyFelvetel();
			sk.TargyakListazasa();
		}
		
		public static void KotelHasznal()
		{
			
		}
		
		
		public static void JelzopisztolyFelvesz()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			j.addJatekos(sk);
			Jelzopisztoly a = new Jelzopisztoly();
			j.setTargy(a);
			
			sk.TargyakListazasa();
			System.out.println("A jatekosnak kezdetben: " + sk.getjelzopisztolydb() + " db jelzopisztolydbja van");  
			System.out.println("Most a jatekos megprobalja felvenni a jelzopisztolyt a tablarol");
			sk.targyFelvetel();
			sk.TargyakListazasa();
			System.out.println("A jatekosnak most: " + sk.getjelzopisztolydb() + " db jelzopisztolydbja van");  
		}
		
		public static void JelzopisztolyHasznal()
		{
			
		}
		
		public static void SatorFrissit()
		{
			
		}
	
		public static void SatorHovihar()
		{
			
		}
		
		public static void SatorFelvesz()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			j.addJatekos(sk);
			Sator a = new Sator(2);
			j.setTargy(a);
			
			sk.TargyakListazasa();
			System.out.println("Most a jatekos megprobalja felvenni a satrat a tablarol");
			sk.targyFelvetel();
			sk.TargyakListazasa();
		}
		
		public static void SatorHasznal()
		{
			
		}
		
		public static void SarkkutatoKepessegetHasznal()
		{
			
		}
		
		public static void TorkenyAsoFelvesz()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			j.addJatekos(sk);
			TorekenyAso a = new TorekenyAso(2);
			j.setTargy(a);
			
			sk.TargyakListazasa();
			System.out.println("Most a jatekos megprobalja felvenni a torekenyasot a tablarol");
			sk.targyFelvetel();
			sk.TargyakListazasa();
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
