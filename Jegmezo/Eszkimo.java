package Jegmezo;



/**
 * @author Henrik
 * A j�t�kban l�v� Eszkim�t reprezent�lja
 */
public class Eszkimo extends Jatekos
{	
	
	/**
	 * Konstruktor, ami l�trehozza az Eszkim�t a medadott param�terekkel
	 * @param jegmezo - a j�gmez�, amin a J�t�kos van
	 * @param Munkadb - A J�t�kos h�tral�v� elv�gezhet� munka sz�ma
	 * @param testho - a J�t�kos h�tral�v� testh�je
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
	 * �p�t egy iglut arra J�gt�bl�ra, amerre nez
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
