package Jegmezo; 

/**
 * @author Henrik
 * A sz�geg kezel�s�hez sz�ks�ges f�ggv�nyeket tartalmazza
 */
public class SzogKezelo {

	/**
	 * T�kr�zi a megadott sz�get az orig�ra
	 * @param szog - a sz�g, amit t�kr�zni szeretn�nk az orig�ra
	 * @return Visszaadja a sz�g orig�ra t�kr�z�tt sz�g�t
	 */
	static Integer szogTukrozveAzOrigora(int szog)
	{
		int tukrozottSzog = szog + 180;
		if(tukrozottSzog >= 360)
			tukrozottSzog -= 360;
		return tukrozottSzog;
	}
}
