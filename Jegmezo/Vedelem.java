package Jegmezo;

/**
 * @author Henrik
 * A játékban lévõ Védelmek abstract õsosztálya
 */
public abstract class Vedelem implements Frissitheto{

	protected Jegtabla jegtablaAminVan;
	
	/**
	 * Minden kör elején kell meghívni, hogy frissíthesse magát a Védelem
	 */
	public abstract void frissit();

	
	/**
	 * Akkor kell meghívni, amikor hóvihar van, hogy a Védelem elvégezzhesse a szükséges teendõket
	 */
	public abstract void hovihar();
	
	
	/**
	 * Akkor hívódik meg, ha egy Jegesmedve támadja meg
	 * @param j - A jegesmedve, aki támadja a védelmet
	 */
	public abstract void tamadas(Jegesmedve j);
	

	/**
	 * Beállítja a jegtabla, amin van atrribútumot
	 */
	public void setJegtablaAminVan(Jegtabla j)
	{
		this.jegtablaAminVan = j;
	}

}
