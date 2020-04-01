package Jegmezo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Menu {
	
	private int answer = 0;
	private Scanner in = new Scanner(System.in);
	
	
		public void main() {	
			
			
		do {
			System.out.println("\n\n");
			System.out.println("Mit szeretne? (nyomja meg a megfelelõ menüpontot)\n "
					+ "1 - Ásás\n"
					+ "2 - Ásó felvesz\n"
					+ "3 - Ásó használ\n"
					+ "4 - Búvárruha felvesz\n"
					+ "5 - Búvárruha használ\n"
					+ "6 - Élelem felvesz\n"
					+ "7 - Élelem használ\n"
					+ "8 - Hóvihar\n"
					+ "9 - Eszkimo kepesseget hasznal\n"
					+ "10 - Jelzõpisztoly felvesz\n "
					+ "11 - Jelzõpisztoly használ\n"
					+ "12 - Kötél felvesz\n "
					+ "13 - Kötél használ\n"
					+ "14 - Lépés\n"
					+ "15 - Sarkkutato kepesseget hasznal\n"
					+ "16 - Targyakat hasznal \n"
					+ "17 - Eszkimo kepesseget hasznal \n"
					+ "18 - Jatekos Athelyez \n"
					+ "19 - Jatekos hovihar \n"
					+ "20 - Jatekos Lep \n"
					+ "21 - Eszkimo kepesseg \n"
					+ "22 - Iglu hovihar \n"
					+ "23 - Iglu frissit \n"
					+ "24 - Iglu jegesmedve tamadas \n"
					+ "25 - Jatekos frissit \n"
					+ "26 - Jegesmedve frissit \n"
					+ "27 - Jegesmedve hovihar \n"
					+ "28 - Jegtabla hovihar \n"
					+ "29 - Jegtabla frissit \n"
					+ "30 - Jegtabla atfordit \n"
					+ "31 - Sator frissit \n"
					+ "32 - Sator hovihar \n"
					+ "33 - Sator felvesz \n"
					+ "34 - Sator hasznal \n"
					+ "35 - TorekenyAsot felvesz \n"
					+ "36 - TorekenyAsot hasznal \n"
					+ " 66 - Kilép ");
			
			System.out.print("Valasztas: ");
			answer =  in.nextInt();
			System.out.println("\n\n");
			
			switch(answer) {
				case 1:
					System.out.println("Mit szeretne?"
							+ "1 - Asas\n"
							+ "2 - Targy kiasas\n"
							+ "3 - Sikertelen Asas\n");
					System.out.print("Valasztas: ");
					answer =  in.nextInt();
					Asas(answer);
			    	break;
				case 2:
					AsotFelvesz();
			    	break;
				case 3:
						System.out.println("Mit szeretne?"
									+ "1 - Asoval asas\n"
									+ "2 - Asoval Targy kiasas\n"
									+ "3 - Asoval sikertelen Asas\n");
						System.out.print("Valasztas: ");
							answer =  in.nextInt();
					AsotHasznal(answer);
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
					System.out.println("Mit szeretne?"
							+ "1 - Elemlem hasznalata\n"
							+ "2 - Elelem sikertelen hasznalata");
				System.out.print("Valasztas: ");
					answer =  in.nextInt();
					ElelemHasznal(answer);
					break;
				case 8:
					
			    	break;	
				case 9:
					EszkimoKepesseg();
					break;
				case 10:
					JelzopisztolyFelvesz();
			    	break;
				case 11:
					System.out.println("Mit szeretne?"
							+ "1 - Jelzopisztoly hasznalata, de az osszeszereles sikertelen\n"
							+ "2 - Jelzopisztoly hasznalata, de az osszeszereles sikeres");
					System.out.print("Valasztas: ");
					answer =  in.nextInt();
					JelzopisztolyHasznal(answer);
					break;
				case 12:
					KotelFelvesz();
			    	break;
				case 13:
					KotelHasznal();
			    	break;
				case 14:
					break;
				case 15:
					SarkkutatoKepessegetHasznal();
					break;
				case 16:

					break;
				case 17:
					EszkimoKepesseg();
					break;
				case 18:
					System.out.println("Mit szeretne?"
							+ "1 - Jatekos athelyezese\n"
							+ "2 - Jatekos athelyezese es tabla felforditasa\n");
					System.out.print("Valasztas: ");
					answer =  in.nextInt();
					JatekosAthelyez(answer);
					break;
				case 19:
					System.out.println("Mit szeretne?"
							+ "1 - Jatekos hovihar vedelem nelkul, de tuleli\n"
							+ "2 - Jatekos hovihar vedelem nelkul es meghal\n"
							+ "3 - Jatekos hovihar Igluval\n"
							+ "4 - Jatekos hovihar Satorral\n");
					System.out.print("Valasztas: ");
					answer =  in.nextInt();
					JatekosHovihar(answer);
					break;
				case 20:
					System.out.println("Mit szeretne?"
							+ "1 - Jatekos lep\n"
							+ "2 - Jatekos lep es felfordul a tabla\n"
							+ "3 - Jatekos lepne, de vizben van\n");
					System.out.print("Valasztas: ");
					answer =  in.nextInt();
					JatekosLep(answer);
					break;
				case 21:
					EszkimoKepesseg();
					break;
				case 22:
					IgluHovihar();
					break;
				case 23:
					IgluFrissit();
					break;
				case 24:
					IgluJegesmedveTamadas();
					break;
				case 25:
					JatekosFrissit();
					break;
				case 26:
					System.out.println("Mit szeretne?"
							+ "1 - Jegesmedve olyan tablara lep, amin iglu van\n"
							+ "2 - Jegesmedve olyan tablara lep, amin sator van\n"
							+ "3 - Jegesmedve olyan tablara lep, amin nincs Vedelem es van jatekos\n"
							+ "4 - Jegesmedve olyan tablara lep, amin nincs Vedelem es nincs jatekos\n");
					System.out.print("Valasztas: ");
					answer =  in.nextInt();
					JegesmedveFrissit(answer);
					break;
				case 27:
					JegesmedveHovihar();
					break;
				case 28:
					JegtablaHovihar();
					break;
				case 29:
					System.out.println("Mit szeretne?"
							+ "1 - Jegtabla frissites atfordulva es jatekosok rajta\n"
							+ "2 - Jegtabla frissites visszafordul\n"
							+ "3 - Jegtabla frissites Igluval\n" 
							+ "4 - Jegtabla frissites Satorral\n" 
							+ "5 - Jegtabla frisites Vedelem nelkul\n" );
					System.out.print("Valasztas: ");
					answer =  in.nextInt();
					JegtablaFrissit(answer);
					break;
				case 30:
					System.out.println("Mit szeretne?"
							+ "1 - Jegtabla atfordit igluval\n"
							+ "2 - Jegtabla atfordit satorral\n"
							+ "3 - Jegtabla atfordit Vedelem nelkul\n"  );
					System.out.print("Valasztas: ");
					answer =  in.nextInt();
					JegtablaAtfordit(answer);
				case 31:
					SatorFrissit();
					break;
				case 32:
					SatorHovihar();
					break;
				case 33:
					SatorFelvesz();
					break;
				case 34:
					SatorHasznal();
					break;
				case 35:
					TorkenyAsoFelvesz();
					break;
				case 36:
					System.out.println("Mit szeretne?"
							+ "1 - TorekenyAso asas \n"
							+ "2 - TorekenyAso targyat kias\n"
							+ "3 - TorekenyAso nem kepes asni\n"  
							+ "4 - TorekenyAso eltorik\n");
					System.out.print("Valasztas: ");
					answer =  in.nextInt();
					TorekenyAsoHasznal(answer);
					break;
				case 66:
					System.out.println("Kilépett");
					break;
				default:
					System.out.println("Válasszon a megadott menüpontok közül");
			}
		}while(answer != 66);
	}
		
		public static void Asas(int eset)
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j1 = new Jegtabla(jm, false, 1, 55, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			j1.addJatekos(sk);
			
			Jegtabla j2 = new Jegtabla(jm, false, 0, 55, null);
			Eszkimo e = new Eszkimo(jm, 55,55,55, null, Irany.Bal);
			j2.addJatekos(e);
			
			Jegtabla j3 = new Jegtabla(jm, false, -1, 55, null);
			Eszkimo e2 = new Eszkimo(jm, 55,55,55, null, Irany.Bal);
			j3.addJatekos(e2);
			
			
			
			if(eset == 1)
			{
				System.out.println("Kezdetben a jegtablan a " + j1.getHo() + " db ho van");
				
				System.out.println("Jatekos as");
				sk.asas();
				System.out.println("Most a jegtablan " + j1.getHo() + " db ho van");
			}
			else if(eset == 2)
			{
				System.out.println("Kezdetben a jegtablan a " + j2.getHo() + " db ho van");
				System.out.println("Jatekos as");
				e.asas();
				System.out.println("Most a jegtablan " + j2.getHo() + " db ho van");
			}
			else if(eset == 3)
			{
				System.out.println("Kezdetben a jegtablan a " + j3.getHo() + " db ho van");
				System.out.println("Jatekos as");
				e2.asas();
				System.out.println("Most a jegtablan " + j3.getHo() + " db ho van");
			}
			
			
			
			
		}
		
		public static void AsotFelvesz()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			j.addJatekos(sk);
			Aso a = new Aso();
			j.setTargy(a);
			
			sk.TargyakListazasa();
			System.out.println("Most a jatekos megprobalja felvenni az asot a tablarol");
			sk.targyFelvetel();
			sk.TargyakListazasa();
		}
		
		public static void AsotHasznal(int eset)
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, 28, 55, null);
			Jegtabla j1 = new Jegtabla(jm, false, 2, 55, null);
			Jegtabla j2 = new Jegtabla(jm, false, 1, 55, null);
			Jegtabla j3 = new Jegtabla(jm, false, -1, 55, null);
			
			j.setSzomszed(j1, Irany.Jobb);
			j.setSzomszed(j2, Irany.Bal);
			j.setSzomszed(j3, Irany.Fel);
			Aso a = new Aso();
			
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Jobb);
		
			
			Sarkkutato sk2 = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			
			
			Sarkkutato sk3 = new Sarkkutato(jm, 55,55,55, null, Irany.Fel);
			sk.targyHozzadasa(a);
			sk2.targyHozzadasa(a);
			sk3.targyHozzadasa(a);
			j.addJatekos(sk);
			j.addJatekos(sk2);
			j.addJatekos(sk3);
			
			
			
			
			
			
		
			
			if(eset == 1)
			{
				System.out.println("Kezdetben a jegtablan a " + j1.getHo() + " db ho van");
				
				System.out.println("Most a jatekos megprobalja hasznalni az asot");
				sk.targyHasznalat(0);
				System.out.println("Most " + j1.getHo() + " db ho van a jegtablan");
			}
			else if(eset == 2)
			{
					System.out.println("Kezdetben a jegtablan a " + j2.getHo()  + " db ho van");
				
				System.out.println("Most a jatekos megprobalja hasznalni az asot");
				sk2.targyHasznalat(0);
				System.out.println("Most " + j2.getHo() + " db ho van a jegtablan");
			}
			else if(eset == 3)
			{
				System.out.println("Kezdetben a jegtablan a " + j3.getHo()  + " db ho van");
				
				System.out.println("Most a jatekos megprobalja hasznalni az asot");
				sk3.targyHasznalat(0);
				System.out.println("Most " + j3.getHo() + " db ho van a jegtablan");
			}
			
		}
		
		public static void BuvarruhaFelvesz()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null);
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
			Jegtabla j = new Jegtabla(jm, true, -1, 0, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Jobb);
			Jegtabla j1 = new Jegtabla(jm, false, 2, 55, null);
			
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
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			j.addJatekos(sk);
			Elelem a = new Elelem(1);
			j.setTargy(a);
			
			sk.TargyakListazasa();
			System.out.println("Most a jatekos megprobalja felvenni az elelmet a tablarol");
			sk.targyFelvetel();
			sk.TargyakListazasa();
		}
		
		public static void ElelemHasznal(int eset)
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, true, -1, 0, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,2, null, Irany.Jobb);
			Sarkkutato sk2 = new Sarkkutato(jm, 55,55,6, null, Irany.Jobb);
			
			j.addJatekos(sk);
			Elelem a = new Elelem(1);
			sk.targyHozzadasa(a);
			sk2.targyHozzadasa(a);
			
			if(eset == 1)
			{
				System.out.println("1-es jatekos targyai kezdetben");
				sk.TargyakListazasa();
				System.out.println("Kezdetben az 1-es jatekosnak " + sk.getTestho() + " testhoje van");
				System.out.println("Most a jatekos hasznalni fogja az elelmet");
				sk.targyHasznalat(0);
				System.out.println("Most a 1-es jatekosnak " + sk.getTestho() + " testhoje van");
				System.out.println("1-es jatekos targyai az elelem hasznalata utan");
				sk.TargyakListazasa();
			}
			else if(eset == 2)
			{
				System.out.println("2-es jatekos targyai kezdetben");
				sk2.TargyakListazasa();
				System.out.println("Kezdetben az 2-es jatekosnak " + sk2.getTestho() + " testhoje van");
				System.out.println("Most a jatekos hasznalni fogja az elelmet");
				sk2.targyHasznalat(0);
				System.out.println("Most a 1-es jatekosnak " + sk2.getTestho() + " testhoje van");
				System.out.println("2-es jatekos targyai az elelem hasznalata utan");
				sk2.TargyakListazasa();
			}
		}
		
		public static void EszkimoKepesseg()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, true, -1, 0, null);
			Jegtabla j1 = new Jegtabla(jm, true, -1, 0, null);
			j.setSzomszed(j1, Irany.Jobb);
			
			Eszkimo e = new Eszkimo(jm, 55,55,2, null, Irany.Jobb);
			j.addJatekos(e);
			
			String jVedelme = j.getjegtablaVedelme() == null? "Semmi" : j.getjegtablaVedelme().toString();
			String j1Vedelme = j1.getjegtablaVedelme() == null? "Semmi" : j1.getjegtablaVedelme().toString();
			System.out.println("Kezdetben a bal jegtablan " 
			+ jVedelme + " van, mig a jobboldalin " + j1Vedelme + " van");
			
			System.out.println("Most hasznaljuk az eszkimo kepesseget");
			e.kepesseg();
			
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
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 0, null);
			Iglu i = new Iglu();
			
			j.setjegtablaVedelme(i);
			
			j.frissit();		
		}
		
		public static void IgluJegesmedveTamadas()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegesmedve je = new Jegesmedve(jm, Irany.Bal, false);
			
			Iglu i = new Iglu();
			i.tamadas(je);
		}
		
		
		
		public static void JatekosAthelyez(int eset)
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, true, -1, 2, null);
			Jegtabla j1 = new Jegtabla(jm, true, -1, 1, null);
			Jegtabla j2 = new Jegtabla(jm, true, -1, 0, null);
			
			j.setSzomszed(j1, Irany.Jobb);
			j.setSzomszed(j2, Irany.Bal);
			
			Eszkimo e = new Eszkimo(jm, 55,55,2, null, Irany.Jobb);
			Eszkimo e2 = new Eszkimo(jm, 55,55,2, null, Irany.Jobb);
			j.addJatekos(e);
			j.addJatekos(e2);
			
			System.out.println("Kezdetben a bal tablan " + j2.jatekosokLekerdez().size() + " db jatekos van "
					+ "a kozepso tablan " + j.jatekosokLekerdez().size() + " db jatekos van "
					+ "mig a jobb tablan " + j1.jatekosokLekerdez().size() + " db jatekos van ");
			
			if(eset == 1)
			{
				System.out.println("Most athelyezzuk a jatekost"); 
				e.athelyez(Irany.Jobb);
				System.out.println("Most a bal tablan " + j2.jatekosokLekerdez().size() + " db jatekos van "
						+ "a kozepso tablan " + j.jatekosokLekerdez().size() + " db jatekos van "
						+ "mig a jobb tablan " + j1.jatekosokLekerdez().size() + " db jatekos van ");
			}
			else if(eset == 2)
			{
				System.out.println("Most athelyezzuk a jatekost"); 
				e2.athelyez(Irany.Bal);
				System.out.println("Most a bal tablan " + j2.jatekosokLekerdez().size() + " db jatekos van "
						+ "a kozepso tablan " + j.jatekosokLekerdez().size() + " db jatekos van "
						+ "mig a jobb tablan " + j1.jatekosokLekerdez().size() + " db jatekos van ");
			}
	
		}
		
		public static void JatekosFrissit()
		{
			Jegmezo jm = new Jegmezo(10);
			Eszkimo e = new Eszkimo(jm, 55,0,2, null, Irany.Jobb);
			System.out.println("Kezdetben a jatekosnak " + e.getMunkadb() + " db Munkaja van");
			
			e.frissit();
			System.out.println("Most a jatekosnak " + e.getMunkadb() + " db Munkaja van");
			
		}
		
		
		public static void JatekosHovihar(int eset)
		{
			Jegmezo jm = new Jegmezo(10);
			Eszkimo e = new Eszkimo(jm, 55,0,2, null, Irany.Jobb);
			Eszkimo e2 = new Eszkimo(jm, 55,0,1, null, Irany.Jobb);
			Eszkimo e3 = new Eszkimo(jm, 55,0,1, null, Irany.Jobb);
			Eszkimo e4 = new Eszkimo(jm, 55,0,1, null, Irany.Jobb);
			
			Jegtabla j = new Jegtabla(jm, true, -1, 2, null);
			Jegtabla j1 = new Jegtabla(jm, true, -1, 1, null);
			j1.setjegtablaVedelme(new Iglu());
			Jegtabla j2 = new Jegtabla(jm, true, -1, 1,  null);
			j2.setjegtablaVedelme(new Sator(1));
			
			j.addJatekos(e);
			j.addJatekos(e2);
			j1.addJatekos(e3);
			j2.addJatekos(e4);
			
			if(eset == 1)
			{
				System.out.println("Kezdetben az 1-es jatekosnak " + e.getTestho() + " db testhoje van");
				e.hovihar();
				System.out.println("Most az 1-es jatekosnak " + e.getTestho() + " db testhoje van");
			}
			else if(eset == 2)
			{
				System.out.println("Kezdetben az 2-es jatekosnak " + e2.getTestho() + " db testhoje van");
				e2.hovihar();
				System.out.println("Most az 2-es jatekosnak " + e2.getTestho() + " db testhoje van");
			}
			else if(eset == 3)
			{
				System.out.println("Kezdetben az 3-as jatekosnak " + e3.getTestho() + " db testhoje van");
				e3.hovihar();
				System.out.println("Most az 3-as jatekosnak " + e3.getTestho() + " db testhoje van");
			}
			else if(eset == 4)
			{
				System.out.println("Kezdetben az 4-es jatekosnak " + e4.getTestho() + " db testhoje van");
				e4.hovihar();
				System.out.println("Most az 4-es jatekosnak " + e4.getTestho() + " db testhoje van");
			}
		}
		
		
		public static void JatekosLep(int eset)
		{
			Jegmezo jm = new Jegmezo(10);
			Eszkimo e = new Eszkimo(jm, 55,55,2, null, Irany.Jobb);
			
			
			
			
			if(eset == 1)
			{
				Jegtabla j = new Jegtabla(jm, false, -1, 2, null);
				Jegtabla j1 = new Jegtabla(jm, false, -1, 1, null);
				j.addJatekos(e);
				
				j.setSzomszed(j1, Irany.Jobb);
				System.out.println("Kezdetben az bal tablan " + j.jatekosokLekerdez().size() + " db jatekos van "
						+ "a jobb tablan " + j1.jatekosokLekerdez().size() + " db jatekos van ");
				e.lepes();
				System.out.println("Most az bal tablan " + j.jatekosokLekerdez().size() + " db jatekos van "
						+ "a jobb tablan " + j1.jatekosokLekerdez().size() + " db jatekos van ");
			}
			else if(eset == 2)
			{
				Jegtabla j = new Jegtabla(jm, false, -1, 1, null);
				Jegtabla j1 = new Jegtabla(jm, false, -1, 0, null);
				j.addJatekos(e);
				j.setSzomszed(j1, Irany.Jobb);
				
				System.out.println("Kezdetben az bal tablan " + j.jatekosokLekerdez().size() + " db jatekos van "
						+ "a jobb tablan " + j1.jatekosokLekerdez().size() + " db jatekos van ");
				e.lepes();
				System.out.println("Most az bal tablan " + j.jatekosokLekerdez().size() + " db jatekos van "
						+ "a jobb tablan " + j1.jatekosokLekerdez().size() + " db jatekos van ");
			}
			else if(eset == 3)
			{
				Jegtabla j = new Jegtabla(jm, true, -1, 0, null);
				Jegtabla j1 = new Jegtabla(jm, false, -1, 0, null);
				j.addJatekos(e);
				j.setSzomszed(j1, Irany.Jobb);
				
				System.out.println("Kezdetben az bal tablan " + j.jatekosokLekerdez().size() + " db jatekos van "
						+ "a jobb tablan " + j1.jatekosokLekerdez().size() + " db jatekos van ");
				e.lepes();
				System.out.println("Most az bal tablan " + j.jatekosokLekerdez().size() + " db jatekos van "
						+ "a jobb tablan " + j1.jatekosokLekerdez().size() + " db jatekos van ");
			}
	
		}
		
		
		
		public static void JegesmedveFrissit(int eset)
		{
			Jegmezo jm = new Jegmezo(10);
			Jegesmedve jeges = new Jegesmedve(jm, Irany.Jobb, false);
			Eszkimo e = new Eszkimo(jm, 55,55,2, null, Irany.Jobb);
			
			Jegtabla j = new Jegtabla(jm, false, -1, 2, null);
			Jegtabla j2 = new Jegtabla(jm, false, -1, 2, null);
			j.setSzomszed(j2,Irany.Bal);
			j.addJegesmedve(jeges);
		
			if(eset == 1)
			{
				Jegtabla j1 = new Jegtabla(jm, false, -1, 1, null);
				j1.setjegtablaVedelme(new Iglu());
				j.setSzomszed(j1,Irany.Jobb);
				j1.addJatekos(e);
				jeges.frissit();
				
			}
			else if(eset == 2)
			{
				Jegtabla j1 = new Jegtabla(jm, false, -1, 1, null);
				j1.setjegtablaVedelme(new Sator(1));
				j.setSzomszed(j1,Irany.Jobb);
				j1.addJatekos(e);
				jeges.frissit();
			}
			else if(eset == 3)
			{
				Jegtabla j1 = new Jegtabla(jm, false, -1, 1, null);
				j.setSzomszed(j1,Irany.Jobb);
				j1.addJatekos(e);
				jeges.frissit();
			}
			else if(eset == 4)
			{

				jeges.setiranyAmibeNez(Irany.Bal);
				jeges.frissit();
			}
		}
		
		/// idaig van afkdkafmsdkmasdm skdvamvlkfdamlkdamflmlfmlkasdmflkasdmfklamdsfklamsdlfkmasdlkfm
		
		public static void JegesmedveHovihar()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegesmedve jeges = new Jegesmedve(jm, Irany.Jobb, false);
			jeges.hovihar();
			
		}
		
		
		public static void JegtablaHovihar()
		{
			
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 2, null);
			System.out.println("Kezdetben a jegtablan " + j.getHo() + " db ho van");
			j.hovihar();
			System.out.println("Most a jegtablan " + j.getHo() + " db ho van");
			
		}
		
		public static void JegtablaFrissit(int eset)
		{
			
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 2, null);
			Eszkimo e = new Eszkimo(jm, 55,55,2, null, Irany.Jobb);
			
			if(eset == 1)
			{
				j.atfordit();
				j.addJatekos(e);
			}
			else if(eset == 2)
			{
				j.atfordit();
			}
			else if(eset == 3)
			{
				
				j.addJatekos(e);
				j.setjegtablaVedelme(new Iglu());
				
				System.out.println("A jegtabla vedelme kezdetben: " + j.getjegtablaVedelme().toString());
			}
			else if(eset == 4)
			{
				j.addJatekos(e);
				j.setjegtablaVedelme(new Sator(1));
				System.out.println("A jegtabla vedelme kezdetben: " + j.getjegtablaVedelme().toString());
			}
			else if(eset == 5)
			{
				j.addJatekos(e);
			}
			
			
			
			j.frissit();
			String jgv = j.getjegtablaVedelme() == null? "Semmi" : j.getjegtablaVedelme().toString();
			System.out.println("A jegtabla vedelme a frissites utan: " + jgv);
		}
		
		
		public static void JegtablaAtfordit(int eset)
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 2, null);
			
			
			if(eset == 1)
			{
				j.setjegtablaVedelme(new Iglu());
				System.out.println("A jegtabla vedelme kezdetben: " + j.getjegtablaVedelme().toString());
			}
			else if(eset == 2)
			{
				j.setjegtablaVedelme(new Sator(1));
				System.out.println("A jegtabla vedelme kezdetben: " + j.getjegtablaVedelme().toString());
			}
			else if(eset == 3)
			{
				
			}
			j.atfordit();
			String jgv = j.getjegtablaVedelme() == null? "Semmi" : j.getjegtablaVedelme().toString();
			System.out.println("A jegtabla vedelme az atfordulas utan: " + jgv);
		}
		
		
		
		public static void KotelFelvesz()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null);
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
			
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null);
			Jegtabla j2 = new Jegtabla(jm, true, -1, 0, null);
			
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Jobb);
			Sarkkutato sk2 = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			
			sk.targyHozzadasa(new Kotel());
			j.addJatekos(sk);
			j2.addJatekos(sk2);
			j.setSzomszed(j2, Irany.Jobb);
			j2.setSzomszed(j, Irany.Bal);
			
			System.out.println("A baloladli tabla kezdetben atvan fordulva? " + j.getAtVanFordulva() + "\n"
					+ "Balodali tablan kezdetben" + j.jatekosokLekerdez().size() + " db jatekos van \n"
							+ "A jobboldali tabla kezdetben atvan fordulva? " + j2.getAtVanFordulva() + "\n"
							+ "jobboldali tablan kezdetben" + j2.jatekosokLekerdez().size() + " db jatekos van \n"  );
			
			sk.targyHasznalat(0);
			
			System.out.println("A baloladli tabla kezdetben atvan fordulva? " + j.getAtVanFordulva() + "\n"
					+ "Balodali tablan kezdetben" + j.jatekosokLekerdez().size() + " db jatekos van \n"
							+ "A jobboldali tabla kezdetben atvan fordulva? " + j2.getAtVanFordulva() + "\n"
							+ "jobboldali tablan kezdetben" + j2.jatekosokLekerdez().size() + " db jatekos van \n"  );
			
		}
		
		
		public static void JelzopisztolyFelvesz()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55,null);
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
		
		public static void JelzopisztolyHasznal(int eset)
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55,null);
			System.out.println("Most a jatekos megprobalja megepiteni a jelzpisztolyt");
			Jelzopisztoly jp = new Jelzopisztoly();
			
			if(eset == 1)
			{
				Sarkkutato sk = new Sarkkutato(jm, 0,55,55, null, Irany.Jobb);
				j.addJatekos(sk);
				sk.targyHozzadasa(jp);
				sk.targyHasznalat(0);
				
			}
			else if(eset == 2)
			{
				Sarkkutato sk = new Sarkkutato(jm, 1,55,55, null, Irany.Jobb);
				Sarkkutato sk2 = new Sarkkutato(jm, 1,55,55, null, Irany.Bal);
				Sarkkutato sk3 = new Sarkkutato(jm, 1,55,55, null, Irany.Bal);
				j.addJatekos(sk);
				j.addJatekos(sk2);
				j.addJatekos(sk3);
				sk.targyHozzadasa(jp);
				sk.targyHasznalat(0);
				
			}
		}
		
		public static void SatorFrissit()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null);
			j.setjegtablaVedelme(new Sator(1));
			
			System.out.println("A jegtabla vedelme a frissites elott: " +  j.getjegtablaVedelme().toString());
			j.frissit();
			
			String jgv = j.getjegtablaVedelme() == null? "Semmi" : j.getjegtablaVedelme().toString();
			System.out.println("A jegtabla vedelme a frissites utan: " + jgv);
			
		}
	
		public static void SatorHovihar()
		{
			Sator i = new Sator(1);
			
			i.hovihar();		
		}
		
		public static void SatorFelvesz()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55,null);
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
			
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null);
			Jegtabla j2 = new Jegtabla(jm, true, -1, 0, null);
			
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Jobb);
			
			sk.targyHozzadasa(new Sator(1));
			j.addJatekos(sk);
			j.setSzomszed(j2, Irany.Jobb);
			
			String jgv = j.getjegtablaVedelme() == null? "Semmi" : j2.getjegtablaVedelme().toString();
			System.out.println("A jegtabla vedelme a sator hasznalat elott: " + jgv);
			sk.targyHasznalat(0);
		
			System.out.println("A jegtabla vedelme a sator hasznalat utan: " + j2.getjegtablaVedelme().toString());
			
		}
		
		public static void SarkkutatoKepessegetHasznal()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null);
			Jegtabla j2 = new Jegtabla(jm, true, -1, 0, null);
			
			j.setSzomszed(j2, Irany.Jobb);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Jobb);
			j.addJatekos(sk);
			
			System.out.println("A jegtabla tartokepessege, amirol tudni szeretnenk: " + j2.gettartokepesseg());
			System.out.println("A sarkkutato altal meghatarozott adatok: ");
			sk.kepesseg();
			
		}
		
		public static void TorkenyAsoFelvesz()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, -1, 55, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			j.addJatekos(sk);
			TorekenyAso a = new TorekenyAso(2);
			j.setTargy(a);
			
			sk.TargyakListazasa();
			System.out.println("Most a jatekos megprobalja felvenni a torekenyasot a tablarol");
			sk.targyFelvetel();
			sk.TargyakListazasa();
		}
		
		public static void TorekenyAsoHasznal(int eset)
		{
			Jegmezo jm = new Jegmezo(10);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Jobb);
			Jegtabla j2 =   new Jegtabla(jm, false, 2, 0, null);
			TorekenyAso t = new TorekenyAso(1);
			if(eset == 1)
			{
				
				Jegtabla j = new Jegtabla(jm, false, 2, 55, null);
				j2 = new Jegtabla(jm, false, 2, 0, null);
				System.out.println("Kezdetben a jobb jegtabla homennyisege " + j2.getHo() + " db");
				j.setSzomszed(j2, Irany.Jobb);
				
				j.addJatekos(sk);
				t.setTartossag(33);
				System.out.println("Kezdetben a Torekenyaso tartossaga: " + t.getTartossag());
				
				sk.targyHozzadasa(t);
				
				System.out.println("Kezdetben a jatekos targyai: ");
				sk.TargyakListazasa();
				sk.targyHasznalat(0);
				
			}
			else if(eset == 2)
			{
				Jegtabla j = new Jegtabla(jm, false, 1, 55, null);
				j2 = new Jegtabla(jm, false, 1, 0, null);
				System.out.println("Kezdetben a jobb jegtabla homennyisege " + j2.getHo() + " db");
				j.setSzomszed(j2, Irany.Jobb);
				
				j.addJatekos(sk);
				
				t.setTartossag(33);
				System.out.println("Kezdetben a Torekenyaso tartossaga: " + t.getTartossag());
				
				sk.targyHozzadasa(t);
				
				System.out.println("Kezdetben a jatekos targyai: ");
				sk.TargyakListazasa();
				sk.targyHasznalat(0);
				
			}
			else if(eset == 3)
			{
				Jegtabla j = new Jegtabla(jm, false, -1, 55, null);
				j2 = new Jegtabla(jm, false, -1, 0, null);
				System.out.println("Kezdetben a jobb jegtabla homennyisege " + j2.getHo() + " db");
				j.setSzomszed(j2, Irany.Jobb);
				
				j.addJatekos(sk);
				t.setTartossag(33);
				System.out.println("Kezdetben a Torekenyaso tartossaga: " + t.getTartossag());
				
				sk.targyHozzadasa(t);
				System.out.println("Kezdetben a jatekos targyai: ");
				sk.TargyakListazasa();
				sk.targyHasznalat(0);
			}
			else if(eset == 4)
			{
				Jegtabla j = new Jegtabla(jm, false, -1, 55, null);
				j2 = new Jegtabla(jm, false, 10, 0, null);
				System.out.println("Kezdetben a jobb jegtabla homennyisege " + j2.getHo() + " db");
				j.setSzomszed(j2, Irany.Jobb);
				
				j.addJatekos(sk);
				t.setTartossag(1);
				System.out.println("Kezdetben a Torekenyaso tartossaga: " + t.getTartossag());
				
				sk.targyHozzadasa(t);
				System.out.println("Kezdetben a jatekos targyai: ");
				sk.TargyakListazasa();
				sk.targyHasznalat(0);
				
			}
			System.out.println("Most a Torekenyaso tartossaga: " + t.getTartossag());
			System.out.println("A torekenyaso hasznalata utan a jobb jegtabla homennyisege " + j2.getHo() + " db");
			System.out.println("A vegen a jatekos targyai: ");
			sk.TargyakListazasa();
			
		}
			
}
