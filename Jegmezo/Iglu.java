package Jegmezo;

import java.util.List;

public class Iglu extends Vedelem{

	public Iglu()
	{
		System.out.println("Letrehoztak egy iglut");
	}
	/**
	 * Itt nem csin�l semmit, de k�s�bb m�g lehet t�rt�nik valami friss�t�skor
	 */
	public void frissit() {
		System.out.println("Az iglura meghivodott a frissit fuggveny");
	}

	
	/**
	 * Ha h�vihar van megv�di a j�gt�bl�j�n l�v� j�t�kosokat �s nem esik semmi b�nt�d�suk
	 */
	public void hovihar() {
		System.out.println("Az iglura meghivodott a hovihar fuggveny");
		System.out.println("Iglu: Megvedtem a hovihartol a bennem levoket");
	}

	
	/**
	 * Ha megt�madj a j�gt�bl�t, amin van, egy jegesmedve, akkor megv�di a vele egy j�gt�bl�n l�v� j�t�koskat  
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
