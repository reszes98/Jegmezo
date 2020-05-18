package Jegmezo;



/**
 * @author Henrik
 * A játékban lévõ Eszkimót reprezentálja
 */
public class Eszkimo extends Jatekos
{	
	
	/**
	 * Konstruktor, ami létrehozza az Eszkimót a medadott paraméterekkel
	 * @param jegmezo - a jégmezõ, amin a Játékos van
	 * @param Munkadb - A Játékos hátralévõ elvégezhetõ munka száma
	 * @param testho - a Játékos hátralévõ testhõje
	 */
	public Eszkimo(Jegmezo jegmezo,
	int Munkadb,
	int testho)
	{
		super(jegmezo,
				Munkadb,
				testho);
		
		Global.out.println("Jatekos tipusa eszkimo.");
	}
	
	
	/**
	 * Épít egy iglut arra Jégtáblára, amerre nez
	 */
	public void kepesseg()
	{
		Global.out.print("A jatekos MunkaDB-ja: "+Munkadb+". ");
		if (Munkadb>0&&!aktjegtabla.getAtVanFordulva()) {
			Iglu i = new Iglu();
			
			aktjegtabla.setjegtablaVedelme(i);
				
			Global.out.print("Iglu epitese sikeres.");
			this.MunkaDBcsokkentese(1);
		}
		else
			Global.out.print("Iglu epitese sikertelen. ");
		Global.out.print("A jatekos MunkaDB-ja: "+Munkadb+". ");
		
	}
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Eszkimo";
	}
	
}
