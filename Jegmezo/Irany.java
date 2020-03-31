package Jegmezo;

/**
 * @author Henrik
 * A j�t�kban a J�gt�bl�k lehets�ges szomsz�dos ir�nyait k�pviseli. (Jobb(0), Bal(1), Fel(2),
Le(3))
 */
public enum Irany {
Jobb(0),
Bal(1),
Fel(2),
Le(3);
	
	//https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
	//innen t�j�koz�dtam az enumokr�l
	private final int intErtek;
	
	Irany(int intErtek)
	{
		this.intErtek = intErtek;
	}
	
	/**
	 * @return Visszaadja az ir�nyhoz tart�z� int �rt�ket  (Jobb(0), Bal(1), Fel(2),Le(3))
	 */
	public int intErtek() {return intErtek;}
	
	/**
	 * Visszaadja a az int�rt�k alapj�n a hozz�tartoz� ir�nyt
	 * @param ertek - az �rt�k, amihez a tartoz� Ir�nyt keress�k
	 * @return Visszaadja a az int�rt�k alapj�n a hozz�tartoz� ir�nyt ((0) - Jobb,(1) - Bal, (2) - Fel,(3) - Le)
	 */
	public static Irany IranyIntErtekAlapjan(int ertek)
	{
		switch(ertek)
		{
			case 0:
				return Jobb;
			case 1:
				return Bal;
			case 2:
				return Fel;
			default:
				return Le;
		}
	}
	
	/**
	 * Viszaadja a param�terben megadott ir�ny ellentetj�t
	 * @param i - az ir�ny, aminek az ellentetj�t akarjuk
	 * @return Viszaadja a param�terben megadott ir�ny ellentetj�t
	 */
	public Irany EllenkezoIrany(Irany i)
	{
		switch(i)
		{
		case Jobb:
			return Bal;
		case Bal:
			return Jobb;
		case Fel:
			return Le;
		default:
			return Fel;
		}
	}
}
