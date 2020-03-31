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
	 * Minden kör eljén hívódik meg és meghívja a Lép függvényt
	 */
	public void frissit() {
		// TODO Auto-generated method stub
		System.out.println("A jegemedve most lepni fog");
		Lep();
	}

	
	/**
	 * Akkor hívódik meg, ha hóvihar van a Jégmezõn, még nem csinál semmit, de késõbb akár, még lehet, hogy lesz valami szerepe
	 */
	public void hovihar() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Beállítja egy random értékre, ha be van állítva a randomMegy, az iranyAmibeNez-t és lép egyet az így kapott irányba, majd 
	 * megnézi, hogy az új jégtáblán milyen védelem van és ha nem null meghívja a támadás függvényt magával, ha null, akkor a jégtáblán lévõ összes játékossal meghívja a jégmezõ meghalt függvényét
	 */
	public void Lep()
	{
		//https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
		//innen tájékozódtam a randomokról
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
	 * Beállítja, hogy melyik jégtáblán áll a Jegesmedve
	 * @param jt - a jégtábla, amire szeretnénk rárakni a Jegesmedvét
	 */
	public void setjegtablaAminAll(Jegtabla jt)
	{
		jegtablaAminAll  = jt;
	}
	
	/**
	 * Átállítja a Jegesmedve 
	 * @param i - Az irány, amibe szeretnénk, hogy nézzen a Jegesmedvénk
	 */
	public void setiranyAmibeNez(Irany i)
	{
		iranyAmibeNez = i;
	}

}
