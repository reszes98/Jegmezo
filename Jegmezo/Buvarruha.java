package Jegmezo;


/**
 * @author Henrik
 * A j�t�kban l�v� Buvarruhat reprezent�lja
 */
public class Buvarruha implements Targy
{
	
	
	public Buvarruha()
	{
		Global.out.print("Sikeresen letrehoztak egy buvarruhat. ");
	}
	
	/**
	 * Hozz�adja a b�v�rruh�t a J�t�kos t�rgyaihoz �s visszaadja, hogy siker�lt-e
	 */
	public boolean felvesz(Jatekos j) {
		
		
		boolean sikeres = j.targyHozzadasa(this);
		
		if(sikeres)
			Global.out.print("Buvarruha sikeresen felveve. ");
		
		else 
			Global.out.print("A buvarruhat nem sikerult felvenni. ");
			
		
		return sikeres;
	}

	
	/**
	 * a j�t�kost �thelyezi a kapott ir�nyba �s visszaadja, hogy siker�lt-e
	 */
	public boolean hasznal(Jatekos j) {
		int szog = j.getSzogAmibeNez();
		
		Global.out.print("Ez egy buvarruha. ");

		boolean sikeres =false;
		
		sikeres=j.athelyez(szog);
		
		
		if(sikeres)
			Global.out.print("Buvarruha sikeresen hasznalva. ");
		else
			Global.out.print("A buvarruhat nem sikertelenul hasznalni. ");
		
		
		return sikeres;
	}
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Buvarruha";
	}
}
