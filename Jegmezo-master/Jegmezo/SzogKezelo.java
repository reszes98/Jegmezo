package Jegmezo; 

public class SzogKezelo {

	static Integer szogTukrozveAzOrigora(int szog)
	{
		int tukrozottSzog = szog + 180;
		if(tukrozottSzog >= 360)
			tukrozottSzog -= 360;
		return tukrozottSzog;
	}
}
