package Jegmezo;

import java.util.List;
import java.util.Random;

public class Jegesmedve implements Frissitheto{

	private Jegmezo jegmezo;
	private Jegtabla jegtablaAminAll;
	private Irany iranyAmibeNez;
	boolean randomMegy;
	
	
	public Jegesmedve(Jegmezo jegmezo, Irany iranyAmibeNez, boolean randomMegy)
	{
		this.jegmezo = jegmezo;
		this.iranyAmibeNez = iranyAmibeNez;
		this.randomMegy = randomMegy;
		this.jegmezo.addFrissitheto(this);
		System.out.println("Letrehoztak egy jegesmedvet");
	}
	
	
	
	/**
	 * Minden k�r elj�n h�v�dik meg �s megh�vja a L�p f�ggv�nyt
	 */
	public void frissit() {
		System.out.println("A jegemedve most lepni fog");
		Lep();
	}

	
	/**
	 * Akkor h�v�dik meg, ha h�vihar van a J�gmez�n, m�g nem csin�l semmit, de k�s�bb ak�r, m�g lehet, hogy lesz valami szerepe
	 */
	public void hovihar() {
		System.out.println("A jegemedve epp hoviharban van");
		
	}
	
	/**
	 * Be�ll�tja egy random �rt�kre, ha be van �ll�tva a randomMegy, az iranyAmibeNez-t �s l�p egyet az �gy kapott ir�nyba, majd 
	 * megn�zi, hogy az �j j�gt�bl�n milyen v�delem van �s ha nem null megh�vja a t�mad�s f�ggv�nyt mag�val, ha null, akkor a j�gt�bl�n l�v� �sszes j�t�kossal megh�vja a j�gmez� meghalt f�ggv�ny�t
	 */
	public void Lep()
	{
		System.out.println("Most a jegesmedve lepesre keszul");
		//https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
		//innen t�j�koz�dtam a randomokr�l
		if(randomMegy)
		{
			System.out.println("Most a jegesmedve epp egy random iranyt valaszt, amerre menni fog");
			Random r = new Random();
			
			int intErtek = r.nextInt(4);
			Irany ujIranyAmibeNez = Irany.IranyIntErtekAlapjan(intErtek);
			iranyAmibeNez = ujIranyAmibeNez;
		}
		
		System.out.println("Most lekerdezi a jegesmedve, hogy abba az iranyba, amerre menni akar milyen jegtabla all");
		Jegtabla sz = jegtablaAminAll.szomszedKerdez(iranyAmibeNez);
		

		if(sz != null)
		{
			System.out.println("Most a jegesmedve eltavolitja magat a jegtablarol, amin eddig allt");
			jegtablaAminAll.JegesmedveEltavolit(this);
			System.out.println("Most a jegesmedve hozzaadja magat a szomszedos jegtablahoz, amire ra akar lepni");
			sz.addJegesmedve(this);
		}
		else
		{
			System.out.println("Az irany amibe a jegesmedve menni akar nincs jegtabla, ezert lepest befejezte es ugyanott maradt");
			return;
			
		}
		System.out.println("Most a  jegesmedve annak a jegtablanak kerdezi a vedelmet, amire epp ralepett");
		Vedelem v = sz.getjegtablaVedelme();
		if(v != null)
		{
			System.out.println("Van vedelme, ezert meghivja ra magaval a tamadas fuggvenyt");
			v.tamadas(this);
		}
		else
		{
			System.out.println("Nincs vedelme, ezert meghivja ra az osszes jatekosra, aki a jegtablan van a meghalt fuggvenyt");
			List<Jatekos> jatekosok = jegtablaAminAll.jatekosokLekerdez();
			
				for(int i = 0; i < jatekosok.size(); i++)
				{
					System.out.println("A jegesmedve megevett egy jatekost");
					jegmezo.meghalt(jatekosok.get(i));
				}
			
				if(jatekosok.size() == 0)
					System.out.println("A jegesmedve nem evett meg senkit");
		}
		
		
		
	}
	
	/**
	 * Be�ll�tja, hogy melyik j�gt�bl�n �ll a Jegesmedve
	 * @param jt - a j�gt�bla, amire szeretn�nk r�rakni a Jegesmedv�t
	 */
	public void setjegtablaAminAll(Jegtabla jt)
	{
		System.out.println("Nekem a jegesmedvenek, epp a jegtablat allitjak, amin allok");
		jegtablaAminAll  = jt;
	}
	
	/**
	 * �t�ll�tja a Jegesmedve 
	 * @param i - Az ir�ny, amibe szeretn�nk, hogy n�zzen a Jegesmedv�nk
	 */
	public void setiranyAmibeNez(Irany i)
	{
		System.out.println("Nekem a jegesmedvenek, epp azt allitjak, hogy merre nezek");
		iranyAmibeNez = i;
	}
	
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Jegesmedve";
	}

}
