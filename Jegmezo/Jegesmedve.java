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
	 * Minden kör eljén hívódik meg és meghívja a Lép függvényt
	 */
	public void frissit() {
		System.out.println("A jegemedve most lepni fog");
		Lep();
	}

	
	/**
	 * Akkor hívódik meg, ha hóvihar van a Jégmezõn, még nem csinál semmit, de késõbb akár, még lehet, hogy lesz valami szerepe
	 */
	public void hovihar() {
		System.out.println("A jegemedve epp hoviharban van");
		
	}
	
	/**
	 * Beállítja egy random értékre, ha be van állítva a randomMegy, az iranyAmibeNez-t és lép egyet az így kapott irányba, majd 
	 * megnézi, hogy az új jégtáblán milyen védelem van és ha nem null meghívja a támadás függvényt magával, ha null, akkor a jégtáblán lévõ összes játékossal meghívja a jégmezõ meghalt függvényét
	 */
	public void Lep()
	{
		System.out.println("Most a jegesmedve lepesre keszul");
		//https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
		//innen tájékozódtam a randomokról
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
	 * Beállítja, hogy melyik jégtáblán áll a Jegesmedve
	 * @param jt - a jégtábla, amire szeretnénk rárakni a Jegesmedvét
	 */
	public void setjegtablaAminAll(Jegtabla jt)
	{
		System.out.println("Nekem a jegesmedvenek, epp a jegtablat allitjak, amin allok");
		jegtablaAminAll  = jt;
	}
	
	/**
	 * Átállítja a Jegesmedve 
	 * @param i - Az irány, amibe szeretnénk, hogy nézzen a Jegesmedvénk
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
