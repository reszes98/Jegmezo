package Jegmezo;

public class TorekenyAso implements Targy{

	
	/**
	 * Azt adja meg, hányszor lehet hasznáni mielõtt eltörik
	 */
	int tartossag;
	
	public TorekenyAso(int tartossag)
	{
		System.out.println("Letrehoztak egy torekenyasot");
		this.tartossag = tartossag;
	}
	/**
	 * Hozzaadja magát a játékos tárgyaihoz és visszatér azzal, hogy sikerült-e
	 */
	public boolean felvesz(Jatekos j) {
		System.out.println("Torekenyaso: most megprobalnak felvenni");
		boolean sikeres = j.targyHozzadasa(this);
		
		if(sikeres)
		{
			System.out.println("Torekeny aso sikeresen felveve");
			
		}
		else 
			System.out.println("A torekeny asot nem sikerult felvenni");
	
		
		return sikeres;
	}

	
	/**
	 * A törékeny ásó használ tevékenységét valósítja meg. Csökkenti a hó mennyiségét 2-vel annak
	 *Jégtáblának,ami abba az irányba van, amibe a Játékos, aki az ásót használja, néz. 
	 *Ha sikerült csökkenti a tartósságát eggyel és ha nullára esik a tartóssága eltörik és eltávolítja magát a játékos tárgyai közül.
	 *És visszaadja, hogy sikerült-e.
	 */
	public boolean hasznal(Jatekos j) {
		System.out.println("Torekenyaso: most megprobalnak hasznalni");
		System.out.println("Torekenyaso: most lekerdezem a jatekosnak, aki hasznal, az iranyAmibeNez-et");
		int szog = j.getSzogAmibeNez();
		System.out.println("Torekenyaso: most lekerdezem a jatekosnak, aki hasznal, a jegtablajat");
		Jegtabla jt = j.JegtablaLekerdez();
		System.out.println("Torekenyaso: most lekerdezem a jegtablanak az abban az iranyban levo szomszedjat, amerre a jatekos nez");
		Jegtabla szJegtabla = jt.szomszedKerdez(szog);
		
		
		if(szJegtabla != null)
		{
			System.out.println("Torekenyaso: Letezik ez a szomszed, szoval megproblaok asni rajta kettot");
			boolean sikeres = szJegtabla.asas(2);
			
			if(sikeres)
			{
				System.out.println("Torekenyaso: Sikerult asni ezert csokkentem a tartossagom");
				tartossag--;
				if(tartossag == 0)
				{
					System.out.println("Torekenyaso: tartossag elerte a nullat,  ezert eltortem");
					j.targyEltavolitasa(this);
				}
				System.out.println("Torekeny aso sikeresen hasznalva");
			}
			else
				System.out.println("Torekeny aso sikertelenul hasznalva");
			return sikeres;
		}
		else
		{
			System.out.println("Torekenyaso: Nem letezik ez a szomszed, szoval nem lehet hasznalni a toreknyasot");
			return false;
		}
		
	}
	
	
	/**
	 * @return Visszaadja a TörékenyÁsó tartosság attribútumát
	 */
	public int getTartossag()
	{
		return tartossag;
	}
	/**
	 * Átállítja a magadott paraméterre a TörékenyÁsó tartósságát
	 * @param i - amire át akarjuk változtatni a tartósságot
	 */
	public void setTartossag(int i)
	{
		tartossag = i;
	}
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "TorekenyAso";
	}

}
