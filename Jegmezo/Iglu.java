package Jegmezo;

/**
 * @author Henrik
 * A j�t�kban l�v� Iglut reprezent�lja
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
	 * Itt nem csin�l semmit, de k�s�bb m�g lehet t�rt�nik valami friss�t�skor
	 */
	public void frissit() {
		Global.out.print("Az iglura sikersesen frissitve. ");
	}

	
	/**
	 * Ha h�vihar van megv�di a j�gt�bl�j�n l�v� j�t�kosokat �s nem esik semmi b�nt�d�suk
	 */
	public void hovihar() {
		Global.out.print(" Az iglu megvedte a hovihartol a benne levoket. ");
	}

	
	/**
	 * Ha megt�madj a j�gt�bl�t, amin van, egy jegesmedve, akkor megv�di a vele egy j�gt�bl�n l�v� j�t�koskat  
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
