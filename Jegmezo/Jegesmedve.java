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
	}
	
	
	
	/**
	 * Minden k�r elj�n h�v�dik meg �s megh�vja a L�p f�ggv�nyt
	 */
	public void frissit() {
		// TODO Auto-generated method stub
		System.out.println("A jegemedve most lepni fog");
		Lep();
	}

	
	/**
	 * Akkor h�v�dik meg, ha h�vihar van a J�gmez�n, m�g nem csin�l semmit, de k�s�bb ak�r, m�g lehet, hogy lesz valami szerepe
	 */
	public void hovihar() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Be�ll�tja egy random �rt�kre, ha be van �ll�tva a randomMegy, az iranyAmibeNez-t �s l�p egyet az �gy kapott ir�nyba, majd 
	 * megn�zi, hogy az �j j�gt�bl�n milyen v�delem van �s ha nem null megh�vja a t�mad�s f�ggv�nyt mag�val, ha null, akkor a j�gt�bl�n l�v� �sszes j�t�kossal megh�vja a j�gmez� meghalt f�ggv�ny�t
	 */
	public void Lep()
	{
		//https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
		//innen t�j�koz�dtam a randomokr�l
		if(randomMegy)
		{
			Random r = new Random();
			
			int intErtek = r.nextInt(4);
			Irany ujIranyAmibeNez = Irany.IranyIntErtekAlapjan(intErtek);
			iranyAmibeNez = ujIranyAmibeNez;
		}
		
		Jegtabla sz = jegtablaAminAll.szomszedKerdez(iranyAmibeNez);
		jegtablaAminAll.JegesmedveEltavolit(this);
		sz.addJegesmedve(this);
		
		Vedelem v = sz.getjegtablaVedelme();
		if(v != null)
			v.tamadas(this);
		else
		{
			List<Jatekos> jatekosok = jegtablaAminAll.jatekosokLekerdez();
			
				for(int i = 0; i < jatekosok.size(); i++)
				{
					System.out.println("A jegesmedve megevett egy jatekost");
					jegmezo.meghalt(jatekosok.get(i));
				}
			
		}
		
		
		
	}
	
	/**
	 * Be�ll�tja, hogy melyik j�gt�bl�n �ll a Jegesmedve
	 * @param jt - a j�gt�bla, amire szeretn�nk r�rakni a Jegesmedv�t
	 */
	public void setjegtablaAminAll(Jegtabla jt)
	{
		jegtablaAminAll  = jt;
	}
	
	/**
	 * �t�ll�tja a Jegesmedve 
	 * @param i - Az ir�ny, amibe szeretn�nk, hogy n�zzen a Jegesmedv�nk
	 */
	public void setiranyAmibeNez(Irany i)
	{
		iranyAmibeNez = i;
	}

}
