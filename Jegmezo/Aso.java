package Jegmezo;



/**
 * @author Henrik
 * A j�t�kban l�v� �s�t reprezent�lja
 */
public class Aso implements Targy
{
	
	public Aso()
	{
		Global.out.print("Aso sikeresen letrehozva. ");
	}
	
	/**
	 * Hozz�adja az �s�t a J�t�kos t�rgyaihoz �s visszaadja, hogy siker�lt-e
	 */
	public boolean felvesz(Jatekos j) {
		
		
		boolean sikeres = j.targyHozzadasa(this);
		
		if(sikeres)
		{
			Global.out.print("Aso sikeresen felveve. ");
			
		}
		else 
			Global.out.print("Az asot nem sikerult felvenni. ");
	
		
		return sikeres;
	}

	
	/**
	 *	Az �s� haszn�l tev�kenys�g�t val�s�tja meg. Cs�kkenti a a h� mennyis�g�t 2-vel annak
	 *J�gt�bl�nak,ami abba az ir�nyba van, amibe a J�t�kos, aki az �s�t haszn�lja, n�z. Es visszaadja, hogy siker�lt-e
	 */
	public boolean hasznal(Jatekos j) {
		
		Jegtabla jt = j.JegtablaLekerdez();
		
		Global.out.print("Ez egy aso. ");
		
		boolean sikeres = jt.asas(2);
		
		if(sikeres)
			Global.out.print("Aso sikeresen hasznalva. ");
		else
			Global.out.print("Aso sikertelenul hasznalva. ");
		
		
		return sikeres;
	}
	
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Aso";
	}
}
