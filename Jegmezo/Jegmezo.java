package Jegmezo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 * @author Henrik
 * A j�t�kban l�v� J�gmez�t reprezent�lja
 */
public class Jegmezo
{
	/**
	 * Azt adja meg, hogy h�ny k�r van a k�vetkez� h�viharig
	 */
	private int hoviharCnt;
	
	/**
	 * A j�gmez�n l�v� friss�thet�k
	 */
	private List<Frissitheto> frissithetok;
	
	/**
	 * A j�gmez�n l�v� j�t�kosok
	 */
	private List<Jatekos> jatekosok;
	
	/**
	 * Azt t�rolja, hogy v�get �rt-e a j�t�k
	 */
	private boolean VegeAjateknak;
	
	
	/**
	 * a konstruktor, ami l�trehozza a J�gez�t a megadott param�terekkel 
	 * @param hoviharCnt - kezdetben h�ny k�r van a h�viharig
	 */
	public Jegmezo(int hoviharCnt)
	{
		this.hoviharCnt = hoviharCnt;
		frissithetok = new ArrayList<>();
		jatekosok = new ArrayList<>();
		VegeAjateknak = false;
		Global.out.print("Sikeresen letrehoztak egy jegmezot. Hovihar: "+hoviharCnt
				+" mulva lesz. ");
	}
	
	/**
	 * Felveszi a frissithetok k�z� a param�terben megadott frissithetot
	 * @param f - a friss�thet�, amit fel akarunk venni
	 */
	public void addFrissitheto(Frissitheto f)
	{
		
		frissithetok.add(f);
		Global.out.print("Sikeresen hozz�adva a j�gmez�h�z az �j frissithet�. ");
		
	}
	
	
	/**
	 * Felveszi a jatekosok koze a param�terben megadott jatekost
	 * @param j - a jatekos, akit fel akarunk venni
	 */
	public void addJatekos(Jatekos j)
	{
		
		jatekosok.add(j);
		Global.out.print("Jatekos sikeresen hozz�adva a j�gmez�h�z. ");
		
	}
	

	
	
	/**
	 * @param nyert  ha igaz �rt�ket kap nyert�nk, ha hamisat vesztett�nk, a j�t�knak v�ge.
	 */
	public void jatekvege(boolean nyert)
	{
		Global.out.print("Vege a jateknak. ");
		if(!nyert) 
			Global.out.print("Sajnos vesztettetek. ");
		else 
			Global.out.print("Nyertetetek! ");
		VegeAjateknak = true;
	}
	
	/**
	 * A frisi�thet�ket friss�ti, �s ha a h�vihar sz�m�l� null�ra v�lt megh�vja a h�vihar f�ggv�ny�t 
	 * a frisi�thet�knek. �s vissza�ll�tja a h�vihar sz�m�l�t
	 */
	public void leptet()
	{
		
				Global.out.print("Uj kor kezdodott. ");
				hoviharCnt--;
				
				
				if(hoviharCnt==0)
				{	
					for(int i=0;i<frissithetok.size();i++) 
						frissithetok.get(i).hovihar();
				} 
				for(int i=0;i<frissithetok.size();i++) {
					frissithetok.get(i).frissit();
				}
				
				Random r=new Random();
				if(hoviharCnt==0)hoviharCnt = r.nextInt(5)+1;
			
		
			
			Global.out.print("Jegmezo: az ujabb hoviharig " + hoviharCnt + "db kor van hatra. ");
		
	}
	
	/**
	 * @param j ha meghalt egy j�t�kos v�ge a j�t�knak, megh�vja ezt a f�ggv�nyt false �rt�kkel
	 */
	public void meghalt(Jatekos j)
	{
		Global.out.print("Egy jatekos meghalt. ");
		this.jatekvege(false);
	}
	
	
	/**
	 * Megkonstru�lja a j�gmez�t a megadott param�terekkel
	 * @param jegtablakSzamaSzelteben - h�ny j�gt�bl�t t�roljon a j�gmez� a v�zszintes s�kon
	 * @param jegtablakSzamaHosszaban - h�ny j�gt�bl�t t�roljon a j�gmez� a f�gg�leges s�kon
	 * @param eszkimokSzama - azt adja meg, hogy h�ny eszkim� legyen a j�gemez�n, a sarrkkutatokSzama-val egy�tt nem haladhatja meg a t�zet 
	 * @param sarrkkutatokSzama - azt adja meg, hogy h�ny sarkkutat� legyen a j�gemez�n, a eszkimokSzama-val egy�tt nem haladhatja meg a t�zet 
	 */
	public void setup( int jegtablakSzamaSzelteben, int jegtablakSzamaHosszaban, int eszkimokSzama, int sarrkkutatokSzama)
	{
		
		Jegtabla jgk[][] = new Jegtabla[jegtablakSzamaHosszaban][jegtablakSzamaSzelteben];
		
		//incializaljuk a jegtablakat
		for(int i = 0; i < jegtablakSzamaHosszaban; i++)
		{
			for(int j = 0; j < jegtablakSzamaSzelteben; j++)
			{
				jgk[i][j] = new Jegtabla(this, false, 5, 2, 4); // TODO: itt majd randomizalni kell a homennyiseget, tartokepesseget es a targyat
			}
		}
		
		//ujra bejarjuk es beallitjuk a szomszedokat
		for(int i = 0; i < jegtablakSzamaHosszaban; i++)
		{
			for(int j = 0; j < jegtablakSzamaSzelteben; j++)
			{
					Jegtabla sz0 = j + 1 < jegtablakSzamaSzelteben? jgk[i][j + 1] : null;
					Jegtabla sz1 = j - 1 >= 0? jgk[i][j - 1] : null;
					Jegtabla sz2 = i - 1 >= 0? jgk[i - 1][j] : null;
					Jegtabla sz3 = i + 1 < jegtablakSzamaHosszaban? jgk[i + 1][j] : null;
					jgk[i][j].setSzomszed(sz0,0, 0);
					jgk[i][j].setSzomszed(sz1,1,180);
					jgk[i][j].setSzomszed(sz2, 2,90);
					jgk[i][j].setSzomszed(sz3, 3,270);
			}
		}
		
		Random r  = new Random();
		for(int i = 0; i < eszkimokSzama; i++)
		{
			Eszkimo e = new Eszkimo(this, 4, 5);
			
			jgk[r.nextInt(jegtablakSzamaHosszaban)][r.nextInt(jegtablakSzamaSzelteben)].addJatekos(e);
			
		}
		
		for(int i = 0; i < sarrkkutatokSzama; i++)
		{
			Sarkkutato sk = new Sarkkutato(this, 4, 4);
			jgk[r.nextInt(jegtablakSzamaHosszaban)][r.nextInt(jegtablakSzamaSzelteben)].addJatekos(sk);
		}
		
		Global.out.print("Jatek sikeresen letrehozva. ");
	}
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Jegmezo";
	}
	
	/**
	 * @return Visszaadja a hoviharCnt attrib�tumot
	 */
	public int getHoviharCnt()
	{
		return hoviharCnt;
	}
	
	/**
	 * @return Visszaadja a j�gemz�n l�v� j�t�kosok sz�m�t
	 */
	public int GetJatekosSzam()
	{
		return jatekosok.size();
	}
	
	
	/**
	 * @return Visszaadja a j�gemz�n l�v� j�t�kosok list�j�t
	 */
	public List<Jatekos> getJatekosok(){
		return jatekosok;
	}
	
	/**
	 * @return Visszaadja, hogy v�get �rt-e a j�t�k
	 */
	public boolean getJatekvege(){
		return VegeAjateknak;
	}
}
