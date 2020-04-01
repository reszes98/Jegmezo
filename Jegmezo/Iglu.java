package Jegmezo;

import java.util.List;

public class Iglu extends Vedelem{

	public Iglu()
	{
		System.out.println("Letrehoztak egy iglut");
	}
	/**
	 * Itt nem csinál semmit, de késõbb még lehet történik valami frissítéskor
	 */
	public void frissit() {
		System.out.println("Az iglura meghivodott a frissit fuggveny");
	}

	
	/**
	 * Ha hóvihar van megvédi a jégtábláján lévõ játékosokat és nem esik semmi bántódásuk
	 */
	public void hovihar() {
		System.out.println("Az iglura meghivodott a hovihar fuggveny");
		System.out.println("Iglu: Megvedtem a hovihartol a bennem levoket");
	}

	
	/**
	 * Ha megtámadj a jégtáblát, amin van, egy jegesmedve, akkor megvédi a vele egy jégtáblán lévõ játékoskat  
	 */
	public void tamadas(Jegesmedve j) {
		System.out.println("Iglu: megvedtem a bennem levoket a Jegesmedvetol");
	}
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Iglu";
	}

}
