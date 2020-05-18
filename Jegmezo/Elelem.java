package Jegmezo;


/**
 * @author Henrik
 * A j�t�kban l�v� �lelmet reprezent�lja
 */
public class Elelem implements Targy
{
	/**
	 * Az �lelem pont �rt�ke, ami azt adja meg, hogy haszn�latkor mennyivel n�veli a j�t�kos testh�j�t.
	 */
	private int pont;
	

	/**
	 * Konstruktor, ami be�ll�tja az �lelem pont �rt�k�t, ami azt adja meg, hogy mennyivel n�veli a testh�t, a megadott �rt�kre
	 * @param pont - Azt adja meg mennyivel n�veli a j�t�kos testh�j�t, ha haszn�lj�k
	 */
	public Elelem(int pont) {
		this.pont = pont;
		Global.out.print("Letrehoztak, egy elelmet " + this.pont + " pontertekkel. ");
	}
	
	/**
	 * Hozz�adja az �lelmet a J�t�kos t�rgyaihoz �s visszaadja, hogy siker�lt-e
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
	 * a j�t�kos testh�j�t n�veli azzal, hogy megeszi, azaz felhaszn�lja az �lelmet �s visszaadja, hogy siker�lt-e
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
	 * @return Visszaadja az �lelem pont �rt�k�t, ami azt adja meg, hogy mennyivel n�veli az �tel a J�t�kos testh�j�t 
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
