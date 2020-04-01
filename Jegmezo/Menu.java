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
					+ "18 - Jatekos Athelyez \n"
					+ "19 - Jatekos hovihar \n"
					+ "20 - Jatekos Lep \n"
					+ "21 - Eszkimo kepesseg \n"
					+ "22 - Iglu hovihar \n"
					+ "23 - Iglu frissit \n"
					+ "24 - Iglu jegesmedve tamadas \n"
					+ "25 - Jatekos frissit \n"
					+ "26 - Jegesmedve frissit \n"
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
			Jegtabla j1 = new Jegtabla(jm, false, 1, 55, null, null);
			Sarkkutato sk = new Sarkkutato(jm, 55,55,55, null, Irany.Bal);
			j1.addJatekos(sk);
			
			Jegtabla j2 = new Jegtabla(jm, false, 0, 55, null, null);
			Eszkimo e = new Eszkimo(jm, 55,55,55, null, Irany.Bal);
			j2.addJatekos(e);
			
			Jegtabla j3 = new Jegtabla(jm, false, -1, 55, null, null);
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
		
		public static void AsotHasznal(int eset)
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, false, 28, 55, null, null);
			Jegtabla j1 = new Jegtabla(jm, false, 2, 55, null, null);
			Jegtabla j2 = new Jegtabla(jm, false, 1, 55, null, null);
			Jegtabla j3 = new Jegtabla(jm, false, 0, 55, null, null);
			
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
				sk.targyHasznalat(0);
				System.out.println("Most " + j2.getHo() + " db ho van a jegtablan");
			}
			else if(eset == 3)
			{
				System.out.println("Kezdetben a jegtablan a " + j3.getHo()  + " db ho van");
				
				System.out.println("Most a jatekos megprobalja hasznalni az asot");
				sk.targyHasznalat(0);
				System.out.println("Most " + j3.getHo() + " db ho van a jegtablan");
			}
			
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
		
		public static void ElelemHasznal(int eset)
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, true, -1, 0, null, null);
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
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, true, -1, 0, null, null);
			Iglu i = new Iglu();
			
			j.setjegtablaVedelme(i);
			
			j.hovihar();		
		
		}
		
		public static void IgluFrissit()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegtabla j = new Jegtabla(jm, true, -1, 0, null, null);
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
			Jegtabla j = new Jegtabla(jm, true, -1, 2, null, null);
			Jegtabla j1 = new Jegtabla(jm, true, -1, 1, null, null);
			Jegtabla j2 = new Jegtabla(jm, true, -1, 0, null, null);
			
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
			
			Jegtabla j = new Jegtabla(jm, true, -1, 2, null, null);
			Jegtabla j1 = new Jegtabla(jm, true, -1, 1, new Iglu(), null);
			Jegtabla j2 = new Jegtabla(jm, true, -1, 1, new Sator(1), null);
			
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
				Jegtabla j = new Jegtabla(jm, false, -1, 2, null, null);
				Jegtabla j1 = new Jegtabla(jm, false, -1, 1, null, null);
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
				Jegtabla j = new Jegtabla(jm, false, -1, 1, null, null);
				Jegtabla j1 = new Jegtabla(jm, false, -1, 0, null, null);
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
				Jegtabla j = new Jegtabla(jm, true, -1, 0, null, null);
				Jegtabla j1 = new Jegtabla(jm, false, -1, 0, null, null);
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
			
			Jegtabla j = new Jegtabla(jm, true, -1, 2, null, null);
			Jegtabla j2 = new Jegtabla(jm, true, -1, 2, null, null);
			j.setSzomszed(j2,Irany.Bal);
			
			if(eset == 1)
			{
				Jegtabla j1 = new Jegtabla(jm, true, -1, 1, new Iglu(), null);
				j.setSzomszed(j1,Irany.Jobb);
				jeges.frissit();
				
			}
			else if(eset == 2)
			{
				Jegtabla j1 = new Jegtabla(jm, true, -1, 1, new Sator(1), null);
				j.setSzomszed(j1,Irany.Jobb);
				jeges.frissit();
			}
			else if(eset == 3)
			{
				Jegtabla j1 = new Jegtabla(jm, true, -1, 1, null, null);
				j.setSzomszed(j1,Irany.Jobb);
				jeges.frissit();
			}
			else if(eset == 4)
			{

				jeges.setiranyAmibeNez(Irany.Bal);
				jeges.frissit();
			}
		}
		
		public static void JegesmedveHovihar()
		{
			Jegmezo jm = new Jegmezo(10);
			Jegesmedve jeges = new Jegesmedve(jm, Irany.Jobb, false);
			jeges.hovihar();
			
		}
		
		
		public static void JegtablaHovihar(int eset)
		{
			
			if(eset == 1)
			{
				satras
			}
			else if(eset == 2)
			{
				iglus
			}
			
		}
		
		public static void JegtablaFrissit(int eset)
		{
			if(eset == 1)
			{
				atfordulva jatekosok meghal
			}
			else if(eset == 2)
			{
				visszafordul
			}
			else if(eset == 3)
			{
				frissit iglu
			}
			else if(eset == 4)
			{
				frissit null
			}
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
