package Jegmezo;

/**
 * @author Henrik
 * A játékban lévõ Iglut reprezentálja
 */
public class Iglu extends Vedelem{

	/**
	 * Default konstruktor
	 */
	public Iglu()
	{
		Global.out.print("Iglu sikeresen letrehozva. ");
	} 
	
	/**
	 * Itt nem csinál semmit, de késõbb még lehet történik valami frissítéskor
	 */
	public void frissit() {
		Global.out.print("Az iglura sikersesen frissitve. ");
	}

	
	/**
	 * Ha hóvihar van megvédi a jégtábláján lévõ játékosokat és nem esik semmi bántódásuk
	 */
	public void hovihar() {
		Global.out.print(" Az iglu megvedte a hovihartol a benne levoket. ");
	}

	
	/**
	 * Ha megtámadj a jégtáblát, amin van, egy jegesmedve, akkor megvédi a vele egy jégtáblán lévõ játékoskat  
	 */
	public void tamadas(Jegesmedve j) {
		Global.out.print("Az iglu sikeresen megvedte a benne levo jatekosokat a Jegesmedvetol. ");
	}
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Iglu";
	}

}
