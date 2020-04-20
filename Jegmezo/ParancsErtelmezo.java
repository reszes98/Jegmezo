package Jegmezo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.TreeMap;

public class ParancsErtelmezo {

	private TreeMap<String, Jatekos> jatekosok;
	private TreeMap<String, Jegmezo> jegmezok;
	private TreeMap<String, Jegesmedve> jegesmedvek;
	private TreeMap<String, Jegtabla> jegtablak;
	private boolean running = true;
	
	public ParancsErtelmezo()
	{
	
		
		jatekosok = new TreeMap<>();
		jegmezok = new TreeMap<>();
		jegesmedvek = new TreeMap<>();
		jegtablak = new TreeMap<>();
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
					String[] params = command.split(" ");
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
							Global.out.print("Jatekos sikeresen letrehozva ");
							Global.out.print("Most van: " + jatekosok.size() + " ");
							Global.out.println("Jatekos id =  " + params[1] 
									+ " tipus = " + params[2].toLowerCase() 
									+ " jegmezoid = " + params[3] 
									+ " Munkadb = " + jatekosok.get(params[1]).getMunkadb() 
									+ " testho =  " + jatekosok.get(params[1]).getTestho());
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
					
							jatekosok.get(params[1]).lepes();
							
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
					
					
					
					
					
					
					
					
				}
				else
				{
					System.out.println("Ervenytelen Parancs");
				}
				}else
				{
					running = false;
				}
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
