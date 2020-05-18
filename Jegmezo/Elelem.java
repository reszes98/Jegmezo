package Jegmezo;


/**
 * @author Henrik
 * A játékban lévõ Élelmet reprezentálja
 */
public class Elelem implements Targy
{
	/**
	 * Az élelem pont értéke, ami azt adja meg, hogy használatkor mennyivel növeli a játékos testhõjét.
	 */
	private int pont;
	

	/**
	 * Konstruktor, ami beállítja az élelem pont értékét, ami azt adja meg, hogy mennyivel növeli a testhõt, a megadott értékre
	 * @param pont - Azt adja meg mennyivel növeli a játékos testhõjét, ha használják
	 */
	public Elelem(int pont) {
		this.pont = pont;
		Global.out.print("Letrehoztak, egy elelmet " + this.pont + " pontertekkel. ");
	}
	
	/**
	 * Hozzáadja az élelmet a Játékos tárgyaihoz és visszaadja, hogy sikerült-e
	 */
	public boolean felvesz(Jatekos j) {
		
		boolean sikeres = j.targyHozzadasa(this);
		
		if(sikeres)
			Global.out.print("Elelem sikeresen felveve. ");
		else 
			Global.out.print("Az elelmet nem sikerult felvenni. ");
		
		return sikeres;
	}

	
	/**
	 * a játékos testhõjét növeli azzal, hogy megeszi, azaz felhasználja az élelmet és visszaadja, hogy sikerült-e
	 */
	public boolean hasznal(Jatekos j) {
		
		Global.out.print("Ez egy elelem. ");
		boolean sikeres = j.testhoNovelese(pont);
		
		if(sikeres) 
		{
			Global.out.print("Elelem sikeresen hasznalva. ");
			
			j.targyEltavolitasa(this);
			return true;
		}
		else
			Global.out.print("Nem sikerult hasznalni az elelmet. ");
		
		
		return false;
	}
	
	/**
	 * @return Visszaadja az élelem pont értékét, ami azt adja meg, hogy mennyivel növeli az étel a Játékos testhõjét 
	 */
	public int getPont()
	{
		
		return pont;
	}
	
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Elelem";
	}
}
