package Jegmezo;

/**
 * @author Henrik
 * A játékban a Jégtáblák lehetséges szomszédos irányait képviseli. (Jobb(0), Bal(1), Fel(2),
Le(3))
 */
public enum Irany {
Jobb(0),
Bal(1),
Fel(2),
Le(3);
	
	//https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
	//innen tájékozódtam az enumokról
	private final int intErtek;
	
	Irany(int intErtek)
	{
		this.intErtek = intErtek;
	}
	
	/**
	 * @return Visszaadja az irányhoz tartózó int értéket  (Jobb(0), Bal(1), Fel(2),Le(3))
	 */
	public int intErtek() {return intErtek;}
	
	/**
	 * Visszaadja a az intérték alapján a hozzátartozó irányt
	 * @param ertek - az érték, amihez a tartozó Irányt keressük
	 * @return Visszaadja a az intérték alapján a hozzátartozó irányt ((0) - Jobb,(1) - Bal, (2) - Fel,(3) - Le)
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
	 * Viszaadja a paraméterben megadott irány ellentetjét
	 * @param i - az irány, aminek az ellentetjét akarjuk
	 * @return Viszaadja a paraméterben megadott irány ellentetjét
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
