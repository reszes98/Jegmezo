package Jegmezo;

/**
 * @author Henrik
 * A j�t�kban l�v� Sarkkutat�t reprezent�lja
 */
public class Sarkkutato extends Jatekos
{
	
	/**
	 * Konstruktor, ami l�trehozza a J�t�kost a medadott param�terekkel
	 * @param jegmezo - a j�gmez�, amin a J�t�kos van
	 * @param Munkadb - A J�t�kos h�tral�v� elv�gezhet� munka sz�ma
	 * @param testho - a J�t�kos h�tral�v� testh�je
	 */
	public Sarkkutato(Jegmezo jegmezo,
	int Munkadb,
	int testho)
	{
		super(jegmezo,
				Munkadb,
				testho);
		
		Global.out.println("Jatekos tipusa sarkkutato.");
	}

	
	/**
	 * A sarkutat� megvizsg�lja az iranyAmibeNezFele levo J�gt�bla tart�k�pess�g�t
	 */
	public void kepesseg()
	{
		
		Global.out.print("A jatekos MunkaDB-ja: "+Munkadb+". ");
		Jegtabla j = aktjegtabla.szomszedKerdez(szogAmibeNez);
		if(j != null)
		{
			Global.out.print("A jegtabla tartokepessege: " + j.gettartokepesseg());
			MunkaDBcsokkentese(1);
		}
		else
		{
			Global.out.print("A szomszed nem letezik, lekerdezes sikertelen. ");
		}
		Global.out.print("A jatekos MunkaDB-ja: "+Munkadb+". ");
	}
	
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Sarkkutato";
	}
	
}
