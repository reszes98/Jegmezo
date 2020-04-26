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
	 * Minden kör eljén hívódik meg és meghívja a Lép függvényt
	 */
	public void frissit() {
		Lep();
		Global.out.print("Jegesmedve sikeresen frissitve. ");
	}

	
	/**
	 * Akkor hívódik meg, ha hóvihar van a Jégmezõn, még nem csinál semmit, de késõbb akár, még lehet, hogy lesz valami szerepe
	 */
	public void hovihar() {
	
		
	}
	
	/**
	 * Beállítja egy random értékre, ha be van állítva a randomMegy, az iranyAmibeNez-t és lép egyet az így kapott irányba, majd 
	 * megnézi, hogy az új jégtáblán milyen védelem van és ha nem null meghívja a támadás függvényt magával, ha null, akkor a jégtáblán lévõ összes játékossal meghívja a jégmezõ meghalt függvényét
	 */
	public void Lep()
	{
		String megy=randomMegy ? "random megy. ":"nem megy random. ";
		Global.out.print("A jegesmedve " + megy);
		//https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
		//innen tájékozódtam a randomokról
		if(randomMegy)
		{
			
			//Random r = new Random();
			
			//int intErtek = r.nextInt(4);
			/*Irany ujIranyAmibeNez = Irany.IranyIntErtekAlapjan(intErtek);
			iranyAmibeNez = ujIranyAmibeNez;*/ // ÚJ
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
	 * Átállítja a Jegesmedve 
	 * @param i - Az irány, amibe szeretnénk, hogy nézzen a Jegesmedvénk
	 */
	public void setSzogAmibeNez(int szog)
	{
		
		szogAmibeNez = szog;
	}
	
	
	/**
	 * Beállítja, hogy melyik jégtáblán áll a Jegesmedve
	 * @param jt - a jégtábla, amire szeretnénk rárakni a Jegesmedvét
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
