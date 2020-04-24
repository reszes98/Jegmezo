package Jegmezo;

import java.util.List;
import java.util.Random;

public class Jegesmedve implements Frissitheto{

	private Jegmezo jegmezo;
	private Jegtabla jegtablaAminAll;
	private int szogAmibeNez;
	boolean randomMegy;
	
	
	public Jegesmedve(Jegmezo jegmezo, boolean randomMegy)
	{
		this.jegmezo = jegmezo;
		this.randomMegy = randomMegy;
		this.jegmezo.addFrissitheto(this);
		String megy=randomMegy ? "random megy. ":"nem megy random. ";
		Global.out.print("Letrehoztak egy jegesmedvet. A jegesmedve " + megy);
	}
	
	
	
	/**
	 * Minden k�r elj�n h�v�dik meg �s megh�vja a L�p f�ggv�nyt
	 */
	public void frissit() {
		Lep();
		Global.out.print("Jegesmedve sikeresen frissitve. ");
	}

	
	/**
	 * Akkor h�v�dik meg, ha h�vihar van a J�gmez�n, m�g nem csin�l semmit, de k�s�bb ak�r, m�g lehet, hogy lesz valami szerepe
	 */
	public void hovihar() {
	
		
	}
	
	/**
	 * Be�ll�tja egy random �rt�kre, ha be van �ll�tva a randomMegy, az iranyAmibeNez-t �s l�p egyet az �gy kapott ir�nyba, majd 
	 * megn�zi, hogy az �j j�gt�bl�n milyen v�delem van �s ha nem null megh�vja a t�mad�s f�ggv�nyt mag�val, ha null, akkor a j�gt�bl�n l�v� �sszes j�t�kossal megh�vja a j�gmez� meghalt f�ggv�ny�t
	 */
	public void Lep()
	{
		String megy=randomMegy ? "random megy. ":"nem megy random. ";
		Global.out.print("A jegesmedve " + megy);
		//https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
		//innen t�j�koz�dtam a randomokr�l
		if(randomMegy)
		{
			
			//Random r = new Random();
			
			//int intErtek = r.nextInt(4);
			/*Irany ujIranyAmibeNez = Irany.IranyIntErtekAlapjan(intErtek);
			iranyAmibeNez = ujIranyAmibeNez;*/ // �J
		}
		
		
		Jegtabla sz = jegtablaAminAll.szomszedKerdez(szogAmibeNez);
		Global.out.print("A jegesmedve "+sz+" iranyba nez. ");

		if(sz != null)
		{
			
			jegtablaAminAll.JegesmedveEltavolit(this);
			sz.addJegesmedve(this);
			jegtablaAminAll=sz;
			Global.out.print("A jegesmedve "+sz+" iranyba nez. ");
		}
		else
		{
			Global.out.print("Az irany amibe a jegesmedve menni akar nincs jegtabla, ezert lepest befejezte es ugyanott maradt. ");
			return;
			
		}
		
		Vedelem v = jegtablaAminAll.getjegtablaVedelme();
		if(v != null)
		{
			Global.out.print("A jegtablanak van vedelme. ");
			v.tamadas(this);
		}
		else
		{
			Global.out.print("A jegtablanak nincs vedelme. ");
			List<Jatekos> jatekosok = jegtablaAminAll.jatekosokLekerdez();
			
				for(int i = 0; i < jatekosok.size(); i++)
				{
					
					jegmezo.meghalt(jatekosok.get(i));
				}
			
				if(jatekosok.size() == 0)
					Global.out.print("A jegesmedve nem evett meg senkit. ");
				else 
					Global.out.print("A  jegesmedve sikeresen megette a jatekoskat. ");
		}
		
		
		
	}
	
	
	/**
	 * �t�ll�tja a Jegesmedve 
	 * @param i - Az ir�ny, amibe szeretn�nk, hogy n�zzen a Jegesmedv�nk
	 */
	public void setSzogAmibeNez(int szog)
	{
		
		szogAmibeNez = szog;
	}
	
	
	/**
	 * Be�ll�tja, hogy melyik j�gt�bl�n �ll a Jegesmedve
	 * @param jt - a j�gt�bla, amire szeretn�nk r�rakni a Jegesmedv�t
	 */
	public void setjegtablaAminAll(Jegtabla jt)
	{
		
		jegtablaAminAll  = jt;
		Global.out.print("Jegesmedve jegtablaja sikeresen beallitva. ");
	}
	
	
	
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Jegesmedve";
	}

}
