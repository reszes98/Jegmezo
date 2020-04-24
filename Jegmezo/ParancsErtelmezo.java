package Jegmezo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.TreeMap;

public class ParancsErtelmezo {

	private TreeMap<String, Jatekos> jatekosok;
	private TreeMap<String, Jegmezo> jegmezok;
	private TreeMap<String, Jegesmedve> jegesmedvek;
	private TreeMap<String, Jegtabla> jegtablak;
	private TreeMap<String, Vedelem> vedelmek;
	private TreeMap<String, Targy> targyak;
	private boolean running = true;
	
	public ParancsErtelmezo()
	{
	
		
		jatekosok = new TreeMap<>();
		jegmezok = new TreeMap<>();
		jegesmedvek = new TreeMap<>();
		jegtablak = new TreeMap<>();
		targyak = new TreeMap<>();
	}
	
	public void Run()
	{
		InputStreamReader is = new InputStreamReader(System.in);
		
		BufferedReader br = new BufferedReader(is);
		
	
		try {
			while(running)
			{
				System.out.print("Parancs: ");
				String command = br.readLine();
				
				if(command != null)
				{
					
					this.ExecuteCommand(command);
						
				}
				else
				{
					running = false;
				}
				
				
			
				
			}
				
				
				
					
					
		}
			catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
			
	
		
	}



public void ExecuteCommand(String comm)
{

	String[] params = comm.split(" ");
	if(params.length > 0)
	{
		
			String commandType = params[0];
			
			
			
			
			
			
				if(commandType.toLowerCase().equals("JatekosLetrehoz".toLowerCase()))
				{
					if(jegmezok.get(params[3]) != null)
					{
						Global.out.print("Eddigi játékosok száma: " + jatekosok.size() + " ");
						if(params[2].toLowerCase().contentEquals("eszkimo"))
						{
							
							Eszkimo e = new Eszkimo(jegmezok.get(params[3]), Integer.parseInt(params[4]), Integer.parseInt(params[5]));
							jatekosok.put(params[1], e);
						}
						else if(params[2].toLowerCase().contentEquals("sarkkutato"))
						{
							
							Sarkkutato e = new Sarkkutato(jegmezok.get(params[3]), Integer.parseInt(params[4]), Integer.parseInt(params[5]));
							jatekosok.put(params[1], e);
						}
						else
						{
							Global.out.println("Nem letezik ilyen tipusu jatekos");
						}
						//Global.out.print("Jatekos sikeresen letrehozva ");
						//Global.out.print("Most van: " + jatekosok.size() + " ");
						//Global.out.println("Jatekos id =  " + params[1] 
							//	+ " tipus = " + params[2].toLowerCase() 
							//	+ " jegmezoid = " + params[3] 
							//	+ " Munkadb = " + jatekosok.get(params[1]).getMunkadb() 
								//+ " testho =  " + jatekosok.get(params[1]).getTestho());
					}
					else {
						Global.out.println("Nem letezik ilyen idju Jegmezo");
					}
				}
				
				
				
				
				
				
				
				
				else if(commandType.toLowerCase().equals("JatekosAthelyez".toLowerCase()))
				{
					if(jatekosok.get(params[1]) != null)
					{
						Jatekos j = jatekosok.get(params[1]);
						Jegtabla jegtablaAminAllt = jatekosok.get(params[1]).aktjegtabla;
						Jegtabla szomszed = jegtablaAminAllt.szomszedKerdez(j.getSzogAmibeNez());
						
						Global.out.print("Játékos jegtablaId = " + jegtablaAminAllt.ID 
								+ ". A jégtáblán " + jegtablaAminAllt.getJatekosokSzama() + " db játékos áll " +
								" a " + j.getSzogAmibeNez() + " szogbe levo szomszed id-je: " + szomszed.ID 
								+ " es rajta  " + szomszed.getJatekosokSzama() + "db jatekos all ");
				
						jatekosok.get(params[1]).athelyez(jatekosok.get(params[1]).getSzogAmibeNez());
						
						Global.out.println("Játékos jegtablaId = " + j.aktjegtabla.ID
								+ ". A jégtáblán " + j.aktjegtabla.getJatekosokSzama() + " db játékos áll " +
								" a szomszed,akirol ellepet id-je: " + jegtablaAminAllt.ID 
								+ " es rajta  " + jegtablaAminAllt.getJatekosokSzama() + "db jatekos all ");
						
					}
					else
					{
						Global.out.println("Nem letezik ilyen idju Jatekos");
					}
					
				}
				
				
				
				
				
				
				
				
				
				
				else if(commandType.toLowerCase().equals("JatekosFrissit".toLowerCase()))
				{
					if(jatekosok.get(params[1]) != null)
					{
						Global.out.print("A jatekosnak frissites elott " + jatekosok.get(params[1]).getMunkadb() + "db munkaja van");
						jatekosok.get(params[1]).frissit();
						Global.out.print("A jatekosnak frissites utan " + jatekosok.get(params[1]).getMunkadb() + "db munkaja van");
					}
					else
					{
						Global.out.println("Nem letezik ilyen idju Jatekos");
					}
				}
				
				
				
				
				
				
				
				
				else if(commandType.toLowerCase().equals("JatekosLep".toLowerCase()))
				{
					if(jatekosok.get(params[1]) != null)
					{
						Jatekos j = jatekosok.get(params[1]);
						Jegtabla jegtablaAminAllt = jatekosok.get(params[1]).aktjegtabla;
						Jegtabla szomszed = jegtablaAminAllt.szomszedKerdez(j.getSzogAmibeNez());
						
						Global.out.print("Játékos jegtablaId = " + jegtablaAminAllt.ID 
								+ ". A jégtáblán " + jegtablaAminAllt.getJatekosokSzama() + " db játékos áll " +
								" a " + j.getSzogAmibeNez() + " szogbe levo szomszed id-je: " + szomszed.ID 
								+ " es rajta  " + szomszed.getJatekosokSzama() + "db jatekos all ");
				
						jatekosok.get(params[1]).lepes();
						
						Global.out.println("Játékos jegtablaId = " + j.aktjegtabla.ID
								+ ". A jégtáblán " + jegtablaAminAllt.getJatekosokSzama() + " db játékos áll " +
								" a szomszed,akirol ellepet id-je: " + jegtablaAminAllt.ID 
								+ " es rajta  " + jegtablaAminAllt.getJatekosokSzama() + "db jatekos all ");
					}
						
					else
					{
						Global.out.println("Nem letezik ilyen idju Jatekos");
					}
				}
				
				
				
				
				
				
				
				
				else if(commandType.toLowerCase().equals("JatekosHovihar".toLowerCase()))
				{
					if(jatekosok.get(params[1]) != null)
					{
						Jatekos j = jatekosok.get(params[1]);
						Jegtabla jegtablaAminAllt = jatekosok.get(params[1]).aktjegtabla;
		
						Vedelem v = jegtablaAminAllt.getjegtablaVedelme();
						String jegtablaVedeleme = v == null? "semmi": v.toString();
						
						Global.out.print("A Játékosnak" + j.getTestho() + "testhoje van. Játékos jegtablaId = " + jegtablaAminAllt.ID 
								+ " A jegtablan " + jegtablaVedeleme + "vedelem van ");
				
						jatekosok.get(params[1]).hovihar();
						
						Global.out.print("A Játékosnak" + j.getTestho() + "testhoje van. "
								+ "Játékos jegtablaId = " + jegtablaAminAllt.ID 
								+ " A jegtablan " + jegtablaVedeleme + "vedelem van ");
					}
						
					else
					{
						Global.out.println("Nem letezik ilyen idju Jatekos");
					}
				}
				
				
				
				
				
				
				
				else if(commandType.toLowerCase().equals("JatekosFelvesz".toLowerCase()))
				{
					if(jatekosok.get(params[1]) != null)
					{
						Jatekos j = jatekosok.get(params[1]);
						Jegtabla jegtablaAminAllt = jatekosok.get(params[1]).aktjegtabla;
							
						Targy t  = jegtablaAminAllt.getTargy();
						String targy = t == null? "semmilyen": t.toString();
						j.TargyakListazasa();
						Global.out.print("Játékos jegtablaId = " + jegtablaAminAllt.ID 
								+ " A jegtablan " + targy + " targy van ");
				
						jatekosok.get(params[1]).targyFelvetel();
						
						j.TargyakListazasa();
						
					}
						
					else
					{
						Global.out.println("Nem letezik ilyen idju Jatekos");
					}
				}
				
				
				
				
				
				
				
				
				
				
				else if(commandType.toLowerCase().equals("JatekosKepesseg".toLowerCase()))
				{
					if(jatekosok.get(params[1]) != null)
					{
						Jatekos j = jatekosok.get(params[1]);
						Jegtabla jegtablaAminAllt = jatekosok.get(params[1]).aktjegtabla;
						
						if(j.toString().equals("Eszkimo"))
						{
							
			
							Vedelem v = jegtablaAminAllt.getjegtablaVedelme();
							String jegtablaVedeleme = v == null? "semmi": v.toString();
							Global.out.println("Játékos jegtablaId = " + jegtablaAminAllt.ID 
									+ " A jegtablan " + jegtablaVedeleme + "vedelem van ");
							jatekosok.get(params[1]).kepesseg();
							v = jegtablaAminAllt.getjegtablaVedelme();
							Global.out.println("Játékos jegtablaId = " + jegtablaAminAllt.ID 
									+ " A jegtablan " + jegtablaVedeleme + "vedelem van ");
						}
						else
						{
							Jegtabla szomszed = jegtablaAminAllt.szomszedKerdez(j.getSzogAmibeNez());
							Global.out.println("Játékos jegtablaId = " + jegtablaAminAllt.ID 
									+ " A jegtabla tartokepessege" + szomszed.gettartokepesseg() + " ");
							jatekosok.get(params[1]).kepesseg();
	
						}
							
						
					}
						
					else
					{
						Global.out.println("Nem letezik ilyen idju Jatekos");
					}
				}
				
				
				
				
				
				
				else if(commandType.toLowerCase().equals("JatekosHasznal".toLowerCase()))
				{
					if(jatekosok.get(params[1]) != null)
					{
						int idx = Integer.parseInt(params[2]);
						
						
							
						jatekosok.get(params[1]).targyHasznalat(idx);
							
						
					}
						
					else
					{
						Global.out.println("Nem letezik ilyen idju Jatekos");
					}
				}
				
				
				
				else if(commandType.toLowerCase().equals("JatekosAddTargy".toLowerCase()))
				{
					if(jatekosok.get(params[1]) != null)
					{
						
						
						
						if(targyak.get(params[2]) != null)
						{
							jatekosok.get(params[1]).TargyakListazasa();
							jatekosok.get(params[1]).targyHozzadasa(targyak.get(params[2]));
							jatekosok.get(params[1]).TargyakListazasa();
						}
						else
						{
							Global.out.println("Nem letezik ilyen idju Targy");
						}
							
						
					}
						
					else
					{
						Global.out.println("Nem letezik ilyen idju Jatekos");
					}
				}
				
				
				else if(commandType.toLowerCase().equals("JatekosPrintAttributum".toLowerCase()))
				{
					if(jatekosok.get(params[1]) != null)
					{
						
						String attri = params[2];
						Jatekos j = jatekosok.get(params[1]);
						
						if(attri.toLowerCase().equals("jelzopisztolydb".toLowerCase()))
						{
							Global.out.println("A " + params[1] + " idju jatekos jelzopisztolydarabszama: "
						+ j.getjelzopisztolydb());
						}
						else if(attri.toLowerCase().equals("Munkadb".toLowerCase()))
						{
							Global.out.println("A " + params[1] + " idju jatekos MunkaDB szama: "
									+ j.getMunkadb());
						}
						else if(attri.toLowerCase().equals("testho".toLowerCase()))
						{
							Global.out.println("A " + params[1] + " idju jatekos testhoje: "
									+ j.getTestho());
						}
						else if(attri.toLowerCase().equals("targyak".toLowerCase()))
						{
							Global.out.println("A " + params[1] + " idju jatekos targyai:");
							j.TargyakListazasa();
						}
						
							
						
					}
						
					else
					{
						Global.out.println("Nem letezik ilyen idju Jatekos");
					}
				}
				
				
				
				
				
				
				
				else if(commandType.toLowerCase().equals("JegesmedveLetrehoz".toLowerCase()))
				{
					
						Global.out.println("Jegesmedvek szama: " + jegesmedvek.size());
						jegesmedvek.put(params[1], new Jegesmedve(jegmezok.get(params[2]), false));
						Global.out.println("Jegesmedvek szama: " + jegesmedvek.size());	
					
				}
				
				
				
				
				else if(commandType.toLowerCase().equals("JegesmedveFrissit".toLowerCase()))
				{
					if(jegesmedvek.get(params[1]) != null)
					{
						jegesmedvek.get(params[1]).frissit();
						
					}
					else
					{
						Global.out.println("Nem letezik ilyen idju Jegesmedve");
					}
						
				}
				
				
				else if(commandType.toLowerCase().equals("JegmezoLetrehoz".toLowerCase()))
				{
					
					
					
					int hoviharCnt = params.length < 3? 4 : Integer.parseInt(params[2]); 
					jegmezok.put(params[1], new Jegmezo(hoviharCnt));
					Jegmezo jm = jegmezok.get(params[1]);
					
					if(jm == null)
					{
						Global.out.println("A jegmezot nem sikerult letrehozni");
					}
					else 
					{
						Global.out.println("A jegmezot nem sikerult letrehozni " + jm.getHoviharCnt() + " hoviharCntvel" );
					}
	
				}
				
				
				
				else if(commandType.toLowerCase().equals("JegtablaLetrehoz".toLowerCase()))
				{
					
					
					boolean atVanFordulva = params[3].equals("0");
					int ho = Integer.parseInt(params[4]);
					int tartokepesseg =  Integer.parseInt(params[5]);
					
					int szomszedokSzama = params.length < 7? 4 : Integer.parseInt(params[6]);
					
					jegtablak.put(params[1], new Jegtabla(params[1], jegmezok.get(params[2]), atVanFordulva,ho, tartokepesseg,szomszedokSzama));
					
					Jegtabla j = jegtablak.get(params[1]);
					
					if(j == null)
					{
						Global.out.println("A jegtablat nem sikerult letrehozni");
					}
					else
					{
						Global.out.println("A jegtablat nem sikerult letrehozni.\n"
						+ "Parameterek: " 
						+ "At van fordulva? " + j.getAtVanFordulva() + " "
						+ j.getHo() + "db ho van rajta  "
						+ "tartokepessege: " + j.gettartokepesseg()
						+ " es " + j.getSzomszedokSzama() + " a szomszedainak a szama"
						);
					}
	
				}
				
				
				else if(commandType.toLowerCase().equals("JegtablaFrissit".toLowerCase()))
				{
					
					
					if(jegtablak.get(params[1]) != null)
					{
						jegtablak.get(params[1]).frissit();
						
					}
					else
					{
						Global.out.println("Nem letezik ilyen idju Jegtabla");
					}
	
				}
				
				
				else if(commandType.toLowerCase().equals("JegtablaHovihar".toLowerCase()))
				{
					
					
					if(jegtablak.get(params[1]) != null)
					{
						jegtablak.get(params[1]).hovihar();
						
					}
					else
					{
						Global.out.println("Nem letezik ilyen idju Jegtabla");
					}
	
				}
				
				
				else if(commandType.toLowerCase().equals("JegtablaAtfordit".toLowerCase()))
				{
					
					
					if(jegtablak.get(params[1]) != null)
					{
						String atfordulva=jegtablak.get(params[1]).getAtVanFordulva() ? " at van fordulva. ":"nincs atforulva. ";
						Global.out.println("A " + params[1] + " idju jegtabla at van fordulva? " 
					+ atfordulva);
						
						Global.out.println("A " + params[1] + " idju jegtablat most atforditom");
						
						jegtablak.get(params[1]).atfordit();
						
						String atfordulva2=jegtablak.get(params[1]).getAtVanFordulva() ? " at van fordulva. ":"nincs atforulva. ";
						Global.out.println("A " + params[1] + " idju jegtabla at van fordulva? " 
					+ atfordulva2);
						
					}
					else
					{
						Global.out.println("Nem letezik ilyen idju Jegtabla");
					}
	
				}
				
				
				else if(commandType.toLowerCase().equals("JegtablaAddJatekos".toLowerCase()))
				{
					
					
					if(jegtablak.get(params[1]) != null)
					{
						
						if(jatekosok.get(params[2]) != null)
						{
							jegtablak.get(params[1]).addJatekos(jatekosok.get(params[2]));
							
						}
						else
						{
							Global.out.println("Nem letezik ilyen idju Jatekos");
						}
						
					}
					else
					{
						Global.out.println("Nem letezik ilyen idju Jegtabla");
					}
	
				}
				
				
				
				else if(commandType.toLowerCase().equals("JegtablaAddJegesmedve".toLowerCase()))
				{
					
					
					if(jegtablak.get(params[1]) != null)
					{
						
						if(jegesmedvek.get(params[2]) != null)
						{
							jegtablak.get(params[1]).addJegesmedve(jegesmedvek.get(params[2]));
							
						}
						else
						{
							Global.out.println("Nem letezik ilyen idju Jegesmedve");
						}
						
					}
					else
					{
						Global.out.println("Nem letezik ilyen idju Jegtabla");
					}
	
				}
				
				
				
				else if(commandType.toLowerCase().equals("JegtablaSetVedelem".toLowerCase()))
				{
					
					
					if(jegtablak.get(params[1]) != null)
					{
						
						if(vedelmek.get(params[2]) != null)
						{
							jegtablak.get(params[1]).setjegtablaVedelme(vedelmek.get(params[2]));
							
						}
						else
						{
							Global.out.println("Nem letezik ilyen idju Vedelem");
						}
						
					}
					else
					{
						Global.out.println("Nem letezik ilyen idju Jegtabla");
					}
	
				}
				
				
				
				else if(commandType.toLowerCase().equals("JegtablaPrintAttributum".toLowerCase()))
				{
					
					
					if(jegtablak.get(params[1]) != null)
					{
						
						String attri = params[2];
						Jegtabla j = jegtablak.get(params[1]);
						
						if(attri.toLowerCase().equals("atVanFordulva".toLowerCase()))
						{
							Global.out.println("A " + params[1] + " idju jegtabla at van fordulva? "
						+ j.getAtVanFordulva());
						}
						else if(attri.toLowerCase().equals("ho".toLowerCase()))
						{
							Global.out.println("A " + params[1] + " idju jegtabla ho mennyisege: "
									+ j.getHo());
						}
						else if(attri.toLowerCase().equals("vedelem".toLowerCase()))
						{
							String vedelem = j.getjegtablaVedelme() == null? "Semmi": j.getjegtablaVedelme().toString();
							Global.out.println("A " + params[1] + " idju jegtabla vedeleme: "
									+ vedelem);
						}
						else if(attri.toLowerCase().equals("jatekosCnt".toLowerCase()))
						{
							Global.out.println("A " + params[1] + " idju jegtablan " +
							j.getJatekosokSzama() + " db jatekos all");
						}
						
						else if(attri.toLowerCase().equals("vanERajtaTargy".toLowerCase()))
						{
							String targy = j.getTargy() == null? "Semmi" : j.getTargy().toString();
							Global.out.println("A " + params[1] + " idju jegtabla targya: "
							+targy);
						}
						
					}
					else
					{
						Global.out.println("Nem letezik ilyen idju Jegtabla");
					}
	
				}
				
				
				
				
				
				
				
				
				
				
	
				else if(commandType.toLowerCase().equals("JegtablaSetSzomszed".toLowerCase()))
				{
					
					
					if(jegtablak.get(params[1]) != null)
					{
						
						if(jegtablak.get(params[2]) != null)
						{
							Global.out.println("Most a" +  params[1] +
									" idju jegtabla szomszedjat fogjuk allitani");
							
							int hanyadikSzomszed = Integer.parseInt(params[3]);
							int melyikszogbeASzomszedja = Integer.parseInt(params[4]);
							jegtablak.get(params[1]).setSzomszed(jegtablak.get(params[2]), hanyadikSzomszed, melyikszogbeASzomszedja);
							
							
							Global.out.println("A" +  params[1] +
									" idju jegtabla  a " + melyikszogbeASzomszedja 
									+ " szogbe levo szomszedjanak az IDje:  " 
									+ jegtablak.get(params[1]).szomszedKerdez(melyikszogbeASzomszedja).ID
									);
						}
						else
						{
							Global.out.println("Nem letezik ilyen idju Jegtabla");
						}
	
					
						
					}
					else
					{
						Global.out.println("Nem letezik ilyen idju Jegtabla");
					}
	
				}
				
				
				
				
				
				else if(commandType.toLowerCase().equals("JegtablaSetTargy".toLowerCase()))
				{
					
					
					if(jegtablak.get(params[1]) != null)
					{
						
						if(targyak.get(params[2]) != null)
						{
							Global.out.println("Most a" +  params[1] +
									" idju jegtabla targyat fogjuk allitani");
							
			
							jegtablak.get(params[1]).setTargy(targyak.get(params[2]));
							
							String targy = jegtablak.get(params[1]).getTargy() == null? "Semmi": jegtablak.get(params[1]).getTargy().toString();
							Global.out.println("A" +  params[1] +
									" idju jegtabla targya: "
									+ targy
									);
						}
						else
						{
							Global.out.println("Nem letezik ilyen idju Targy");
						}
	
						
					}
					else
					{
						Global.out.println("Nem letezik ilyen idju Jegtabla");
					}
	
				}
				
				
				
				
				else if(commandType.toLowerCase().equals("VedelemLetrehoz".toLowerCase()))
				{
					
					if(params[2].toLowerCase().equals("Iglu".toLowerCase()))
					{
						vedelmek.put(params[1], new Iglu());
						Global.out.println("Iglu hozzadva " + params[1] + " idvel");
					}
					else if(params[2].toLowerCase().equals("Sator".toLowerCase()))
					{
						vedelmek.put(params[1], new Sator(1));
						Global.out.println("Sator hozzadva " + params[1] + " idvel");
					}
					else
					{
						Global.out.println("Nem letezik ilyen tipusu vedelem");
					}
	
				}
				
				
				else if(commandType.toLowerCase().equals("TargyLetrehoz".toLowerCase()))
				{
					
					if(params[2].toLowerCase().equals("Aso".toLowerCase()))
					{
						targyak.put(params[1], new Aso());
						Global.out.println("Aso hozzadva " + params[1] + " idvel");
					}
					else if(params[2].toLowerCase().equals("Buvarruha".toLowerCase()))
					{
						targyak.put(params[1], new Buvarruha());
						Global.out.println("Buvarruha hozzadva " + params[1] + " idvel");
					}
					else if(params[2].toLowerCase().equals("Elelem".toLowerCase()))
					{
						targyak.put(params[1], new Elelem(1));
						Global.out.println("Elelem hozzadva " + params[1] + " idvel");
					}
					
					else if(params[2].toLowerCase().equals("Jelzopisztoly".toLowerCase()))
					{
						vedelmek.put(params[1], new Sator(1));
						Global.out.println("Jelzopisztoly hozzadva " + params[1] + " idvel");
					}
					
					else if(params[2].toLowerCase().equals("Kotel".toLowerCase()))
					{
						targyak.put(params[1], new Kotel());
						Global.out.println("Kotel hozzadva " + params[1] + " idvel");
					}
					else if(params[2].toLowerCase().equals("Sator".toLowerCase()))
					{
						targyak.put(params[1], new Sator(1));
						Global.out.println("Sator hozzadva " + params[1] + " idvel");
					}
					else if(params[2].toLowerCase().equals("TorekenyAso".toLowerCase()))
					{
						targyak.put(params[1], new TorekenyAso(3));
						Global.out.println("TorekenyAso hozzadva " + params[1] + " idvel");
					}
					else
					{
						Global.out.println("Nem letezik ilyen tipusu Targy");
					}
	
				}
				
				
				
				
				
				
				
				
				else if(commandType.toLowerCase().equals("TesztEsetEleje".toLowerCase()))
				{
					
					
					String outPath = params[1] +".output";
					try
					{
						
						Global.out.println("Mostantol a kimenet a " + outPath  +" fajlba kerul");
						File outfile = new File(outPath);
						FileOutputStream tesztOutputStream =  new FileOutputStream(outfile);
						Global.out = new PrintStream(tesztOutputStream);
						
					}
					catch(NullPointerException e)
					{
						System.out.println(e.getMessage());
					}
					catch(FileNotFoundException e)
					{
						System.out.println(e.getMessage());
					}
					
					
					
					
	
				}
				
				
				
				
				
				
				
				
				
				
				else if(commandType.toLowerCase().equals("TesztEsetVege".toLowerCase()))
				{
					
					
					Global.out.close();
					Global.out = System.out;
					Global.out.println("Mostantol a  kiemnet megint a konzolra kerul");	
					
	
				}
				
				
				else if(commandType.toLowerCase().equals("LoadTesztEset".toLowerCase()))
				{
					try
					{
						String inPath = params[1] +".input";
						File infile = new File(inPath);
						FileInputStream tesztInputStream = new FileInputStream(infile);
						InputStreamReader is = new InputStreamReader(tesztInputStream);
						BufferedReader br = new BufferedReader(is);
						
						String commandInFile; 
						
						try {
							while((commandInFile = br.readLine()) != null)
							{
								ExecuteCommand(commandInFile);
							}
							
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					catch(NullPointerException e)
					{
						System.out.println(e.getMessage());
					}
					catch(FileNotFoundException e)
					{
						System.out.println(e.getMessage());
					}
					
					
				}
				
				else
				{
					System.out.println("Ervenytelen Parancs");
				}
				
				
				
		}
		else
		{
			System.out.println("Ervenytelen Parancs");
		}
}

}
