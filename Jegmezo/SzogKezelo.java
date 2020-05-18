package Jegmezo; 

/**
 * @author Henrik
 * A szögeg kezeléséhez szükséges függvényeket tartalmazza
 */
public class SzogKezelo {

	/**
	 * Tükrözi a megadott szöget az origóra
	 * @param szog - a szög, amit tükrözni szeretnénk az origóra
	 * @return Visszaadja a szög origóra tükrözött szögét
	 */
	static Integer szogTukrozveAzOrigora(int szog)
	{
		int tukrozottSzog = szog + 180;
		if(tukrozottSzog >= 360)
			tukrozottSzog -= 360;
		return tukrozottSzog;
	}
}
