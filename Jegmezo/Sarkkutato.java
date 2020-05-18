package Jegmezo;

/**
 * @author Henrik
 * A játékban lévõ Sarkkutatót reprezentálja
 */
public class Sarkkutato extends Jatekos
{
	
	/**
	 * Konstruktor, ami létrehozza a Játékost a medadott paraméterekkel
	 * @param jegmezo - a jégmezõ, amin a Játékos van
	 * @param Munkadb - A Játékos hátralévõ elvégezhetõ munka száma
	 * @param testho - a Játékos hátralévõ testhõje
	 */
	public Sarkkutato(Jegmezo jegmezo,
	int Munkadb,
	int testho)
	{
		super(jegmezo,
				Munkadb,
				testho);
		
		Global.out.println("Jatekos tipusa sarkkutato.");
	}

	
	/**
	 * A sarkutató megvizsgálja az iranyAmibeNezFele levo Jégtábla tartóképességét
	 */
	public void kepesseg()
	{
		
		Global.out.print("A jatekos MunkaDB-ja: "+Munkadb+". ");
		Jegtabla j = aktjegtabla.szomszedKerdez(szogAmibeNez);
		if(j != null)
		{
			Global.out.print("A jegtabla tartokepessege: " + j.gettartokepesseg());
			MunkaDBcsokkentese(1);
		}
		else
		{
			Global.out.print("A szomszed nem letezik, lekerdezes sikertelen. ");
		}
		Global.out.print("A jatekos MunkaDB-ja: "+Munkadb+". ");
	}
	
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Sarkkutato";
	}
	
}
